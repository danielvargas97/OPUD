/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.usuario.usuario;


import apiUsuario.IUsuario;
import logica.usuario.calificacion.iCalificacion;
import logica.usuario.calificador.iCalificable;

/**
 *
 * @author PC
 */
public class UsuarioOPUD implements IUsuario {
    private Usuario usuario;
    private String rolUniversidad;
    private String codigo;
    private iCalificable calificador;
    private iCalificacion calificacion; 
            
    public UsuarioOPUD() {
    	
    }
    
    
    public UsuarioOPUD(Usuario usuario) {
    	this.usuario = usuario;
    }
    
    
    public UsuarioOPUD(Usuario usuario,iCalificacion calificacion){
    	this.calificacion = calificacion;
    	this.calificacion.asignarCalificado(usuario.getIdUser());
        this.usuario = usuario;
    }
    
    public void calificarUsuario(int nota) {
    	calificador.calificar(nota);
    }
    
    public int verMiCalificacion() {
    	return calificacion.verCalificacion();
    }
    
    public String getRolUniversidad() {
        return rolUniversidad;
    }

    public void setRolUniversidad(String rolUniversidad) {
        this.rolUniversidad = rolUniversidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public void setCalificador(iCalificable calificador) {
		this.calificador = calificador;
	}
    
    public void asignarCalificador(iCalificable calificador, String calificante, String calificado) {
    	this.calificador = calificador;
    }

	public Usuario getUsuario() {
		return usuario;
	}


	public void setCalificacion(iCalificacion calificacion) {
		this.calificacion = calificacion;
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
		return rolUniversidad;
	}

	@Override
	public String getTipoDocumento() {
		return usuario.getTipoDocumento();
	}


    
}
