package dao;

import javax.ejb.Stateless;

import model.CategoriaMaster;



@Stateless
public class CategoriaMasterDAO extends GenericDAO<CategoriaMaster> {
	
	public CategoriaMasterDAO() {
		super(CategoriaMaster.class);
	}
	
	
	 
}