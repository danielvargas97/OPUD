package logica.usuario.fachadaUser;

import datos.usuario.usuario.UsuarioDAO;
import logica.usuario.usuario.Administrador;
import logica.usuario.usuario.Usuario;
import logica.usuario.usuario.UsuarioOPUD;


public class UsuarioLogin{
	private Usuario usr;
	private Administrador admin;
	private UsuarioOPUD usuario;
	private UsuarioDAO userDAO = new UsuarioDAO();

	public boolean iniciarSesion(String user, String pass, int tipo) {
		return userDAO.login(user, pass, tipo);
	}
	
	
}
