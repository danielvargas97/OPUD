package apiUsuario;

//import logica.usuario.usuario.IUsuario;

public interface ILogin {	
	public boolean iniciarSesion(String user, String pass, int tipo);
}
