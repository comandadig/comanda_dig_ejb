package dao;

import javax.ejb.Stateless;

import model.Produto;



@Stateless
public class ProdutoDAO extends GenericDAO<Produto> {
	
	public ProdutoDAO() {
		super(Produto.class);
	}
	
	
	 
}