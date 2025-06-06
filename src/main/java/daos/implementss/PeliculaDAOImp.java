package daos.implementss;

import java.util.List;

import daos.interfaces.*;
import models.Pelicula;
import jakarta.persistence.*;

public class PeliculaDAOImp implements IPelicularDAO {

	private EntityManagerFactory factory;
	private EntityManager em;
	
	public PeliculaDAOImp() {
		this.factory = Persistence.createEntityManagerFactory("App");
		this.em = factory.createEntityManager();
	}
	
	@Override
	public void crearPelicula(Pelicula entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@Override
	public List<Pelicula> obtenerTodasPeliculas() {
		return em.createNamedQuery("Pelicula.findAll", Pelicula.class).getResultList();
	}
	
	
}
