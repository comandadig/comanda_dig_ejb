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
@NamedQuery(name="PedidosComanda.findByComanda", query="SELECT p FROM PedidosComanda p where p.comanda.idComanda = :idComanda")
public class PedidosComanda implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_BY_COMANDA = "PedidosComanda.findByComanda";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedidos_comanda")
	private Long idPedidosComanda;


	//bi-directional many-to-one association to Comanda
	@ManyToOne
	@JoinColumn(name="id_comanda")
	private Comanda comanda;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="pedidosComanda")
	private List<Pedido> pedidos;

	public PedidosComanda() {
	}

	public Long getIdPedidosComanda() {
		return this.idPedidosComanda;
	}

	public void setIdPedidosComanda(Long idPedidosComanda) {
		this.idPedidosComanda = idPedidosComanda;
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