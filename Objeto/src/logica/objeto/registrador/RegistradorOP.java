package logica.objeto.registrador;


import logica.objeto.fabricaCondicion.FabricaPerdido;
import logica.objeto.objetos.Objeto;

public class RegistradorOP extends RegistradorObjeto {

	public RegistradorOP() {
		this.fabricaCond = new FabricaPerdido();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean crearObjeto(String nombre, String descripcion, String estado) {
		objeto = new Objeto(nombre, descripcion, estado);
		objeto.asignarID();
		return true;
	}

	@Override
	public void asignarCategoria(int id) {
		
	}

	@Override
	public void asignarCondicion() {
		this.condicion = fabricaCond.crearCondicion();
	}

	@Override
	public Objeto getObjeto() {
		// TODO Auto-generated method stub
		return objeto;
	}


}
