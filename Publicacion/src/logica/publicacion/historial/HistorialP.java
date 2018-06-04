package logica.publicacion.historial;

import java.util.ArrayList;
import apiPublicacion.IPublicacion;

public class HistorialP extends Historial {

	@Override
	public ArrayList<IPublicacion> verHistorial() {	
		return pubDao.cargarPublicaciones(idUsuario, 1, fechaInicio, fechaFin);
	}
	
}
