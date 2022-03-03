package Logic;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

import Data.DataPartido;
import Entidades.Partido;

public class PartidoLogic {
	
	private DataPartido dPartido;
	public PartidoLogic()
	{
		dPartido= new DataPartido();
	}
	public Partido getOne(LocalDate fecha, LocalTime hora,int nroCancha)
	{	
		return dPartido.getOne(fecha,hora,nroCancha);	
	}
	

	public LinkedList<Partido> getAll () {
		return dPartido.getAll();
	}
	public void Modif(Partido p)
	{
		dPartido.Modif(p);
	}
	public  boolean alta (Partido p)
	{
		return dPartido.alta(p);
	}
	public boolean baja(Partido p)
	{
		return dPartido.baja(p);
	}

}
