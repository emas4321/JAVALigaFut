package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;

import Entidades.Arbitro;
import Entidades.Entrenador;

public class DataArbitro {

public String Alta(Arbitro a)  {
		
		try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ligafut","root","root");
		PreparedStatement stmt= conn.prepareStatement("insert into Arbitro(dniArbitro , nombre , apellido , fechaNac) values (?,?,?,?) " , PreparedStatement. RETURN_GENERATED_KEYS);
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
return a.getNombre()+"  "+a.getApellido()+" ";																
									}


public String Baja(Arbitro a) {
		
		try {
		
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ligafut","root","root");
			PreparedStatement stmt = conn.prepareStatement("delete from Arbitro where dniArbitro = ?" );
			stmt.setInt(1 , a.getDni());
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


public String Modif(Arbitro a) {
	
	try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ligafut","root","root");
		PreparedStatement stmt = conn.prepareStatement("update Arbitro set  nombre = ? , apellido = ? , fechaNac = ? where dniArbitro = ?" );
		stmt.setString(1, a.getNombre());
		stmt.setString(2, a.getApellido());
		stmt.setObject(3, a.getFecha_nacimiento());
		stmt.setInt(4, a.getDni());
		stmt.executeUpdate();
		if(stmt!=null) {stmt.close();}
		conn.close();
	} catch (Exception ex) {ex.printStackTrace();}

	return a.getNombre()+"  "+a.getApellido()+" ";	
}


public LinkedList<Arbitro> getAll () {
	LinkedList<Arbitro> Arbitros = new LinkedList<>();
	try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ligafut","root","root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from arbitro");
		while (rs.next()) {
							Arbitro a = new Arbitro();
							a.setDni(rs.getInt("dniArbitro"));
							a.setNombre(rs.getString("nombre"));
							a.setApellido(rs.getString("apellido"));
							a.setFecha_nacimiento(rs.getObject("fechaNac", LocalDate.class));
							Arbitros.add(a);
							}
		if(stmt!=null) {stmt.close();}
		if(rs!=null) {rs.close();}
		conn.close();
		}catch(Exception ex) {ex.printStackTrace();}
	return Arbitros;
}

}
