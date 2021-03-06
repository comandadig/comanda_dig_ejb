package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cartao_comanda database table.
 * 
 */

@Entity
@Table(name="cartao_comanda")
@NamedQuery(name="CartaoComanda.CARTAO_ATIVO", query="SELECT c FROM CartaoComanda c where c.codComanda = :codComanda and c.situacao = 'ATIVO'")
public class CartaoComanda implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String CARTAO_ATIVO = "CartaoComanda.CARTAO_ATIVO";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cartao_comanda")
	private Long idCartaoComanda;

	@Column(name="cod_comanda",unique=true)
	private String codComanda;

	private String situacao;

	//bi-directional many-to-one association to Comanda
	@OneToMany(mappedBy="cartaoComanda")
	private List<Comanda> comandas;

	public CartaoComanda() {
	}

	public Long getIdCartaoComanda() {
		return this.idCartaoComanda;
	}

	public void setIdCartaoComanda(Long idCartaoComanda) {
		this.idCartaoComanda = idCartaoComanda;
	}

	public String getCodComanda() {
		return this.codComanda;
	}

	public void setCodComanda(String codComanda) {
		this.codComanda = codComanda;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public List<Comanda> getComandas() {
		return this.comandas;
	}

	public void setComandas(List<Comanda> comandas) {
		this.comandas = comandas;
	}

	public Comanda addComanda(Comanda comanda) {
		getComandas().add(comanda);
		comanda.setCartaoComanda(this);

		return comanda;
	}

	public Comanda removeComanda(Comanda comanda) {
		getComandas().remove(comanda);
		comanda.setCartaoComanda(null);

		return comanda;
	}

}