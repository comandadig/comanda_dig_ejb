package dao;

import javax.ejb.Stateless;

import model.CartaoComanda;



@Stateless
public class CartaoComandaDAO extends GenericDAO<CartaoComanda> {
	
	public CartaoComandaDAO() {
		super(CartaoComanda.class);
	}
	
	
}