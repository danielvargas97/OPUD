package logica.publicacion.fabricaPublicaciones;

import logica.publicacion.publicaciones.Publicador;
import logica.publicacion.publicaciones.PublicadorHallado;

public class FabricaPublHallado extends FabricaPublicador {

	@Override
	public Publicador crearPublicador() {
		// TODO Auto-generated method stub
		return new PublicadorHallado();
	}

}
