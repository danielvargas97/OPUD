package logica.usuario.registrador;

import logica.usuario.contrasenaInterface.IContrasena;
import logica.usuario.usuario.Administrador;
import logica.usuario.usuario.Usuario;
import logica.usuario.usuario.UsuarioOPUD;

public interface IRegistroUsuario {	
	public boolean registrar(String nombre, String apellido,String correo, String docIdentidad);
	public void asignarContrasena(IContrasena contrasena);
	public Usuario getUsuario();
	
	
}
