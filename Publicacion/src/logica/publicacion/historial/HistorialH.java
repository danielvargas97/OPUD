package logica.publicacion.historial;

import java.util.ArrayList;

import apiPublicacion.IPublicacion;

public class HistorialH extends Historial {

	@Override
	public ArrayList<IPublicacion> verHistorial() {
		return pubDao.cargarPublicaciones(idUsuario, 2, fechaInicio, fechaFin);
	}
}
