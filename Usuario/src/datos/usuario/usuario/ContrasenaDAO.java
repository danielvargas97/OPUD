package datos.usuario.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import datos.conexion.implementacion.ConexionOracle;
import logica.usuario.contrasena.Contrasena;

public class ContrasenaDAO {
	private Contrasena pass;
	
	public ContrasenaDAO() {
		
	}
	
	
	public void registrarPass(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO CONTRASENA VALUES (?,?)");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conex = myConn.tomarConexion();
			PreparedStatement ps = conex.prepareCall(sql.toString());
			
			ps.setString(1, id);
			ps.setString(2, pass.getContrasena());
			
			ps.executeUpdate();
			ps.close();
			
			myConn.realizarCommit();
			
		}
		catch(Exception ex) {
			
		}
		finally {
			myConn.soltarConexion();
		}
		
		
	}
	
	public Contrasena cargarContrasena(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM CONTRASENA WHERE IDUSUARIO=?");
		ConexionOracle myConn = ConexionOracle.getInstance();
		Contrasena newPass;		
		
		try {
			Connection conex = myConn.tomarConexion();
			PreparedStatement ps = conex.prepareCall(sql.toString());			
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			String clave="";
			while(rs.next()) {
				clave = rs.getString(2);
								
			}
			newPass = new Contrasena(clave);
			return newPass;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			myConn.soltarConexion();
		}
	}
	
	public void actualizarContrasena(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE CONTRASENA SET CONTRASENA=? WHERE IDUSUARIO=?");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conex = myConn.tomarConexion();
			PreparedStatement ps = conex.prepareCall(sql.toString());
			
			ps.setString(1, id);
			ps.setString(2, pass.getContrasena());
			
			ps.executeUpdate();
			ps.close();
			
			myConn.realizarCommit();
			
		}
		catch(Exception ex) {
			
		}
		finally {
			myConn.soltarConexion();
		}
		
				
	}
	


	public Contrasena getPass() {
		return pass;
	}


	public void setPass(Contrasena pass) {
		this.pass = pass;
	} 
}
