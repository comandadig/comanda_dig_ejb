package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the comanda database table.
 * 
 */
@Entity
@Table(name="cartao_comanda")
@NamedQuery(name="CartaoComanda.findAll", query="SELECT c FROM CartaoComanda c")
public class CartaoComanda implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	public CartaoComanda() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cartao_comanda")
	private Long idCartaoComanda;

    
	@Column(name="cod_comanda")
	private String codComanda;

	private String situacao;



	public Long getIdCartaoComanda() {
		return idCartaoComanda;
	}

	public void setIdCartaoComanda(Long idCartaoComanda) {
		this.idCartaoComanda = idCartaoComanda;
	}

	public String getCodComanda() {
		return codComanda;
	}

	public void setCodComanda(String codComanda) {
		this.codComanda = codComanda;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	




	


}