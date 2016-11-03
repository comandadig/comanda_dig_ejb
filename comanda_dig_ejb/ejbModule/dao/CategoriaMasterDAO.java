package dao;

import javax.ejb.Stateless;

import model.Menu;



@Stateless
public class CategoriaMasterDAO extends GenericDAO<Menu> {
	
	public CategoriaMasterDAO() {
		super(Menu.class);
	}
	
	
	 
}