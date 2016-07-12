package dao;

import javax.ejb.Stateless;

import model.FilaBar;



@Stateless
public class FilaBarDAO extends GenericDAO<FilaBar> {
	
	public FilaBarDAO() {
		super(FilaBar.class);
	}
	
	
}