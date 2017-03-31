package ejb.imp;



import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.ComandaDAO;
import ejb.CaixaFacade;
import ejb.ComandaFacade;
import exception.ComandaException;
import model.Caixa;
import model.Comanda;
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
		return comandaDAO.buscarComanda(codComanda);
	}

	@Override
	public Comanda abrirComanda(Comanda comanda) {
		Comanda comandaPersist = comandaDAO.find(comanda.getIdComanda());
		comandaPersist.setDocumento(comanda.getDocumento());
		comandaPersist.setNome(comanda.getNome());
		comandaPersist.setSexo(comanda.getSexo());
		comandaPersist.setTelefone(comanda.getTelefone());
		comandaPersist.setSituacao(SituacaoComanda.ABERTO.getValue());
		return comandaDAO.update(comandaPersist);
	}

	
	@Override
	public Comanda vericaAberturaComanda(String codigoComanda) throws ComandaException{
		
		Caixa caixa = caixaFacade.buscarCaixaDisponivel();
		if (caixa == null) throw new ComandaException(CAIXA_NAO_ESTA_ABERTO);
		
		Comanda comanda = comandaDAO.buscarComanda(codigoComanda);
		if (comanda != null){
			if (comanda.getSituacao().equals(SituacaoComanda.DISPONIVEL.getValue())){
				comanda.setCaixa(caixa);
				return comanda;
			} else {
				throw new ComandaException(COMANDA_NAO_ESTA_DISPONIVEL);
			}
			
		} else {
			 throw new ComandaException(COMANDA_NAO_CADASTRADA);
		}
	}
	
	
}
