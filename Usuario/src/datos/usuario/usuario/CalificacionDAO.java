package datos.usuario.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import datos.conexion.implementacion.ConexionOracle;
import datos.conexion.interfaz.ConexionDB;

public class CalificacionDAO {
	
	
	public CalificacionDAO() {
		
	}
	
	public void insertarCalificacion() throws SQLException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO CALIFICACION ");
			sql.append("(idCalificador,idCalificado,nota) ");
			sql.append("values (?,?,?)");
			Connection db = ConexionOracle.getInstance().tomarConexion();
			PreparedStatement ps = db.prepareStatement(sql.toString());
			ps.setString(1, "");
			ps.setString(2, "");
			ps.setInt(3, 0);
			ps.executeUpdate();
			ps.close();
			ConexionOracle.getInstance().realizarCommit();
		}
		catch(SQLException ex) {
			throw new SQLException("Error en la insercion de calificacion");
		}
		finally {
			ConexionOracle.getInstance().soltarConexion();
		}
	}
	
	public void verCalificacion() {
		
	}
	
}
