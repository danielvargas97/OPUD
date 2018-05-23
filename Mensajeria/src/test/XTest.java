package test;

import javax.swing.JOptionPane;

import apiMensajeria.IMensajeria;
import logica.usuario.fachadaMensajeria.MensajeMaster;

public class XTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = "1016099017";
		IMensajeria mens = new MensajeMaster(id);
		//mens.verMensajeSalida(0);
		JOptionPane.showMessageDialog(null,"Hola");
		
	}

}
