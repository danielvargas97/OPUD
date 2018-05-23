/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.objeto.objetos;

import java.util.Random;

import apiObjeto.IObjeto;
import logica.objeto.condicionAbs.iCondicionable;

/**
 *
 * @author PC
 */
public class Objeto implements IObjeto{
    private String idObjeto;
    private String nombre;
    private String descripcion;
    private String estado;
    
    private Categoria categoria;
    private iCondicionable condicion;
    
    
    public Objeto(String nombre, String descripcion,String estado){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        
    }    

    public void asignarCategoria(Categoria cat){     
    	this.categoria = cat;
    }
    public void asignarCondicion(iCondicionable condicion) {
    	this.condicion = condicion;
    }
    
    private void generarID(){
        Random r = new Random(System.currentTimeMillis());
        Long id =r.nextLong();        
        this.idObjeto = Long.toString(id,10);
    }

    public String getIdObjeto() {
    	return this.idObjeto;
    }
    public String getNombre() {
    	return this.nombre;
    }
    public String getDescripcion() {
    	return this.descripcion;
    }
    public String getEstado() {
    	return this.estado;
    }
    
    public void asignarID() {
    	generarID();
    }
    
    public void setIDObjeto(String idObjeto) {
    	this.idObjeto = idObjeto;
    }
    
    public void setCategoria(Categoria cat) {
    	this.categoria = cat;
    }
    
    public void setCondicion(iCondicionable cond) {
    	this.condicion = cond;
    }
    
    public String getCategoria() {
    	String nombreCategoria = categoria.getNombre();
    	return nombreCategoria;
    }
    
    public int getIDCategoria() {
    	return categoria.getIdCategoria();
    }
    
    public int getIDCondicion() {
    	return condicion.getIdCondicion();
    }
    
    public String getCondicion() {
    	String nombreCondicion = condicion.verNombreCondicion();
    	return nombreCondicion;
    }
    
    
}
