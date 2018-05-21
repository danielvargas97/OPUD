package logica.objeto.fabricaCondicion;

import logica.objeto.condicion.Hallado;
import logica.objeto.condicion.iCondicionable;

public class FabricaHallado extends FabricaCondicion {

	public FabricaHallado() {
		super();
	}
	
	@Override
	public iCondicionable crearCondicion() {
		// TODO Auto-generated method stub
		return new Hallado();
	}

}
