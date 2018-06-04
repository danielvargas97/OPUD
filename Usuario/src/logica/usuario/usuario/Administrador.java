/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.usuario.usuario;

import apiUsuario.IUsuario;

/**
 *
 * @author PC
 */
public class Administrador implements IUsuario {
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
	
	@Override
	public String getNombre() {
		return usuario.getNombre();
	}


	@Override
	public String getApellido() {
		return usuario.getApellido();
	}


	@Override
	public String getDocIdentidad() {

		return usuario.getDocIdentidad();
	}


	@Override
	public String getCorreo() {
		return usuario.getCorreo();
	}


	@Override
	public String getIdUser() {
		return usuario.getIdUser();
	}


	@Override
	public String getRol() {
		return "Administrador";
	}

	@Override
	public String getTipoDocumento() {
		return usuario.getTipoDocumento();
	}

	@Override
	public String getCodigo() {
		return usuario.getDocIdentidad();
	}

}
