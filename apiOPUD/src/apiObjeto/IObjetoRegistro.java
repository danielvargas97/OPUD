package apiObjeto;

import java.util.List;

public interface IObjetoRegistro {
	//Creacion del objeto
	public void registrarOP(String nombre, String descripcion, String estado, int categoria);
	public void registrarOH(String nombre, String descripcion, String estado, int categoria);
	public String verID();
	public IObjeto cargarObjeto(String idObjeto);
	public List<String> verCategoria();
}
