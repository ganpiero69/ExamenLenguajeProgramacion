package daos.implementss;

import java.util.List;

import daos.interfaces.*;

import jakarta.persistence.*;
import models.Genero;

public class GeneroDAOImp implements IGeneroDAO {

	private EntityManagerFactory factory;
	private EntityManager em;
	
	public GeneroDAOImp() {
		this.factory = Persistence.createEntityManagerFactory("App");
		this.em = factory.createEntityManager();
	}
	
	@Override
	public List<Genero> obtenerTodosGeneros() {
		return em.createNamedQuery("Genero.findAll", Genero.class).getResultList();
	}

	@Override
	public Genero obtenerGeneroPorId(int idGenero) {
		return em.find(Genero.class, idGenero);
	}

	
}
