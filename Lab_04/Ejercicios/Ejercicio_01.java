package Ejercicios;

public class Ejercicio_01 {

	
	private String nombre;
	private int telefono;
	private String direccion;
	public Ejercicio_01(String nombre, int telefono, String direccion) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
