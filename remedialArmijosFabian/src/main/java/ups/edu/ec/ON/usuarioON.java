package ups.edu.ec.ON;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.DAO.UsuarioDao;
import ups.edu.ec.Modelo.Compra;
import ups.edu.ec.Modelo.Usuario;
import ups.edu.ec.libroTEMP.UsuarioTEMP;

@Stateless
public class usuarioON {
	
	@Inject
	private UsuarioDao dao;
	
	public void crearUsuario(Usuario usuario) {
		this.dao.agregarUsuario(usuario);
	}
	
	public List<Usuario> mostrarUsarios() {
		return dao.mostrarUsuarios();
	}
	
	public List<UsuarioTEMP> listarUsuarios() {
		List<UsuarioTEMP> tmp = new ArrayList<UsuarioTEMP>();
		for(Object[] u: dao.listarUsuarios()) {
			UsuarioTEMP ust = new UsuarioTEMP();
			ust.setId((int)u[0]);
			ust.setNombres((String) u[1]);
			tmp.add(ust);
		}
		return tmp;
	}
	
	public void eliminar(int id) {
		dao.eliminar(id);
	}
	
	public Usuario buscar(int id) {
		return dao.search(id);
	}
	
	public void actualizarUsuaurio(Usuario usuario) {
		dao.actualizarUsuaurio(usuario);
	}
	
	public Usuario login(String correo, String password) {
		return dao.login(correo, password);
	}
	

	public List<Compra> misCompras(int id) {
		return dao.misCompras(id);
	}
	

}
