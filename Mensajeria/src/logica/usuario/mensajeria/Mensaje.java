/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.usuario.mensajeria;

import java.util.Date;
import java.util.Random;

import apiMensajeria.IMensaje;


/**
 *
 * @author PC
 */
public class Mensaje implements IMensaje {
	private String idMensaje;
	private String origen;
    private String destino;
    private String asunto;
    private String mensaje;
    
    private int leido;
    private Date fecha;
    
    public Mensaje(){     
        this.leido = 0;
        generarID();
    }
    
    public Mensaje(String origen,String destino){
        this.origen = origen;
        this.destino = destino;
        this.fecha = new Date();
        this.leido = 0;
        generarID();
    }

    private void generarID() {
    	Random r = new Random(System.currentTimeMillis());
    	String id = "";
    	
    	for(int i=0;i<7;i++) {
    		id = id +(char)(65+r.nextInt(26));
    	}
    	for(int i=0;i<8;i++) {
    		id = id +(char)(48+r.nextInt(10));
    	}
    	
    	
    	
    	this.idMensaje = id;
    	
    }
    
    
    public String getIdMensaje() {
    	return idMensaje;
    }
    
    public void setIdMensaje (String idMensaje) {
    	this.idMensaje = idMensaje;
    }
    
	@Override
	public String getFechaEnvio() {
		// TODO Auto-generated method stub
		
		return this.fecha.toString();
	}

	@Override
	public String getContenido() {
		// TODO Auto-generated method stub
		return getMensaje();
	}
    
    
    public String getOrigen() {
        return this.origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getLeido() {
        return leido;
    }

    public void setLeido(int leido) {
        this.leido = leido;
    }    
    
}
