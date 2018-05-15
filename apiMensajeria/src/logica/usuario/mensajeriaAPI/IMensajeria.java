package logica.usuario.mensajeriaAPI;

import java.util.List;


public interface IMensajeria {
	public List<IMensaje> verMensajesEntrantes();
	public List<IMensaje> verMensajesEnviados();
	public void enviarMensaje(IMensaje mensaje);	
	public void eliminarMensajeEntrante(int index);
	
	public IMensaje verMensajeEntrante(int index);
	public IMensaje verMensajeSalida(int index);
	public void redactar(String origen, String destino,String asunto, String mensaje);
	public IMensaje verMensajeRedactado();
}
