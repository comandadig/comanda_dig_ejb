package dao;

import javax.ejb.Stateless;

import model.Pedido;



@Stateless
public class PedidoDAO extends GenericDAO<Pedido> {
	
	public PedidoDAO() {
		super(Pedido.class);
	}
	
	
	 
}