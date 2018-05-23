/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.conexion.implementacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author PC
 */
public class ConexionOracle{
    private static ConexionOracle conexOracle= null ;
    private Connection conexion = null;
    private boolean conexionDisponible = true;
    
    private String driver = "oracle.jdbc.OracleDriver";
    private String direccion = "jdbc:oracle:thin:@localhost:1521:XE";
    private String nombre = "OPUD";
    private String pass = "OPUD";
    
    public static ConexionOracle getInstance(){
        if(conexOracle == null){
            conexOracle = new ConexionOracle();
        }
        return conexOracle;
    }
    
    private ConexionOracle (){
        try{
            this.conectar();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    

    
    public void conectar() throws SQLException {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            //DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            conexion = DriverManager.getConnection(direccion,nombre,pass);            
        }
        catch(Exception e){
            throw new SQLException("Error en la conexion a la BD "+e);
        }
    }

    public void desconectar() {
        try{
            conexion.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public synchronized Connection tomarConexion() throws SQLException{
        while(!conexionDisponible){
            try{
                wait();
            }
            catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
        
        conexionDisponible = false;
        notify();
        return conexion;
    }
    
    public synchronized void soltarConexion(){
        while(conexionDisponible){
            try{
                wait();
            }
            catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
        conexionDisponible = true;
        notify();
    }
    
    
    public void realizarCommit() {
    	try {
    		conexion.commit();
    	}
    	catch(SQLException ex) {
    		ex.printStackTrace();
    	}
    }
    
    public void realizarRollback() {
    	try {
    		conexion.rollback();
    	}
    	catch(SQLException ex) {
    		ex.printStackTrace();
    	}
    	
    }
}
