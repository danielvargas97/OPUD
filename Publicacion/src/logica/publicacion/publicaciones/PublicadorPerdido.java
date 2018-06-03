package logica.publicacion.publicaciones;

import java.util.Random;

public class PublicadorPerdido extends Publicador {
	public PublicadorPerdido() {
		this.tipoPublicacion = 1;
	}

	@Override
	public void generarId() {
		this.idPublicacion = generarIdBase()+generarIdBody();		
	}
	
	private String generarIdBase() {
		String base = "PH";
		return base;
	}
}
