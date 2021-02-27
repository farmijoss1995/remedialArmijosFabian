package ups.edu.ec.ON;

import java.util.List;

import javax.inject.Inject;

import ups.edu.ec.DAO.LibroDao;
import ups.edu.ec.Modelo.Libro;


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
	public List<LibroTEMP>librosMasVendidos{
		List<Object[]> lista = librodao.librosMasVendidos();
		List<LibroTEMP> libros = new ArrayList<LibroTEMP>();
		for(Object[] 1 : lista) {
			LibroTEMP lt = new LibroTEMP();
			lt.setId((int) 1[0]);
			lt.setTitulo((String) 1[1]);
			lt.setPaginas((int) 1[2]);
			lt.setCantidad(((BigDecimal)1[3]).intValue());
			libros.add(lt)

		}
	}
}
