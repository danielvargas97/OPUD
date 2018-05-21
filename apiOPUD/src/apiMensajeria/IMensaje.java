/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiMensajeria;

/**
 *
 * @author PC
 */
public interface IMensaje {
	public String getIdMensaje();
    public String getOrigen();
    public String getDestino();
    public String getFechaEnvio();
    public String getAsunto();
    public String getContenido();
    
}
