package dao;

import javax.ejb.Stateless;

import model.Caixa;



@Stateless
public class CaixaDAO extends GenericDAO<Caixa> {
	
	public CaixaDAO() {
		super(Caixa.class);
	}
	
	
	 
}