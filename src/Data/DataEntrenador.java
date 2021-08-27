package Data;

import Entidades.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class DataEntrenador {
	
		public void Alta(Entrenador e)  {
			
		try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket","root","root");
		PreparedStatement stmt= conn.prepareStatement("insert into Entrenador(dni , nombre , apellido , fecha_nacimiento) values (?,?,?,?) " , PreparedStatement. RETURN_GENERATED_KEYS);
		stmt.setInt(1, e.getDni());
		stmt.setString(2, e.getNombre());
		stmt.setString(3, e.getApellido());
		stmt.setObject(4, e.getFecha_nacimiento());
		stmt.executeUpdate();
		conn.close();
		stmt.close();
						}catch (Exception ex) {ex.printStackTrace();} /*finally {
																					try {
		
																							if(stmt!=null) {stmt.close();}
																							conn.close();
																						} catch (SQLException ex) { ex.printStackTrace(); }
																				}*/	
																}
	

		
		
		
public void Baja (Entrenador e) {
	
	try {
	
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket","root","root");
		PreparedStatement stmt = conn.prepareStatement("delete from Entrenador where dni = ?" );
		stmt.setInt(1 , e.getDni());
		stmt.executeUpdate();
		if(stmt!=null) {stmt.close();}
		conn.close();
		System.out.println("El entrenador de id:"+e.getDni()+"  fue eliminado de la BD");
		}catch (Exception ex) {ex.printStackTrace();} /*finally {
																	try {
																		
																		if(stmt!=null) {stmt.close();}
																		conn.close();
																		} catch (SQLException ex) { ex.printStackTrace(); }
																}*/
									}


public void Modif(Entrenador e) {
	
	try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket","root","root");
		PreparedStatement stmt = conn.prepareStatement("update Entrenador set  nombre = ? , apellido = ? , fecha_nacimiento = ? where dni = ?" );
		stmt.setString(1, e.getNombre());
		stmt.setString(2, e.getApellido());
		stmt.setObject(3, e.getFecha_nacimiento());
		stmt.setInt(4, e.getDni());
		stmt.executeUpdate();
		if(stmt!=null) {stmt.close();}
		conn.close();
	} catch (Exception ex) {ex.printStackTrace();}
}

public LinkedList<Entrenador> getAll () {
		LinkedList<Entrenador> Entrenadores = new LinkedList<>();
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket","root","root");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Entrenador");
			while (rs.next()) {
								Entrenador e = new Entrenador();
								e.setDni(rs.getInt("dni"));
								e.setNombre(rs.getString("nombre"));
								e.setApellido(rs.getString("apellido"));
								e.setFecha_nacimiento(rs.getObject("fecha_nacimiento", LocalDate.class));
								Entrenadores.add(e);
								if(stmt!=null) {stmt.close();}
								if(rs!=null) {rs.close();}
								conn.close();
								}
			}catch(Exception ex) {ex.printStackTrace();}
		return Entrenadores;
	}



}