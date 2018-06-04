package logica.publicacion.buscador;

public class BuscadorOP extends Buscador {

	@Override
	protected void cargarResultados() {
		resultados = publDao.buscarPublicacion(textoBusqueda, 1);
	}

}
