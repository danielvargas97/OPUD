package logica.cargador.usuario;

import apiUsuario.IUsuario;
import datos.usuario.usuario.AdministradorDAO;
import logica.usuario.usuario.Administrador;

public class CargadorAdmin implements ICargadorAdmin {
	private ICargadorUser usuario;
	private Administrador adm;
	private AdministradorDAO admDao;
	
	public CargadorAdmin() {
		this.admDao = new AdministradorDAO();
		
	}
	
	@Override
	public void cargarUsuarioBase(ICargadorUser cargador) {
		this.usuario = cargador;
	}

	@Override
	public void cargarAdmin() {
		adm = admDao.cargarUsuario(usuario.getIdUsuario());
		adm.setUsuario(usuario.getUsuario());
	}

	@Override
	public IUsuario getAdmin() {
		IUsuario usr = adm;
		return usr;
	}

}
