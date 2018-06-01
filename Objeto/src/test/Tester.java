package test;

import java.util.List;

import logica.objeto.fachada.ObjetoMaster;

public class Tester {

	public static void main(String[] args) {		
		ObjetoMaster obj = new ObjetoMaster();
		
		List<String> s = obj.verCategoria();
		int k=1;
		for(String cat:s) {
			System.out.println(k+" "+cat);
			k++;
		}
		//obj.registrarOP("Chaleco azul", "Es un chaleco azul, cualquiera", "Excelente", 6); Funcionando :v
		
	}

}
