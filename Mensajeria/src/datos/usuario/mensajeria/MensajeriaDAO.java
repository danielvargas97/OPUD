package datos.usuario.mensajeria;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datos.conexion.implementacion.ConexionOracle;
import logica.usuario.bandeja.BandejaEntrada;
import logica.usuario.mensajeria.Mensaje;

public class MensajeriaDAO {
	private BandejaEntrada bandeja;	
	private Mensaje m;
	
	
	public MensajeriaDAO() {		
		bandeja = new BandejaEntrada();
	}
	
	public void insertar(){
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO MENSAJE VALUES (?,?,?,?,?,?,?)");
		ConexionOracle myConn = ConexionOracle.getInstance();
		try {			
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ps.setString(1, m.getIdMensaje());
			ps.setString(2, m.getOrigen());
			ps.setString(3, m.getDestino());
			ps.setString(4, m.getAsunto());
			ps.setString(5, m.getMensaje());
			long date = m.getFecha().getTime();
			ps.setDate(6, new Date(date));
			ps.setInt(7, 0);
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
	
	private void cargarCorreoEntrante(String id) {
		StringBuilder sql = new StringBuilder();
		ConexionOracle myConn = ConexionOracle.getInstance();		
		sql.append("SELECT * FROM MENSAJE WHERE IDDESTINO = ? AND LEIDO=0");

		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareCall(sql.toString());
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Mensaje m = new Mensaje();
				m.setIdMensaje(rs.getString(1));
				m.setOrigen(rs.getString(2));
				m.setDestino(rs.getString(3));
				m.setAsunto(rs.getString(4));
				m.setMensaje(rs.getString(5));
				long date = rs.getDate(6).getTime();
				m.setFecha( new java.util.Date(date));
				m.setLeido(rs.getInt(7));
				bandeja.getBuzonEntrada().add(m);
			}		
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			myConn.soltarConexion();
		}
	}
	
	private void cargarCorreoSaliente(String id) {
		StringBuilder sql = new StringBuilder();
		ConexionOracle myConn = ConexionOracle.getInstance();
		sql.append("SELECT * FROM MENSAJE WHERE IDORIGEN = ?");

		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Mensaje m = new Mensaje();
				m.setIdMensaje(rs.getString(1));
				m.setOrigen(rs.getString(2));
				m.setDestino(rs.getString(3));
				m.setAsunto(rs.getString(4));
				m.setMensaje(rs.getString(5));
				m.setFecha(rs.getDate(6));
				m.setLeido(rs.getInt(7));
				bandeja.getBuzonEntrada().add(m);
			}			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			myConn.soltarConexion();
		}
		
	}
	
	
	public void cargarCorreo(String id) {
		bandeja.setBandejaID(id);
		cargarCorreoEntrante(id);
		cargarCorreoSaliente(id);
	}
	
	public void marcarLeido(String idMensaje) {
		StringBuilder sql = new StringBuilder();
		ConexionOracle myConn = ConexionOracle.getInstance();
		sql.append("UPDATE MENSAJE SET LEIDO = ?  WHERE IDMENSAJE = ?");

		try {
			Connection conn = myConn.tomarConexion();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, 1);
			ps.setString(2, idMensaje);
			
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
	
	
	
	public void setBandeja(BandejaEntrada bandeja) {
		this.bandeja = bandeja;		
	}
	
	public BandejaEntrada getBandeja() {
		return bandeja;
	}
	
	public Mensaje getMensaje() {
		return m;
	}
	public void setMensaje(Mensaje m) {
		this.m = m;
	}
	
	
}
