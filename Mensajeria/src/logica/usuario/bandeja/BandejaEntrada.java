/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.usuario.bandeja;

import java.util.ArrayList;
import java.util.List;

import logica.usuario.bandejaInterface.IBandejaEntrada;
import logica.usuario.mensajeriaAPI.IMensaje;

/**
 *
 * @author PC
 */
public class BandejaEntrada implements IBandejaEntrada {
    private String idBandeja;
    private ArrayList<IMensaje> buzonEntrada;
    private ArrayList<IMensaje> buzonSalida;
    
    
    public BandejaEntrada(){
        this.buzonEntrada = new ArrayList<>(); 
        this.buzonSalida = new ArrayList<>();
    }
    
    public BandejaEntrada(String id) {
    	this.buzonEntrada = new ArrayList<>(); 
        this.buzonSalida = new ArrayList<>();
        this.idBandeja = id;
    }
    
    public String getIdBandeja() {
        return idBandeja;
    }

    public ArrayList<IMensaje> getBuzonEntrada() {
    	
        return buzonEntrada;
    }

    public ArrayList<IMensaje> getBuzonSalida() {
        return buzonSalida;
    }

	@Override
	public void setBandejaID(String id) {
		this.idBandeja = id;
	}

	@Override
	public List<IMensaje> verMensajesEntrantes() {
		// TODO Auto-generated method stub
		return this.getBuzonEntrada();
	}

	@Override
	public List<IMensaje> verMensajesEnviados() {
		// TODO Auto-generated method stub
		return this.getBuzonSalida();
	}

	@Override
	public void enviarMensaje(IMensaje mensaje) {
		buzonSalida.add(0, mensaje);
		//
	}

	@Override
	public void eliminarMensajeEntrante(int index) {
		buzonEntrada.remove(index);
	}

	@Override
	public IMensaje verMensajeEntrante(int index) {
		// TODO Auto-generated method stub
		return this.getBuzonEntrada().get(index);
	}

	@Override
	public IMensaje verMensajeSalida(int index) {
		
		return this.getBuzonSalida().get(index);
	}    
    
}

