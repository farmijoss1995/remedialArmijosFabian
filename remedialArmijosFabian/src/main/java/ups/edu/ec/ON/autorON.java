package ups.edu.ec.ON;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.DAO.AutorDao;
import ups.edu.ec.Modelo.Autor;

@Stateless
public class autorON {
	
	@Inject
	private AutorDao gestion;
	
	public void crearAutor(Autor autor) {
		this.gestion.crearAutor(autor);
	}
	public Autor Buscar(int id) {
		return this.gestion.buscar(id);
	}
	public Autor buscarAutor(String nombre) {
		return this.gestion.buscarAutor(nombre);
	}
	public List<Autor>mostrarAutores() {
		return this.gestion.mostrarAutores();
	}
	public Autor libroAutor(int id) {
		 return this.gestion.autores(id);
	}
	

}
