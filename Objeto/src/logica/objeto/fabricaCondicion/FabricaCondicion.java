package logica.objeto.fabricaCondicion;

import logica.objeto.condicion.iCondicionable;

public abstract class FabricaCondicion {
	public abstract iCondicionable crearCondicion();
	
	public FabricaCondicion() {}
}
