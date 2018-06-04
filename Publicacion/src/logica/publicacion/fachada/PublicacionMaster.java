package logica.publicacion.fachada;

import java.util.ArrayList;
import java.util.List;

import apiObjeto.IObjeto;
import apiObjeto.IObjetoRegistro;
import apiPublicacion.IPublicacion;
import apiPublicacion.IPublicacionAdmin;
import apiUsuario.IUsuario;
import datos.publicacion.publicaciones.PublicacionDAO;
import logica.publicacion.fabricaPublicaciones.FabricaPublicador;
import logica.publicacion.historial.Historial;
import logica.publicacion.historial.HistorialH;
import logica.publicacion.historial.HistorialP;
import logica.publicacion.publicaciones.Publicador;
import logica.publicacion.registro.IRegistroPublicador;
import logica.publicacion.registro.RegistradorPubOH;
import logica.publicacion.registro.RegistradorPubOP;

public class PublicacionMaster implements IPublicacionAdmin {
	
	private PublicacionDAO publDAO = new PublicacionDAO();
	private FabricaPublicador fabrica;
	private int tipo;
	private IObjetoRegistro objRegister;
	private IObjeto objeto;
	
	//private IUsuario user;
	private IRegistroPublicador registroPub;
	
	
	public PublicacionMaster() {
		
	}
	@Override
	public void crearPublicacion(int tipo) {
		this.tipo = tipo;
		crearRegistrador(tipo);
	}
	@Override
	public void asignarUsuario(IUsuario user) {
		registroPub.asignarIdUser(user.getIdUser());		
	}
	
	@Override
	public void registrarTitulo(String titulo) {
		registroPub.asignarTituloPublicacion(titulo);		
	}
	
	@Override
	public void registrarFechaPublicacion(String dia, String mes, String anho) {
		registroPub.registrarFecha(dia, mes, anho);
	}
	
	@Override
	public void registrarObjeto(String nombre, String descripcion, String estado, int idCategoria) {		
		
		if(tipo==1) {
			objRegister.registrarOP(nombre, descripcion, estado, idCategoria);
		}
		else{
			objRegister.registrarOH(nombre, descripcion, estado, idCategoria);
		}
		
		registroPub.asignarIdObjeto(objRegister.verID());
	}
	@Override
	public void publicar() {
		registroPub.registrar();
	}
	
	
	@Override
	public void cambiarEstadoPublicacion(int activo, String idPublicacion) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void cargarPublicacion(String idUsuario, String idPublicacion, int tipo) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	@Override
	public ArrayList<IPublicacion> buscarPublicacion(String textoBusqueda, int tipoPublicacion) {
		return null;
	}
	
	@Override
	public ArrayList<IPublicacion> historial(String idUsuario, String fechaInicio, String fechaFinal,int tipoPublicacion) {
		Historial h;
		if(tipoPublicacion == 1) {
			h = new HistorialP();
		}
		else {
			h = new HistorialH();
		}
		
		h.setIdUsuario(idUsuario);
		h.asignarRangoFecha(fechaInicio, fechaFinal);
		h.setPubDao(publDAO);		
		return h.verHistorial();
	}
	
	@Override
	public void cambiarEstadoNotificacion(boolean estado) {
		
	}
	@Override
	public List<IPublicacion> verResultadosNotificacion(String idPublicacion) {
		return null;
	}

	public void setObjRegister(IObjetoRegistro objRegister) {
		this.objRegister = objRegister;
	}
	
	private void crearRegistrador(int tipo) {
		if(tipo==1)
			registroPub = new RegistradorPubOP();
		else
			registroPub = new RegistradorPubOH();
	}

	
	
		
}

