package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import model.Comanda;



@Stateless
public class ComandaDAO extends GenericDAO<Comanda> {
	
	public ComandaDAO() {
		super(Comanda.class);
	}
	
	
	public Comanda buscarComandaAberta(String codComanda) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("codComanda", codComanda);
		List<Comanda> list = this.executeNamedQuery(Comanda.COMANDA_ABERTA, parameters);
		if (list!= null && !list.isEmpty()) return list.get(0);
		return null;
	}
	
}