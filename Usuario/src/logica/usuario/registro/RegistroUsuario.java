package logica.usuario.registro;

import logica.usuario.usuario.Administrador;
import logica.usuario.usuario.Contrasena;
import logica.usuario.usuario.Usuario;
import logica.usuario.usuario.UsuarioOPUD;

public class RegistroUsuario implements IRegistroUsuario {
	private Usuario nuevo;
	private UsuarioOPUD nuevoUser;
	private Administrador nuevoAdmin;
	

	@Override
	public boolean registrar(String nombre, String apellido, String correo, String docIdentidad) {
		nuevo = new Usuario();
		nuevo.setNombre(nombre);
		nuevo.setApellido(apellido);
		nuevo.setDocIdentidad(docIdentidad);
		nuevo.setCorreo(correo);
		return false;
	}

	@Override
	public void asignarContrasena(String contrasena) {
		nuevo.setContrasena(new Contrasena(contrasena));
		//UsuarioDAO.cambiarContrasena(contrasena);
	}

	@Override
	public boolean registrarUsuarioOPUD(String codigo, String rolUniversidad) {
		nuevoUser = new UsuarioOPUD(nuevo, null);
		nuevoUser.setCodigo(codigo);
		nuevoUser.setRolUniversidad(rolUniversidad);
		//UsuarioDAO.registrarUsuarioOPUD();
		
		return true;
	}

	@Override
	public boolean registrarAdmin(String nickname) {
		nuevoAdmin = new Administrador(nuevo);
		nuevoAdmin.setNickname(nickname);
		//UsuarioDAO.registrarUsuarioOPUD();
		
		return false;
	}

	@Override
	public Usuario getUsuario() {
		// TODO Auto-generated method stub
		return nuevo;
	}

	@Override
	public UsuarioOPUD getUsuarioOPUD() {
		// TODO Auto-generated method stub
		return nuevoUser;
	}

	@Override
	public Administrador getAdmin() {
		// TODO Auto-generated method stub
		return nuevoAdmin;
	}

}
