package logica.usuario.bandeja;

import java.util.List;

import apiMensajeria.IMensaje;


public interface IBandejaEntrada {
	public void setBandejaID(String id);
	public List<IMensaje> verMensajesEntrantes();
	public List<IMensaje> verMensajesEnviados();
	
	public void enviarMensaje(IMensaje mensaje);
	public void eliminarMensajeEntrante(int index);
	public IMensaje verMensajeEntrante(int index);
	public IMensaje verMensajeSalida(int index);
	
}
