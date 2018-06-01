package logica.objeto.cargador;

import apiObjeto.IObjeto;
import datos.objeto.objetos.CategoriaDAO;
import datos.objeto.objetos.CondicionDAO;
import datos.objeto.objetos.ObjetoDAO;
import logica.objeto.fabricafachada.ClienteFabrica;
import logica.objeto.objetos.Objeto;

public class CargadorObjeto implements ICargadorObjeto  {
	private Objeto o;
	private ObjetoDAO objDao;
	private CondicionDAO condDao;
	private CategoriaDAO catDao;
	
	
	@Override
	public void crearObjeto(String id) {		
		o = objDao.cargarObjeto(id);
	}

	@Override
	public void asociarCondicion(ClienteFabrica cliente) {
		String idCond = condDao.cargarIDCondicion(o.getIdObjeto());
		cliente.generarCondicion(idCond);		
		o.setCondicion(cliente.crear());
	}

	@Override
	public void asociarCategoria() {
		o.setCategoria(catDao.cargarCategoria(o.getIDCategoria()));
	}

	@Override
	public IObjeto getObjeto() {
		IObjeto cargado = o;
		return cargado;
	}

}
