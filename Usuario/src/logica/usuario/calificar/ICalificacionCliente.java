package logica.usuario.calificar;

public interface ICalificacionCliente {
	public void calificar(String idCalificado,String idCalificador,int nota);
	public int verNota(String idUser);
}
