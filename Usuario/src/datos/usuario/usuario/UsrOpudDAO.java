package datos.usuario.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datos.conexion.implementacion.ConexionOracle;
import logica.usuario.usuario.UsuarioOPUD;


public class UsrOpudDAO {
	private UsuarioOPUD usrOPUD;
	
	public UsrOpudDAO() {
		
	}
	
	public void insertar() {
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO USUARIOOPUD VALUES (?,?,?)");
		
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			
			ps.setString(1, usrOPUD.getRolUniversidad());
			ps.setString(2, usrOPUD.getCodigo());
			ps.setString(3, usrOPUD.getUsuario().getIdUser());
			
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
	
	
	
	public UsuarioOPUD cargarUsuario(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM USUARIOOPUD WHERE IDUSUARIO=?");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			UsuarioOPUD unUsuario = new UsuarioOPUD();
			while(rs.next()) {
				unUsuario.setRolUniversidad(rs.getString(1));
				unUsuario.setCodigo(rs.getString(2));
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
	
}
