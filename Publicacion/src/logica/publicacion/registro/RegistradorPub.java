package logica.publicacion.registro;

import java.util.Random;

import datos.publicacion.publicaciones.PublicacionDAO;
import logica.publicacion.publicaciones.Publicador;
import logica.utils.utilidades.FechaString;

public abstract class RegistradorPub implements IRegistroPublicador {
	
	protected String idUser;
	protected String idObjeto;
	protected Publicador publicacion;
	protected PublicacionDAO publDao;
	
	public RegistradorPub() {
		this.publDao = new PublicacionDAO();
	}
	
	@Override
	public void asignarTituloPublicacion(String titulo) {
		publicacion.setNombre(titulo);
	}
	
	@Override
	public void asignarIdUser(String idUser) {
		this.idUser = idUser;
	}

	@Override
	public void asignarIdObjeto(String idObjeto) {
		this.idObjeto = idObjeto;
	}

	@Override
	public void registrarFecha(String dia, String mes, String anho) {
		publicacion.setFechaCondicion(FechaString.parseDate(dia, mes, anho));
	}

	@Override
	public void registrar() {
		publDao.setPublicacion(publicacion);
		publDao.setIdObjeto(idObjeto);
		publDao.setIdUsuario(idUser);
		publDao.insertarPublicacion();
	}

	protected String generarIdBody() {
		Random r = new Random(System.currentTimeMillis());
		String body = "";
		
		//Parte de ID con letras;
		
		for(int i=0;i<10;i++) {
			char x = (char)(65+r.nextInt(26));
			body = body+x;
		}
		
		for(int i=0;i<8;i++) {
			char x = (char)(48+r.nextInt(10));
			body = body+x;
		}		
		
		return body;
	}
	
	
	
}
