package apiPublicacion;

import apiObjeto.IObjeto;

public interface IPublicacion {
	//Obtener informacion de una publicacion particular
	public String getNombre();
	public String getIdPublicacion();
	public String getFechaPublicacion();
	public String getFechaCondicion();	
	//public IObjeto getInfoObjeto();	
	public int getTipoPublicacion();
	public int getActivo();

}
