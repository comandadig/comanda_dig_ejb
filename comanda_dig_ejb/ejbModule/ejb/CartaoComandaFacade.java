package ejb;

import java.util.List;

import javax.ejb.Local;

import model.CartaoComanda;



@Local
public interface CartaoComandaFacade {

	public abstract void save(CartaoComanda Cartao);

	public abstract CartaoComanda update(CartaoComanda Cartao);
	
	public abstract void delete(CartaoComanda Cartao);

	public abstract CartaoComanda find(Long entityID);
	
	public abstract List<CartaoComanda> findAll();
	
	
		
	

}
