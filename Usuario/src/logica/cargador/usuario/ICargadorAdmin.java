package logica.cargador.usuario;

import apiUsuario.IUsuario;

public interface ICargadorAdmin {
	public void cargarUsuarioBase(ICargadorUser cargador);
	public void cargarAdmin();
	public IUsuario getAdmin();
}
