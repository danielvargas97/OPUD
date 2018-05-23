/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.usuario.calificador;


/**
 *
 * @author PC
 */
public class Calificador implements iCalificable,ICotaNota {
    private String calificador;
    private String calificado;
    private int nota;

    public Calificador(){
        this.nota = 0;
    }
    public Calificador(String calificador,String calificado) {
    	this.calificado = calificado;
    	this.calificador = calificador;
    }
    
    @Override
    public boolean calificar(int nota){
       if(revisarNota(nota)){
           this.nota = nota;
           return true;
       }
       else{
           return false;
       } 

    }
    
    private boolean revisarNota(int nota){
        return (nota>=NOTA_MINIMA && nota<=NOTA_MAXIMA);
    }
	public String getCalificador() {
		return calificador;
	}
	public String getCalificado() {
		return calificado;
	}
	public int getNota() {
		return nota;
	}
    
    
    
    
}
