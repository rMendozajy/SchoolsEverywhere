package com.searchschool.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
@Table (name="colegio")

@NamedQueries( {
		@NamedQuery(name = "FindColegioByDfundacionColegio", query = "select myColegio from Colegio myColegio where myColegio.dfundacionColegio = ?1"),
		@NamedQuery(name = "FindColegioByDfundacionColegioCount", query = "select count(myColegio.ccolegio) from Colegio myColegio where myColegio.dfundacionColegio = ?1"),
		@NamedQuery(name = "FindColegioByCcolegio", query = "select myColegio from Colegio myColegio where myColegio.ccolegio = ?1"),
		@NamedQuery(name = "FindColegioByCcolegioCount", query = "select count(myColegio.ccolegio) from Colegio myColegio where myColegio.ccolegio = ?1"),
		@NamedQuery(name = "FindColegioByTpaginaWeb", query = "select myColegio from Colegio myColegio where myColegio.tpaginaWeb = ?1"),
		@NamedQuery(name = "FindColegioByTpaginaWebCount", query = "select count(myColegio.ccolegio) from Colegio myColegio where myColegio.tpaginaWeb = ?1"),
		@NamedQuery(name = "FindColegioByPrimaryKey", query = "select myColegio from Colegio myColegio where myColegio.ccolegio = ?1"),
		@NamedQuery(name = "FindColegioByPrimaryKeyCount", query = "select count(myColegio.ccolegio) from Colegio myColegio where myColegio.ccolegio = ?1"),
		@NamedQuery(name = "FindColegioByDfundacionColegioContaining", query = "select myColegio from Colegio myColegio where myColegio.dfundacionColegio like ?1"),
		@NamedQuery(name = "FindColegioByDfundacionColegioContainingCount", query = "select count(myColegio.ccolegio) from Colegio myColegio where myColegio.dfundacionColegio like ?1"),
		@NamedQuery(name = "FindColegioByTdescripcionColegio", query = "select myColegio from Colegio myColegio where myColegio.tdescripcionColegio = ?1"),
		@NamedQuery(name = "FindColegioByTdescripcionColegioCount", query = "select count(myColegio.ccolegio) from Colegio myColegio where myColegio.tdescripcionColegio = ?1"),
		@NamedQuery(name = "FindColegioByTelefonoPrincipalColegioContaining", query = "select myColegio from Colegio myColegio where myColegio.telefonoPrincipalColegio like ?1"),
		@NamedQuery(name = "FindColegioByTelefonoPrincipalColegioContainingCount", query = "select count(myColegio.ccolegio) from Colegio myColegio where myColegio.telefonoPrincipalColegio like ?1"),
		@NamedQuery(name = "FindColegioByNcolegioContaining", query = "select myColegio from Colegio myColegio where myColegio.ncolegio like ?1"),
		@NamedQuery(name = "FindColegioByNcolegioContainingCount", query = "select count(myColegio.ccolegio) from Colegio myColegio where myColegio.ncolegio like ?1"),
		@NamedQuery(name = "FindColegioByTpaginaWebContaining", query = "select myColegio from Colegio myColegio where myColegio.tpaginaWeb like ?1"),
		@NamedQuery(name = "FindColegioByTpaginaWebContainingCount", query = "select count(myColegio.ccolegio) from Colegio myColegio where myColegio.tpaginaWeb like ?1"),
		@NamedQuery(name = "FindColegioByQvaloracionPromedio", query = "select myColegio from Colegio myColegio where myColegio.qvaloracionPromedio = ?1"),
		@NamedQuery(name = "FindColegioByQvaloracionPromedioCount", query = "select count(myColegio.ccolegio) from Colegio myColegio where myColegio.qvaloracionPromedio = ?1"),
		@NamedQuery(name = "FindColegioByNcolegio", query = "select myColegio from Colegio myColegio where myColegio.ncolegio = ?1"),
		@NamedQuery(name = "FindColegioByNcolegioCount", query = "select count(myColegio.ccolegio) from Colegio myColegio where myColegio.ncolegio = ?1"),
		@NamedQuery(name = "FindColegioByTelefonoPrincipalColegio", query = "select myColegio from Colegio myColegio where myColegio.telefonoPrincipalColegio = ?1"),
		@NamedQuery(name = "FindColegioByTelefonoPrincipalColegioCount", query = "select count(myColegio.ccolegio) from Colegio myColegio where myColegio.telefonoPrincipalColegio = ?1"),
		@NamedQuery(name = "FindColegioByTdescripcionColegioContaining", query = "select myColegio from Colegio myColegio where myColegio.tdescripcionColegio like ?1"),
		@NamedQuery(name = "FindColegioByTdescripcionColegioContainingCount", query = "select count(myColegio.ccolegio) from Colegio myColegio where myColegio.tdescripcionColegio like ?1"),
		@NamedQuery(name = "FindAllColegios", query = "select myColegio from Colegio myColegio"),
		@NamedQuery(name = "FindAllColegiosCount", query = "select count(myColegio.ccolegio) from Colegio myColegio") })
public class Colegio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CColegio", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue ( strategy=GenerationType.TABLE, 
	  generator="Colegio_SEQ")
	@TableGenerator(name="Colegio_SEQ", table="tbsequence",
	pkColumnName="SEQ_NAME",
	valueColumnName="SEQ_COUNT",
	pkColumnValue="colegio",
	allocationSize=1)
	private Integer ccolegio;

	@Column(name = "TelefonoPrincipalColegio", length = 20)
	@Basic(fetch = FetchType.EAGER)
	private String telefonoPrincipalColegio;

	@Column(name = "NColegio", length = 200)
	@Basic(fetch = FetchType.EAGER)
	private String ncolegio;

	@Column(name = "TDescripcionColegio", length = 1000)
	@Basic(fetch = FetchType.EAGER)
	private String tdescripcionColegio;

	@Column(name = "DFundacionColegio", length = 20)
	@Basic(fetch = FetchType.EAGER)
	private String dfundacionColegio;

	@Column(name = "TPaginaWeb", length = 100)
	@Basic(fetch = FetchType.EAGER)
	private String tpaginaWeb;
	
	@Column(name = "TUrlImagen", length = 100)
	@Basic(fetch = FetchType.EAGER)
	private String turlImagen;

	@Column(name = "QValoracionPromedio")
	@Basic(fetch = FetchType.EAGER)
	private Integer qvaloracionPromedio;
	
	@Column(name = "PosX")
	@Basic(fetch = FetchType.EAGER)
	private Double posX;
	
	@Column(name = "PosY")
	@Basic(fetch = FetchType.EAGER)
	private Double posY;

	@OneToOne( optional=false, fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumns( { @JoinColumn(name = "CUsuario", referencedColumnName = "CUsuario") })
	private Usuario usuario;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumns( { @JoinColumn(name = "CRedColegio", referencedColumnName = "CRedColegio") })
	private RedColegio redColegio;
	
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumns( { @JoinColumn(name = "CTipoColegio", referencedColumnName = "CTipoColegio") })
	private TipoColegio tipoColegio;
	
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumns( { @JoinColumn(name = "COrigen", referencedColumnName = "COrigen") })
	private Origen origen;
	
	@OneToMany(mappedBy = "colegio", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<ColegioUsuario> colegioUsuarios;
	
	@OneToMany(mappedBy = "colegio", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<Valoracion> valoracions;
		
	@OneToMany(mappedBy = "colegio", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<Comentario> comentarios;
	
	@OneToMany(mappedBy = "colegio", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<ConvenioColegio> convenioColegios;
	
	public Colegio() {
	}

	public void setCcolegio(Integer ccolegio) {
		this.ccolegio = ccolegio;
	}

	public Integer getCcolegio() {
		return this.ccolegio;
	}

	public void setTelefonoPrincipalColegio(String telefonoPrincipalColegio) {
		this.telefonoPrincipalColegio = telefonoPrincipalColegio;
	}

	public String getTelefonoPrincipalColegio() {
		return this.telefonoPrincipalColegio;
	}

	public void setNcolegio(String ncolegio) {
		this.ncolegio = ncolegio;
	}

	public String getNcolegio() {
		return this.ncolegio;
	}

	public void setTdescripcionColegio(String tdescripcionColegio) {
		this.tdescripcionColegio = tdescripcionColegio;
	}

	public String getTdescripcionColegio() {
		return this.tdescripcionColegio;
	}

	public void setDfundacionColegio(String dfundacionColegio) {
		this.dfundacionColegio = dfundacionColegio;
	}

	public String getDfundacionColegio() {
		return this.dfundacionColegio;
	}

	public void setTpaginaWeb(String tpaginaWeb) {
		this.tpaginaWeb = tpaginaWeb;
	}

	public String getTpaginaWeb() {
		return this.tpaginaWeb;
	}

	public void setQvaloracionPromedio(Integer qvaloracionPromedio) {
		this.qvaloracionPromedio = qvaloracionPromedio;
	}

	public Integer getQvaloracionPromedio() {
		return this.qvaloracionPromedio;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {

		return this.usuario;
	}

	public void setRedColegio(RedColegio redColegio) {
		this.redColegio = redColegio;
	}

	public RedColegio getRedColegio() {

		return this.redColegio;
	}

	public void setTipoColegio(TipoColegio tipoColegio) {
		this.tipoColegio = tipoColegio;
	}

	public TipoColegio getTipoColegio() {

		return this.tipoColegio;
	}

	public void setOrigen(Origen origen) {
		this.origen = origen;
	}

	public Origen getOrigen() {

		return this.origen;
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

	public void setConvenioColegios(List<ConvenioColegio> convenioColegios) {
		this.convenioColegios = convenioColegios;
	}

	public List<ConvenioColegio> getConvenioColegios() {
		if (convenioColegios == null) {
			convenioColegios = new ArrayList<ConvenioColegio>();
		}

		return this.convenioColegios;
	}

	public void copy(Colegio that) {
		setCcolegio(that.getCcolegio());
		setTelefonoPrincipalColegio(that.getTelefonoPrincipalColegio());
		setNcolegio(that.getNcolegio());
		setTdescripcionColegio(that.getTdescripcionColegio());
		setDfundacionColegio(that.getDfundacionColegio());
		setTpaginaWeb(that.getTpaginaWeb());
		setQvaloracionPromedio(that.getQvaloracionPromedio());
		setUsuario(that.getUsuario());
		setRedColegio(that.getRedColegio());
		setTipoColegio(that.getTipoColegio());
		setOrigen(that.getOrigen());
		setComentarios(new ArrayList<Comentario>(that.getComentarios()));
		setConvenioColegios(new ArrayList<ConvenioColegio>(that.getConvenioColegios()));
		setColegioUsuarios(new ArrayList<ColegioUsuario>(that.getColegioUsuarios()));
		setValoracions(new ArrayList<Valoracion>(that.getValoracions()));
	}

	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("ccolegio=[").append(ccolegio).append("] ");
		buffer.append("telefonoPrincipalColegio=[").append(telefonoPrincipalColegio).append("] ");
		buffer.append("ncolegio=[").append(ncolegio).append("] ");
		buffer.append("tdescripcionColegio=[").append(tdescripcionColegio).append("] ");
		buffer.append("dfundacionColegio=[").append(dfundacionColegio).append("] ");
		buffer.append("tpaginaWeb=[").append(tpaginaWeb).append("] ");
		buffer.append("turlImagen=[").append(turlImagen).append("] ");
		buffer.append("qvaloracionPromedio=[").append(qvaloracionPromedio).append("] ");

		return buffer.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccolegio == null) ? 0 : ccolegio.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Colegio))
			return false;
		Colegio equalCheck = (Colegio) obj;
		if ((ccolegio == null && equalCheck.ccolegio != null) || (ccolegio != null && equalCheck.ccolegio == null))
			return false;
		if (ccolegio != null && !ccolegio.equals(equalCheck.ccolegio))
			return false;
		return true;
	}

	public String getTurlImagen() {
		return turlImagen;
	}

	public void setTurlImagen(String turlImagen) {
		this.turlImagen = turlImagen;
	}

	public Double getPosX() {
		return posX;
	}

	public void setPosX(Double posX) {
		this.posX = posX;
	}

	public Double getPosY() {
		return posY;
	}

	public void setPosY(Double posY) {
		this.posY = posY;
	}

}
