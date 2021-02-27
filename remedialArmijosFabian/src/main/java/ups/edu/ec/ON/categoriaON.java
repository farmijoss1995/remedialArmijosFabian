package ups.edu.ec.ON;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.DAO.AutorDao;
import ups.edu.ec.DAO.CategoriaDao;
import ups.edu.ec.Modelo.Autor;
import ups.edu.ec.Modelo.Categoria;

@Stateless
public class categoriaON {

	@Inject
	private CategoriaDao dao;
	
	public void crearCategoria(Categoria categoria) {
		this.dao.crearCategoria(categoria);
	}
	public Categoria Buscar(int id) {
		return this.dao.buscar(id);
	}
	public Categoria buscarCategoria(String nombre) {
		return this.dao.buscarCategoria(nombre);
	}
	public List<Categoria>mostrarCategorias() {
		return this.dao.mostrarCategorias();
	}
	

}
