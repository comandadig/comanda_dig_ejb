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
@NamedQuery(name="Caixa.caixaDisponivel", query="SELECT c FROM Caixa c where c.situacao = 'ABERTO'")
public class Caixa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String CAIXA_DISPONIVEL = "Caixa.caixaDisponivel";

	@Id
	@Column(name="id_caixa")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCaixa;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_abertura")
	private Date dtAbertura;

	@Temporal(TemporalType.TIMESTAMP)
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
	
	private Boolean cadastroCliente;
	private Boolean conver;
	private Double valorConver;
	private Boolean entrada;
	private Double valorEntrada;
	private Boolean entradaMasFem;
	private Double valorEntradaFem;
	private Double valorEntradaMas;
	
	
	
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

	public Boolean getCadastroCliente() {
		return cadastroCliente;
	}

	public void setCadastroCliente(Boolean cadastroCliente) {
		this.cadastroCliente = cadastroCliente;
	}

	public Boolean getConver() {
		return conver;
	}

	public void setConver(Boolean conver) {
		this.conver = conver;
	}

	public Double getValorConver() {
		return valorConver;
	}

	public void setValorConver(Double valorConver) {
		this.valorConver = valorConver;
	}

	public Boolean getEntrada() {
		return entrada;
	}

	public void setEntrada(Boolean entrada) {
		this.entrada = entrada;
	}

	public Double getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(Double valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public Boolean getEntradaMasFem() {
		return entradaMasFem;
	}

	public void setEntradaMasFem(Boolean entradaMasFem) {
		this.entradaMasFem = entradaMasFem;
	}

	public Double getValorEntradaFem() {
		return valorEntradaFem;
	}

	public void setValorEntradaFem(Double valorEntradaFem) {
		this.valorEntradaFem = valorEntradaFem;
	}

	public Double getValorEntradaMas() {
		return valorEntradaMas;
	}

	public void setValorEntradaMas(Double valorEntradaMas) {
		this.valorEntradaMas = valorEntradaMas;
	}
	
	

}