package logica.publicacion.registro;

import logica.publicacion.fabricaPublicaciones.FabricaPublPerdido;
import logica.publicacion.publicaciones.PublicadorPerdido;

public class RegistradorPubOP extends RegistradorPub {
	
	public RegistradorPubOP() {
		fabrica = new FabricaPublPerdido();
		publicacion = fabrica.crearPublicador();
	}
	
	@Override
	public void generarId() {
		String id = generarIdBase()+generarIdBody();
		publicacion.setIdPublicacion(id);
	}
	
	private String generarIdBase() {
		String base = "PP";
		return base;
	}

	@Override
	public void crearPublicacion() {
		publicacion = new PublicadorPerdido();		
	}
	

}
