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
@Table(name="menu")
@NamedQuery(name="Menu.findAll", query="SELECT c FROM Menu c")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_Menu")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMenu;


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

	public Menu() {
	}

	public Long getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
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

	public List<Categoria> getCategoriaMenus() {
		return categoriaMenus;
	}

	public void setCategoriaMenus(List<Categoria> categoriaMenus) {
		this.categoriaMenus = categoriaMenus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	

	

	

	

}