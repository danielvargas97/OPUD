package apiPublicacion;

import java.util.ArrayList;
import java.util.List;

import apiObjeto.IObjeto;
import apiObjeto.IObjetoRegistro;
import apiUsuario.IUsuario;
import apiUsuario.IUsuarioAdmin;

public interface IPublicacionAdmin {

	// Registrador
	public void crearPublicacion(int tipo);
	public void asignarUsuario(IUsuario user);
	public void asignarUsuarioUtil(IUsuarioAdmin usrAdm);
	public void asignarRegistroObjeto(IObjetoRegistro reg);
	public void registrarTitulo(String titulo);
	public void registrarFechaPublicacion(String dia,String mes, String anho);
	public void registrarObjeto(String nombre, String descripcion, String estado, int idCategoria);	
	public void publicar();
	
	public void cambiarEstadoPublicacion(int activo, String idPublicacion);	
	public void cargarPublicacion(String idUsuario, String idPublicacion, int tipo);
	
	//public void asignarObjeto(IObjeto objeto);
	
	public IUsuario cargarDatosUsuario(String idPublicacion);
	public IObjeto cargarDatosObjeto(String idPublicacion);
	
	
	
	//Buscador
	public ArrayList<IPublicacion> buscarPublicacion(String textoBusqueda,int tipoPublicacion);
	//Historial
	public ArrayList<IPublicacion> historial(String idUsuario,String fechaInicio,String fechaFinal, int tipoPublicacion);
	
	//Notificador
	public void cambiarEstadoNotificacion(boolean estado);
	public List<IPublicacion> verResultadosNotificacion(String idPublicacion);
}
