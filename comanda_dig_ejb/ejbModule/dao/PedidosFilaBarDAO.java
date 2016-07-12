package dao;

import javax.ejb.Stateless;

import model.PedidosFilaBar;



@Stateless
public class PedidosFilaBarDAO extends GenericDAO<PedidosFilaBar> {
	
	public PedidosFilaBarDAO() {
		super(PedidosFilaBar.class);
	}
	
	
}