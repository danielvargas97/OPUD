package logica.publicacion.registro;

import logica.publicacion.fabricaPublicaciones.FabricaPublHallado;
import logica.publicacion.publicaciones.PublicadorHallado;

public class RegistradorPubOH extends RegistradorPub {

	public RegistradorPubOH() {
		fabrica = new FabricaPublHallado();
		publicacion = fabrica.crearPublicador();
	}
	
	@Override
	public void generarId() {
		String id = generarIdBase()+generarIdBody();
		publicacion.setIdPublicacion(id);
	}
	
	private String generarIdBase() {
		String base = "PH";
		return base;
	}

	@Override
	public void crearPublicacion() {
		publicacion = new PublicadorHallado();		
	}
}
