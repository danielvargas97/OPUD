package apiPublicacion;

import apiObjeto.IObjeto;
import apiUsuario.IUsuario;

public interface ICreadorPublicacion {
	// Acciones de la publicacion
	public void crearPublicacion(int tipo);
	public void cambiarEstadoPublicacion(int activo);
	public void asignarUsuario(IUsuario user);
	public void asignarObjeto(IObjeto objeto);
	public void publicar();
	public void cargarPublicacion(String idUsuario, String idPublicacion);
	public void registrarObjetoHallado(String nombre, String descripcion, String estado, int idCategoria);
	public void registrarObjetoPerdido(String nombre, String descripcion, String estado, int idCategoria);
	
}