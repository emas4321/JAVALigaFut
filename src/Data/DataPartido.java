package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

import Entidades.*;

public class DataPartido {


	public static LinkedList<Partido> getAll () {
		Conexion conexion = new Conexion();
		Connection cn = null;
		LinkedList<Partido> Partidos = new LinkedList<>();
		try {
			cn = conexion.conectar();
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from partido");
			while (rs.next()) {
								Partido p = new Partido();
								p.setFecha(rs.getObject("fecha", LocalDate.class));
								p.setHora(rs.getObject("hora", LocalTime.class));
								p.setResultado(rs.getString("resultado"));
								p.setIncidencias(rs.getString("incidencias"));
								p.setIdEquipo1(rs.getInt("idEquipo1"));
								p.setIdEquipo2(rs.getInt("idEquipo2"));
								p.setNumCancha(rs.getInt("numCancha"));
								Partidos.add(p);
								}
			if(stmt!=null) {stmt.close();}
			if(rs!=null) {rs.close();}
			cn.close();
			}catch(Exception ex) {ex.printStackTrace();}
		return Partidos;
	}

	public String Modif(Partido p) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		//Actualiza resultado y incidencias de un partido que ya debe estar cargado
		
		try { 
			cn = conexion.conectar();
			PreparedStatement stmt = cn.prepareStatement("update partido set  resultado = ?, idEquipo1 =?, idEquipo2=?, dniArbitro=? where  fecha=? and hora =? and numCancha= ?" );
			stmt.setString(1, p.getResultado());
			stmt.setInt(2, p.getIdEquipo1());
			stmt.setInt(3, p.getIdEquipo2());
			stmt.setString(4, p.getDniArbitro());
			//stmt.setString(2, p.getIncidencias());
			stmt.setObject(5, p.getFecha());
			stmt.setObject(6, p.getHora());
			stmt.setInt(7, p.getNumCancha());
	
			stmt.executeUpdate();
			 
		} catch (SQLException ex) {
			ex.printStackTrace();
		}/*finally {try {
			if(stmt!=null)stmt.close();
			DbConnector.getInstance().releaseConn();
		}
	}*/
		return "El Partido fue Actualizado ";
	}

	public Partido getOne(LocalDate Fecha, LocalTime Hora, int nroC) // agregue nroCancha como clave primaria
	{	Conexion conexion = new Conexion();
		Connection cn = null;
		Partido p= new Partido();
		try {
			cn = conexion.conectar();
			PreparedStatement ps =cn
					.prepareStatement("select * from partido where fecha=? and hora=? and numCancha= ?");
		
			ps.setObject(1, Fecha);
			ps.setObject(2, Hora);
			ps.setInt(3, nroC);
			ResultSet rs=ps.executeQuery();  
			rs.next();
					
				 	p.setFecha(rs.getObject("fecha", LocalDate.class));
					p.setHora(rs.getObject("hora", LocalTime.class));
					p.setIdEquipo1(rs.getInt("idEquipo1"));
					p.setIdEquipo2(rs.getInt("idEquipo2"));
					p.setResultado(rs.getString("resultado"));
					p.setNumCancha(rs.getInt("numCancha"));
					p.setDniArbitro(rs.getString("dniArbitro"));	

					
		        if(ps!=null)ps.close();
		        cn.close();
		        
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		return p;
	}
	public  boolean alta (Partido p) {
		   
		Conexion conexion = new Conexion();
		Connection cn = null;

        try {
        	cn = conexion.conectar();
    		PreparedStatement ps;
    		ps=cn.prepareStatement("insert into partido(fecha,hora,idEquipo1,idEquipo2,numCancha,resultado) values (?,?,?,?,?,?)"); // no pongo incidencias ni resultado porque es un partido nuevo
    		ps.setObject(1, p.getFecha());
    		ps.setObject(2, p.getHora());
			ps.setInt(3, p.getIdEquipo1());
			ps.setInt(4,p.getIdEquipo2());
			//ps.setInt(5,p.getDniArbitro());
			ps.setInt(5,p.getNumCancha());
			ps.setString(6, p.getResultado());
            ps.executeUpdate();
            if(ps!=null)ps.close();
            cn.close();
            
        } catch (SQLException ex) {
        	ex.printStackTrace();
        	return false;
        }
		return true;
	}
	public static boolean baja(Partido p) {
		Conexion conexion = new Conexion();
		Connection cn = null;
	    try {
	    	cn = conexion.conectar();
	    	PreparedStatement ps = cn.prepareStatement("delete from partido where fecha=? and hora=? and numCancha=?");
			ps.setObject(1, p.getFecha());
			ps.setObject(2, p.getHora());
			ps.setInt(3, p.getNumCancha());		
			ps.executeUpdate();  		
	        if(ps!=null)ps.close();
	        cn.close();	        
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        return false;
	    }
	    return true;
	
}

}