package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;

import Entidades.Entrenador;

public class DataEntrenador {


		public static LinkedList<Entrenador> getall(){	
			Conexion conexion = new Conexion();
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			LinkedList<Entrenador> entre= new LinkedList<>();
			
			try {
				cn = conexion.conectar();
				stm = cn.createStatement();
				rs = stm.executeQuery("Select dniEntrenador,nombre,apellido,fechaNac,idEquipo from entrenador");
				
				while (rs.next()) {
					Entrenador e=new Entrenador();
					e.setDni(rs.getInt("dniEntrenador"));
					e.setNombre(rs.getString("nombre"));
					e.setApellido(rs.getString("apellido"));
					e.setFecha_nacimiento(rs.getObject("fechaNac",LocalDate.class));
					entre.add(e);
					
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
			return entre;
		}


			public static boolean alta (Entrenador e) {
		   
				Conexion conexion = new Conexion();
				Connection cn = null;

		        try {
		        	cn = conexion.conectar();
		    		PreparedStatement ps;
		    		ps=cn.prepareStatement("insert into entrenador(dniEntrenador,nombre,apellido,fechaNac) values (?,?,?,?)");
		    		ps.setInt(1, e.getDni());
		    		ps.setString(2, e.getNombre());
					ps.setString(3,e.getApellido());
					ps.setObject(4,e.getFecha_nacimiento());

		         
		            ps.executeUpdate();
		            if(ps!=null)ps.close();
		            cn.close();
		            
		        } catch (SQLException ex) {
		        	ex.printStackTrace();
		        	return false;
		        }
				return true;
			}

			
		public static void baja(Entrenador e) {
				Conexion conexion = new Conexion();
				Connection cn = null;
			    try {
			    	cn = conexion.conectar();
			    	PreparedStatement ps = cn.prepareStatement("delete from entrenador where dniEntrenador=?");
					ps.setInt(1, e.getDni());
					ps.executeUpdate();  
						
			        if(ps!=null)ps.close();
			        cn.close();
			        
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			
		}

		public static void modif (Entrenador e) {
			   
			Conexion conexion = new Conexion();
			Connection cn = null;

		    try {
		    	cn = conexion.conectar();
				PreparedStatement ps;
				ps=cn.prepareStatement("update entrenador set nombre=?, apellido=?, fechaNac=? where dniEntrenador=?");
				ps.setString(1, e.getNombre());
				ps.setString(2,e.getApellido());
				ps.setObject(3,e.getFecha_nacimiento());
				ps.setInt(4, e.getDni());
		        ps.executeUpdate();   
		        if(ps!=null)ps.close();
		        cn.close();
		        
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		}


		public static Entrenador list(int dni) {
			Conexion conexion = new Conexion();
			Connection cn = null;
			Entrenador e = new Entrenador();
		    try {
		    	cn = conexion.conectar();
				PreparedStatement ps =cn
						.prepareStatement("Select * from Entrenador where dniEntrenador=?");
				ps.setInt(1, dni);
				ResultSet rs=ps.executeQuery();  
		        while (rs.next()) {
					
					e.setDni(rs.getInt("dniEntrenador"));
					e.setNombre(rs.getString("nombre"));
					e.setApellido(rs.getString("apellido"));
					e.setFecha_nacimiento(rs.getObject("fechaNac",LocalDate.class));
		        }
					
		        if(ps!=null)ps.close();
		        cn.close();
		        
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		return e;
			}
		}