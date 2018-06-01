package logica.objeto.registrador;

import datos.objeto.objetos.ObjetoDAO;
import logica.objeto.fabricaCondicion.FabricaCondicion;
import logica.objeto.objetos.Categoria;
import logica.objeto.objetos.Objeto;

public abstract class RegistradorObjeto implements IRegistradorObjetos{
	protected Objeto objeto;
	protected ObjetoDAO objetoDAO;
	protected FabricaCondicion fabricaCond;
	
	public RegistradorObjeto() {
		objetoDAO = new ObjetoDAO();
	}	
	
	
	@Override
	public boolean crearObjeto(String nombre, String descripcion, String estado) {
		objeto = new Objeto(nombre, descripcion, estado);
		return true;
	} 	
	
	@Override
	public void asignarCategoria(int id) {
		Categoria cat = new Categoria();
		cat.setIdCategoria(id);
		objeto.setCategoria(cat);
	}
	
	@Override
	public Objeto getObjeto() {
		return objeto;
	}
	
	@Override
	public void registrar() {
		objetoDAO.setObjeto(objeto);
		objetoDAO.registrarObjeto();
		
	}
	
}
