package test;

import java.util.List;

import apiObjeto.IObjetoRegistro;
import logica.objeto.fachada.ObjetoMaster;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IObjetoRegistro obj = new ObjetoMaster();
		
		List<String> s = obj.verCategoria();
		
		for(String cat:s)
			System.out.println(cat);
	}

}
