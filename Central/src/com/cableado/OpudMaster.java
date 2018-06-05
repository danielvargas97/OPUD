package com.cableado;
import apiMensajeria.IMensajeria;
import apiObjeto.IObjetoRegistro;
import apiPublicacion.IPublicacionAdmin;
import apiUsuario.IUsuario;
import apiUsuario.IUsuarioAdmin;
/*
import java.util.List;

import apiObjeto.IObjeto;
import apiObjeto.IObjetoRegistro;
import apiPublicacion.IPublicacion;
import apiPublicacion.IPublicacionAdmin;
import apiUsuario.IUsuario;
import apiUsuario.IUsuarioAdmin;
import logica.objeto.fachada.ObjetoMaster;
import logica.publicacion.fachada.PublicacionMaster;
import logica.usuario.fachadaUser.RegistroUsr;
*/
import utilidades.Cargador;

public class OpudMaster {
	public static void main(String args[]) {
		Cargador c = new Cargador("componentes", ClassLoader.getSystemClassLoader());
		
		Class cls = null;
		IPublicacionAdmin pubAdm = null;
		IMensajeria message = null;
		IUsuarioAdmin usrAdm= null;
		IObjetoRegistro objReg = null;
		
		try {
			cls = c.cargarUnaClase(IPublicacionAdmin.class.getName());			
			pubAdm = (IPublicacionAdmin) cls.newInstance();
			
			cls = c.cargarUnaClase(IMensajeria.class.getName());
			message = (IMensajeria)cls.newInstance();
			
			cls = c.cargarUnaClase(IUsuarioAdmin.class.getName());
			usrAdm = (IUsuarioAdmin)cls.newInstance();
			
			cls = c.cargarUnaClase(IObjetoRegistro.class.getName());
			objReg = (IObjetoRegistro)cls.newInstance();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}						
		
		IUsuario u = usrAdm.cargarUsuario("1016099017");
		System.out.println(u.getIdUser()+" "+u.getNombre()+" "+u.getApellido());
		
		/*IPublicacionAdmin r = new PublicacionMaster();
		IObjetoRegistro obj = new ObjetoMaster();
		
		
		IUsuarioAdmin usrAdm = new RegistroUsr();
		IUsuario u = usrAdm.cargarUsuario("1015065090");
		
		System.out.println(u.getIdUser());
		System.out.println(u.getNombre());
		System.out.println(u.getApellido());
		r.asignarUsuarioUtil(usrAdm);
		r.asignarRegistroObjeto(obj);
		*/
		/*
		r.crearPublicacion(1);
		r.asignarUsuario(usrAdm.cargarUsuario("1015065090"));		
		r.registrarTitulo("Computador MAC");
		r.registrarFechaPublicacion("02", "06", "2018");
		r.registrarObjeto("MAC", "Es una laptop mac negra", "Excelente", 2);		
		r.publicar();
		
		r.crearPublicacion(1);
		r.asignarUsuario(usrAdm.cargarUsuario("1015065090"));
		
		r.registrarTitulo("Libro Fisica 1");
		r.registrarFechaPublicacion("02", "06", "2018");
		r.registrarObjeto("Libro Fisica 1", "Es un libro fisica 1 de serway", "Excelente", 1);		
		r.publicar();
		
		
		r.crearPublicacion(2);
		r.asignarUsuario(usrAdm.cargarUsuario("1125025025"));
		r.registrarTitulo("Computador MAC");
		r.registrarFechaPublicacion("02", "06", "2018");
		r.registrarObjeto("MAC", "Es una laptop mac negra", "Excelente", 2);		
		r.publicar();
		*/
		/*
		List<IPublicacion> x = r.buscarPublicacion("Libro", 1);
		
		for(IPublicacion y:x) {
			System.out.println(y.getNombre());
			System.out.println(y.getFechaCondicion());
			System.out.println(y.getFechaPublicacion());
			//IUsuario uu= r.cargarDatosUsuario(y.getIdPublicacion());
			IObjeto oo = r.cargarDatosObjeto(y.getIdPublicacion());
			//System.out.println(uu.getNombre()+" "+uu.getApellido());
			System.out.println(oo.getNombre()+" : "+oo.getDescripcion());
		}
		
		*/
	}
	
	
}