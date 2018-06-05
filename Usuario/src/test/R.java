package test;


import apiUsuario.IUsuario;
import apiUsuario.IUsuarioAdmin;
import logica.usuario.fachadaUser.RegistroUsr;


public class R {

	public static void main(String[] args) {
		IUsuarioAdmin usr = new RegistroUsr();
		
		
		/*
		usr.asignarDatosUsuario("Dino", "Zoff", "dzoff@example.com", "79256255","CC");
		usr.asignarContrasena("dxdydz");
		usr.registrarUsuario();
	
		usr.registrarAdmin("End");
		*/
		//IUsuario u = usr.cargarAdmin("79256255");
		/*
		System.out.println(u.getIdUser());
		System.out.println(u.getNombre());		
		System.out.println(u.getApellido());
		System.out.println(u.getCorreo());
		System.out.println(u.getRol());
		System.out.println(u.getCodigo());
		*/		
	}

}
