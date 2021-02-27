package ups.edu.ec.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ups.edu.ec.Modelo.Autor;
import ups.edu.ec.ON.autorON;

@ManagedBean
public class autorVis {
	
	@Inject
	private autorON gestion;
	private Autor autor;
	private List<Autor> autores;
	
	@PostConstruct
	
	public void init() {
		this.autor = new Autor();
		listar();
		
	}
	public String agregarAutor() {
		this.gestion.crearAutor(autor);
		this.autor = null;
		return null;
		
	}
	public void listar() {
		this.autores = this.gestion.mostrarAutores();
	}
	public autorON getGestion() {
		return gestion;
	}
	public void setGestion(autorON gestion) {
		this.gestion = gestion;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
}
