package apiPublicacion;

import java.util.ArrayList;

public interface IHistorial {
	public ArrayList<IPublicacion> historial(String idUsuario,String fechaInicio,String fechaFinal, int tipoPublicacion);
}
