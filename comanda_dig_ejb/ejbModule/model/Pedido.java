package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private Long idPedido;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_fila")
	private Date dtFimFila;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_ini_fila")
	private Date dtIniFila;

	private String obs;

	private String situacao;
	
	private Integer quantItem;

	

	//bi-directional many-to-one association to PedidosComanda
	@ManyToOne
	@JoinColumn(name="id_pedidos_comanda")
	private PedidosComanda pedidosComanda;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	
	
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_produto")
	private Produto produto;

	
	@OneToMany(mappedBy="pedido")
	private List<PedidosFilaBar> filaBars;
	
	@OneToMany(mappedBy="pedido")
	private List<PedidosFilaCozinha> filaCozinhas;
	
	public Pedido() {
	}

	public Long getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDtFimFila() {
		return this.dtFimFila;
	}

	public void setDtFimFila(Date dtFimFila) {
		this.dtFimFila = dtFimFila;
	}

	public Date getDtIniFila() {
		return this.dtIniFila;
	}

	public void setDtIniFila(Date dtIniFila) {
		this.dtIniFila = dtIniFila;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}



	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public PedidosComanda getPedidosComanda() {
		return this.pedidosComanda;
	}

	public void setPedidosComanda(PedidosComanda pedidosComanda) {
		this.pedidosComanda = pedidosComanda;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PedidosFilaBar> getFilaBars() {
		return filaBars;
	}

	public void setFilaBars(List<PedidosFilaBar> filaBars) {
		this.filaBars = filaBars;
	}

	public List<PedidosFilaCozinha> getFilaCozinhas() {
		return filaCozinhas;
	}

	public void setFilaCozinhas(List<PedidosFilaCozinha> filaCozinhas) {
		this.filaCozinhas = filaCozinhas;
	}

	public Integer getQuantItem() {
		return quantItem;
	}

	public void setQuantItem(Integer quantItem) {
		this.quantItem = quantItem;
	}
	
	

}