package Logic;

import java.util.LinkedList;

import Data.DataEquipo;
import Entidades.Equipo;

public class EquipoLogic {
	private DataEquipo dEquipo;
	public EquipoLogic()
	{
		dEquipo= new DataEquipo();
	}
public Equipo getOne(int id) 
	{
		return dEquipo.getOne(id);
	}
public LinkedList<Equipo> getAll()
{
	return dEquipo.getall();
}

}
