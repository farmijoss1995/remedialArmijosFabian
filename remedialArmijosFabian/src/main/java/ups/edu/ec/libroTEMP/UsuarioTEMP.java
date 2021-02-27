package ups.edu.ec.libroTEMP;

import java.sql.Date;
import java.util.List;



public class UsuarioTEMP {

	private int id;
	private String correo;
	private String password;
	private Date fecha;
	private String nombres;
	private String telefono;
	

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return "UsuarioTMP [id=" + id + ", correo=" + correo + ", password=" + password + ", fecha=" + fecha
				+ ", nombres=" + nombres + ", telefono=" + telefono +  "]";
	}
	
	
}
