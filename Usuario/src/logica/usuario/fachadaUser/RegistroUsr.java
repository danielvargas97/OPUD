package logica.usuario.fachadaUser;

import apiUsuario.IUsuario;
import apiUsuario.IUsuarioAdmin;
import datos.usuario.usuario.UsuarioDAO;
import logica.cargador.usuario.CargadorAdmin;
import logica.cargador.usuario.CargadorUser;
import logica.cargador.usuario.CargadorUsrOPUD;
import logica.cargador.usuario.ICargadorAdmin;
import logica.cargador.usuario.ICargadorUser;
import logica.cargador.usuario.ICargadorUsrOPUD;
import logica.usuario.calificar.CalificacionCliente;
import logica.usuario.calificar.ICalificacionCliente;
import logica.usuario.contrasena.Contrasena;
import logica.usuario.contrasenaInterface.IContrasena;
import logica.usuario.registrador.IRegistroAdmin;
import logica.usuario.registrador.IRegistroOPUD;
import logica.usuario.registrador.IRegistroUsuario;
import logica.usuario.registrador.RegistroAdmin;
import logica.usuario.registrador.RegistroUsuario;
import logica.usuario.registrador.RegistroUsuarioOPUD;


public class RegistroUsr implements IUsuarioAdmin {
	private IRegistroUsuario registro;
	private IRegistroAdmin regAdmin;
	private IRegistroOPUD regOpud;
	private ICargadorUser cargUser; 
	private String idUserActual;
	
	
	public RegistroUsr() {
		this.registro = new RegistroUsuario();
		this.regAdmin = new RegistroAdmin();
		this.regOpud = new RegistroUsuarioOPUD();
	}
	
	@Override
	public boolean asignarDatosUsuario(String nombre, String apellido, String correo, String docIdentidad,String tipoDoc) {
		registro.crearUsuario(nombre, apellido, correo, docIdentidad,tipoDoc);
		return true;
	}

	@Override
	public void asignarContrasena(String contrasena) {
		IContrasena pass = new Contrasena(contrasena);
		registro.asignarContrasena(pass);
		
	}

	@Override
	public void registrarUsuario() {
		registro.registrarUsuario();
	}
	
	@Override
	public boolean registrarUsuarioOPUD(String codigo, String rolUniversidad) {		
		regOpud.asignarUsuario(registro.getUsuario());
		regOpud.registrarUsuarioOPUD(codigo, rolUniversidad);
		
		return true;
	}

	@Override
	public boolean registrarAdmin(String nickname) {
		regAdmin.asignarUsuario(registro.getUsuario());
		regAdmin.registrarAdmin(nickname);		
		return true;
	}

	@Override
	public IUsuario cargarUsuario(String idUser) {
		precargarUsuario(idUser);
		ICargadorUsrOPUD usrCargado = new CargadorUsrOPUD();
		usrCargado.cargarUsuarioBase(cargUser);
		usrCargado.cargarUsuarioOpud();
		return usrCargado.getUsuarioOPUD();
		
	}
	
	@Override
	public IUsuario cargarAdmin(String idUser) {
		precargarUsuario(idUser);
		ICargadorAdmin usrCargado = new CargadorAdmin();
		usrCargado.cargarUsuarioBase(cargUser);
		usrCargado.cargarAdmin();
		return usrCargado.getAdmin();
	}
	
	@Override
	public boolean iniciarSesion(String user, String pass, int tipo) {
		UsuarioDAO userDAO = new UsuarioDAO();
		if(userDAO.login(user, pass, tipo)) {
			this.idUserActual = user;
			return true;
		}
		else {
			return false;
		}
	}

	private void precargarUsuario(String idUser) {
		cargUser = new CargadorUser();
		ICargadorUsrOPUD usrOPUD = new CargadorUsrOPUD();
		cargUser.setIdUsuario(idUser);
		cargUser.crearUsuarioBase();
	}

	@Override
	public void calificarUsuario(String idCalificado, int nota) {
		ICalificacionCliente cl = new CalificacionCliente();
		cl.calificar(idCalificado, idUserActual, nota);
		
	}

	@Override
	public int verNota() {
		ICalificacionCliente cl = new CalificacionCliente();		
		return cl.verNota(idUserActual);
	}


}
