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
import logica.publicacion.publicaciones.Publicador;

public class PublicacionMaster implements IBuscador,ICreadorPublicacion,INotificable,IHistorial {
	private PublicacionDAO publDAO = new PublicacionDAO();
	private Publicador publicacion;
	private IPublicacion publicacionCargada;
	private int tipo;
	//private Publicador publicacion;
	
	
	public PublicacionMaster(int tipo) {
		this.tipo = tipo;
	}


	@Override
	public ArrayList<IPublicacion> historial(String idUsuario, String fechaInicio, String fechaFinal,
			int tipoPublicacion) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void cambiarEstadoNotificacion(boolean estado) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<IPublicacion> verResultadosNotificacion(String idPublicacion) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void crearPublicacion(int tipo) {
		publicacion = new Publicador(tipo); 
		
	}


	@Override
	public void cambiarEstadoPublicacion(int activo) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void publicar() {
		publDAO.insertarPublicacion();
		
	}


	@Override
	public void cargarPublicacion(String idUsuario, String idPublicacion) {
		publicacionCargada = publDAO.cargarPublicacion(idUsuario, idPublicacion);
		
	}


	@Override
	public void registrarObjetoHallado(String nombre, String descripcion, String estado, int idCategoria) {
		publicacion.setNombre(nombre);
		publDAO.setPublicacion(publicacion);	
		publicar();
		
	}


	@Override
	public void registrarObjetoPerdido(String nombre, String descripcion, String estado, int idCategoria) {
		publicacion.setNombre(nombre);
		publDAO.setPublicacion(publicacion);
		publicar();		
	}


	@Override
	public ArrayList<IPublicacion> buscarPublicacion(String textoBusqueda, int tipoPublicacion) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<IPublicacion> verMisPublicaciones(String idUser, int tipo) {
		return publDAO.cargarPublicaciones(idUser, tipo);
	}


	@Override
	public IPublicacion cargarPublicacion(String idUser, String idPublicacion, int tipo) {		
		return null;
	}


	@Override
	public void asignarUsuario(IUsuario user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void asignarObjeto(IObjeto objeto) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
