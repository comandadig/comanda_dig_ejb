package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQueries(
{@NamedQuery(name="User.findAll",   query="SELECT u FROM User u"),
@NamedQuery(name="User.findByLogin", query="SELECT u from User u where u.login = :login"),
@NamedQuery(name="User.findByEmail", query="SELECT u from User u where u.email = :email")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FIND_BY_LOGIN = "User.findByLogin";
	public static final String FIND_BY_EMAIL = "User.findByEmail";
	
	@Id
	@Column(name="id_user")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser;

	private String celular;

	private String cpf;
	
	private String email;

	@Lob
	@XmlTransient
	private byte[] foto;

	private String login;

	private String nome;

	private String senha;

	private String telefone;
	
	@Column(name="dir_foto")
	private String dirFoto;

	
	@Transient
	private Endereco endereco;

	@Transient
	private SalarioUser salarioUser;

	@Transient
	private TipoUser tipoUser;

	@Transient
	@XmlTransient
	@OneToMany(mappedBy="user")
	private List<Pedido> pedidos;
	
	public User() {
	}


	public Long getIdUser() {
		return idUser;
	}




	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}







	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public SalarioUser getSalarioUser() {
		return salarioUser;
	}

	public void setSalarioUser(SalarioUser salarioUser) {
		this.salarioUser = salarioUser;
	}

	public TipoUser getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(TipoUser tipoUser) {
		this.tipoUser = tipoUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getFindByLogin() {
		return FIND_BY_LOGIN;
	}

	public static String getFindByEmail() {
		return FIND_BY_EMAIL;
	}


	public String getDirFoto() {
		return dirFoto;
	}


	public void setDirFoto(String dirFoto) {
		this.dirFoto = dirFoto;
	}


	public List<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


	
	
	

}