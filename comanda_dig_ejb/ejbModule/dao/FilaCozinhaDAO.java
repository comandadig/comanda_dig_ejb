package dao;

import javax.ejb.Stateless;

import model.FilaCozinha;



@Stateless
public class FilaCozinhaDAO extends GenericDAO<FilaCozinha> {
	
	public FilaCozinhaDAO() {
		super(FilaCozinha.class);
	}
	
	
}