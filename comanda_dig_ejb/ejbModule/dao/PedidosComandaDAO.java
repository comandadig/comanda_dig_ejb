package dao;

import javax.ejb.Stateless;

import model.PedidosComanda;



@Stateless
public class PedidosComandaDAO extends GenericDAO<PedidosComanda> {
	
	public PedidosComandaDAO() {
		super(PedidosComanda.class);
	}
	
	
	 
}