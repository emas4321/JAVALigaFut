package Logic;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

import Entidades.Cancha;
import Entidades.Equipo;
import Entidades.Partido;

public class Validaciones {

	public Boolean VerificarEquiposFecha(int ide1, int ide2,LocalDate fecha, LocalTime hora) // verificacion para reprogramar, verifica que los equipos no esten jugando otro partido en esa fecha/hora

    {
	   	EquipoLogic equipoL= new EquipoLogic();
	   	Equipo equipo1=equipoL.getOne(ide1);
	   	Equipo equipo2=equipoL.getOne(ide2);
	   	PartidoLogic partidoL=new PartidoLogic();
	   	LinkedList<Partido> listP=partidoL.getAll();
	   	Boolean Disp=true;
	   	for(Partido p:listP)
	   	{
	   		if(p.getFecha().isEqual(fecha)&& p.getHora().compareTo(hora)==0 && (p.getIdEquipo1()==ide1||p.getIdEquipo2()==ide2||p.getIdEquipo1()==ide2||p.getIdEquipo2()==ide1))
	   			Disp=false;
	   	}
	   	return Disp;
	   	
	}
	public Boolean VerificarCanchaDisp(LocalDate fecha,LocalTime hora,int nroC)
	{
		PartidoLogic partidoL=new PartidoLogic();
		LinkedList<Partido>listP=partidoL.getAll();
		CanchaLogic canchaL= new CanchaLogic();
		Cancha c= canchaL.getOne(nroC);
				
		for(Partido p:listP)
		{	
			if(p.getNumCancha()==c.getNroCancha() && p.getFecha().isEqual(fecha) && p.getHora().compareTo(hora)==0) {
				System.out.println("true");
				return false;	}			
		}
		return true;
	}
}
