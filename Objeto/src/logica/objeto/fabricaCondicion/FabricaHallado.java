package logica.objeto.fabricaCondicion;

import logica.objeto.condicion.Hallado;
import logica.objeto.condicionAbs.iCondicionable;

public class FabricaHallado extends FabricaCondicion {

	public FabricaHallado() {
	}
	
	@Override
	public iCondicionable crearCondicion() {
		// TODO Auto-generated method stub
		return new Hallado();
	}

}
