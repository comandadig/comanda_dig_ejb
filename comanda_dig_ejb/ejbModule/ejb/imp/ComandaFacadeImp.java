package ejb.imp;



import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.CartaoComandaDAO;
import dao.ComandaDAO;
import dao.PedidosComandaDAO;
import ejb.CaixaFacade;
import ejb.ComandaFacade;
import exception.ComandaException;
import model.Caixa;
import model.CartaoComanda;
import model.Comanda;
import model.Pedido;
import model.PedidosComanda;
import util.SituacaoComanda;



/**
 * Session Bean implementation class UserFacadeImp
 */
@Stateless
public class ComandaFacadeImp implements ComandaFacade {

	private static final String COMANDA_NAO_CADASTRADA = "Comanda Não Cadastrada.";

	private static final String COMANDA_NAO_ESTA_DISPONIVEL = "Comanda Não Esta Disponivel.";

	private static final String CAIXA_NAO_ESTA_ABERTO = "Caixa não está aberto.";

	@EJB
	private ComandaDAO comandaDAO;
	@EJB
	private CaixaFacade caixaFacade;
	@EJB
	private PedidosComandaDAO pedidosComandaDAO;
	@EJB
	private CartaoComandaDAO cartaoComandaDao;
	
	
	@Override
	public void save(Comanda entity) {
		comandaDAO.save(entity);
		
	}

	@Override
	public Comanda update(Comanda entity) {
		return comandaDAO.update(entity);
	}

	@Override
	public void delete(Comanda entity) {
		comandaDAO.delete(entity);
		
	}

	@Override
	public Comanda find(Long entityID) {
		return comandaDAO.find(entityID);
	}

	@Override
	public List<Comanda> findAll() {
		return comandaDAO.findAll();
	}

	@Override
	public Comanda buscarComanda(String codComanda) {
		return comandaDAO.buscarComandaAberta(codComanda);
	}

	@Override
	public void abrirComanda(Comanda comanda) throws ComandaException {
		
		CartaoComanda cartaoComanda = this.vericaAberturaComanda(comanda.getCartaoComanda().getCodComanda());
		Caixa caixa = caixaFacade.buscarCaixaDisponivel();
		
		comanda.setCaixa(caixa);
		comanda.setCartaoComanda(cartaoComanda);
		comanda.setDataAbertura(new Date());
		comanda.setSituacao(SituacaoComanda.ABERTA.getValue());
		comandaDAO.save(comanda);
	}

	
	@Override
	public CartaoComanda vericaAberturaComanda(String codigoComanda) throws ComandaException{
		
		Caixa caixa = caixaFacade.buscarCaixaDisponivel();
		if (caixa == null) throw new ComandaException(CAIXA_NAO_ESTA_ABERTO);
		
		CartaoComanda cartaoComanda = cartaoComandaDao.buscarCartaoAtivo(codigoComanda);
		if (cartaoComanda == null) throw new ComandaException(COMANDA_NAO_CADASTRADA);
		
		Comanda comanda = comandaDAO.buscarComandaAberta(codigoComanda);
		if (comanda != null)  throw new ComandaException(COMANDA_NAO_ESTA_DISPONIVEL);
		
		return cartaoComanda;
		
		
	}
	
	
	@Override
	public Comanda vericaComandaPedido(String codigoComanda) throws ComandaException{
		
		return verificaComanda(codigoComanda);
	}

	private Comanda verificaComanda(String codigoComanda) throws ComandaException {
		Caixa caixa = caixaFacade.buscarCaixaDisponivel();
		if (caixa == null) throw new ComandaException(CAIXA_NAO_ESTA_ABERTO);
		
		CartaoComanda cartaoComanda = cartaoComandaDao.buscarCartaoAtivo(codigoComanda);
		if (cartaoComanda == null) throw new ComandaException(COMANDA_NAO_CADASTRADA);
		
		Comanda comanda = comandaDAO.buscarComandaAberta(codigoComanda);
		if (comanda != null){
			if (comanda.getSituacao().equals(SituacaoComanda.ABERTA.getValue())){
				comanda.setCaixa(caixa);
				return comanda;
			} else {
				throw new ComandaException(COMANDA_NAO_ESTA_DISPONIVEL);
			}
			
		} else {
			 throw new ComandaException(COMANDA_NAO_ESTA_DISPONIVEL);
		}
	}
	
	@Override
	public PedidosComanda pedidosComanda(Comanda comanda){
		
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("idComanda", comanda.getIdComanda());
		List<PedidosComanda> list = pedidosComandaDAO.executeNamedQuery(PedidosComanda.FIND_BY_COMANDA, map);
		
		if (list != null && !list.isEmpty()) 	return list.get(0);
		
		return null;
	}

	@Override
	public void fecharComanda(Comanda comanda, int percentual) throws ComandaException {
		
		verificaComanda(comanda.getCartaoComanda().getCodComanda());
		double resultTotal =  this.totalPedidos(comanda);
		resultTotal = resultTotal + ((resultTotal * percentual) / 100);
		
		comanda.setDataFechamento(new Date());
		comanda.setValorTotal(resultTotal);
		comanda.setSituacao(SituacaoComanda.FECHADO.getValue());
		
		comandaDAO.update(comanda);
		
	}

	private double totalPedidos(Comanda comanda) {
		
		double resultTotal = 0;
		
		
		PedidosComanda pedidosComanda = this.pedidosComanda(comanda);
		
		if (comanda.getPedidosComandas() != null && pedidosComanda != null){
			
			if (pedidosComanda !=null && pedidosComanda.getPedidos() != null){
				for (Pedido pedido : pedidosComanda.getPedidos()) {
						resultTotal = resultTotal + pedido.getValor();
				}
			}
		}
		
		return resultTotal;
	}
}
