package datos.usuario.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datos.conexion.implementacion.ConexionOracle;
import logica.usuario.usuario.Administrador;

public class AdministradorDAO {
	private Administrador admin;
	
	public AdministradorDAO() {
		
	}
	
	
	public void insertar() {
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO ADMINISTRADOR VALUES (?,?)");
		
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			
			ps.setString(1, admin.getNickname());
			ps.setString(2, admin.getUsuario().getIdUser());
			
			ps.executeUpdate();
			ps.close();
			myConn.realizarCommit();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			myConn.soltarConexion();
		}
	}
	
	
	
	public Administrador cargarUsuario(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM ADMINISTRADOR WHERE IDUSUARIO=?");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			Administrador unUsuario = new Administrador();
			while(rs.next()) {
				unUsuario.setNickname(rs.getString(1));				
			}
			
			return unUsuario;			
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			myConn.soltarConexion();
		}
		
	}


	public Administrador getAdmin() {
		return admin;
	}


	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}

	
}
