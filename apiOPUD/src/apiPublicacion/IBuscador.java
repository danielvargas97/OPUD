package apiPublicacion;

import java.util.ArrayList;

public interface IBuscador {
	public ArrayList<IPublicacion> buscarPublicacion(String textoBusqueda,int tipoPublicacion);
	public ArrayList<IPublicacion> verMisPublicaciones(String idUser, int tipo);
	public IPublicacion cargarPublicacion(String idUser, String idPublicacion, int tipo);
}
