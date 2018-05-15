/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.conexion.implementacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import datos.conexion.interfaz.ConexionDB;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author PC
 */
public class ConexionOracle implements ConexionDB {
    private static ConexionOracle conexOracle;
    private Connection conexion;
    private String driver = "oracle.jdbc.OracleDriver";
    private String direccion = "jdbc:oracle:thin:@//localhost:1521/xe";
    private String nombre = "opud";
    private String pass = "opud";
    private boolean conexionDisponible;
    
    private ConexionOracle (){
        try{
            this.conectar();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static ConexionOracle getInstance(){
        if(conexOracle==null){
            conexOracle = new ConexionOracle();
        }
        return conexOracle;
    }
    
    @Override
    public void conectar() throws SQLException {
        try{
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            conexion = DriverManager.getConnection(direccion,nombre,pass);
        }
        catch(SQLException e){
            throw new SQLException("Error en la conexion a la BD");
        }
    }

    @Override
    public void desconectar() {
        try{
            conexion.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    private synchronized Connection tomarConn(){
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
    
    private synchronized void soltarConn(){
        while(!conexionDisponible){
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
    
    
    @Override
    public Connection tomarConexion() {
        return tomarConn();
    }

    @Override
    public void soltarConexion() {
        soltarConn();
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
