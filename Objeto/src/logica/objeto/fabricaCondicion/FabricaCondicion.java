package logica.objeto.fabricaCondicion;

import logica.objeto.condicionAbs.iCondicionable;

public abstract class FabricaCondicion {
	public abstract iCondicionable crearCondicion();
	
	public FabricaCondicion() {}
}
