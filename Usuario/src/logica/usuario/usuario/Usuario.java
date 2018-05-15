/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.usuario.usuario;

import java.util.List;


/**
 *
 * @author PC
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private String docIdentidad;
    private String correo;
    private String idUser;
    private String tipoDocumento;

    //private iMensaje mensajeria;
    //private i
    private Contrasena contrasena;
 
    
    public Usuario() {
    	
    }
    
    /*
    public Usuario(iMensaje mensajeria){
        this.mensajeria = mensajeria;
    }
    
    public Usuario(iMensaje mensajeria,Contrasena contrasena) {
    	this.mensajeria = mensajeria;
    	this.contrasena = contrasena;
    }
    
    
    public List<String> verMensaje(int index) {
    	return mensajeria.verMensaje(index);
    }
    
    public void redactarMensaje(String destino,String asunto,String mensaje) {
    	mensajeria.redactar(idUser, destino, asunto, mensaje);
    	
    }
     */
    
    public void asignarContrasena(String nuevaContrasena){
        try{
            contrasena.setContrasena(nuevaContrasena);
        }
        catch(NullPointerException e){
            e.printStackTrace();
            contrasena = new Contrasena(nuevaContrasena);
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocIdentidad() {
        return docIdentidad;
    }

    public void setDocIdentidad(String docIdentidad) {
        this.docIdentidad = docIdentidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Contrasena getContrasena() {
        return contrasena;
    }

    public void setContrasena(Contrasena contrasena) {
        this.contrasena = contrasena;
    }
    
    public String getIdUser(){
    	return this.idUser;
    }
    
}
