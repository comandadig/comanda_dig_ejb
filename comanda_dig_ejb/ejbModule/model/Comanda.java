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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_comanda")
	private Long idComanda;

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

	
	private String nome;
	private String telefone;
	private String documento;
	private Boolean sexo;
	private Integer mesa;
	
	public Comanda() {
	}

	public Long getIdComanda() {
		return this.idComanda;
	}

	public void setIdComanda(Long idComanda) {
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

	public List<PedidosComanda> getPedidosComandas() {
		return pedidosComandas;
	}

	public void setPedidosComandas(List<PedidosComanda> pedidosComandas) {
		this.pedidosComandas = pedidosComandas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Boolean getSexo() {
		return sexo;
	}

	public void setSexo(Boolean sexo) {
		this.sexo = sexo;
	}

	public Integer getMesa() {
		return mesa;
	}

	public void setMesa(Integer mesa) {
		this.mesa = mesa;
	}

	
	
	

}