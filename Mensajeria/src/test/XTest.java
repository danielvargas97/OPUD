package test;



import java.util.List;

import apiMensajeria.IMensaje;
import apiMensajeria.IMensajeria;
import logica.usuario.fachadaMensajeria.MensajeMaster;

public class XTest {

	public static void main(String[] args) {
		/*String id = "1016099017";
		IMensajeria mens = new MensajeMaster(id);
		
		mens.redactar(id, "1015065090", "Hola", "This is just a test message");
		mens.enviarMensaje(null);
		*/
		String id = "1015065090";
		
		IMensajeria mens = new MensajeMaster();
		mens.setIdUser(id);
		mens.cargarMensajeria();
		List<IMensaje> x = mens.verMensajesEntrantes();
		List<IMensaje> y = mens.verMensajesEnviados();
		/*IMensaje x = mens.verMensajeEntrante(0);
		*/

		for(IMensaje r:x)
			System.out.println(r.getAsunto());
		for(IMensaje s:y)
			System.out.println(s.getAsunto());
	}

}
