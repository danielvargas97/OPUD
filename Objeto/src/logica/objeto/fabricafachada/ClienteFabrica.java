package logica.objeto.fabricafachada;

import logica.objeto.condicion.iCondicionable;
import logica.objeto.fabricaCondicion.FabricaCondicion;
import logica.objeto.fabricaCondicion.FabricaHallado;
import logica.objeto.fabricaCondicion.FabricaPerdido;

public class ClienteFabrica {
	private FabricaCondicion fabrica;
	
	public ClienteFabrica(String tipo) {
		if(tipo.equals("1")) {
			fabrica = new FabricaPerdido();
		}
		else {
			fabrica = new FabricaHallado();
		}
	}
	
	public iCondicionable crear() {
		return fabrica.crearCondicion();
	}
}
