package logica.publicacion.fabricaPublicaciones;

import logica.publicacion.publicaciones.Publicador;

public abstract class FabricaPublicador {
	
	
	public FabricaPublicador() {
		
	}
	
	public abstract Publicador crearPublicador();
}
