package logica.objeto.fabricaCondicion;

import logica.objeto.condicion.Perdido;
import logica.objeto.condicion.iCondicionable;

public class FabricaPerdido extends FabricaCondicion {
	public FabricaPerdido() {
	}
	@Override
	public iCondicionable crearCondicion() {
		// TODO Auto-generated method stub
		return new Perdido();
	}

}
