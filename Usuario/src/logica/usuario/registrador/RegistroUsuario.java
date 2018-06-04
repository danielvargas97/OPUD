package logica.usuario.registrador;

import datos.usuario.usuario.ContrasenaDAO;
import datos.usuario.usuario.UsuarioDAO;
import logica.usuario.contrasena.Contrasena;
import logica.usuario.contrasenaInterface.IContrasena;
import logica.usuario.usuario.Usuario;

public class RegistroUsuario implements IRegistroUsuario {
	private Usuario nuevo;
	private UsuarioDAO usrDao;
	private ContrasenaDAO passDao;

	public RegistroUsuario() {
		this.usrDao = new UsuarioDAO();
		this.passDao = new ContrasenaDAO();
	}
	
	@Override
	public boolean crearUsuario(String nombre, String apellido, String correo, String docIdentidad, String tipoDoc) {
		nuevo = new Usuario();
		nuevo.setNombre(nombre);
		nuevo.setApellido(apellido);
		nuevo.setDocIdentidad(docIdentidad);
		nuevo.setIdUser(docIdentidad);
		nuevo.setTipoDocumento(tipoDoc);
		nuevo.setCorreo(correo);
		return false;
	}
	
	@Override
	public void registrarUsuario() {
		usrDao.setUser(nuevo);		
		passDao.setPass((Contrasena)nuevo.getContrasena());
		
		usrDao.insertar();
		passDao.registrarPass(nuevo.getIdUser());
	}	

	@Override
	public void asignarContrasena(IContrasena contrasena) {		
		nuevo.setContrasena(contrasena);
	}

	@Override
	public Usuario getUsuario() {
		return nuevo;
	}
}
