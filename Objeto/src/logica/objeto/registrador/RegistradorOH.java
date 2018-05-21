package logica.objeto.registrador;

import java.util.List;

import logica.objeto.fabricaCondicion.FabricaHallado;
import logica.objeto.objetos.Objeto;

public class RegistradorOH extends RegistradorObjeto {

	public RegistradorOH() {
		this.fabricaCond = new FabricaHallado();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean crearObjeto(String nombre, String descripcion, String estado) {
		objeto = new Objeto(nombre, descripcion, estado);
		return true;
	}

	@Override
	public void asignarCategoria(int id) {
		// TODO Auto-generated method stub
		
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
