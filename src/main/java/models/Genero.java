package models;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the genero database table.
 * 
 */
@Entity
@NamedQuery(name="Genero.findAll", query="SELECT g FROM Genero g")
public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="INT_IDGENERO")
	private int intIdgenero;

	@Column(name="VAR_NOMBRE")
	private String varNombre;

	//bi-directional many-to-one association to Pelicula
	@OneToMany(mappedBy="genero")
	private List<Pelicula> peliculas;

	public Genero() {
	}

	public int getIntIdgenero() {
		return this.intIdgenero;
	}

	public void setIntIdgenero(int intIdgenero) {
		this.intIdgenero = intIdgenero;
	}

	public String getVarNombre() {
		return this.varNombre;
	}

	public void setVarNombre(String varNombre) {
		this.varNombre = varNombre;
	}

	public List<Pelicula> getPeliculas() {
		return this.peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public Pelicula addPelicula(Pelicula pelicula) {
		getPeliculas().add(pelicula);
		pelicula.setGenero(this);

		return pelicula;
	}

	public Pelicula removePelicula(Pelicula pelicula) {
		getPeliculas().remove(pelicula);
		pelicula.setGenero(null);

		return pelicula;
	}

}