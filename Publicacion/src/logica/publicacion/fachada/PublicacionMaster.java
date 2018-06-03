package logica.publicacion.fachada;

import java.util.ArrayList;
import java.util.List;

import apiObjeto.IObjeto;
import apiPublicacion.IBuscador;
import apiPublicacion.ICreadorPublicacion;
import apiPublicacion.IHistorial;
import apiPublicacion.INotificable;
import apiPublicacion.IPublicacion;
import apiUsuario.IUsuario;
import datos.publicacion.publicaciones.PublicacionDAO;
import logica.publicacion.fabricaPublicaciones.FabricaPublicador;
import logica.publicacion.publicaciones.Publicador;

public class PublicacionMaster {
	private PublicacionDAO publDAO = new PublicacionDAO();
	private Publicador publicacion;
	private IPublicacion publicacionCargada;
	private int tipo;
	private FabricaPublicador fabrica;
	//private Publicador publicacion;
	
	
	public PublicacionMaster(int tipo) {
		this.tipo = tipo;
	}		
	
}
