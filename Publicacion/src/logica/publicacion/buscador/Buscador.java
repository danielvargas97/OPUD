package logica.publicacion.buscador;


import java.util.ArrayList;

import apiPublicacion.IPublicacion;
import datos.publicacion.publicaciones.PublicacionDAO;

public abstract class Buscador implements IBuscador {
	protected PublicacionDAO publDao;
	protected String textoBusqueda;
	protected ArrayList<IPublicacion> resultados;
	
	protected abstract void cargarResultados();
	
	@Override
	public void setDao(PublicacionDAO pubDao) {
		this.publDao = pubDao;
	}

	@Override
	public void setTextoBusqueda(String texto) {
		this.textoBusqueda = texto;
	}

	@Override
	public ArrayList<IPublicacion> getResultados(){
		cargarResultados();
		return resultados;
	}

}
