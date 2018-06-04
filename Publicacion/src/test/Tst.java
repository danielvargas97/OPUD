package test;

import logica.publicacion.fachada.PublicacionMaster;

public class Tst {

	public static void main(String[] args) {
		PublicacionMaster pm = new PublicacionMaster();
		pm.crearPublicacion(1);
		pm.registrarTitulo("Chaleco azul perdido");
		pm.registrarFechaPublicacion("02", "06", "2018");
		pm.registrarObjeto("Chaleco Azul", "Test pub", "Excelente", 4);

	}

}
