package Logic;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Partido;
import Logic.Validaciones;

/**
 * Servlet implementation class PartidoControlador
 */
@WebServlet("/PartidoControl")
public class PartidoControl extends HttpServlet {
	String listar = "Partido-Listar.jsp";
	String add="Partido-Add.jsp";
	String modif="Partido-Modif.jsp"; //seleccion de partido editar o borrar
	String edit="Partido-Edit.jsp"; // carga datos
	private static final long serialVersionUID = 1L;
    public PartidoControl() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acceso = "";
		String action = request.getParameter("accion");
		if(action.equalsIgnoreCase("add")){
			
			acceso=add;			
		}
		if(action.equalsIgnoreCase("modif"))
			acceso=modif;
		if(action.equalsIgnoreCase("listarP"))
			
				acceso=listar;
		if(action.equalsIgnoreCase("Alta"))
		{
			LocalDate fecha=LocalDate.parse(request.getParameter("fecha"));
			LocalTime hora=LocalTime.parse(request.getParameter("hora"));
			int idEquipo1=Integer.parseInt(request.getParameter("equipoId1"));
			int idEquipo2=Integer.parseInt(request.getParameter("equipoId2"));
			int nroC=Integer.parseInt(request.getParameter("nroC"));
			Validaciones validar= new Validaciones();
			Boolean bandera=true; // para verificar si se puede hacer el alta
			if(validar.VerificarEquiposFecha(idEquipo1,idEquipo2, fecha, hora) && (idEquipo1!=idEquipo2)&& validar.VerificarCanchaDisp(fecha,hora,nroC)) // valida que los partidos no esten jugando ya en esa fecha/hora, que los ids de los equipos no sean iguales y que la cancha este disponible en esa fecha/hora
			{
				Partido p= new Partido();
				PartidoLogic partidoL= new PartidoLogic();
				p.setFecha(fecha);
				p.setHora(hora);
				p.setNumCancha(nroC);
				p.setIdEquipo1(idEquipo1);
				p.setIdEquipo2(idEquipo2);
				partidoL.alta(p);		
				acceso=listar;
			}
			else {				
				acceso=add;		// pensar una forma de mostrar mensaje de error	
			}				
					}
		if(action.equalsIgnoreCase("editar"))
		{
			PartidoLogic partidoL= new PartidoLogic();
			LocalDate fecha= LocalDate.parse(request.getParameter("fecha"));
			System.out.println(fecha);
			LocalTime hora=LocalTime.parse(request.getParameter("hora"));
			int nroC=Integer.parseInt(request.getParameter("nroC"));
			System.out.println(nroC);
			Partido p=partidoL.getOne(fecha, hora, nroC);
			request.setAttribute("partido", p);
			acceso=edit;
		}
		if(action.equalsIgnoreCase("Actualizar"))
		{
			Validaciones validar= new Validaciones();
			LocalDate fecha= LocalDate.parse(request.getParameter("fecha"));
			
			LocalTime hora=LocalTime.parse(request.getParameter("hora"));
			int nroC=Integer.parseInt(request.getParameter("nroC"));
			
			int idEquipo1=Integer.parseInt(request.getParameter("equipo1"));
			int idEquipo2=Integer.parseInt(request.getParameter("equipo2"));
			String resultado=request.getParameter("resultado");
			String incidencias=request.getParameter("incidencias");
			if((idEquipo1!=idEquipo2)&& validar.VerificarEquiposFecha(idEquipo1,idEquipo2,fecha,hora))
			{
				PartidoLogic partidoL=new PartidoLogic();
				Partido p= new Partido();
				p.setFecha(fecha);
				p.setHora(hora);
				p.setIdEquipo1(idEquipo1);
				p.setIdEquipo2(idEquipo2);
				p.setNumCancha(idEquipo2);
				p.setResultado(resultado);
				p.setIncidencias(incidencias);
				p.setNumCancha(nroC);
				partidoL.Modif(p);
				acceso=listar;
				
			}
			else
			{
				acceso=edit;
			}
			
			
		}
		if(action.equalsIgnoreCase("eliminar"))
		{
			LocalDate fecha= LocalDate.parse(request.getParameter("fecha"));
			LocalTime hora=LocalTime.parse(request.getParameter("hora"));
			int nroC=Integer.parseInt(request.getParameter("nroC"));
			PartidoLogic partidoL = new PartidoLogic();
			Partido p = partidoL.getOne(fecha, hora, nroC);
			partidoL.baja(p);
			acceso=listar;								
		}	
	    RequestDispatcher vista=request.getRequestDispatcher(acceso);
		vista.forward(request, response);		
	}

}
