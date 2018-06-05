package logica.usuario.calificar;

import datos.usuario.usuario.CalificacionDAO;
import logica.usuario.calificacion.Calificacion;
import logica.usuario.calificador.Calificador;

public class CalificacionCliente implements ICalificacionCliente {
	private CalificacionDAO califDao;
	private Calificador calificador;
	private Calificacion calificacion;
	
	public CalificacionCliente() {
		this.califDao = new CalificacionDAO();		
	}

	@Override
	public void calificar(String idCalificado, String idCalificador, int nota) {
		calificador = new Calificador(idCalificador, idCalificado);
		calificador.calificar(nota);
		califDao.setCalificador(calificador);
		califDao.insertarCalificacion();
	}

	@Override
	public int verNota(String idUser) {
		calificacion = califDao.verCalificacion(idUser);
		return calificacion.verCalificacion();
	}
	
	
	
}
