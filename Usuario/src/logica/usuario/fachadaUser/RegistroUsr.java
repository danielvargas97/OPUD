package logica.usuario.fachadaUser;

import apiUsuario.IRegistro;
import apiUsuario.IUsuario;
import logica.usuario.registrador.IRegistroUsuario;
import logica.usuario.registrador.RegistroUsuario;


public class RegistroUsr implements IRegistro {
	private IRegistroUsuario registro = new RegistroUsuario();
	
	@Override
	public boolean registrar(String nombre, String apellido, String correo, String docIdentidad) {
		registro.registrar(nombre, apellido, correo, docIdentidad);
		return true;
	}

	@Override
	public void asignarContrasena(String contrasena) {
		registro.asignarContrasena(contrasena);
		
	}

	@Override
	public boolean registrarUsuarioOPUD(String codigo, String rolUniversidad) {		
		//registro.registrarUsuarioOPUD(codigo, rolUniversidad);
		
		return true;
	}

	@Override
	public boolean registrarAdmin(String nickname) {
		//registro.registrarAdmin(nickname);
		return true;
	}

	@Override
	public IUsuario cargarUsuario(String idUser) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
