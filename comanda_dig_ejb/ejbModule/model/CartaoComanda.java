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
	private int idCartaoComanda;

    
	@Column(name="cod_comanda")
	private int codComanda;

	private String situacao;

	public int getIdCartaoComanda() {
		return idCartaoComanda;
	}

	public void setIdCartaoComanda(int idCartaoComanda) {
		this.idCartaoComanda = idCartaoComanda;
	}

	public int getCodComanda() {
		return codComanda;
	}

	public void setCodComanda(int codComanda) {
		this.codComanda = codComanda;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}