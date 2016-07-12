package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the fila_cozinha database table.
 * 
 */
@Entity
@Table(name="fila_cozinha")
@NamedQuery(name="FilaCozinha.findAll", query="SELECT f FROM FilaCozinha f")
public class FilaCozinha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_fila_cozinha")
	private int idFilaCozinha;

	private String situacao;
	
	@ManyToOne
	@JoinColumn(name="id_caixa")
	private Caixa caixa;
	
	@OneToMany(mappedBy="filaCozinha")
	private List<PedidosFilaCozinha> filaCozinhas;
	

	public FilaCozinha() {
	}

	public int getIdFilaCozinha() {
		return this.idFilaCozinha;
	}

	public void setIdFilaCozinha(int idFilaCozinha) {
		this.idFilaCozinha = idFilaCozinha;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public List<PedidosFilaCozinha> getFilaCozinhas() {
		return filaCozinhas;
	}

	public void setFilaCozinhas(List<PedidosFilaCozinha> filaCozinhas) {
		this.filaCozinhas = filaCozinhas;
	}
	
	

}