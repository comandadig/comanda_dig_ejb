package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;






/**
 * The persistent class for the comanda database table.
 * 
 */
@Entity
@NamedQuery(name="Comanda.findAll", query="SELECT c FROM Comanda c")
public class Comanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_comanda")
	private int idComanda;

	private String situacao;

	//bi-directional many-to-one association to CartaoComanda
	@ManyToOne
	@JoinColumn(name="id_cartao_comanda")
	private CartaoComanda cartaoComanda;
	
	@ManyToOne
	@JoinColumn(name="id_caixa")
	private Caixa caixa;
	
	@OneToMany(mappedBy="comanda")
	private List<PedidosComanda> pedidosComandas;

	public Comanda() {
	}

	public int getIdComanda() {
		return this.idComanda;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public CartaoComanda getCartaoComanda() {
		return this.cartaoComanda;
	}

	public void setCartaoComanda(CartaoComanda cartaoComanda) {
		this.cartaoComanda = cartaoComanda;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	
	
	

}