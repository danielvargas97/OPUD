package logica.publicacion.publicaciones;

import java.util.Random;

public class PublicadorHallado extends Publicador {
	public PublicadorHallado() {
		this.tipoPublicacion = 2;
	}

	@Override
	public void generarId() {
		this.idPublicacion = generarIdBase()+generarIdBody();
		
	}
	
	private String generarIdBase() {
		String base = "PP";
		return base;
	}
	

	
}
