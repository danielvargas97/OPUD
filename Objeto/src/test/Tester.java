package test;

import java.util.List;

import apiObjeto.IObjeto;
import datos.objeto.objetos.ObjetoDAO;
import logica.objeto.fachada.ObjetoMaster;

public class Tester {

	public static void main(String[] args) {		
		ObjetoMaster obj = new ObjetoMaster();
		ObjetoDAO objDao = new ObjetoDAO();
		List<String> s = obj.verCategoria();
		int k=1;
		for(String cat:s) {
			System.out.println(k+" "+cat);
			k++;
		}
		//obj.registrarOH("Multimetro XY", "Multimetro regular", "Nuevo", 5); //Funcionando :v
		
		IObjeto o = obj.cargarObjeto("H-ARTBVVULGK58587264");
		
		System.out.println("ID: "+o.getIdObjeto());
		System.out.println("Nombre: "+o.getNombre());
		System.out.println("Descripcion: "+o.getDescripcion());
		System.out.println("Categoria: "+o.getCategoria());
		System.out.println("Condicion: "+o.getCondicion());				
		
	}

}
