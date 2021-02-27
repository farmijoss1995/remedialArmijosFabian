package ups.edu.ec.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ups.edu.ec.Modelo.Autor;
import ups.edu.ec.Modelo.Categoria;
import ups.edu.ec.Modelo.Libro;
import ups.edu.ec.libroTEMP.LibroTEMP;
import ups.edu.ec.ON.autorON;
import ups.edu.ec.ON.libroON;
import ups.edu.ec.libroTEMP.LibroTEMP;

@Path("/libros")
public class LibroService {

	@Inject
	private libroON libro;

	@Inject
	private autorON autor;

	@GET
	@Path("todos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> libros() {
		return libro.mostrarLibros();
	}

	@GET
	@Path("/buscar/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public LibroTEMP buscarLibro(@PathParam("id") int id) {
		List<Autor> autores = new ArrayList<Autor>();
		List<Categoria> categorias = new ArrayList<Categoria>();
		LibroTEMP tmp = new LibroTEMP();
		Libro l = libro.buscarLibro(id);
		tmp.setId(l.getId());
		tmp.setTitulo(l.getTitulo());
		tmp.setDescripcion(l.getDescripcion());
		tmp.setPortada(l.getPortada());
		tmp.setFechaPublicacion(l.getFechaPublicacion());
		tmp.setPaginas(l.getPaginas());
		tmp.setPrecio(l.getPrecio());
		tmp.setStock(l.getStock());
		for (int i = 0; i < l.getAutores().size(); i++) {
			autores.add(l.getAutores().get(i).getAutor());
		}
		for (int i = 0; i < l.getCategorias().size(); i++) {
			categorias.add(l.getCategorias().get(i).getCategoria());
		}
		tmp.setAutores(autores);
		tmp.setCategorias(categorias);
		return tmp;
	}

	@GET
	@Path("/similar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> buscarLibro(@QueryParam("key") String key) {
		return libro.buscarSimilar(key);
	}

	@GET
	@Path("/autor")
	@Produces(MediaType.APPLICATION_JSON)
	public Autor libroautor() {
		return autor.libroAutor(0);
	}

	@GET
	@Path("/vendidos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LibroTEMP> librosMasVendidos() {
		return libro.librosMasVendidos();
	}

}
