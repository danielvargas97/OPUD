package logica.usuario.registrador;

import logica.usuario.usuario.Usuario;
import logica.usuario.usuario.UsuarioOPUD;

public interface IRegistroOPUD {
	public boolean registrarUsuarioOPUD(String codigo, String rolUniversidad);	
	public UsuarioOPUD getUsuarioOPUD();
	public void asignarUsuario(Usuario usr);
}
