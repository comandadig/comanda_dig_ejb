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
@Table(name="categoria_menu")
@NamedQuery(name="CategoriaMenu.findAll", query="SELECT c FROM CategoriaMenu c")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CategoriaMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_categoria_menu")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategoriaMenu;

	@Column(name="desconto_cat")
	private double descontoCat;

	private String descricao;
	
	private String dir_foto;

	@Lob
	@XmlTransient
	private byte[] foto;

	private String nome;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="id_categoria_menu")
	private List<ItemMenu> itemMenuList;

	public CategoriaMenu() {
	}

	public Long getIdCategoriaMenu() {
		return this.idCategoriaMenu;
	}

	public void setIdCategoriaMenu(Long idCategoriaMenu) {
		this.idCategoriaMenu = idCategoriaMenu;
	}

	public double getDescontoCat() {
		return this.descontoCat;
	}

	public void setDescontoCat(double descontoCat) {
		this.descontoCat = descontoCat;
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

	

	public List<ItemMenu> getItemMenuList() {
		return itemMenuList;
	}

	public void setItemMenuList(List<ItemMenu> itemMenuList) {
		this.itemMenuList = itemMenuList;
	}

	public String getDir_foto() {
		return dir_foto;
	}

	public void setDir_foto(String dir_foto) {
		this.dir_foto = dir_foto;
	}

	

	

}