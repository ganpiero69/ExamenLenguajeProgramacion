<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="models.*" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<h1>Peliculas</h1>
	
		<hr>
		
		<button type="button" class="btn btn-outline-success" id="btnNuevo">Nueva Pelicula</button>
		
		<br><br>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>IdPelicula</th>
					<th>Nombre</th>
					<th>Director</th>
					<th>Fecha Estreno</th>
					<th>Genero</th>
				</tr>
			</thead>
			<tbody>
			<%
    			List<Pelicula> peliculas = (List<Pelicula>) request.getAttribute("peliculas");
    			if(peliculas != null){
    			    for (Pelicula p : peliculas){
			%>
            <tr>
                <td><%= p.getIntIdpelicula() %></td>
                <td><%= p.getVarNombre() %></td>
                <td><%= p.getVarDirector() %></td>
                <td><%= p.getDmeFechaestreno() != null ? new java.text.SimpleDateFormat("yyyy-MM-dd").format(p.getDmeFechaestreno()) : "" %></td>
                <td><%= p.getGenero() != null ? p.getGenero().getVarNombre() : "Sin género" %></td>
            </tr>
			<%
			        }
			    }
			%>
			</tbody>
		</table>
	
	</div>
<div class="modal fade" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <form method="post" action="PeliculaServlet">
        <div class="modal-header">
          <h5 class="modal-title">Nueva Película</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
        </div>
        <div class="modal-body">
          <!-- Nombre -->
          <div class="mb-3">
            <label for="nombrePelicula" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="nombrePelicula" name="nombre" required>
          </div>

          <!-- Director -->
          <div class="mb-3">
            <label for="directorPelicula" class="form-label">Director</label>
            <input type="text" class="form-control" id="directorPelicula" name="director" required>
          </div>

          <!-- Fecha Estreno -->
          <div class="mb-3">
            <label for="fechaEstrenoPelicula" class="form-label">Fecha Estreno</label>
            <input type="date" class="form-control" id="fechaEstrenoPelicula" name="fechaEstreno" required>
          </div>

          <div class="mb-3">
  			<label for="selectGenero" class="form-label">Género</label>
  			<select id="selectGenero" name="idGenero" class="form-select" required>
    		<option value="" disabled selected>Seleccione un género</option>
    		<%
    		  List<Genero> generos = (List<Genero>) request.getAttribute("generos");
    		  if (generos != null) {
    		      for (Genero g : generos) {
    		%>
      		<option value="<%= g.getIntIdgenero() %>"><%= g.getVarNombre() %></option>
    		<%
    		      }
    		  } else {
    		%>
      		<option disabled>No hay géneros disponibles</option>
    		<%
    		  }
    		%>
  			</select>
		</div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
          <button type="submit" class="btn btn-primary">Guardar Película</button>
        </div>
      </form>
    </div>
  </div>
</div>


<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<script>
	
	$(document).ready(() => {
	
		$("#btnNuevo").on("click", () => {
			mostrarModal();
		});
		
	});
	
	function mostrarModal(pelicula = { nombre: "", director: "", fechaEstreno: "", idGenero: "" }){
		$("#nombrePelicula").val(pelicula.nombre);
		$("#directorPelicula").val(pelicula.director);
		$("#fechaEstrenoPelicula").val(pelicula.fechaEstreno);
		$("#selectGenero").val(pelicula.idGenero);
		$(".modal").modal("show");
	};	
	
</script>
</body>
</html>