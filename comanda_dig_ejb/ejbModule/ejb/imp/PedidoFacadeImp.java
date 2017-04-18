package ejb.imp;



import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import dao.ComandaDAO;
import dao.PedidoDAO;
import dao.PedidosComandaDAO;
import ejb.PedidoFacade;
import model.Comanda;
import model.Pedido;
import model.PedidosComanda;
import model.Produto;
import model.User;



/**
 * Session Bean implementation class PeididoFacadeImp
 */
@Stateless
public class PedidoFacadeImp implements PedidoFacade {

    @EJB
    private PedidoDAO pedidoDAO;
    @EJB
    private ComandaDAO comandaDAO;
    @EJB
    private PedidosComandaDAO pedidosComandaDAO;
    
    public PedidoFacadeImp() {
    	
    }


	@Override
	public void save(Pedido entity) {
		pedidoDAO.save(entity);
	}



	@Override
	public Pedido update(Pedido entity) {
		return pedidoDAO.update(entity);
	}



	@Override
	public void delete(Pedido entity) {
		pedidoDAO.delete(entity);
		
	}



	@Override
	public Pedido find(Long entityID) {
		return pedidoDAO.find(entityID);
	}



	@Override
	public List<Pedido> findAll() {
		return pedidoDAO.findAll();
	}


	@Override
	public Comanda buscarComanda(String codComanda) {
		return comandaDAO.buscarComanda(codComanda);
	}


	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean fecharPedido(List<Produto> produtos, Comanda comanda, User user) {
		
		PedidosComanda pedidosComanda = new PedidosComanda();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("idComanda",comanda.getIdComanda());
		List<PedidosComanda> comandas = pedidosComandaDAO.executeNamedQuery(PedidosComanda.FIND_BY_COMANDA,map);
		
		if (comandas != null && !comandas.isEmpty()){
			pedidosComanda = comandas.get(0);
		} else {
			pedidosComanda.setComanda(comanda);
			pedidosComandaDAO.save(pedidosComanda);
		}
		
		for (Produto produto : produtos) {
			Pedido pedido = new Pedido();
			pedido.setDtIniFila(new Date());
			pedido.setProduto(produto);
			pedido.setObs(produto.getObs());
			pedido.setQuantItem(produto.getQuant());
			pedido.setUser(user);
			pedido.setPedidosComanda(pedidosComanda);
			
			pedidoDAO.save(pedido);
		}
		
		
		return false;
	}


	
}
