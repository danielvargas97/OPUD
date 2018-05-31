/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.usuario.usuario;

import logica.usuario.contrasenaInterface.IContrasena;


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

    private IContrasena contrasena;
    
    public Usuario() {
    	
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

    public IContrasena getContrasena() {
        return contrasena;
    }

    public void setContrasena(IContrasena contrasena) {
        this.contrasena = contrasena;
    }
    
    public String getIdUser(){
    	return this.idUser;
    }

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
    
}
