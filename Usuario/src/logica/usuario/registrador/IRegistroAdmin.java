package logica.usuario.registrador;

import logica.usuario.usuario.Administrador;
import logica.usuario.usuario.Usuario;

public interface IRegistroAdmin {
	public void asignarUsuario(Usuario usr);
	public Administrador getAdmin();
	public boolean registrarAdmin(String nickname);
}
