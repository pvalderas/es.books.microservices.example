package application.domain;

public class Producto {
	private Integer id;
	private String nombre;
	private String Descripcion;
	private Double precio;
	
	public Producto(){
		super();
	}
	
	
	public Producto(Integer id, String nombre, String descripcion, Double precio) {
		this.id = id;
		this.nombre = nombre;
		Descripcion = descripcion;
		this.precio = precio;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
}
