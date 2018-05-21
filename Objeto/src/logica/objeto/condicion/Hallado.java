package logica.objeto.condicion;

public class Hallado extends Condicion{	
	public Hallado() {
		super();
		setNombre("Hallado");
		setIdCondicion(2);
	}
	

	@Override
	public String verNombreCondicion() {
		// TODO Auto-generated method stub
		return getNombre();
	}


	@Override
	public int getIdCondicion() {
		// TODO Auto-generated method stub
		return getId();
	}
	
}
