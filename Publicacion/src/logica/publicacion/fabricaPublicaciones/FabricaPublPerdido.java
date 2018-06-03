package logica.publicacion.fabricaPublicaciones;

import logica.publicacion.publicaciones.Publicador;
import logica.publicacion.publicaciones.PublicadorPerdido;

public class FabricaPublPerdido extends FabricaPublicador {

	@Override
	public Publicador crearPublicador() {
		return new PublicadorPerdido();
	}

}
