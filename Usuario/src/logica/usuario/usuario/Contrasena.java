/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.usuario.usuario;

/**
 *
 * @author PC
 */
public class Contrasena {
    private String contrasena;
    
    public Contrasena(String contrasena){
        this.contrasena = contrasena;
    }
    
    public boolean verificarContrasena(String posibleContrasena){
        return contrasena.compareTo(posibleContrasena)==0;
    }
    
    
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
    
}
