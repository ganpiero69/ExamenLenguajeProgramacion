package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import java.text.SimpleDateFormat;

import models.*;
import daos.interfaces.*;
import daos.implementss.*;

@WebServlet("/PeliculaServlet")
public class PeliculaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PeliculaServlet() {
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		IGeneroDAO generoDAO = new GeneroDAOImp();
		
		List<Genero> generos = generoDAO.obtenerTodosGeneros();
		request.setAttribute("generos", generos);
		
		IPelicularDAO peliculaDAO = new PeliculaDAOImp();
		
		List<Pelicula> peliculas = peliculaDAO.obtenerTodasPeliculas();
		request.setAttribute("peliculas", peliculas);
		
		request.getRequestDispatcher("/Pelicula.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IPelicularDAO peliculaDAO = new PeliculaDAOImp();
		IGeneroDAO generoDAO = new GeneroDAOImp();
		
		try {
			
			String nombre = request.getParameter("nombre");
			String director = request.getParameter("director");
			String fechaEstrenoStr = request.getParameter("fechaEstreno");
			
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			
			Date fechaEstreno = sdf.parse(fechaEstrenoStr);
			
			System.out.println(fechaEstreno);
			
			int idGenero = Integer.parseInt(request.getParameter("idGenero"));		
			
			Pelicula peli = new Pelicula();
			peli.setVarNombre(nombre);
			peli.setVarDirector(director);
			peli.setDmeFechaestreno(fechaEstreno);
			
			Genero genero = generoDAO.obtenerGeneroPorId(idGenero);
			peli.setGenero(genero);
			
			peliculaDAO.crearPelicula(peli);
			
			response.sendRedirect("PeliculaServlet");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
