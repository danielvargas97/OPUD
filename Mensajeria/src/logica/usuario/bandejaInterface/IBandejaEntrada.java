package logica.usuario.bandejaInterface;

import java.util.List;

import logica.usuario.mensajeriaAPI.IMensaje;

public interface IBandejaEntrada {
	public void setBandejaID(String id);
	public List<IMensaje> verMensajesEntrantes();
	public List<IMensaje> verMensajesEnviados();
	
	public void enviarMensaje(IMensaje mensaje);
	public void eliminarMensajeEntrante(int index);
	public IMensaje verMensajeEntrante(int index);
	public IMensaje verMensajeSalida(int index);
	
}
