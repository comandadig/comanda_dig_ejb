package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pedidos_comanda database table.
 * 
 */
@Entity
@Table(name="pedidos_comanda")
@NamedQuery(name="PedidosComanda.findAll", query="SELECT p FROM PedidosComanda p")
public class PedidosComanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pedidos_comanda")
	private int idPedidosComanda;

	private String mesa;

	@Column(name="valor_total_pedidos")
	private double valorTotalPedidos;

	//bi-directional many-to-one association to Comanda
	@ManyToOne
	@JoinColumn(name="id_comanda")
	private Comanda comanda;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="pedidosComanda")
	private List<Pedido> pedidos;

	public PedidosComanda() {
	}

	public int getIdPedidosComanda() {
		return this.idPedidosComanda;
	}

	public void setIdPedidosComanda(int idPedidosComanda) {
		this.idPedidosComanda = idPedidosComanda;
	}

	public String getMesa() {
		return this.mesa;
	}

	public void setMesa(String mesa) {
		this.mesa = mesa;
	}

	public double getValorTotalPedidos() {
		return this.valorTotalPedidos;
	}

	public void setValorTotalPedidos(double valorTotalPedidos) {
		this.valorTotalPedidos = valorTotalPedidos;
	}

	public Comanda getComanda() {
		return this.comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setPedidosComanda(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setPedidosComanda(null);

		return pedido;
	}

}