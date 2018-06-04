package logica.usuario.registrador;

import logica.usuario.contrasenaInterface.IContrasena;
import logica.usuario.usuario.Administrador;
import logica.usuario.usuario.Usuario;
import logica.usuario.usuario.UsuarioOPUD;

public interface IRegistroUsuario {	
	
	public boolean crearUsuario(String nombre, String apellido,String correo, String docIdentidad, String tipoDoc);	
	public void asignarContrasena(IContrasena contrasena);
	public void registrarUsuario();
	public Usuario getUsuario();
	
	
}
