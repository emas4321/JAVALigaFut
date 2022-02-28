package Logic;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

import Entidades.Equipo;
import Entidades.Partido;

public class Validaciones {

	public Boolean VerificarEquipos(int ide1, int ide2,LocalDate fecha, LocalTime hora)

    {
	   	EquipoLogic equipoL= new EquipoLogic();
	   	Equipo equipo1=equipoL.getOne(ide1);
	   	Equipo equipo2=equipoL.getOne(ide2);
	   	PartidoLogic partidoL=new PartidoLogic();
	   	LinkedList<Partido> listP=partidoL.getAll();
	   	Boolean Disp=true;
	   	for(Partido p:listP)
	   	{
	   		if(p.getFecha()==fecha && p.getHora()==hora && (p.getIdEquipo1()==ide1||p.getIdEquipo2()==ide2||p.getIdEquipo1()==ide2||p.getIdEquipo2()==ide1))
	   			Disp=false;
	   	}
	   	return Disp;
	   	
	}
}
