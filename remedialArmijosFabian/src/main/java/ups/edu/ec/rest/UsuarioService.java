package ups.edu.ec.rest;




import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ups.edu.ec.Modelo.Compra;
import ups.edu.ec.Modelo.Libro;
import ups.edu.ec.Modelo.Usuario;
import ups.edu.ec.libroTEMP.UsuarioTEMP;
import ups.edu.ec.ON.libroON;
import ups.edu.ec.ON.usuarioON;

@Path("/usuario")
public class UsuarioService {
	
	@Inject
	private usuarioON user;
	@Inject
	private libroON libs;

	
	
	@POST
	@Path("/login")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public UsuarioTEMP login(Usuario usuario) {
		Usuario use = new Usuario();
		UsuarioTEMP u = new UsuarioTEMP();
		try {
			use = user.login(usuario.getCorreo(), usuario.getPassword());
			u.setId(use.getId());
			u.setCorreo(use.getCorreo());
			u.setPassword(use.getPassword());
		} catch (Exception e) {
			u.setCorreo(e.getMessage());
		}
		return u;
	}
	
	@POST
	@Path("/registro")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Respuesta registrar(UsuarioTEMP u) {
		System.out.println("LLEGANDO ESTOS DAOTS "+u.toString());
		Respuesta r = new Respuesta();
		try {
			Usuario usuario = new Usuario();
			usuario.setNombres(u.getNombres());
			usuario.setFecha(u.getFecha());
			usuario.setCorreo(u.getCorreo());
			usuario.setPassword(u.getPassword());
			usuario.setTelefono(u.getTelefono());
			
			
			user.crearUsuario(usuario);
			r.setId(200);
			r.setMensaje("Usuario: "+usuario.getNombres()+" creado exitosamente");
		} catch (Exception e) {
			
			r.setId(400);
			r.setMensaje("Error "+e.getMessage());
			e.printStackTrace();
			
		}
		return r;
	}
	
	@GET
	@Path("/usuarios")
	@Produces({MediaType.APPLICATION_JSON})
	public List<UsuarioTEMP> usuarios() {
		return user.listarUsuarios();
	}
	
	@GET
	@Path("/miscompras")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Compra> misCompras(@QueryParam("id") int id) {
		return user.misCompras(id);
	}
	
}
