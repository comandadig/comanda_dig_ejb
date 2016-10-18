package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the item_menu database table.
 * 
 */
@Entity
@Table(name="produto")
@NamedQueries({
@NamedQuery(name="Produto.findAll", query="SELECT i FROM Produto i")
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_produto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduto;

	private double desconto;

	@Column(name="descricao_ingredientes")
	private String descricaoIngredientes;

	@Column(name="fila_preparo")
	private String filaPreparo;
	
	@Column(name="dir_foto")
	private String dirFoto;

	@Lob
	@XmlTransient
	private byte[] foto;

	private String nome;

	private String quant;

	private String situacao;

	private Double valor;
	
	
	@XmlTransient
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="id_categoria", referencedColumnName="id_categoria",nullable = true)
	private Categoria categoria;
	
	@XmlTransient
	@OneToMany(mappedBy="produto")
	private List<Pedido> pedidos;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public String getDescricaoIngredientes() {
		return descricaoIngredientes;
	}

	public void setDescricaoIngredientes(String descricaoIngredientes) {
		this.descricaoIngredientes = descricaoIngredientes;
	}

	public String getFilaPreparo() {
		return filaPreparo;
	}

	public void setFilaPreparo(String filaPreparo) {
		this.filaPreparo = filaPreparo;
	}

	public String getDirFoto() {
		return dirFoto;
	}

	public void setDirFoto(String dirFoto) {
		this.dirFoto = dirFoto;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQuant() {
		return quant;
	}

	public void setQuant(String quant) {
		this.quant = quant;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		long temp;
		temp = Double.doubleToLongBits(desconto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((descricaoIngredientes == null) ? 0 : descricaoIngredientes.hashCode());
		result = prime * result + ((dirFoto == null) ? 0 : dirFoto.hashCode());
		result = prime * result + ((filaPreparo == null) ? 0 : filaPreparo.hashCode());
		result = prime * result + Arrays.hashCode(foto);
		result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pedidos == null) ? 0 : pedidos.hashCode());
		result = prime * result + ((quant == null) ? 0 : quant.hashCode());
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (Double.doubleToLongBits(desconto) != Double.doubleToLongBits(other.desconto))
			return false;
		if (descricaoIngredientes == null) {
			if (other.descricaoIngredientes != null)
				return false;
		} else if (!descricaoIngredientes.equals(other.descricaoIngredientes))
			return false;
		if (dirFoto == null) {
			if (other.dirFoto != null)
				return false;
		} else if (!dirFoto.equals(other.dirFoto))
			return false;
		if (filaPreparo == null) {
			if (other.filaPreparo != null)
				return false;
		} else if (!filaPreparo.equals(other.filaPreparo))
			return false;
		if (!Arrays.equals(foto, other.foto))
			return false;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pedidos == null) {
			if (other.pedidos != null)
				return false;
		} else if (!pedidos.equals(other.pedidos))
			return false;
		if (quant == null) {
			if (other.quant != null)
				return false;
		} else if (!quant.equals(other.quant))
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	



	
}