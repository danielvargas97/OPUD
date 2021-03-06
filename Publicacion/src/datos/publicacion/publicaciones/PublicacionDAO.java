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
import logica.publicacion.fabricaPublicaciones.FabricaPublicador;
import logica.publicacion.publicaciones.Publicador;

public class PublicacionDAO {
	private Publicador publicacion;
	private String idUsuario;
	private String idObjeto;
	private FabricaPublicador fabrica;
	
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
			
			long fechaPub = publicacion.generarFechaPub().getTime();
			long fechaCond = publicacion.generarFechaCond().getTime();
			
			ps.setDate(5, new java.sql.Date(fechaPub));
			ps.setDate(6, new java.sql.Date(fechaCond));
			ps.setInt(7, publicacion.getTipoPublicacion());
			ps.setInt(8, publicacion.getActivo());
			
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
	
	public IPublicacion cargarPublicacion(String idUsuario,String idPublicacion,int tipo) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT IDPUBLICACION,TITULO,FECHAPUBLICACION,FECHACONDICION,TIPOPUBLICACION,ACTIVO ");
		sql.append("FROM PUBLICACION WHERE IDUSUARIO=? AND IDPUBLICACION=? AND TIPOPUBLICACION=?");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ps.setString(1, idUsuario);
			ps.setString(2, idPublicacion);
			ps.setInt(3, tipo);
			
			ResultSet rs = ps.executeQuery();
			
			Publicador p = fabrica.crearPublicador();
			
			while(rs.next()) {
				p.setIdPublicacion(rs.getString(1));
				p.setNombre(rs.getString(2));
				long fechaPub = rs.getDate(3).getTime();
				long fechaCond = rs.getDate(3).getTime();
				p.setFechaPublicacion(new java.util.Date(fechaPub));
				p.setFechaCondicion(new java.util.Date(fechaCond));
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
				Publicador p = fabrica.crearPublicador();
				p.setIdPublicacion(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setFechaPublicacion(rs.getDate(3));
				p.setFechaCondicion(rs.getDate(4));				
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
	
	
	public ArrayList<IPublicacion> cargarPublicaciones(String idUsuario, int tipo,String fechaInicio,String fechaFin){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT IDPUBLICACION,TITULO,FECHAPUBLICACION,FECHACONDICION,TIPOPUBLICACION,ACTIVO ");
		sql.append("FROM PUBLICACION WHERE IDUSUARIO=? AND TIPOPUBLICACION=? AND ");
		sql.append("FECHAPUBLICACION BETWEEN TO_DATE(?,'YYYY-MM-DD') AND TO_DATE(?,'YYYY-MM-DD') ");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ps.setString(1, idUsuario);
			ps.setInt(2, tipo);
			ps.setString(3,fechaInicio);
			ps.setString(4,fechaFin);
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<IPublicacion> publicaciones = new ArrayList<IPublicacion>();
			
			while(rs.next()) {
				Publicador p = fabrica.crearPublicador();
				p.setIdPublicacion(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setFechaPublicacion(rs.getDate(3));
				p.setFechaCondicion(rs.getDate(4));				
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
	
	public ArrayList<IPublicacion> buscarPublicacion(String texto, int tipo){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT IDPUBLICACION,TITULO,FECHAPUBLICACION,FECHACONDICION,TIPOPUBLICACION,ACTIVO ");
		sql.append("FROM PUBLICACION WHERE TITULO LIKE ? AND TIPOPUBLICACION=?");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			String aux = "%"+texto+"%";
			ps.setString(1, aux);
			ps.setInt(2, tipo);
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<IPublicacion> publicaciones = new ArrayList<IPublicacion>();
			
			while(rs.next()) {
				Publicador p = fabrica.crearPublicador();
				p.setIdPublicacion(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setFechaPublicacion(rs.getDate(3));
				p.setFechaCondicion(rs.getDate(4));				
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
	
	public String cargarIdObjeto(String idPublicacion) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT IDOBJETO FROM PUBLICACION WHERE IDPUBLICACION=?");		
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ps.setString(1, idPublicacion);
			
			ResultSet rs = ps.executeQuery();
			
			String idObjeto = "";
			
			while(rs.next()) {
				idObjeto = (rs.getString(1));				
			}								
			return idObjeto;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			myConn.soltarConexion();
		}	
	}
	public String cargarIdUsuario(String idPublicacion) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT IDUSUARIO FROM PUBLICACION WHERE IDPUBLICACION=?");		
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ps.setString(1, idPublicacion);
			
			ResultSet rs = ps.executeQuery();
			
			String idObjeto = "";
			
			while(rs.next()) {
				idObjeto = (rs.getString(1));				
			}								
			return idObjeto;
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
	
	public void setFabrica(FabricaPublicador fabrica) {
		this.fabrica = fabrica;
	}
	
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}


	public void setIdObjeto(String idObjeto) {
		this.idObjeto = idObjeto;
	}


	public List<String> verCategorias(){		
		return null;
	}
}
