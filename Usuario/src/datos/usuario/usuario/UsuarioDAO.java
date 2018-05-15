package datos.usuario.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datos.conexion.implementacion.ConexionOracle;

public class UsuarioDAO {
	private StringBuilder sql;
	
	public UsuarioDAO() {
		
	}
	
	
	public void insertar() {
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			
		}
	}
	
	public boolean login(String docIdentidad,String pass, int tipo) {
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			sql.append("SELECT DOCIDENTIDAD,CONTRASENA FROM USUARIO,CONTRASENA WHERE USUARIO.DOCIDENTIDAD=? AND CONTRASENA.CONTRASENA=? ");
			sql.append("AND USUARIO.IDUSUARIO=CONTRASENA.IDUSUARIO");
			
			String docBD="";
			String passBD="";
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ps.setString(1, docIdentidad);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				docBD = rs.getString(1);
				passBD = rs.getString(2);
			}		
			
			if(docBD.compareTo(docIdentidad)==0 && passBD.compareTo(pass)==0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		finally {
			
		}
	}
	
	public void actualizarContrasena(String newPass) {
		
	}
	
	//public void
	
}
