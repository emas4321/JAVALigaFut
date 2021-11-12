package Data;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import Entidades.*;


public class DataEquipo {
	
	
	// FALTA CORREGIR CONEXION A BD
	
	public LinkedList<Equipo> getall(){
		
		Statement stmt = null;
		ResultSet rs= null;
		LinkedList<Equipo> equi= new LinkedList<>();
		
		try {
			 stmt = DBConector.getInstancia().getConn().createStatement();
			 rs= stmt.executeQuery("Select id,nombre,locacion,puntaje,difgoles from Equipo), values (?,?,?,?)" );
			if (rs!=null) {
				while(rs.next()) {
					Equipo e=new Equipo();
					e.setIdEquipo(rs.getInt("id"));
					e.setNombre(rs.getString("nombre"));
					e.setLocalidad(rs.getString("locacion"));
					e.setPuntaje(rs.getInt("puntaje"));
					e.setDifGoles(rs.getInt("difgoles"));
					
					equi.add(e);
				}
			}
			 
		}catch (SQLException ex) {
				ex.printStackTrace();
				
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
				}
		return equi;
			}
	
	
	public void Alta (Equipo e) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getIntance().getConn();
					stmt.prepareStatement(
							"insert into equipo(nombre, localidad,puntaje,difGoles), values (?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, e.getNombre());
			stmt.setString(2,e.getLocalidad());
			stmt.setInt(3,e.getPuntaje());
			stmt.setInt(4,e.getDifGoles());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()) {
				e.setIdEquipo(keyResultSet.getInt(1));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(keyResultSet!=null)keyResultSet.close();
				if(stmt!=null)stmt.close();
				DbConnector.getInstance().releaseConn();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		}
}
	

public void Baja (Equipo e) {
	PreparedStatement stmt= null;
	ResultSet keyResultSet=null;
	try {
		stmt=DbConnector.getIntance().getConn();
				stmt.prepareStatement("delete from Entrenador where dni = ? ");
		stmt.setInt(1 , e.getIdEquipo());
		stmt.executeUpdate();
		System.out.println("El Equipo de id:"+e.getIdEquipo()+"  fue eliminado de la BD");
	} catch (SQLException ex) {
		ex.printStackTrace();
	} finally {
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			DbConnector.getInstance().releaseConn();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	}

public void Modif(Equipo e) {
	PreparedStatement stmt=null;
	try { 
		stmt=DbConnector.getIntance().getConn();
			stmt.prepareStatement("update Equipo set  nombre = ? , localidad = ? , puntaje = ? , difGoles where id = ?" );
		stmt.setString(1, e.getNombre());
		stmt.setString(2, e.getLocalidad());
		stmt.setInt(3, e.getPuntaje());
		stmt.setInt(4, e.getDifGoles());
		stmt.setInt(5, e.getIdEquipo());
		stmt.executeUpdate();
		System.out.println("El Equipo de id: " + e.getIdEquipo()+ " fue Modificado de la DB");
	} catch (SQLException ex) {
		ex.printStackTrace();
	}finally {try {
		if(stmt!=null)stmt.close();
		DbConnector.getInstance().releaseConn();
	} catch(SQLException ex) {
		ex.printStackTrace();
	}
}	
}
}






