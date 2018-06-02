package logica.objeto.cargador;

import apiObjeto.IObjeto;
import datos.objeto.objetos.CategoriaDAO;
import datos.objeto.objetos.ObjetoDAO;
import logica.objeto.fabricafachada.ClienteFabrica;
import logica.objeto.objetos.Objeto;

public class CargadorObjeto implements ICargadorObjeto  {
	private Objeto o;
	private ObjetoDAO objDao;
	private CategoriaDAO catDao;
	
	public CargadorObjeto() {		
		this.objDao = new ObjetoDAO();		
		this.catDao = new CategoriaDAO();		
	}
	
	@Override
	public void crearObjeto(String id) {		
		o = objDao.cargarObjeto(id);
	}

	@Override
	public void asociarCondicion(ClienteFabrica cliente) {
		int idCond = objDao.cargarIdCondicion(o.getIdObjeto());
		cliente.generarCondicion(Integer.toString(idCond));		
		o.setCondicion(cliente.crear());
	}

	@Override
	public void asociarCategoria() {
		int idCat = objDao.cargarIdCategoria(o.getIdObjeto());
		o.setCategoria(catDao.cargarCategoria(idCat));
	}

	@Override
	public IObjeto getObjeto() {
		IObjeto cargado = o;
		return cargado;
	}

}
