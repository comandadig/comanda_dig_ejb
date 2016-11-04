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
	
	
	private final String CONSULTA_COMANDA= "";
			
	
	
	public Comanda buscarComanda(String codComanda) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("codComanda", codComanda);
		List<Comanda> list = this.executeNamedQuery("Comanda.ConsultaComanda", parameters);
		if (list!= null && !list.isEmpty()) return list.get(0);
		return null;
	}
	
}