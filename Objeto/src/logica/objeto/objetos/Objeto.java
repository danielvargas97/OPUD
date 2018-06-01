/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.objeto.objetos;

import apiObjeto.IObjeto;
import logica.objeto.condicion.ICondicionable;

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
    private ICondicionable condicion;
    
    
    public Objeto(String nombre, String descripcion,String estado){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        
    }    

	public void asignarCategoria(Categoria cat){     
    	this.categoria = cat;
    }
    public void asignarCondicion(ICondicionable condicion) {
    	this.condicion = condicion;
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
    public void setIDObjeto(String idObjeto) {
    	this.idObjeto = idObjeto;
    }
    
    public void setCategoria(Categoria cat) {
    	this.categoria = cat;
    }
    
    public void setCondicion(ICondicionable cond) {
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
