package datos.usuario.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datos.conexion.implementacion.ConexionOracle;
import logica.usuario.calificacion.Calificacion;
import logica.usuario.calificador.Calificador;

public class CalificacionDAO {
	private Calificador calificador;
	
	public CalificacionDAO() {
		
	}
	
	public void insertarCalificacion(){
		StringBuilder sql = new StringBuilder();
		ConexionOracle myConn = ConexionOracle.getInstance();
		
		sql.append("INSERT INTO CALIFICACION ");
		sql.append("VALUES (?,?,?)");
		
		try {		
			Connection db = myConn.tomarConexion();
			PreparedStatement ps = db.prepareStatement(sql.toString());
			ps.setString(1, calificador.getCalificador());
			ps.setString(2, calificador.getCalificado());
			ps.setInt(3, calificador.getNota());
			ps.executeUpdate();
			ps.close();
			myConn.realizarCommit();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			myConn.soltarConexion();
		}
	}
	
	public Calificacion verCalificacion(String id) {
		StringBuilder sql = new StringBuilder();
		ConexionOracle myConn = ConexionOracle.getInstance();
		
		sql.append("SELECT AVG(NOTA) FROM CALIFICACION ");
		sql.append("WHERE IDCALIFICADO=?");
		
		try {		
			Connection db = myConn.tomarConexion();
			PreparedStatement ps = db.prepareStatement(sql.toString());
			ps.setString(1, id);
			Calificacion calificacion = new Calificacion();
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				calificacion.setNota(rs.getInt(1));
			}			
			return calificacion;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			myConn.soltarConexion();
		}
	}

	public Calificador getCalificador() {
		return calificador;
	}

	public void setCalificador(Calificador calificador) {
		this.calificador = calificador;
	}
	
}
