package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

import Entidades.*;

public class DataPartido {


	public static LinkedList<Partido> getAll () {
		LinkedList<Partido> Partidos = new LinkedList<>();
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ligafut","root","root");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Partido");
			while (rs.next()) {
								Partido p = new Partido();
								p.setFecha(rs.getObject("fecha", LocalDate.class));
								p.setHora(rs.getObject("hora", LocalTime.class));
								p.setResultado(rs.getString("resultado"));
								/*p.setIncidencias(rs.getString("incidencias"))*/
								Partidos.add(p);
								}
			if(stmt!=null) {stmt.close();}
			if(rs!=null) {rs.close();}
			conn.close();
			}catch(Exception ex) {ex.printStackTrace();}
		return Partidos;
	}



}