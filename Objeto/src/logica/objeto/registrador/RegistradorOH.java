package logica.objeto.registrador;

import java.util.Random;

import logica.objeto.fabricaCondicion.FabricaHallado;
import logica.objeto.objetos.Objeto;

public class RegistradorOH extends RegistradorObjeto {

	public RegistradorOH() {
		super();
		this.fabricaCond = new FabricaHallado();
	}

	@Override
	public void asignarCondicion() {
		objeto.setCondicion(fabricaCond.crearCondicion());
	}

	@Override
	public void generarIdObjeto() {
		String id = generarIDHeader()+generarIDBody();
		
		objeto.setIDObjeto(id);
	}
	
	
	private String generarIDHeader() {
		String header = "H-";
		return header;
	}
	
	private String generarIDBody() {
		Random r = new Random(System.currentTimeMillis());
		String body = "";
		
		//Parte de ID con letras;
		
		for(int i=0;i<10;i++) {
			char x = (char)(65+r.nextInt(26));
			body = body+x;
		}
		
		for(int i=0;i<8;i++) {
			char x = (char)(48+r.nextInt(10));
			body = body+x;
		}		
		
		return body;
	}

}
