package logica.objeto.condicion;


public abstract class Condicion implements ICondicionable {
	
	protected String nombre;
	protected int idCondicion;
	
	
	public Condicion() {
	
	}
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getId() {
		return idCondicion;
	}
	
	public void setIdCondicion(int idCondicion) {
		this.idCondicion = idCondicion;
	}
	
}
