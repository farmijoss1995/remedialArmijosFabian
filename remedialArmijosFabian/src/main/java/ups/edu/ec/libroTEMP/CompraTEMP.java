package ups.edu.ec.libroTEMP;


import java.util.List;



import ups.edu.ec.Modelo.Usuario;

public class CompraTEMP {

	private Usuario usuario;
	
	private List<DetalleCom> detalles;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<DetalleCom> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleCom> detalles) {
		this.detalles = detalles;
	}

	public Double calcularTotal() {
		Double total = 0.0;
		for(int i = 0; i < detalles.size(); i++) {
			total += detalles.get(i).calcularSubtotal();
		}
		return total;
	}
	
	
}
