package logica.objeto.fabricaCondicion;

import logica.objeto.condicion.ICondicionable;

public abstract class FabricaCondicion {
	public abstract ICondicionable crearCondicion();
	
	public FabricaCondicion() {}
}
