package Logic;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Arbitro;
import Entidades.Partido;

public class CasoUsoControl {
	String PartidoListar="Partido_Listar.jsp";
	String asignaArbitro="AsignarArbitro.jsp";
	String PartidoSinArbitroLista="PartidoSinArbitro_Lista.jsp";
	private static final long serialVersionUID = 1L;
    public CasoUsoControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acceso="";
		String action=request.getParameter("accion");
		if(action.equalsIgnoreCase("ReprogramarPartido"))
		{
			preparalistP(request, response);
			acceso=PartidoListar;
		}
		if(action.equalsIgnoreCase("AsignarArbitro"))
		{
			preparalistaPSinArbitro(request,response);
			acceso=PartidoSinArbitroLista;
		}
		RequestDispatcher vista=request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}
		
	
	
	
	
	private void preparalistP(HttpServletRequest request, HttpServletResponse response) {
		PartidoLogic partidoL= new PartidoLogic();
		LinkedList<Partido> listP = partidoL.getAll();
		LinkedList<Partido>listPDisp=new LinkedList<>();
		for(Partido p:listP)
		{
			if(p.getResultado()== null && p.getFecha().isAfter(LocalDate.now())) // habia otro metodo para comparar si un string era nulo en una de las primeras clases de meca
				listPDisp.add(p);
		}
		request.getSession().setAttribute("listaP", listPDisp); // muestra los partidos que no tengan resultado
	}
	
	
	
	private void preparalistaPSinArbitro(HttpServletRequest request, HttpServletResponse response) {
		PartidoLogic partidoL= new PartidoLogic();
		LinkedList<Partido> listP = partidoL.getAll();
		LinkedList<Partido>listPsinArbitro=new LinkedList<>();
		for(Partido p:listP)
		{
			if(p.getDniArbitro().isBlank()&&p.getFecha().isAfter(LocalDate.now()) &&p.getResultado()!="Reprogra") // si el partido no tiene arbitro + la fecha es despeus de hoy + no fue reprogramado entonces agrego partido a la lista
			{
				listPsinArbitro.add(p);
			}
		}
		request.getSession().setAttribute("listaPartido", listPsinArbitro);
	}

}
