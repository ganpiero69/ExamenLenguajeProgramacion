package daos.interfaces;

import models.Genero;
import java.util.List;
public interface IGeneroDAO {
	List<Genero> obtenerTodosGeneros();
	Genero obtenerGeneroPorId(int idGenero);
}
