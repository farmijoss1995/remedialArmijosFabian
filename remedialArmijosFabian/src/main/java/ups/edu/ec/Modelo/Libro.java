package ups.edu.ec.Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "libros")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "titulo es requerido")
	private String titulo;
	private String descripcion;
	@Lob
	private byte[] portada;
	@NotNull(message = "fecha publicacion es requerido")
	@Column(name = "fecha_publicion")
	private Date fechaPublicacion;
	@NotNull(message = "pagina es requerido")
	private int paginas;
	@NotNull(message = "precio es requerido")
	private double precio;
	@NotNull(message = "stock es requerido")
	private int stock;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "libro_id")
	private List<LibroAutor> autores;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "libro_id")
	private List<LibroCategoria> categorias;

	
	public void agregarAuto(LibroAutor libroAutor) {
		if (this.autores == null) {
			this.autores = new ArrayList<LibroAutor>();
		}
		this.autores.add(libroAutor);
	}
	
	public void agregarCategoria(LibroCategoria libroCategoria) {
		if(categorias == null) {
			this.categorias = new ArrayList<LibroCategoria>();
		}
		this.categorias.add(libroCategoria);
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public byte[] getPortada() {
		return portada;
	}

	public void setPortada(byte[] portada) {
		this.portada = portada;
	}

	public List<LibroAutor> getAutores() {
		return autores;
	}

	public void setAutores(List<LibroAutor> autores) {
		this.autores = autores;
	}


	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", portada=" + portada
				+ ", fechaPublicacion=" + fechaPublicacion + ", paginas=" + paginas + ", precio=" + precio + ", stock="
				+ stock + ", autores=" + autores + "]";
	}

	public List<LibroCategoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<LibroCategoria> categorias) {
		this.categorias = categorias;
	}
	

}
