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
public class Administrador {
    private Usuario usuario;
    private String nickname;
    
    
    public Administrador() {
    	
    }
    
    public Administrador(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getNickname() {
    	return nickname;
    }
    public void setNickname(String nickname) {
    	this.nickname = nickname;
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
        
}
