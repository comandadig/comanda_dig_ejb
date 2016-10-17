package dao;

import javax.ejb.Stateless;

import model.Produto;



@Stateless
public class ItemMenuDAO extends GenericDAO<Produto> {
	
	public ItemMenuDAO() {
		super(Produto.class);
	}
	
	
	 
}