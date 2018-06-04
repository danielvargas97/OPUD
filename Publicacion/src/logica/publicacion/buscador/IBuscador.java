package logica.publicacion.buscador;

import java.util.ArrayList;

import apiPublicacion.IPublicacion;
import datos.publicacion.publicaciones.PublicacionDAO;

public interface IBuscador {
	public void setDao(PublicacionDAO pubDao);
	public void setTextoBusqueda(String texto);
	
	public ArrayList<IPublicacion> getResultados();
}
