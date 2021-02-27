package ups.edu.ec.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ups.edu.ec.Modelo.Categoria;
import ups.edu.ec.ON.categoriaON;



@ManagedBean
public class categoriaVis {
	
	@Inject
	private categoriaON on;
	private Categoria categoria;
	private List<Categoria> categorias;
	
	@PostConstruct
	
	public void init() {
		this.categoria = new Categoria();
		listar();
		
	}
	public String agregarCategoria() {
		this.on.crearCategoria(categoria);
		this.categoria = null;
		return null;
		
	}
	public void listar() {
		this.categorias = this.on.mostrarCategorias();
	}
	public categoriaON getOn() {
		return on;
	}
	public void setOn(categoriaON on) {
		this.on = on;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
}

