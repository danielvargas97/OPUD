package logica.objeto.registrador;


import logica.objeto.objetos.Objeto;

public interface IRegistradorObjetos {
	public boolean crearObjeto(String nombre, String descripcion, String estado);
	public void asignarCategoria(int id);
	public void asignarCondicion();
	public Objeto getObjeto();	
}
