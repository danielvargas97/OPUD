package logica.usuario.registrador;

import logica.usuario.usuario.Usuario;
import logica.usuario.usuario.UsuarioOPUD;

public class RegistroUsuarioOPUD implements IRegistroOPUD {
	private Usuario nuevo;
	private UsuarioOPUD nuevoUser;
	
	@Override
	public boolean registrarUsuarioOPUD(String codigo, String rolUniversidad) {
		nuevoUser = new UsuarioOPUD(nuevo);
		nuevoUser.setCodigo(codigo);
		nuevoUser.setRolUniversidad(rolUniversidad);
		
		return true;
	}
	
	@Override
	public UsuarioOPUD getUsuarioOPUD() {
		// TODO Auto-generated method stub
		return nuevoUser;
	}

	@Override
	public void asignarUsuario(Usuario usr) {
		this.nuevo = usr;
		
	}

}
