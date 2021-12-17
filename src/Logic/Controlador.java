package Logic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import Entidades.Equipo;
import Data.DataEquipo;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	String listar = "Equipo-Listar.jsp";
	String add="Equipo-Add.jsp";
	String modif="Equipo-Modif.jsp";
	String edit="Equipo-Edit.jsp";
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
			acceso=listar;
		}
		else if(action.equalsIgnoreCase("add")) {
			acceso=add;
		}
		else if(action.equalsIgnoreCase("agregar")) {
			String id=request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String localidad = request.getParameter("localidad");
			String	puntaje = request.getParameter("puntaje");
			String difGol = request.getParameter("difGol");
			e.setIdEquipo(Integer.parseInt(id));
			e.setNombre(nombre);
			e.setLocalidad(localidad);
			e.setPuntaje(Integer.parseInt(puntaje));
			e.setDifGoles(Integer.parseInt(difGol));
			if(DataEquipo.alta(e)) {
				acceso=listar;
			} else {
				request.setAttribute("msg", "No se pudo cargar Equipo Vuelva a intentarlo");
				RequestDispatcher rd= request.getRequestDispatcher("Equipo-Add.jsp");
				rd.forward(request, response);
			}
			
		}
		else if(action.equalsIgnoreCase("modif")) {
			acceso=modif;
		}
		else if(action.equalsIgnoreCase("editar")) {
			request.setAttribute("idEqui", request.getParameter("id"));
			acceso=edit;
		}
		else if(action.equalsIgnoreCase("Actualizar")) {
			int id=Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("nombre");
			String localidad = request.getParameter("localidad");
			String	puntaje = request.getParameter("puntaje");
			String difGol = request.getParameter("difGol");
			
			System.out.println(id +nombre + localidad + puntaje + difGol );
			
			
			e.setIdEquipo(id);
			e.setNombre(nombre);
			e.setLocalidad(localidad);
			e.setPuntaje(Integer.parseInt(puntaje));
			e.setDifGoles(Integer.parseInt(difGol));
			DataEquipo.modif(e);
			acceso=listar;
		}
		else if(action.equalsIgnoreCase("eliminar")) {
			int id=Integer.parseInt(request.getParameter("id"));
			e.setIdEquipo(id);
			DataEquipo.baja(e);
			acceso=listar;
		}
		RequestDispatcher vista=request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

}
