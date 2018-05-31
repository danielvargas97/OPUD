package logica.objeto.condicion;


public class Perdido extends Condicion{
	
	
	public Perdido() {
		super();
		setNombre("Perdido");
		setIdCondicion(2);
	}
	
	@Override
	public String verNombreCondicion() {
		// 
		return getNombre();
	}

	@Override
	public int getIdCondicion() {
		// TODO Auto-generated method stub
		return getId();
	}
}
