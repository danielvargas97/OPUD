package logica.objeto.cargador;

import apiObjeto.IObjeto;
import logica.objeto.condicion.ICondicionable;
import logica.objeto.fabricafachada.ClienteFabrica;

public interface ICargadorObjeto {
	
	public void crearObjeto(String id);
	public void asociarCondicion(ClienteFabrica cliente);
	public void asociarCategoria();
	
	public IObjeto getObjeto();
	
	
}
