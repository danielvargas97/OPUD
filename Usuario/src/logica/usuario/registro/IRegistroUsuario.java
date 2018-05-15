package logica.usuario.registro;

import logica.usuario.usuario.Administrador;
import logica.usuario.usuario.Usuario;
import logica.usuario.usuario.UsuarioOPUD;

public interface IRegistroUsuario {	
	public boolean registrar(String nombre, String apellido,String correo, String docIdentidad);
	public void asignarContrasena(String contrasena);
	public boolean registrarUsuarioOPUD(String codigo, String rolUniversidad);
	public boolean registrarAdmin(String nickname);
	public Usuario getUsuario();
	public UsuarioOPUD getUsuarioOPUD();
	public Administrador getAdmin();
}
