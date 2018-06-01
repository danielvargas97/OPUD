package logica.objeto.fabricafachada;

import logica.objeto.condicion.ICondicionable;
import logica.objeto.fabricaCondicion.FabricaCondicion;
import logica.objeto.fabricaCondicion.FabricaHallado;
import logica.objeto.fabricaCondicion.FabricaPerdido;

public class ClienteFabrica {
	private FabricaCondicion fabrica;
	
	public ClienteFabrica() {
	}
	
	public void generarCondicion(String tipo) {
		if(tipo.equals("1")) {
			fabrica = new FabricaPerdido();
		}
		else {
			fabrica = new FabricaHallado();
		}
	}
	
	public ICondicionable crear() {
		return fabrica.crearCondicion();
	}
}
