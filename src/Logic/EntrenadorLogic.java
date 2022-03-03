package Logic;
import Entidades.Entrenador;

import java.util.LinkedList;

import Data.DataEntrenador;

public class EntrenadorLogic {
	private DataEntrenador dEntrenador;
	public EntrenadorLogic()
	{
		dEntrenador= new DataEntrenador();
	}
	public Entrenador getOne(int dni)
	{
		return dEntrenador.getOne(dni);
	}
	public LinkedList<Entrenador> getAll()
	{
		return dEntrenador.getall();
	}
	public void Modif(Entrenador e )
	{
		dEntrenador.modif(e);
	}
	public void baja(Entrenador e)
	{
		dEntrenador.baja(e);
	}
	

}
