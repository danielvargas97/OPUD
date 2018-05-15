/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.conexion.interfaz;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public interface ConexionDB {        
    public void conectar() throws SQLException;
    public void desconectar();
    public Connection tomarConexion();
    public void soltarConexion();
}
