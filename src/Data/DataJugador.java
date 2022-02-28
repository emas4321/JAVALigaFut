package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;

import Entidades.Jugador;

public class DataJugador {
	
	public static LinkedList<Jugador> getall(){	
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		LinkedList<Jugador> jugador= new LinkedList<>();
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("Select dniJugador,nombre,apellido,fechaNac,posicion,goles,asistencias,amarillas,rojas,partJugados,idEquipo from jugador");
			
			while (rs.next()) {
				Jugador j=new Jugador();
				j.setDni(rs.getInt("dniJugador"));
				j.setNombre(rs.getString("nombre"));
				j.setApellido(rs.getString("apellido"));
				j.setFecha_nacimiento(rs.getObject("fechaNac", LocalDate.class));
				j.setPosicion(rs.getString("posicion"));
				j.setGoles(rs.getInt("goles"));
				j.setAsistencias(rs.getInt("asistencias"));
				j.setTarjetasA(rs.getInt("amarillas"));
				j.setTarjetasR(rs.getInt("rojas"));
				j.setPartidosJugados(rs.getInt("partJugados"));
				
				jugador.add(j);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rs!= null) {
					rs.close();
				}
				
				if (stm != null) {
					stm.close();
				}
				
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return jugador;
	}


		public static boolean alta (Jugador j) {
	   
			Conexion conexion = new Conexion();
			Connection cn = null;

	        try {
	        	cn = conexion.conectar();
	    		PreparedStatement ps;
	    		ps=cn.prepareStatement("insert into jugador(dniJugador,nombre,apellido,fechaNac,posicion,goles,asistencias,amarillas,rojas,partJugados) values (?,?,?,?,?,?,?,?,?,?)");
	    		ps.setInt(1, j.getDni());
	    		ps.setString(2, j.getNombre());
				ps.setString(3,j.getApellido());
				ps.setObject(4,j.getFecha_nacimiento());
				ps.setString(5,j.getPosicion());
				ps.setInt(6, j.getGoles());
				ps.setInt(7,j.getAsistencias());
				ps.setInt(8, j.getTarjetasA());
				ps.setInt(9, j.getTarjetasR());
				ps.setInt(10, j.getPartidosJugados());
	         
	            ps.executeUpdate();
	            if(ps!=null)ps.close();
	            cn.close();
	            
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        	return false;
	        }
			return true;
		}

		
	public static void baja(Jugador j) {
			Conexion conexion = new Conexion();
			Connection cn = null;
		    try {
		    	cn = conexion.conectar();
		    	PreparedStatement ps = cn.prepareStatement("delete from jugador where dniJugador=?");
				ps.setInt(1, j.getDni());
				ps.executeUpdate();  
					
		        if(ps!=null)ps.close();
		        cn.close();
		        
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		
	}

	public static void modif (Jugador j) {
		   
		Conexion conexion = new Conexion();
		Connection cn = null;

	    try {
	    	cn = conexion.conectar();
			PreparedStatement ps;
			ps=cn.prepareStatement("update jugador set nombre=?, apellido=?, fechaNac=?,posicion=?,goles=?,asistencias=?,amarillas=?,rojas=?,partJugados=? where dniJugador=?");
			ps.setString(1, j.getNombre());
			ps.setString(2,j.getApellido());
			ps.setObject(3,j.getFecha_nacimiento());
			ps.setString(4,j.getPosicion());
			ps.setInt(5, j.getGoles());
			ps.setInt(6, j.getAsistencias());
			ps.setInt(7, j.getTarjetasA());
			ps.setInt(8, j.getTarjetasR());
			ps.setInt(9, j.getPartidosJugados());
			ps.setInt(10,j.getDni());
	        ps.executeUpdate();   
	        if(ps!=null)ps.close();
	        cn.close();
	        
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}


	public static Jugador list(int dni) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Jugador j = new Jugador();
	    try {
	    	cn = conexion.conectar();
			PreparedStatement ps =cn
					.prepareStatement("Select * from jugador where dnijugador=?");
			ps.setInt(1, dni);
			ResultSet rs=ps.executeQuery();  
	        while (rs.next()) {
				
				j.setDni(rs.getInt("dniJugador"));
				j.setNombre(rs.getString("nombre"));
				j.setApellido(rs.getString("apellido"));
				j.setFecha_nacimiento(rs.getObject("fechaNac",LocalDate.class));
				j.setPosicion(rs.getString("posicion"));
				j.setGoles(rs.getInt("goles"));
				j.setAsistencias(rs.getInt("asistencias"));
				j.setTarjetasA(rs.getInt("amarillas"));
				j.setTarjetasR(rs.getInt("rojas"));
				j.setPartidosJugados(rs.getInt("partJugados"));
				
	        }
				
	        if(ps!=null)ps.close();
	        cn.close();
	        
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	return j;
		}
	}
