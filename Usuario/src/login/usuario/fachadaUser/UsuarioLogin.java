package login.usuario.fachadaUser;

import datos.usuario.usuario.UsuarioDAO;
import logica.usuario.usuario.Administrador;
import logica.usuario.usuario.Usuario;
import logica.usuario.usuario.UsuarioOPUD;
import logica.usuario.usuarioAPI.ILogin;

public class UsuarioLogin implements ILogin {
	private Usuario usr;
	private Administrador admin;
	private UsuarioOPUD usuario;
	private UsuarioDAO userDAO = new UsuarioDAO();
	@Override
	public boolean iniciarSesion(String user, String pass, int tipo) {
		if(userDAO.login(user, pass, tipo)) {
			if(tipo==1) {
				
			}
			else if(tipo==2) {
				
			}
			return true;
		}
		else {
			
			return false;
		}
	}
	
	
}
