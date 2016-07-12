package model;



import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the caixa database table.
 * 
 */
@Entity
@NamedQuery(name="Caixa.findAll", query="SELECT c FROM Caixa c")
public class Caixa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_caixa")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCaixa;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_abertura")
	private Date dtAbertura;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_fechamento")
	private Date dtFechamento;

	private String situacao;
	
	//bi-directional many-to-one association to Comanda
	@OneToMany(mappedBy="caixa")
	private List<Comanda> comandas;
	
	@OneToMany(mappedBy="caixa")
	private List<FilaBar> filaBars ;
	
	@OneToMany(mappedBy="caixa")
	private List<FilaCozinha> filaCozinhas;
	

	public Caixa() {
	}

	public Long getIdCaixa() {
		return this.idCaixa;
	}

	public void setIdCaixa(Long idCaixa) {
		this.idCaixa = idCaixa;
	}

	public Date getDtAbertura() {
		return this.dtAbertura;
	}

	public void setDtAbertura(Date dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public Date getDtFechamento() {
		return this.dtFechamento;
	}

	public void setDtFechamento(Date dtFechamento) {
		this.dtFechamento = dtFechamento;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public List<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(List<Comanda> comandas) {
		this.comandas = comandas;
	}

	public List<FilaBar> getFilaBars() {
		return filaBars;
	}

	public void setFilaBars(List<FilaBar> filaBars) {
		this.filaBars = filaBars;
	}

	public List<FilaCozinha> getFilaCozinhas() {
		return filaCozinhas;
	}

	public void setFilaCozinhas(List<FilaCozinha> filaCozinhas) {
		this.filaCozinhas = filaCozinhas;
	}
	
	

}