/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.publicacion.publicaciones;

import java.util.Date;
import java.util.Random;

import apiPublicacion.IPublicacion;

/**
 *
 * @author PC
 */
public class Publicador implements IPublicacion{
    protected String nombre;
    protected String idPublicacion;
    protected Date fechaPublicacion;
    protected Date fechaCondicion;
    protected int tipoPublicacion;
    protected int activo;
    
    public Publicador(){
    	
    }   
    
    public Publicador(int tipo) {
    	this.tipoPublicacion = tipo;
    }
    
    
    protected void generarIdBase() {
    	/*Random r = new Random(System.currentTimeMillis());
    	 r.
    	r.nextInt(5);*/
    	
    }
    
    public Date generarFechaPub() {
    	return fechaPublicacion;
    }
    public Date generarFechaCond() {
    	return fechaCondicion;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(String idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public int getTipoPublicacion() {
        return tipoPublicacion;
    }
    
    public void setTipoPublicacion(int tipo) {
        this.tipoPublicacion = tipo;
    }
    
    
    public int getActivo() {
        return activo;
    }
    
    public void setActivo(int activo) {
    	this.activo = activo;
    }
    
    
    public String getFechaCondicion() {    	
    	return FechaString.getFechaString(fechaCondicion);
    }
    
    public void setFechaCondicion(Date fecha) {
    	this.fechaCondicion = fecha;
    }
    
    public String getFechaPublicacion() {
    	return FechaString.getFechaString(fechaPublicacion);
    }
    
    public void setFechaPublicacion(Date fecha) {
    	this.fechaPublicacion = fecha;
    }
}
