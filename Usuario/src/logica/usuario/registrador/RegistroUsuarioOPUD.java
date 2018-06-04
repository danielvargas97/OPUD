package logica.usuario.registrador;

import datos.usuario.usuario.UsrOpudDAO;
import logica.usuario.usuario.Usuario;
import logica.usuario.usuario.UsuarioOPUD;

public class RegistroUsuarioOPUD implements IRegistroOPUD {
	private Usuario nuevo;
	private UsuarioOPUD nuevoUser;
	private UsrOpudDAO opuddao;
	
	public RegistroUsuarioOPUD() {
		this.opuddao = new UsrOpudDAO();
	}
	
	@Override
	public boolean registrarUsuarioOPUD(String codigo, String rolUniversidad) {
		nuevoUser = new UsuarioOPUD(nuevo);
		nuevoUser.setCodigo(codigo);
		nuevoUser.setRolUniversidad(rolUniversidad);
		
		registrar();
		return true;
	}
	
	@Override
	public UsuarioOPUD getUsuarioOPUD() {
		return nuevoUser;
	}

	@Override
	public void asignarUsuario(Usuario usr) {
		this.nuevo = usr;
		
	}

	private void registrar() {
		opuddao.setUsrOPUD(nuevoUser);
		opuddao.insertar();
	}
	
	
}
