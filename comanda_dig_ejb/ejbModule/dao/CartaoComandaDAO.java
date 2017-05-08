package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import model.CartaoComanda;



@Stateless
public class CartaoComandaDAO extends GenericDAO<CartaoComanda> {
	
	public CartaoComandaDAO() {
		super(CartaoComanda.class);
	}
	
	
	public CartaoComanda buscarCartaoAtivo(String codComanda) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("codComanda", codComanda);
		List<CartaoComanda> list = this.executeNamedQuery(CartaoComanda.CARTAO_ATIVO, parameters);
		if (list!= null && !list.isEmpty()) return list.get(0);
		return null;
	}
	
}