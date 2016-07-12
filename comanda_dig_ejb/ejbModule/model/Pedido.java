package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


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

	@Temporal(TemporalType.DATE)
	@Column(name="dt_fim_fila")
	private Date dtFimFila;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_ini_fila")
	private Date dtIniFila;

	private String obs;

	private String situacao;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="pedido")
	private List<ItemMenu> itemMenu;

	//bi-directional many-to-one association to PedidosComanda
	@ManyToOne
	@JoinColumn(name="id_pedidos_comanda")
	private PedidosComanda pedidosComanda;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

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



	

	public List<ItemMenu> getItemMenu() {
		return itemMenu;
	}

	public void setItemMenu(List<ItemMenu> itemMenu) {
		this.itemMenu = itemMenu;
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
	
	

}