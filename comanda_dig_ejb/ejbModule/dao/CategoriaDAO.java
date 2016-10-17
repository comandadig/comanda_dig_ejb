package dao;

import javax.ejb.Stateless;

import model.Categoria;



@Stateless
public class CategoriaDAO extends GenericDAO<Categoria> {
	
	public CategoriaDAO() {
		super(Categoria.class);
	}
	 
}