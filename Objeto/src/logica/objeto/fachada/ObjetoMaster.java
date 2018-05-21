package logica.objeto.fachada;

import java.util.List;


import apiObjeto.IObjeto;
import apiObjeto.IObjetoRegistro;
import datos.objeto.objetos.ObjetoDAO;
import logica.objeto.fabricafachada.ClienteFabrica;
import logica.objeto.objetos.Objeto;
import logica.objeto.registrador.IRegistradorObjetos;
import logica.objeto.registrador.RegistradorOP;

public class ObjetoMaster implements IObjetoRegistro {
	private IRegistradorObjetos creador;
	private ObjetoDAO objDao = new ObjetoDAO();
	//private IObjeto objeto;
	
	public ObjetoMaster() {
	
	}
	
	
	/**
	 * Registro de objeto perdido
	 * @param nombre 
	 * @param descripcion 
	 * @param estado
	 * @param categoria
	 */
	public void registrarOP(String nombre, String descripcion, String estado, int categoria) {
		creador = new RegistradorOP();
		creador.crearObjeto(nombre, descripcion, estado);
		creador.asignarCondicion();
		creador.asignarCategoria(categoria);
		objDao.registrarObjeto();
	}
	
	/**
	 * Registro de objeto hallado
	 * @param nombre 
	 * @param descripcion
	 * @param estado
	 * @param categoria
	 */
	public void registrarOH(String nombre, String descripcion, String estado, int categoria) {
		creador = new RegistradorOP();
		creador.crearObjeto(nombre, descripcion, estado);
		creador.asignarCondicion();
		creador.asignarCategoria(categoria);
		objDao.registrarObjeto();
		
	}
	
	public IObjeto cargarObjeto(String idObjeto) {
		Objeto cargado = objDao.cargarObjeto(idObjeto);		
		ClienteFabrica cliente = new ClienteFabrica(objDao.cargarIDCondicion(idObjeto));
		cargado.asignarCondicion(cliente.crear());
		
		IObjeto obj = cargado;
		
		return obj;/*objeto;*/
	}
	
	public List<String> verCategoria(){		
		return objDao.cargarCategoria();
	}
	
	
	//public boolean crearObjeto(String nombre, String descripcion, String estado);
	
	
	
}
