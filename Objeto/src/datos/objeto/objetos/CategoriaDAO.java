package datos.objeto.objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.conexion.implementacion.ConexionOracle;
import logica.objeto.objetos.Categoria;

public class CategoriaDAO {
	
	public CategoriaDAO() {
		
	}
	
	
	public Categoria cargarCategoria(String idCat) {
		StringBuilder sql = new StringBuilder();
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
	
	public List<String> cargarCategoria(){
		StringBuilder sql = new StringBuilder();
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
	
	
}
