package logica.cargador.usuario;

import datos.usuario.usuario.ContrasenaDAO;
import datos.usuario.usuario.UsuarioDAO;
import logica.usuario.usuario.Usuario;

public class CargadorUser implements ICargadorUser {
	private Usuario user;
	private String idUser;
	
	private UsuarioDAO userDao;
	private ContrasenaDAO passDao;
	
	public CargadorUser() {
		userDao = new UsuarioDAO();
		passDao = new ContrasenaDAO();		
	} 

	@Override
	public void crearUsuarioBase() {
		user = userDao.cargarUsuario(idUser);
	}

	
	public void cargarContrasena() {		
		user.setContrasena(passDao.cargarContrasena(idUser));
	}

	@Override
	public void setIdUsuario(String id) {
		this.idUser = id;
	}	
	
	@Override
	public String getIdUsuario() {
		return idUser;
	}

	@Override
	public Usuario getUsuario() {
		return user;
	}

}
