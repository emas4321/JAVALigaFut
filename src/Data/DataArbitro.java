package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;

import Entidades.*;

public class DataArbitro {

	
	public void Alta(Arbitro a)  {
		
		try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket","root","root");
		PreparedStatement stmt= conn.prepareStatement("insert into Arbitro(dni , nombre , apellido , fecha_nacimiento) values (?,?,?,?) " , PreparedStatement. RETURN_GENERATED_KEYS);
		stmt.setInt(1, a.getDni());
		stmt.setString(2, a.getNombre());
		stmt.setString(3, a.getApellido());
		stmt.setObject(4, a.getFecha_nacimiento());
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
	

		
		
		
public void Baja (Arbitro a) {
	
	try {
	
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket","root","root");
		PreparedStatement stmt = conn.prepareStatement("delete from Arbitro where dni = ?" );
		stmt.setInt(1 , a.getDni());
		stmt.executeUpdate();
		if(stmt!=null) {stmt.close();}
		conn.close();
		System.out.println("El entrenador de id:"+a.getDni()+"  fue eliminado de la BD");
		}catch (Exception ex) {ex.printStackTrace();} /*finally {
																	try {
																		
																		if(stmt!=null) {stmt.close();}
																		conn.close();
																		} catch (SQLException ex) { ex.printStackTrace(); }
																}*/
									}


public void Modif(Arbitro a) {
	
	try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket","root","root");
		PreparedStatement stmt = conn.prepareStatement("update Arbitro set  nombre = ? , apellido = ? , fecha_nacimiento = ? where dni = ?" );
		stmt.setString(1, a.getNombre());
		stmt.setString(2, a.getApellido());
		stmt.setObject(3, a.getFecha_nacimiento());
		stmt.setInt(4, a.getDni());
		stmt.executeUpdate();
		if(stmt!=null) {stmt.close();}
		conn.close();
	} catch (Exception ex) {ex.printStackTrace();}
}


public LinkedList<Arbitro> getAll() {
		
	LinkedList<Arbitro> Arbitros = new LinkedList<>();
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket","root","root");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Arbitro");
			while (rs.next()) {
								Arbitro a = new Arbitro();
								a.setDni(rs.getInt("dni"));
								a.setNombre(rs.getString("nombre"));
								a.setApellido(rs.getString("apellido"));
								a.setFecha_nacimiento(rs.getObject("fecha_nacimiento", LocalDate.class));
								Arbitros.add(a);
								if(stmt!=null) {stmt.close();}
								if(rs!=null) {rs.close();}
								conn.close();
								}
			}catch(Exception ex) {ex.printStackTrace();}
		
		return Arbitros;
	}
}
