package logica.usuario.registrador;

import logica.usuario.usuario.Administrador;
import logica.usuario.usuario.Usuario;

public class RegistroAdmin implements IRegistroAdmin {
	private Administrador nuevoAdmin;
	private Usuario nuevo;
	@Override
	public void asignarUsuario(Usuario usr) {
		this.nuevo = usr;
		
	}

	@Override
	public Administrador getAdmin() {
		// TODO Auto-generated method stub
		return nuevoAdmin;
	}

	@Override
	public boolean registrarAdmin(String nickname) {
		nuevoAdmin = new Administrador(nuevo);
		nuevoAdmin.setNickname(nickname);
		//UsuarioDAO.registrarUsuarioOPUD();
		
		return false;
	}
}
