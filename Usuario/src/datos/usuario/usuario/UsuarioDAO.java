package datos.usuario.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datos.conexion.implementacion.ConexionOracle;
import logica.usuario.usuario.Usuario;

public class UsuarioDAO {
	private Usuario user;
	public UsuarioDAO() {
		
	}
	
	
	public void insertar() {
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO USUARIO VALUES (?,?,?,?,?,?)");
		
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			
			ps.setString(1, user.getIdUser());
			ps.setString(2, user.getNombre());
			ps.setString(3, user.getApellido());
			ps.setString(4, user.getDocIdentidad());
			ps.setString(5, user.getTipoDocumento());
			ps.setString(6, user.getCorreo());
			
			
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
	
	public Usuario cargarUsuario(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM USUARIO WHERE IDUSUARIO=?");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			Usuario unUsuario = new Usuario();
			while(rs.next()) {
				unUsuario.setIdUser(rs.getString(1));
				unUsuario.setNombre(rs.getString(2));
				unUsuario.setApellido(rs.getString(3));
				unUsuario.setDocIdentidad(rs.getString(4));
				unUsuario.setTipoDocumento(rs.getString(5));
				unUsuario.setCorreo(rs.getString(6));
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
	
	
	
	public boolean login(String docIdentidad,String pass, int tipo) {
		StringBuilder sql = new StringBuilder();
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
			myConn.soltarConexion();
		}
	}


	public Usuario getUser() {
		return user;
	}


	public void setUser(Usuario user) {
		this.user = user;
	}
	
}
