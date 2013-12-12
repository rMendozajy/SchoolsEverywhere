package com.searchschool.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
@Entity

@NamedQueries( {
		@NamedQuery(name = "FindUsuarioByNapellidoUsuarioContaining", query = "select myUsuario from Usuario myUsuario where myUsuario.napellidoUsuario like ?1"),
		@NamedQuery(name = "FindUsuarioByNapellidoUsuarioContainingCount", query = "select count(myUsuario.cusuario) from Usuario myUsuario where myUsuario.napellidoUsuario like ?1"),
		@NamedQuery(name = "FindUsuarioByNnickNameContaining", query = "select myUsuario from Usuario myUsuario where myUsuario.nnickName like ?1"),
		@NamedQuery(name = "FindUsuarioByNnickNameContainingCount", query = "select count(myUsuario.cusuario) from Usuario myUsuario where myUsuario.nnickName like ?1"),
		@NamedQuery(name = "FindUsuarioByTcontraseniaUsuario", query = "select myUsuario from Usuario myUsuario where myUsuario.tcontraseniaUsuario = ?1"),
		@NamedQuery(name = "FindUsuarioByTcontraseniaUsuarioCount", query = "select count(myUsuario.cusuario) from Usuario myUsuario where myUsuario.tcontraseniaUsuario = ?1"),
		@NamedQuery(name = "FindUsuarioByCusuario", query = "select myUsuario from Usuario myUsuario where myUsuario.cusuario = ?1"),
		@NamedQuery(name = "FindUsuarioByCusuarioCount", query = "select count(myUsuario.cusuario) from Usuario myUsuario where myUsuario.cusuario = ?1"),
		@NamedQuery(name = "FindUsuarioByNcorreoUsuario", query = "select myUsuario from Usuario myUsuario where myUsuario.ncorreoUsuario = ?1"),
		@NamedQuery(name = "FindUsuarioByNcorreoUsuarioCount", query = "select count(myUsuario.cusuario) from Usuario myUsuario where myUsuario.ncorreoUsuario = ?1"),
		@NamedQuery(name = "FindUsuarioByNnombreUsuarioContaining", query = "select myUsuario from Usuario myUsuario where myUsuario.nnombreUsuario like ?1"),
		@NamedQuery(name = "FindUsuarioByNnombreUsuarioContainingCount", query = "select count(myUsuario.cusuario) from Usuario myUsuario where myUsuario.nnombreUsuario like ?1"),
		@NamedQuery(name = "FindUsuarioByNcorreoUsuarioContaining", query = "select myUsuario from Usuario myUsuario where myUsuario.ncorreoUsuario like ?1"),
		@NamedQuery(name = "FindUsuarioByNcorreoUsuarioContainingCount", query = "select count(myUsuario.cusuario) from Usuario myUsuario where myUsuario.ncorreoUsuario like ?1"),
		@NamedQuery(name = "FindUsuarioByPrimaryKey", query = "select myUsuario from Usuario myUsuario where myUsuario.cusuario = ?1"),
		@NamedQuery(name = "FindUsuarioByPrimaryKeyCount", query = "select count(myUsuario.cusuario) from Usuario myUsuario where myUsuario.cusuario = ?1"),
		@NamedQuery(name = "FindUsuarioByNnombreUsuario", query = "select myUsuario from Usuario myUsuario where myUsuario.nnombreUsuario = ?1"),
		@NamedQuery(name = "FindUsuarioByNnombreUsuarioCount", query = "select count(myUsuario.cusuario) from Usuario myUsuario where myUsuario.nnombreUsuario = ?1"),
		@NamedQuery(name = "FindUsuarioByTcontraseniaUsuarioContaining", query = "select myUsuario from Usuario myUsuario where myUsuario.tcontraseniaUsuario like ?1"),
		@NamedQuery(name = "FindUsuarioByTcontraseniaUsuarioContainingCount", query = "select count(myUsuario.cusuario) from Usuario myUsuario where myUsuario.tcontraseniaUsuario like ?1"),
		@NamedQuery(name = "FindUsuarioByNapellidoUsuario", query = "select myUsuario from Usuario myUsuario where myUsuario.napellidoUsuario = ?1"),
		@NamedQuery(name = "FindUsuarioByNapellidoUsuarioCount", query = "select count(myUsuario.cusuario) from Usuario myUsuario where myUsuario.napellidoUsuario = ?1"),
		@NamedQuery(name = "FindAllUsuarios", query = "select myUsuario from Usuario myUsuario"),
		@NamedQuery(name = "FindAllUsuariosCount", query = "select count(myUsuario.cusuario) from Usuario myUsuario"),
		@NamedQuery(name = "FindUsuarioByNnickName", query = "select myUsuario from Usuario myUsuario where myUsuario.nnickName = ?1"),
		@NamedQuery(name = "FindUsuarioByNnickNameCount", query = "select count(myUsuario.cusuario) from Usuario myUsuario where myUsuario.nnickName = ?1") })

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CUsuario", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue ( strategy=GenerationType.TABLE, 
	  generator="Usuario_SEQ")
	@TableGenerator(name="Usuario_SEQ", table="tbsequence",
	pkColumnName="SEQ_NAME",valueColumnName="SEQ_COUNT", pkColumnValue="usuario", allocationSize=1)
	private Integer cusuario;

	@Column(name = "NNombreUsuario", length = 50)
	@Basic(fetch = FetchType.EAGER)
	private String nnombreUsuario;
	
	@Column(name = "NApellidoUsuario", length = 50)
	@Basic(fetch = FetchType.EAGER)
	private String napellidoUsuario;
	
	@Column(name = "TContraseniaUsuario", length = 50)
	@Basic(fetch = FetchType.EAGER)
	private String tcontraseniaUsuario;
	
	@Column(name = "NCorreoUsuario", length = 200)
	@Basic(fetch = FetchType.EAGER)
	private String ncorreoUsuario;

	@Column(name = "NNickName", length = 45)
	@Basic(fetch = FetchType.EAGER)
	private String nnickName;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumns( { @JoinColumn(name = "CTipoUsuario", referencedColumnName = "CTipoUsuario") })
	private TipoUsuario tipoUsuario;
	
	@OneToMany(mappedBy = "usuario", cascade = {
			CascadeType.ALL,
			CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private List<ColegioUsuario> colegioUsuarios;
	
	@OneToMany 	(fetch=FetchType.EAGER, mappedBy="usuario",targetEntity=Visitaslogueo.class)
	private List<Visitaslogueo> logueos;
	
	@OneToOne ( optional=true, cascade=CascadeType.ALL, mappedBy="usuario" , targetEntity=Colegio.class)
	private Colegio colegio;
	
	@OneToMany(mappedBy = "usuario", cascade = {
			CascadeType.ALL,
			CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private List<Valoracion> valoracions;
	
	@OneToMany(mappedBy = "usuario", cascade = {
			CascadeType.ALL,
			CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private List<Comentario> comentarios;

	public Usuario() {
	}

	public void setCusuario(Integer cusuario) {
		this.cusuario = cusuario;
	}

	public Integer getCusuario() {
		return this.cusuario;
	}

	public void setNnombreUsuario(String nnombreUsuario) {
		this.nnombreUsuario = nnombreUsuario;
	}

	public String getNnombreUsuario() {
		return this.nnombreUsuario;
	}

	public void setNapellidoUsuario(String napellidoUsuario) {
		this.napellidoUsuario = napellidoUsuario;
	}

	public String getNapellidoUsuario() {
		return this.napellidoUsuario;
	}

	public void setTcontraseniaUsuario(String tcontraseniaUsuario) {
		this.tcontraseniaUsuario = tcontraseniaUsuario;
	}

	public String getTcontraseniaUsuario() {
		return this.tcontraseniaUsuario;
	}

	public void setNcorreoUsuario(String ncorreoUsuario) {
		this.ncorreoUsuario = ncorreoUsuario;
	}

	public String getNcorreoUsuario() {
		return this.ncorreoUsuario;
	}

	public void setNnickName(String nnickName) {
		this.nnickName = nnickName;
	}

	public String getNnickName() {
		return this.nnickName;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public TipoUsuario getTipoUsuario() {

		return this.tipoUsuario;
	}

	public void setColegioUsuarios(List<ColegioUsuario> colegioUsuarios) {
		this.colegioUsuarios = colegioUsuarios;
	}

	public List<ColegioUsuario> getColegioUsuarios() {
		if (colegioUsuarios == null) {
			colegioUsuarios = new ArrayList<ColegioUsuario>();
		}

		return this.colegioUsuarios;
	}

	public void setValoracions(List<Valoracion> valoracions) {
		this.valoracions = valoracions;
	}

	public List<Valoracion> getValoracions() {
		if (valoracions == null) {
			valoracions = new ArrayList<Valoracion>();
		}

		return this.valoracions;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Comentario> getComentarios() {
		if (comentarios == null) {
			comentarios = new ArrayList<Comentario>();
		}

		return this.comentarios;
	}

	public void copy(Usuario that) {
		setCusuario(that.getCusuario());
		setNnombreUsuario(that.getNnombreUsuario());
		setNapellidoUsuario(that.getNapellidoUsuario());
		setTcontraseniaUsuario(that.getTcontraseniaUsuario());
		setNcorreoUsuario(that.getNcorreoUsuario());
		setNnickName(that.getNnickName());
		setTipoUsuario(that.getTipoUsuario());
		setColegioUsuarios(new ArrayList<ColegioUsuario>(that.getColegioUsuarios()));
		setColegio((that.getColegio()));
		setValoracions(new ArrayList<Valoracion>(that.getValoracions()));
		setComentarios(new ArrayList<Comentario>(that.getComentarios()));
	}

	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("cusuario=[").append(cusuario).append("] ");
		buffer.append("nnombreUsuario=[").append(nnombreUsuario).append("] ");
		buffer.append("napellidoUsuario=[").append(napellidoUsuario).append("] ");
		buffer.append("tcontraseniaUsuario=[").append(tcontraseniaUsuario).append("] ");
		buffer.append("ncorreoUsuario=[").append(ncorreoUsuario).append("] ");
		buffer.append("nnickName=[").append(nnickName).append("] ");

		return buffer.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cusuario == null) ? 0 : cusuario.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Usuario))
			return false;
		Usuario equalCheck = (Usuario) obj;
		if ((cusuario == null && equalCheck.cusuario != null) || (cusuario != null && equalCheck.cusuario == null))
			return false;
		if (cusuario != null && !cusuario.equals(equalCheck.cusuario))
			return false;
		return true;
	}

	public Colegio getColegio() {
		return colegio;
	}

	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}

	/**
	 * @return the logueos
	 */
	public List<Visitaslogueo> getLogueos() {
		return logueos;
	}

	/**
	 * @param logueos the logueos to set
	 */
	public void setLogueos(List<Visitaslogueo> logueos) {
		this.logueos = logueos;
	}

}
