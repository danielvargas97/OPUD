package logica.usuario.fachadaUser;

import apiUsuario.IRegistro;
import apiUsuario.IUsuario;
import logica.usuario.contrasena.Contrasena;
import logica.usuario.contrasenaInterface.IContrasena;
import logica.usuario.registrador.IRegistroAdmin;
import logica.usuario.registrador.IRegistroOPUD;
import logica.usuario.registrador.IRegistroUsuario;
import logica.usuario.registrador.RegistroUsuario;


public class RegistroUsr implements IRegistro {
	private IRegistroUsuario registro;
	private IRegistroAdmin regAdmin;
	private IRegistroOPUD regOpud;
	
	public RegistroUsr(IRegistroUsuario usr,IRegistroOPUD opud) {
		this.registro = usr;
		this.regOpud = opud;
	}
	
	public RegistroUsr(IRegistroUsuario usr,IRegistroAdmin admin) {
		this.registro = usr;
		this.regAdmin = admin;
	}
	
	
	@Override
	public boolean registrar(String nombre, String apellido, String correo, String docIdentidad) {
		registro.registrar(nombre, apellido, correo, docIdentidad);
		return true;
	}

	@Override
	public void asignarContrasena(String contrasena) {
		IContrasena pass = new Contrasena(contrasena);
		registro.asignarContrasena(pass);
		
	}

	@Override
	public boolean registrarUsuarioOPUD(String codigo, String rolUniversidad) {		
		regOpud.asignarUsuario(registro.getUsuario());
		regOpud.registrarUsuarioOPUD(codigo, rolUniversidad);
		
		return true;
	}

	@Override
	public boolean registrarAdmin(String nickname) {
		regAdmin.asignarUsuario(registro.getUsuario());
		regAdmin.registrarAdmin(nickname);		
		return true;
	}

	@Override
	public IUsuario cargarUsuario(String idUser) {
		return null;
	}
	

}
