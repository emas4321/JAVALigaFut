package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;

import Entidades.Arbitro;


public class DataArbitro {

	public static LinkedList<Arbitro> getall(){	
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		LinkedList<Arbitro> arbi= new LinkedList<>();
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("Select * from arbitro");
			
			while (rs.next()) {
				Arbitro a=new Arbitro();
				a.setDni(rs.getInt("dniArbitro"));
				a.setNombre(rs.getString("nombre"));
				a.setApellido(rs.getString("apellido"));
				a.setFecha_nacimiento(rs.getObject("fechaNac",LocalDate.class));
				
				arbi.add(a);
				
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
		return arbi;
	}


		public static boolean alta (Arbitro a) {
	   
			Conexion conexion = new Conexion();
			Connection cn = null;

	        try {
	        	cn = conexion.conectar();
	    		PreparedStatement ps;
	    		ps=cn.prepareStatement("insert into arbitro(dniArbitro,nombre,apellido,fechaNac) values (?,?,?,?)");
	    		ps.setInt(1, a.getDni());
	    		ps.setString(2, a.getNombre());
				ps.setString(3,a.getApellido());
				ps.setObject(4,a.getFecha_nacimiento());
			

	         
	            ps.executeUpdate();
	            if(ps!=null)ps.close();
	            cn.close();
	            
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        	return false;
	        }
			return true;
		}

		
	public static void baja(Arbitro a) {
			Conexion conexion = new Conexion();
			Connection cn = null;
		    try {
		    	cn = conexion.conectar();
		    	PreparedStatement ps = cn.prepareStatement("delete from arbitro where dniArbitro=?");
				ps.setInt(1, a.getDni());
				ps.executeUpdate();  
					
		        if(ps!=null)ps.close();
		        cn.close();
		        
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		
	}

	public static void modif (Arbitro a) {
		   
		Conexion conexion = new Conexion();
		Connection cn = null;

	    try {
	    	cn = conexion.conectar();
			PreparedStatement ps;
			ps=cn.prepareStatement("update arbitro set nombre=?, apellido=?, fechaNac=? where dniArbitro=?");
			ps.setString(1, a.getNombre());
			ps.setString(2,a.getApellido());
			ps.setObject(3,a.getFecha_nacimiento());
			ps.setInt(4,a.getDni());
	        ps.executeUpdate();   
	        if(ps!=null)ps.close();
	        cn.close();
	        
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}


	public static Arbitro list(int dni) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Arbitro a = new Arbitro();
	    try {
	    	cn = conexion.conectar();
			PreparedStatement ps =cn
					.prepareStatement("Select * from arbitro where dniArbitro=?");
			ps.setInt(1, dni);
			ResultSet rs=ps.executeQuery();  
	        while (rs.next()) {
				
				a.setDni(rs.getInt("dniArbitro"));
				a.setNombre(rs.getString("nombre"));
				a.setApellido(rs.getString("apellido"));
				a.setFecha_nacimiento(rs.getObject("fechaNac",LocalDate.class));
	        }
				
	        if(ps!=null)ps.close();
	        cn.close();
	        
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	return a;
		}
	}
