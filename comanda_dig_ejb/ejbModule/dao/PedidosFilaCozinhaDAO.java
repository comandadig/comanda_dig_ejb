package dao;

import javax.ejb.Stateless;

import model.PedidosFilaCozinha;



@Stateless
public class PedidosFilaCozinhaDAO extends GenericDAO<PedidosFilaCozinha> {
	
	public PedidosFilaCozinhaDAO() {
		super(PedidosFilaCozinha.class);
	}
	
	
}