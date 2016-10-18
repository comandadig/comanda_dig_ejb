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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the categoria_menu database table.
 * 
 */
@Entity
@Table(name="categoria")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_categoria")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategoria;

	@Column(name="desconto")
	private double desconto;

	private String descricao;
	
	@Column(name="dir_foto")
	private String dirfoto;

	@Lob
	@XmlTransient
	private byte[] foto;

	private String nome;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="id_categoria",nullable = true)
	private List<Produto> produtosList;

	@XmlTransient
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="id_categoria_master", referencedColumnName="id_categoria_master",nullable = true)
	private CategoriaMaster categoriaMaster;
	
	public Categoria() {
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDirfoto() {
		return dirfoto;
	}

	public void setDirfoto(String dirfoto) {
		this.dirfoto = dirfoto;
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

	public List<Produto> getProdutosList() {
		return produtosList;
	}

	public void setProdutosList(List<Produto> produtosList) {
		this.produtosList = produtosList;
	}

	public CategoriaMaster getCategoriaMaster() {
		return categoriaMaster;
	}

	public void setCategoriaMaster(CategoriaMaster categoriaMaster) {
		this.categoriaMaster = categoriaMaster;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoriaMaster == null) ? 0 : categoriaMaster.hashCode());
		long temp;
		temp = Double.doubleToLongBits(desconto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((dirfoto == null) ? 0 : dirfoto.hashCode());
		result = prime * result + Arrays.hashCode(foto);
		result = prime * result + ((idCategoria == null) ? 0 : idCategoria.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((produtosList == null) ? 0 : produtosList.hashCode());
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
		Categoria other = (Categoria) obj;
		if (categoriaMaster == null) {
			if (other.categoriaMaster != null)
				return false;
		} else if (!categoriaMaster.equals(other.categoriaMaster))
			return false;
		if (Double.doubleToLongBits(desconto) != Double.doubleToLongBits(other.desconto))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (dirfoto == null) {
			if (other.dirfoto != null)
				return false;
		} else if (!dirfoto.equals(other.dirfoto))
			return false;
		if (!Arrays.equals(foto, other.foto))
			return false;
		if (idCategoria == null) {
			if (other.idCategoria != null)
				return false;
		} else if (!idCategoria.equals(other.idCategoria))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (produtosList == null) {
			if (other.produtosList != null)
				return false;
		} else if (!produtosList.equals(other.produtosList))
			return false;
		return true;
	}


	
	
	

	

	

}