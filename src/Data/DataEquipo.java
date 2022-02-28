package Data;


import java.sql.*;
import java.util.LinkedList;

import Entidades.*;



public class DataEquipo {
	

public static LinkedList<Equipo> getall(){	
	Conexion conexion = new Conexion();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	LinkedList<Equipo> equi= new LinkedList<>();
	
	try {
		cn = conexion.conectar();
		stm = cn.createStatement();
		rs = stm.executeQuery("Select id,razonSocial,localidad,puntaje,difGoles from equipo");
		
		while (rs.next()) {
			Equipo e=new Equipo();
			e.setIdEquipo(rs.getInt("id"));
			e.setNombre(rs.getString("razonSocial"));
			e.setLocalidad(rs.getString("localidad"));
			e.setPuntaje(rs.getInt("puntaje"));
			e.setDifGoles(rs.getInt("difGoles"));
			
			equi.add(e);
			
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
	return equi;
}


	
	public static boolean alta (Equipo e) {
   
		Conexion conexion = new Conexion();
		Connection cn = null;

        try {
        	cn = conexion.conectar();
    		PreparedStatement ps;
    		ps=cn.prepareStatement("insert into equipo(id,razonSocial,localidad,puntaje,difGoles) values (?,?,?,?,?)");
    		ps.setInt(1, e.getIdEquipo());
    		ps.setString(2, e.getNombre());
			ps.setString(3,e.getLocalidad());
			ps.setInt(4,e.getPuntaje());
			ps.setInt(5,e.getDifGoles());
		

         
            ps.executeUpdate();
            if(ps!=null)ps.close();
            cn.close();
            
        } catch (SQLException ex) {
        	ex.printStackTrace();
        	return false;
        }
		return true;
	}

	
public static void baja(Equipo e) {
		Conexion conexion = new Conexion();
		Connection cn = null;
	    try {
	    	cn = conexion.conectar();
	    	PreparedStatement ps = cn.prepareStatement("delete from equipo where id=?");
			ps.setInt(1, e.getIdEquipo());
			ps.executeUpdate();  
				
	        if(ps!=null)ps.close();
	        cn.close();
	        
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	
}

public static void modif (Equipo e) {
	   
	Conexion conexion = new Conexion();
	Connection cn = null;

    try {
    	cn = conexion.conectar();
		PreparedStatement ps;
		ps=cn.prepareStatement("update equipo set razonSocial=?, localidad=?, puntaje=?, difGoles=? where id=?");
		ps.setString(1, e.getNombre());
		ps.setString(2,e.getLocalidad());
		ps.setInt(3,e.getPuntaje());
		ps.setInt(4,e.getDifGoles());
		ps.setInt(5,e.getIdEquipo());
        ps.executeUpdate();   
        if(ps!=null)ps.close();
        cn.close();
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}


public static Equipo getOne(int id) {
	Conexion conexion = new Conexion();
	Connection cn = null;
	Equipo e = new Equipo();
    try {
    	cn = conexion.conectar();
		PreparedStatement ps =cn
				.prepareStatement("Select * from equipo where id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();  
        while (rs.next()) {
			
			e.setIdEquipo(rs.getInt("id"));
			e.setNombre(rs.getString("razonSocial"));
			e.setLocalidad(rs.getString("localidad"));
			e.setPuntaje(rs.getInt("puntaje"));
			e.setDifGoles(rs.getInt("difGoles"));
        }
			
        if(ps!=null)ps.close();
        cn.close();
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
return e;
	}
}
	





