package logica.cargador.usuario;

import apiUsuario.IUsuario;
import logica.usuario.calificador.iCalificable;

public interface ICargadorUsrOPUD {
	public void cargarUsuarioBase(ICargadorUser cargador);
	public void setCalificador(iCalificable calificador);
	public void cargarUsuarioOpud();
		
	public IUsuario getUsuarioOPUD();
}
