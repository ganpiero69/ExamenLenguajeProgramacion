package daos.interfaces;
import models.Pelicula;
import java.util.List;

public interface IPelicularDAO {

	void crearPelicula(Pelicula entity);
	List<Pelicula> obtenerTodasPeliculas();
}
