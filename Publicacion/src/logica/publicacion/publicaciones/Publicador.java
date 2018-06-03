package logica.publicacion.publicaciones;

import java.util.Date;
import java.util.Random;

import apiPublicacion.IPublicacion;

/**
 *
 * @author PC
 */
public abstract class Publicador implements IPublicacion{
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
        
    public abstract void generarId();
    
	protected String generarIdBody() {
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
