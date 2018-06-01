package logica.objeto.fachada;

import java.util.List;


import apiObjeto.IObjeto;
import apiObjeto.IObjetoRegistro;
import datos.objeto.objetos.CategoriaDAO;
import datos.objeto.objetos.CondicionDAO;
import datos.objeto.objetos.ObjetoDAO;
import logica.objeto.cargador.CargadorObjeto;
import logica.objeto.cargador.ICargadorObjeto;
import logica.objeto.fabricafachada.ClienteFabrica;
import logica.objeto.registrador.IRegistradorObjetos;
import logica.objeto.registrador.RegistradorOH;
import logica.objeto.registrador.RegistradorOP;

public class ObjetoMaster implements IObjetoRegistro {
	private IRegistradorObjetos creador;
	private ObjetoDAO objDao = new ObjetoDAO();
	private CategoriaDAO catDao = new CategoriaDAO();
	private CondicionDAO condDao = new CondicionDAO();
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
		registrar(nombre,descripcion,estado,categoria);
	}
	
	/**
	 * Registro de objeto hallado
	 * @param nombre 
	 * @param descripcion
	 * @param estado
	 * @param categoria
	 */
	public void registrarOH(String nombre, String descripcion, String estado, int categoria) {
		creador = new RegistradorOH();
		registrar(nombre,descripcion,estado,categoria);
		
	}
	
	public IObjeto cargarObjeto(String idObjeto) {
		ICargadorObjeto cargador = new CargadorObjeto();
		cargador.crearObjeto(idObjeto);
		cargador.asociarCategoria();
		cargador.asociarCondicion(new ClienteFabrica());		
		return cargador.getObjeto();
	}
	
	public List<String> verCategoria(){		
		return catDao.cargarCategoria();
	}
	
	
	private void registrar(String nombre, String descripcion, String estado, int categoria) {
		creador.crearObjeto(nombre, descripcion, estado);
		creador.generarIdObjeto();
		creador.asignarCondicion();
		creador.asignarCategoria(categoria);
		creador.registrar();
	}
	
}
