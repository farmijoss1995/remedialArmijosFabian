package ups.edu.ec.ON;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import javax.inject.Inject;

import ups.edu.ec.DAO.LibroDao;
import ups.edu.ec.Modelo.Libro;
import ups.edu.ec.libroTEMP.LibroTEMP;


public class libroON {

	@Inject
	private LibroDao librodao;
	
	public void crearLibro(Libro libro) {
		this.librodao.crearLibro(libro);
	}
	public List<Libro>mostrarLibros() {
		return this.librodao.mostrarLibros();
	}
	public Libro buscar(int id) {
		return librodao.buscar(id);
	}
	public Libro buscarLibro(int id) {
		return librodao.buscarLibro(id);
	}
	public List<Libro>buscarSimilar(String key) {
		return librodao.buscarSimilar(key);
	}
	public List<LibroTEMP> librosMasVendidos(){
		List<Object[]> lista = librodao.librosMasVendidos();
		List<LibroTEMP> libros = new ArrayList<LibroTEMP>();
		for (Object[] l : lista) {
			LibroTEMP lt = new LibroTEMP();
			lt.setId((int) l[0]);
			lt.setTitulo((String) l[1]);
			lt.setPaginas((int) l[2]);
			lt.setCantidad(((BigDecimal)l[3]).intValue());
			libros.add(lt);

		}
		return libros;
	}
}
