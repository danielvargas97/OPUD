package datos.publicacion.publicaciones;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import apiPublicacion.IPublicacion;
import datos.conexion.implementacion.ConexionOracle;
import logica.publicacion.publicaciones.Publicador;

public class PublicacionDAO {
	private Publicador publicacion;
	private String idUsuario;
	private String idObjeto;
	
	public PublicacionDAO() {		
	}
	
	
	public void insertarPublicacion() {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO PUBLICACION VALUES (?,?,?,?,?,?,?,?)");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ps.setString(1, publicacion.getIdPublicacion());
			ps.setString(2, idUsuario);
			ps.setString(3, idObjeto);
			ps.setString(4, publicacion.getNombre());
			ps.setDate(5, (Date)publicacion.generarFechaPub());
			ps.setDate(6, (Date)publicacion.generarFechaCond());
			ps.setInt(7, publicacion.getTipoPublicacion());
			ps.setInt(8, publicacion.getActivo());
			
			myConn.realizarCommit();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			myConn.soltarConexion();
		}
	}
	
	public IPublicacion cargarPublicacion(String idUsuario,String idPublicacion) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT IDPUBLICACION,TITULO,FECHAPUBLICACION,FECHACONDICION,TIPOPUBLICACION,ACTIVO ");
		sql.append("FROM PUBLICACION WHERE IDUSUARIO=? AND IDPUBLICACION=?");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ps.setString(1, idUsuario);
			ps.setString(2, idPublicacion);
			
			ResultSet rs = ps.executeQuery();
			
			Publicador p = new Publicador();
			
			while(rs.next()) {
				p.setIdPublicacion(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setFechaPublicacion(rs.getDate(3));
				p.setFechaCondicion(rs.getDate(4));
				p.setTipoPublicacion(rs.getInt(5));
				p.setActivo(rs.getInt(6));
			}			
			IPublicacion cargada = p;
			
			return cargada;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			myConn.soltarConexion();
		}		
	}
	
	public ArrayList<IPublicacion> cargarPublicaciones(String idUsuario, int tipo){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT IDPUBLICACION,TITULO,FECHAPUBLICACION,FECHACONDICION,TIPOPUBLICACION,ACTIVO ");
		sql.append("FROM PUBLICACION WHERE IDUSUARIO=? AND TIPOPUBLICACION=?");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ps.setString(1, idUsuario);
			ps.setInt(2, tipo);
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<IPublicacion> publicaciones = new ArrayList<IPublicacion>();
			
			while(rs.next()) {
				Publicador p = new Publicador();
				p.setIdPublicacion(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setFechaPublicacion(rs.getDate(3));
				p.setFechaCondicion(rs.getDate(4));
				p.setTipoPublicacion(rs.getInt(5));
				p.setActivo(rs.getInt(6));
				IPublicacion cargada = p;
				publicaciones.add(cargada);
			}			
			
			
			return publicaciones;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			myConn.soltarConexion();
		}
	}
	
	public void setPublicacion(Publicador publicacion) {
		this.publicacion = publicacion;
	}
	
	public List<String> verCategorias(){
		
		return null;
	}
}
