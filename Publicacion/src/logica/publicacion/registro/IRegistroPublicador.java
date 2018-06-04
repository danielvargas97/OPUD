package logica.publicacion.registro;

public interface IRegistroPublicador {
	public void crearPublicacion();
	public void asignarIdUser(String idUser);
	public void asignarTituloPublicacion(String titulo);
	public void asignarIdObjeto(String idObjeto);
	public void registrarFecha(String dia,String mes,String anho);
	public void generarId();
	public void registrar();
}
