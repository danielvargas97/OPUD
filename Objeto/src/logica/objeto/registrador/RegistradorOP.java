package logica.objeto.registrador;

import java.util.Random;

import logica.objeto.fabricaCondicion.FabricaPerdido;

public class RegistradorOP extends RegistradorObjeto {

	public RegistradorOP() {
		super();
		this.fabricaCond = new FabricaPerdido();
	}
	@Override
	public void asignarCondicion() {
		objeto.setCondicion(fabricaCond.crearCondicion());		
	}
	@Override
	public void generarIdObjeto() {
		String id = generarIDHeader()+generarIDBody();
		lastID = id;
		objeto.setIDObjeto(id);
	}
	
	
	private String generarIDHeader() {
		String header = "P-";
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
		// Parte de ID con numeros
		for(int i=0;i<8;i++) {
			char x = (char)(48+r.nextInt(10));
			body = body+x;
		}		
		
		return body;
	}
	
	
}
