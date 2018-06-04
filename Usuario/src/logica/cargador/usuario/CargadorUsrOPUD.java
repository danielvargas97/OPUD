package logica.cargador.usuario;

import apiUsuario.IUsuario;
import datos.usuario.usuario.CalificacionDAO;
import datos.usuario.usuario.UsrOpudDAO;
import logica.usuario.calificador.iCalificable;
import logica.usuario.usuario.UsuarioOPUD;

public class CargadorUsrOPUD implements ICargadorUsrOPUD {
	
	private ICargadorUser usuario;
	private CalificacionDAO califDao;
	private iCalificable calificador;
	private UsrOpudDAO opudDAO;
	private UsuarioOPUD userOPUD;
	
	//private I
	
	public CargadorUsrOPUD() {
		this.califDao = new CalificacionDAO();
		this.opudDAO = new UsrOpudDAO();
	}
	
	@Override
	public void cargarUsuarioBase(ICargadorUser cargador) {
		this.usuario = cargador;
	}
	@Override
	public void setCalificador(iCalificable calificador) {
		this.calificador = calificador;
	}

	@Override
	public void cargarUsuarioOpud() {
		userOPUD = opudDAO.cargarUsuario(usuario.getIdUsuario());
		userOPUD.setUsuario(usuario.getUsuario());
		cargarCalificacion();
	}
	
	public void cargarCalificacion() {		
		userOPUD.setCalificacion(califDao.verCalificacion(usuario.getIdUsuario()));
	}

	@Override
	public IUsuario getUsuarioOPUD() {
		IUsuario u = userOPUD;		
		return u;
	}
	

}
