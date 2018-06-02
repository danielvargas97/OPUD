package logica.usuario.fachadaMensajeria;

import java.util.Date;
import java.util.List;

import apiMensajeria.IMensaje;
import apiMensajeria.IMensajeria;
import datos.usuario.mensajeria.MensajeriaDAO;
import logica.usuario.bandeja.IBandejaEntrada;
import logica.usuario.mensajeria.Mensaje;


public class MensajeMaster implements IMensajeria {
	private IMensaje mensajeActual;
	private IBandejaEntrada bandeja;
	private MensajeriaDAO mdao;
	
	public MensajeMaster(String idUser) {
		cargarBandeja(idUser);
	}

	public List<IMensaje> verMensajesEntrantes(){
		return bandeja.verMensajesEntrantes();
	}
	
	public List<IMensaje> verMensajesEnviados(){
		return bandeja.verMensajesEnviados();
	}
	
	
	public void enviarMensaje(IMensaje mensaje) {
		bandeja.enviarMensaje(mensajeActual);
		mdao.setMensaje((Mensaje)bandeja.verMensajeSalida(0));
		mdao.insertar();
	}
	
	public void eliminarMensajeEntrante(int index) {
		bandeja.eliminarMensajeEntrante(index);
	}
	
	public IMensaje verMensajeEntrante(int index) {
		IMensaje aux = bandeja.verMensajeEntrante(index);
		mdao.marcarLeido(aux.getIdMensaje());
		return aux; 		
	}
	
	public IMensaje verMensajeSalida(int index) {
		return bandeja.verMensajeSalida(index);
	}
	
	public void redactar(String origen, String destino,String asunto, String mensaje){
		Mensaje m = new Mensaje(origen,destino);
		m.setAsunto(asunto);
		m.setMensaje(mensaje);
		m.setFecha(new Date());
		m.setLeido(0);		
		mensajeActual = m;		
	}
	
	public IMensaje verMensajeRedactado() {
		return mensajeActual;
	}
	
	private void cargarBandeja(String id) {
		mdao = new MensajeriaDAO();
		mdao.cargarCorreo(id);
		bandeja = mdao.getBandeja();
	}	
}
