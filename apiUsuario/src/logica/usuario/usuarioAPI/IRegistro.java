package logica.usuario.usuarioAPI;

//import logica.usuario.usuario.IUsuario;

public interface IRegistro {
	public boolean registrar(String nombre, String apellido,String correo, String docIdentidad);
	public void asignarContrasena(String contrasena);
	public boolean registrarUsuarioOPUD(String codigo, String rolUniversidad);
	public boolean registrarAdmin(String nickname);
	public IUsuario cargarUsuario(String idUser);
}
