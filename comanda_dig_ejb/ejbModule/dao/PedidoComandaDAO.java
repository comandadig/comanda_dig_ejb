package dao;

import javax.ejb.Stateless;

import model.Pedido;



@Stateless
public class PedidoComandaDAO extends GenericDAO<Pedido> {
	
	public PedidoComandaDAO() {
		super(Pedido.class);
	}
	
	
	 
}