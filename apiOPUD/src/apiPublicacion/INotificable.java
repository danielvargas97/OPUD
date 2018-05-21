package apiPublicacion;

import java.util.List;

public interface INotificable {
	public void cambiarEstadoNotificacion(boolean estado);
	public List<IPublicacion> verResultadosNotificacion(String idPublicacion);
}
