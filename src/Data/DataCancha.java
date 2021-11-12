package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;

import Entidades.*;


public class DataCancha {
	
	public String Alta(Cancha c)  {
		
		try {
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ligafut","root","root");
		PreparedStatement stmt= conn.prepareStatement("insert into Cancha(numCancha , nombre) values (?,?) " , PreparedStatement. RETURN_GENERATED_KEYS);
		stmt.setInt(1, c.getNroCancha());
		stmt.setString(2, c.getNombre());
		stmt.executeUpdate();
		conn.close();
		stmt.close();
						}catch (Exception ex) {ex.printStackTrace();} /*finally {
																					try {
		
																							if(stmt!=null) {stmt.close();}
																							conn.close();
																						} catch (SQLException ex) { ex.printStackTrace(); }
																				}*/	
return c.getNombre();																
									}
	
	public String Baja (Cancha c) {
		
		try {
		
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ligafut","root","root");
			PreparedStatement stmt = conn.prepareStatement("delete from Cancha where numCancha = ?" );
			stmt.setInt(1 , c.getNroCancha());
			stmt.executeUpdate();
			if(stmt!=null) {stmt.close();}
			conn.close();
			}catch (Exception ex) {ex.printStackTrace();} /*finally {
																		try {
																			
																			if(stmt!=null) {stmt.close();}
																			conn.close();
																			} catch (SQLException ex) { ex.printStackTrace(); }
																	}*/

			return "";						
		
										}
	
	public LinkedList<Cancha> getAll () {
		LinkedList<Cancha> Canchas = new LinkedList<>();
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ligafut","root","root");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Cancha");
			while (rs.next()) {
								Cancha c = new Cancha();
								c.setNroCancha(rs.getInt("numCancha"));
								c.setNombre(rs.getString("nombre"));
								Canchas.add(c);
								}
			if(stmt!=null) {stmt.close();}
			if(rs!=null) {rs.close();}
			conn.close();
			}catch(Exception ex) {ex.printStackTrace();}
		return Canchas;
	}
	
	public int Modif(Cancha c) {
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ligafut","root","root");
			PreparedStatement stmt = conn.prepareStatement("update Cancha set  nombre = ?  where numCancha = ?" );
			stmt.setString(1, c.getNombre());
			stmt.setInt(2, c.getNroCancha());
			stmt.executeUpdate();
			if(stmt!=null) {stmt.close();}
			conn.close();
		} catch (Exception ex) {ex.printStackTrace();}

		return c.getNroCancha();	
	}
}
