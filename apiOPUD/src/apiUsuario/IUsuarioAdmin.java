package apiUsuario;

public interface IUsuarioAdmin {
	
	public boolean asignarDatosUsuario(String nombre, String apellido,String correo, String docIdentidad, String tipoDoc);
	public void asignarContrasena(String contrasena);
	public boolean registrarUsuarioOPUD(String codigo, String rolUniversidad);
	public boolean registrarAdmin(String nickname);
	public void registrarUsuario();
	
	public IUsuario cargarUsuario(String idUser);
	public IUsuario cargarAdmin(String idUser);
		
	public boolean iniciarSesion(String user, String pass, int tipo);
}
