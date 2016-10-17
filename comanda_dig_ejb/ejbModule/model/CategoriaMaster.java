package model;

import java.io.Serializable;
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
@Table(name="categoria_master")
@NamedQuery(name="CategoriaMaster.findAll", query="SELECT c FROM CategoriaMaster c")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CategoriaMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_categoria_master")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategoriaMaster;


	private String descricao;
	
	@Column(name="dir_foto")
	private String dirfoto;

	@Lob
	@XmlTransient
	private byte[] foto;

	private String nome;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="id_categoria_master",nullable = true)
	private List<Categoria> categoriaMenus;

	public CategoriaMaster() {
	}

	

	public Long getIdCategoriaMaster() {
		return idCategoriaMaster;
	}



	public void setIdCategoriaMaster(Long idCategoriaMaster) {
		this.idCategoriaMaster = idCategoriaMaster;
	}



	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getFoto() {
		return this.foto;
	}

	

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public List<Categoria> getCategoriaMenus() {
		return categoriaMenus;
	}



	public void setCategoriaMenus(List<Categoria> categoriaMenus) {
		this.categoriaMenus = categoriaMenus;
	}



	public String getDirfoto() {
		return dirfoto;
	}

	public void setDirfoto(String dirfoto) {
		this.dirfoto = dirfoto;
	}

	

	

	

}