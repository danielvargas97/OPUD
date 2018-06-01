package datos.objeto.objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datos.conexion.implementacion.ConexionOracle;

public class CondicionDAO {
	
	public CondicionDAO() {

	}
	
	public String cargarIDCondicion(String idObjeto) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT IDCONDICION FROM OBJETO WHERE IDOBJETO=?");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ps.setString(1, idObjeto);
			ResultSet rs = ps.executeQuery();
			
			String idCondicion="";
			
			while(rs.next()) {
				idCondicion = rs.getString(1);				
			}
			
			return idCondicion;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			myConn.soltarConexion();
		}		
		
	}
	
}
