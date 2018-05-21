package datos.objeto.objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.conexion.implementacion.ConexionOracle;
import logica.objeto.objetos.Categoria;
import logica.objeto.objetos.Objeto;

public class ObjetoDAO {
	private Objeto o;
	private StringBuilder sql = new StringBuilder();
	public ObjetoDAO() {
		
	}
	
	public void registrarObjeto() {	
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
	
	public List<String> cargarCategoria(){
		sql.append("SELECT NOMBRE FROM CATEGORIA");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ResultSet rs = ps.executeQuery();
			List<String> categorias = new ArrayList<String>();
			while(rs.next()) {
				categorias.add(rs.getString(1));				
			}			
			return categorias;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			myConn.soltarConexion();
		}
	}
	
	public Objeto cargarObjeto(String id) {
		sql.append("SELECT IDOBJETO,NOMBRE,IDCATEGORIA,DESCRIPCION FROM OBJETO WHERE IDOBJETO=?");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ResultSet rs = ps.executeQuery();
			
			String nombre="";
			String idObjeto ="";
			String idCategoria="";
			String descripcion="";
			String estado="";		
			
			while(rs.next()) {
				idObjeto = rs.getString(1);
				nombre = rs.getString(2);
				idCategoria = rs.getString(3);
				descripcion = rs.getString(4);
			}
			
			Objeto cargado = new Objeto(nombre, descripcion, estado);			
			cargado.setIDObjeto(idObjeto);
			cargado.asignarCategoria(cargarCategoria(idCategoria));
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
	
	public String cargarIDCondicion(String idObjeto) {
		sql.append("SELECT IDCONDICION FROM OBJETO WHERE IDOBJETO=?");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
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
	
	
	private Categoria cargarCategoria(String idCat) {
		sql.append("SELECT IDCATEGORIA,NOMBRE,DESCRIPCION FROM CATEGORIA WHERE IDCATEGORIA=?");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ResultSet rs = ps.executeQuery();
			ps.setString(1, idCat);			
			Categoria cat = new Categoria();
			while(rs.next()) {				
				cat.setIdCategoria(Integer.parseInt(rs.getString(1)));
				cat.setNombre(rs.getString(2));
				cat.setDescripcion(rs.getString(3));
			}			
			return cat;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			myConn.soltarConexion();
		}		
		
		
	}
	
	
	
	public void setObjeto(Objeto o) {
		this.o = o;
	}	
	
}
