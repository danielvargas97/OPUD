package logica.publicacion.historial;

import java.util.ArrayList;
import apiPublicacion.IPublicacion;
import datos.publicacion.publicaciones.PublicacionDAO;

public abstract class Historial {
	
	protected PublicacionDAO pubDao;
	protected String idUsuario;
	protected String fechaInicio;
	protected String fechaFin;
	
	
	public Historial() {
		
	}	
	public abstract ArrayList<IPublicacion> verHistorial();

	public void asignarRangoFecha(String fechaInicio, String fechaFin) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;		
	}
	
	public void setPubDao(PublicacionDAO pubDao) {
		this.pubDao = pubDao;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
}
