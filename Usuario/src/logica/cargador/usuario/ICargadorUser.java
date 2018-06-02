package logica.cargador.usuario;

import logica.usuario.usuario.Usuario;

public interface ICargadorUser {
	public void setIdUsuario(String id);
	public void crearUsuarioBase();	
	public String getIdUsuario();	

	public Usuario getUsuario(); 
}
