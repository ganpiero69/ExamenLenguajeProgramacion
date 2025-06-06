package models;

import java.io.Serializable;

import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pelicula database table.
 * 
 */
@Entity
@NamedQuery(name="Pelicula.findAll", query="SELECT p FROM Pelicula p")
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="INT_IDPELICULA")
	private int intIdpelicula;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DME_FECHAESTRENO")
	private Date dmeFechaestreno;

	@Column(name="VAR_DIRECTOR")
	private String varDirector;

	@Column(name="VAR_NOMBRE")
	private String varNombre;

	//bi-directional many-to-one association to Genero
	@ManyToOne
	@JoinColumn(name="INT_IDGENERO")
	private Genero genero;

	public Pelicula() {
	}

	public int getIntIdpelicula() {
		return this.intIdpelicula;
	}

	public void setIntIdpelicula(int intIdpelicula) {
		this.intIdpelicula = intIdpelicula;
	}

	public Date getDmeFechaestreno() {
		return this.dmeFechaestreno;
	}

	public void setDmeFechaestreno(Date dmeFechaestreno) {
		this.dmeFechaestreno = dmeFechaestreno;
	}

	public String getVarDirector() {
		return this.varDirector;
	}

	public void setVarDirector(String varDirector) {
		this.varDirector = varDirector;
	}

	public String getVarNombre() {
		return this.varNombre;
	}

	public void setVarNombre(String varNombre) {
		this.varNombre = varNombre;
	}

	public Genero getGenero() {
		return this.genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}