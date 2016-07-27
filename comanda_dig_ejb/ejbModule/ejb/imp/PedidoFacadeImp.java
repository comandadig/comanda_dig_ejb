package ejb.imp;



import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.ComandaDAO;
import dao.PedidoDAO;
import ejb.PedidoFacade;
import model.Comanda;
import model.Pedido;



/**
 * Session Bean implementation class PeididoFacadeImp
 */
@Stateless
public class PedidoFacadeImp implements PedidoFacade {

    @EJB
    private PedidoDAO pedidoDAO;
    @EJB
    private ComandaDAO comandaDAO;
   
    
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


	
}
