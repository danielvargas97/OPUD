package logica.objeto.registrador;

import logica.objeto.condicion.iCondicionable;
import logica.objeto.fabricaCondicion.FabricaCondicion;
import logica.objeto.objetos.Objeto;

public abstract class RegistradorObjeto implements IRegistradorObjetos{
	protected Objeto objeto;
	protected iCondicionable condicion;
	protected FabricaCondicion fabricaCond;
	
	public RegistradorObjeto() {
	}
	
	
}
