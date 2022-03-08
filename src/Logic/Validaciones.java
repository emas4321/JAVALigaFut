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
    public Boolean VerificarCanchaDisp(LocalDate fecha,LocalTime hora,int nroC)
    {
        PartidoLogic partidoL=new PartidoLogic();
        LinkedList<Partido>listP=partidoL.getAll();
        CanchaLogic canchaL= new CanchaLogic();
        Cancha c= canchaL.getOne(nroC);
                
        for(Partido p:listP)
        {
            if(p.getNumCancha()==c.getNroCancha() && p.getFecha()==fecha &&p.getHora()==hora)
                return false;                
        }
        return true;
    }
    public Boolean VerificarUnEquipo(LocalDate fecha,LocalTime hora,int idEquipo)
    {
           PartidoLogic partidoL=new PartidoLogic();
           LinkedList<Partido> listP=partidoL.getAll();
           Boolean Disp=true;
           for(Partido p:listP)
           {
               if(p.getFecha()==fecha && p.getHora()==hora && (p.getIdEquipo1()==idEquipo||p.getIdEquipo2()==idEquipo))
                   Disp=false;
           }
           return Disp;
    }
    
    public Boolean DosEquiposIguales(int IdEquipo1Viejo,int IdEquipo2Viejo, int idEquipo1N , int idEquipo2N)
    {
        if((IdEquipo1Viejo==idEquipo1N &&IdEquipo2Viejo==idEquipo2N)||(IdEquipo1Viejo==idEquipo2N && IdEquipo2Viejo==idEquipo1N))
            return true;
            else
                return false;
    }
}
