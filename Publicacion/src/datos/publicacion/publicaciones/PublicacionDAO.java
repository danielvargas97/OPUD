package datos.publicacion.publicaciones;

import java.util.List;

import apiPublicacion.IPublicacion;
import logica.publicacion.publicaciones.Publicador;

public class PublicacionDAO {
	private Publicador publicacion;
	
	
	public PublicacionDAO() {
		
	}
	
	
	public void insertarPublicacion() {
		
	}
	
	public IPublicacion cargarPublicacion(String idUsuario,String idPublicacion) {
		return null;
	}
	
	public List<IPublicacion> cargarPublicaciones(String idUsuario, int tipo){
		return null;
	}
	
	public void setPublicacion(Publicador publicacion) {
		this.publicacion = publicacion;
	}
	
	public List<String> verCategorias(){
		
		return null;
	}
}
