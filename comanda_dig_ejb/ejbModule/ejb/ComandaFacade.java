package ejb;

import java.util.List;

import javax.ejb.Local;

import exception.ComandaException;
import model.CartaoComanda;
import model.Comanda;
import model.PedidosComanda;



@Local
public interface ComandaFacade {

	public abstract void save(Comanda entity);

	public abstract Comanda update(Comanda entity);
	
	public abstract void delete(Comanda entity);

	public abstract Comanda find(Long entityID);
	
	public abstract List<Comanda> findAll();
	
	public abstract CartaoComanda vericaAberturaComanda(String codigoComanda) throws ComandaException;
	
	public abstract Comanda vericaComandaPedido (String codigoComanda) throws ComandaException;
	
	public abstract Comanda buscarComanda(String codComanda);
	
	public abstract void abrirComanda(Comanda comanda) throws ComandaException;
	
	public abstract PedidosComanda pedidosComanda(Comanda comanda);

	public abstract void fecharComanda(Comanda comanda, int percentual) throws ComandaException;
	

}
