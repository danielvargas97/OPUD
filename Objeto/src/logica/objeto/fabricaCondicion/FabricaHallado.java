package logica.objeto.fabricaCondicion;

import logica.objeto.condicion.Hallado;
import logica.objeto.condicion.ICondicionable;

public class FabricaHallado extends FabricaCondicion {

	public FabricaHallado() {
	}
	
	@Override
	public ICondicionable crearCondicion() {
		// TODO Auto-generated method stub
		return new Hallado();
	}

}
