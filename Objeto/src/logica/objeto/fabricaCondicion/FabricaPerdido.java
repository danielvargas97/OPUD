package logica.objeto.fabricaCondicion;

import logica.objeto.condicion.Perdido;
import logica.objeto.condicion.ICondicionable;
public class FabricaPerdido extends FabricaCondicion {
	public FabricaPerdido() {
	}
	@Override
	public ICondicionable crearCondicion() {
		// TODO Auto-generated method stub
		return new Perdido();
	}

}
