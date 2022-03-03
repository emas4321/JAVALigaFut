package Logic;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import Entidades.Arbitro;
import Entidades.Entrenador;
import Entidades.Equipo;
import Entidades.Partido;
import Data.DataEquipo;
import Logic.EntrenadorLogic;


/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	String listar = "Equipo-Listar.jsp";
	String add="Equipo-Add.jsp";
	String modif="Equipo-Modif.jsp";
	String edit="Equipo-Edit.jsp";
	String PartidoListar="Partido_Listar.jsp";
	String asignaArbitro="AsignarArbitro";
	Equipo e = new Equipo();
	
	private static final long serialVersionUID = 1L;
    public Controlador() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acceso="";
		String action=request.getParameter("accion");
		if(action.equalsIgnoreCase("listar")) {
			preparalist(request, response);
			acceso=listar;
		}
		else if(action.equalsIgnoreCase("add")) {
			preparalistE(request, response);
			acceso=add;
		}
		else if(action.equalsIgnoreCase("agregar")) {
			String id=request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String localidad = request.getParameter("localidad");
			String	puntaje = request.getParameter("puntaje");
			String difGol = request.getParameter("difGol");
			EntrenadorLogic entrenadorL=new EntrenadorLogic();
			int dni= Integer.parseInt(request.getParameter("EntrenadorDni"));
			Entrenador entrenador=entrenadorL.getOne(dni);
			e.setIdEquipo(Integer.parseInt(id));
			e.setNombre(nombre);
			e.setLocalidad(localidad);
			e.setPuntaje(Integer.parseInt(puntaje));
			e.setDifGoles(Integer.parseInt(difGol));
			entrenador.setIdEquipo(e.getIdEquipo());					
			if(DataEquipo.alta(e)) {
				preparalist(request, response);
				entrenadorL.Modif(entrenador);
				acceso=listar;
			} else {
				request.setAttribute("msg", "No se pudo cargar Equipo Vuelva a intentarlo");
				RequestDispatcher rd= request.getRequestDispatcher("Equipo-Add.jsp");
				rd.forward(request, response);
			}
			
		}
		else if(action.equalsIgnoreCase("modif")) {
			DataEquipo equipo = new DataEquipo();
			LinkedList<Equipo> list = equipo.getall();
			request.getSession().setAttribute("lista", list);
			acceso=modif;
		}
		else if(action.equalsIgnoreCase("editar")) {
			int id=Integer.parseInt((String) request.getParameter("id"));
			DataEquipo dEqui= new DataEquipo();
			Equipo e=(Equipo)dEqui.getOne(id);
			request.setAttribute("equipo", e);
			acceso=edit;
		}
		else if(action.equalsIgnoreCase("Actualizar")) {
			int id=Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("nombre");
			String localidad = request.getParameter("localidad");
			String	puntaje = request.getParameter("puntaje");
			String difGol = request.getParameter("difGol");
		
			
			
			e.setIdEquipo(id);
			e.setNombre(nombre);
			e.setLocalidad(localidad);
			e.setPuntaje(Integer.parseInt(puntaje));
			e.setDifGoles(Integer.parseInt(difGol));
			DataEquipo.modif(e);
			preparalist(request, response);
			acceso=listar;
		}
		else if(action.equalsIgnoreCase("eliminar")) {
			int id=Integer.parseInt(request.getParameter("id"));
			e.setIdEquipo(id);
			EntrenadorLogic entrenadorL= new EntrenadorLogic();
			LinkedList<Entrenador> listaEntrenador= new LinkedList<>();
			listaEntrenador=entrenadorL.getAll();
			Boolean Disp=true;
			Entrenador entrenadorConEquipo= new Entrenador();
			for(Entrenador entrenador: listaEntrenador)
			{
				if(entrenador.getIdEquipo()==e.getIdEquipo())
				{
					Disp=false;
					entrenadorConEquipo=entrenador;
				}
					
			}
			if(Disp)
			{
				DataEquipo.baja(e);	
			}
			else
			{
				entrenadorL.baja(entrenadorConEquipo);
				DataEquipo.baja(e);
			}
			preparalist(request, response);
			acceso=listar;
		}					
		RequestDispatcher vista=request.getRequestDispatcher(acceso);
		vista.forward(request, response);		
	}


private void preparalist(HttpServletRequest request, HttpServletResponse response) {
		DataEquipo equipo = new DataEquipo();
		LinkedList<Equipo> list = equipo.getall();
		request.getSession().setAttribute("lista", list);
	}


private void preparalistE(HttpServletRequest request, HttpServletResponse response) {
	EntrenadorLogic entrenadorL= new EntrenadorLogic();
	LinkedList<Entrenador> listE = entrenadorL.getAll();
	LinkedList<Entrenador>listEDisp=new LinkedList<>();
	for(Entrenador e:listE)
	{
		if(e.getIdEquipo()==0) // habia otro metodo para comparar si un string era nulo en una de las primeras clases de meca
			listEDisp.add(e);
	}
	request.getSession().setAttribute("listaE", listEDisp); // muestra los partidos que no tengan resultado
}
}
