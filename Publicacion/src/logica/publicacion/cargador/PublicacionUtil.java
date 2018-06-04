package logica.publicacion.cargador;

import datos.publicacion.publicaciones.PublicacionDAO;

public class PublicacionUtil implements IPublicacionInfo {
	private PublicacionDAO pubDAO;
	
	public PublicacionUtil(PublicacionDAO p){
		this.pubDAO = p;
	}
	
	@Override
	public String getIdUsuario(String idPublicacion) {
		return pubDAO.cargarIdUsuario(idPublicacion);
	}

	@Override
	public String getIdObjeto(String idPublicacion) {
		return pubDAO.cargarIdObjeto(idPublicacion);
	}

}
