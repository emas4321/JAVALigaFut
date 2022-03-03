package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import Entidades.Cancha;

public class DataCancha {
	

		public static LinkedList<Cancha> getall(){	
			Conexion conexion = new Conexion();
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			LinkedList<Cancha> cancha= new LinkedList<>();
			
			try {
				cn = conexion.conectar();
				stm = cn.createStatement();
				rs = stm.executeQuery("Select * from cancha");
				
				while (rs.next()) {
					Cancha c=new Cancha();
					c.setNroCancha(rs.getInt("numCancha"));
					c.setNombre(rs.getString("nombre"));
					
					
					cancha.add(c);
					
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
			return cancha;
		}


			public static boolean alta (Cancha c) {
		   
				Conexion conexion = new Conexion();
				Connection cn = null;

		        try {
		        	cn = conexion.conectar();
		    		PreparedStatement ps;
		    		ps=cn.prepareStatement("insert into cancha(numCancha,nombre) values (?,?)");
		    		ps.setInt(1, c.getNroCancha());
		    		ps.setString(2, c.getNombre());

		         
		            ps.executeUpdate();
		            if(ps!=null)ps.close();
		            cn.close();
		            
		        } catch (SQLException ex) {
		        	ex.printStackTrace();
		        	return false;
		        }
				return true;
			}

			
		public static void baja(Cancha c) {
				Conexion conexion = new Conexion();
				Connection cn = null;
			    try {
			    	cn = conexion.conectar();
			    	PreparedStatement ps = cn.prepareStatement("delete from cancha where numCancha=?");
					ps.setInt(1, c.getNroCancha());
					ps.executeUpdate();  
						
			        if(ps!=null)ps.close();
			        cn.close();
			        
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			
		}

		public static void modif (Cancha c) {
			   
			Conexion conexion = new Conexion();
			Connection cn = null;

		    try {
		    	cn = conexion.conectar();
				PreparedStatement ps;
				ps=cn.prepareStatement("update cancha set nombre=? where numCancha=?");
				ps.setString(1, c.getNombre());
				ps.setInt(2,c.getNroCancha());
				ps.executeUpdate();   
		        if(ps!=null)ps.close();
		        cn.close();
		        
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		}


		public static Cancha getOne(int nroCancha) {
			Conexion conexion = new Conexion();
			Connection cn = null;
			Cancha c = new Cancha();
		    try {
		    	cn = conexion.conectar();
				PreparedStatement ps =cn
						.prepareStatement("Select * from cancha where numCancha=?");
				ps.setInt(1, nroCancha);
				ResultSet rs=ps.executeQuery();  
		        while (rs.next()) {
					
					c.setNroCancha(rs.getInt("numCancha"));
					c.setNombre(rs.getString("nombre"));
		        }
					
		        if(ps!=null)ps.close();
		        cn.close();
		        
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		return c;
			}
		}