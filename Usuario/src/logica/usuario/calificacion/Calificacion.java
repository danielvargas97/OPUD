/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.usuario.calificacion;

/**
 *
 * @author PC
 */
public class Calificacion implements iCalificacion{
    private int nota;
    private String idUsuario;
    
    public Calificacion(){
    }
    
    @Override
    public void asignarCalificado(String idUser) {
        this.idUsuario = idUser;
    }

    @Override
    public int verCalificacion() {
        return nota;
    }
    
}
