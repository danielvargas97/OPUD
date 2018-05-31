package test;

import apiUsuario.ILogin;
import logica.usuario.fachadaUser.UsuarioLogin;

public class R {

	public static void main(String[] args) {
		ILogin log = new UsuarioLogin();
		
		if(log.iniciarSesion("1016099017", "coconut", 1)) {
			System.out.println(":v");
		}
		else {
			System.out.println(">>:v");
		}

	}

}
