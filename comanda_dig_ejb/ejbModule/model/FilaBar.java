package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the fila_bar database table.
 * 
 */
@Entity
@Table(name="fila_bar")
@NamedQuery(name="FilaBar.findAll", query="SELECT f FROM FilaBar f")
public class FilaBar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_fila_bar")
	private Integer idFilaBar;

	@ManyToOne
	@JoinColumn(name="id_caixa")
	private Caixa caixa;
	
	@OneToMany(mappedBy="filaBar")
	private List<PedidosFilaBar> filaBars;
	
	private String situacao;

	public FilaBar() {
	}

	public int getIdFilaBar() {
		return this.idFilaBar;
	}

	public void setIdFilaBar(int idFilaBar) {
		this.idFilaBar = idFilaBar;
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

	public List<PedidosFilaBar> getFilaBars() {
		return filaBars;
	}

	public void setFilaBars(List<PedidosFilaBar> filaBars) {
		this.filaBars = filaBars;
	}

	
}