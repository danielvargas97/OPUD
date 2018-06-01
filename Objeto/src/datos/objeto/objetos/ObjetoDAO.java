package datos.objeto.objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import datos.conexion.implementacion.ConexionOracle;
import logica.objeto.objetos.Objeto;

public class ObjetoDAO {
	private Objeto o;
	
	public ObjetoDAO() {
		
	}
	
	public void registrarObjeto() {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO OBJETO VALUES (?,?,?,?,?)");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ps.setString(1, o.getIdObjeto());
			ps.setString(2, o.getNombre());
			ps.setString(3, String.valueOf(o.getIDCategoria()));
			ps.setString(4, o.getDescripcion());
			ps.setString(5, String.valueOf(o.getIDCondicion()));
			
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

	
	public Objeto cargarObjeto(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT IDOBJETO,NOMBRE,IDCATEGORIA,DESCRIPCION FROM OBJETO WHERE IDOBJETO=?");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			String nombre="";
			String idObjeto ="";
			String descripcion="";
			String estado="";		
			
			while(rs.next()) {
				idObjeto = rs.getString(1);
				nombre = rs.getString(2);				
				descripcion = rs.getString(4);
			}
			
			Objeto cargado = new Objeto(nombre, descripcion, estado);			
			cargado.setIDObjeto(idObjeto);			
			return cargado;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			myConn.soltarConexion();
		}				
	}
	
	public int cargarIdCategoria(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT IDCATEGORIA FROM OBJETO WHERE IDOBJETO=?");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			int idCat = 0;		
			
			while(rs.next()) {
				idCat = rs.getInt(1);				
			}
			
			return idCat;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return -1;
		}
		finally {
			myConn.soltarConexion();
		}			
	}
	public int cargarIdCondicion(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT IDCONDICION FROM OBJETO WHERE IDOBJETO=?");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			int idCond = 0;		
			
			while(rs.next()) {
				idCond = rs.getInt(1);				
			}
			
			return idCond;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return -1;
		}
		finally {
			myConn.soltarConexion();
		}		
	}

	public void setObjeto(Objeto o) {
		this.o = o;
	}	
	
}
