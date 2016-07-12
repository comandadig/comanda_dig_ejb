package dao;

import javax.ejb.Stateless;

import model.Comanda;



@Stateless
public class ComandaDAO extends GenericDAO<Comanda> {
	
	public ComandaDAO() {
		super(Comanda.class);
	}
	
	
}