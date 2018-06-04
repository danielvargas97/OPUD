package com.cableado;

import apiObjeto.IObjetoRegistro;
import apiPublicacion.IPublicacionAdmin;
import apiUsuario.IUsuario;
import logica.objeto.fachada.ObjetoMaster;
import logica.publicacion.fachada.PublicacionMaster;

public class OpudMaster {
	public static void main(String args[]) {
		IPublicacionAdmin r = new PublicacionMaster();
		IObjetoRegistro obj = new ObjetoMaster();
		
		
		
	}
	
	
}
