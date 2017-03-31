package ejb;

import java.util.List;

import javax.ejb.Local;

import exception.ComandaException;
import model.Comanda;



@Local
public interface ComandaFacade {

	public abstract void save(Comanda entity);

	public abstract Comanda update(Comanda entity);
	
	public abstract void delete(Comanda entity);

	public abstract Comanda find(Long entityID);
	
	public abstract List<Comanda> findAll();
	
	public abstract Comanda vericaAberturaComanda(String codigoComanda) throws ComandaException;
	
	public abstract Comanda buscarComanda(String codComanda);
	
	public abstract Comanda abrirComanda(Comanda comanda);
	

}
