package ups.edu.ec.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ups.edu.ec.Modelo.Libro;
import ups.edu.ec.libroTEMP.LibroTEMP;
import ups.edu.ec.ON.libroON;

@ManagedBean
public class vendidosVis {

	@Inject
	private libroON libroON;

	private Libro libro;

	private List<Libro> libros;
	private List<LibroTEMP> tmp;

	@PostConstruct
	public void init() {
		libro = new Libro();
		tmp = new ArrayList<LibroTEMP>();
		libros = new ArrayList<>();
		cargar();
	}

	public void cargar() {
		tmp = libroON.librosMasVendidos();
		for (LibroTEMP l : tmp) {
			libro = libroON.buscar(l.getId());
			libros.add(libro);
		}
		System.out.println("Size "+libros.size());
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public List<LibroTEMP> getTmp() {
		return tmp;
	}

	public void setTmp(List<LibroTEMP> tmp) {
		this.tmp = tmp;
	}

}
