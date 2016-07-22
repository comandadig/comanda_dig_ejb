package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Comanda;
import model.Pedido;



@Local
public interface PedidoFacade {

	public abstract void save(Pedido entity);

	public abstract Pedido update(Pedido entity);
	
	public abstract void delete(Pedido entity);

	public abstract Pedido find(Long entityID);
	
	public abstract List<Pedido> findAll();
	
	public abstract Comanda buscarComanda(String codCoamnda);
	
	
	

}
