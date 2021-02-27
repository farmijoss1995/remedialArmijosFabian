package ups.edu.ec.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ups.edu.ec.Modelo.Compra;
import ups.edu.ec.Modelo.Detalle;
import ups.edu.ec.Modelo.Usuario;
import ups.edu.ec.modelotmp.DetalleCom;
//import modelo.Detalle;
import ups.edu.ec.modelotmp.DetalleTMP;
import ups.edu.ec.modelotmp.DireccionTMP;
import ups.edu.ec.modelotmp.TarjetaTMP;
import ups.edu.ec.ON.compraON;
import ups.edu.ec.ON.libroON;
import ups.edu.ec.ON.usuarioON;

@Path("/compras")
public class CompraService {

	@Inject
	private libroON libOn;
	
	@Inject
	private usuarioON userOn;
	
	@Inject
	private compraON compraOn;

	
	@POST
	@Path("/detalles")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Double detalles(List<DetalleTEMP> detalles) {
		Double subtotal = 0.0;
		List<DetalleCom> details = new ArrayList<DetalleCom>();
		for (DetalleTEMP detalle : detalles) {
			DetalleCom det = new DetalleCom();
			det.setCantidad(detalle.getCantidad());
			det.setLibro(libOn.buscarLibro(detalle.getIdLib()));
			details.add(det);
		}
		for (DetalleCom detalleCom : details) {
			subtotal += detalleCom.calcularSubtotal(); 
		}
		
		return subtotal;
	}
	
	@POST
	@Path("/factura")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Double factura(List<DetalleTEMP> detalles) {
		System.out.println(detalles.size()+" size");
		Usuario u = new Usuario();
		Double total = 0.0;
		List<Detalle> dts = new ArrayList<Detalle>();
		for (DetalleTEMP detalle : detalles) {
			u = userOn.buscar(detalle.getIdUsuario());
			Detalle d = new Detalle();
			d.setCantidad(detalle.getCantidad());
			d.setLibro(libOn.buscarLibro(detalle.getIdLib()));
			d.setSubtotal(d.calcularSubtotal());
			dts.add(d);
		}
		
		Compra c = new Compra();
		c.setDescripcion("Facturando tus productos");
		c.setDetalles(dts);
		c.setFecha(new Date());
		c.setUsuario(u);
		total = c.calcularTotal();
		c.setTotal(total);
		u.nuevaCompra(c);
		compraOn.nuevaCompra(c);
		
		return total;
	}
	
}
