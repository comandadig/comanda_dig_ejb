package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pedidos_fila_bar database table.
 * 
 */
@Entity
@Table(name="pedidos_fila_bar")
@NamedQuery(name="PedidosFilaBar.findAll", query="SELECT p FROM PedidosFilaBar p")
public class PedidosFilaBar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pedidos_fila_bar")
	private int idPedidosFilaBar;

	private String situacao;
	
	@ManyToOne
	@JoinColumn(name="id_pedido")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="id_fila_bar")
	private FilaBar filaBar;

	public PedidosFilaBar() {
	}

	public int getIdPedidosFilaBar() {
		return this.idPedidosFilaBar;
	}

	public void setIdPedidosFilaBar(int idPedidosFilaBar) {
		this.idPedidosFilaBar = idPedidosFilaBar;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public FilaBar getFilaBar() {
		return filaBar;
	}

	public void setFilaBar(FilaBar filaBar) {
		this.filaBar = filaBar;
	}
	
	

}