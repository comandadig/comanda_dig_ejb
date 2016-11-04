package dao;

import javax.ejb.Stateless;

import model.Menu;



@Stateless
public class MenuDAO extends GenericDAO<Menu> {
	
	public MenuDAO() {
		super(Menu.class);
	}
	
	
	 
}