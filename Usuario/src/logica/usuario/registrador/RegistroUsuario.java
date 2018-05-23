package logica.usuario.registrador;

import logica.usuario.contrasena.Contrasena;
import logica.usuario.usuario.Administrador;
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
	public Usuario getUsuario() {
		// TODO Auto-generated method stub
		return nuevo;
	}





}
