package logica.publicacion.buscador;

public class BuscadorOH extends Buscador {

	@Override
	protected void cargarResultados() {
		resultados = publDao.buscarPublicacion(textoBusqueda, 2);
	}

}
