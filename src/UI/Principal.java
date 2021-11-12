package UI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Entidades.*;
import Logic.*;

/*Entrenador e = dtlogic.EntrenadorLogic();
		Arbitro a = arbLogic.ArbitroLogic();
		dentro del menu si tira error algo*/

public class Principal {
	   static LogicEntrenador dtlogic = new Logic.LogicEntrenador();
	   static LogicArbitro arbLogic = new Logic.LogicArbitro();
	   static LogicCancha canLogic = new Logic.LogicCancha();
	   static LogicPartido parLogic = new Logic.LogicPartido();
	  
	  
public static void main(String[] args) 
{
	int opcion=0;
	while(opcion!=5 ) {
	menuPrincipal();
						}
}
	   
	   
	   
	   public static void menuPrincipal() {
			int op=0;
			
			Scanner lector = new Scanner(System.in);
			System.out.println("Ingrese la opcion a realizar: ");
			System.out.println("1) ABM Arbitro");
			System.out.println("2) ABM Entrenador");
			System.out.println("3) ABM Cancha");
			System.out.println("4) ABMC Partido");
			System.out.println("5) Salir");
			op=Integer.parseInt(lector.nextLine());
			
			switch(op) {
			case 1: abmc_Arbitro(); break;
			
			case 2: abmc_dt(); break; 
			
			case 3: abmc_Cancha(); break;
			
			case 4: abmc_partido(); break;
			}
		
	   }
	public static void menu() {
		System.out.println("Ingrese la opcion a realizar: ");
		System.out.println("1) Ver todos");
		System.out.println("2) Cargar ");
		System.out.println("3) Modificar ");
		System.out.println("4) Borrar ");
		
	}
	 
	public static void abmc_Cancha()
	{
		int opt;
		Scanner lector = new Scanner(System.in);
		
		menu();
		opt=Integer.parseInt(lector.nextLine());
		switch(opt) {
		case 1: {System.out.println(canLogic.getAll());} break;
		
		case 2: {
					Cancha can = new Cancha();
					System.out.println("ingrese numero de cancha");
					can.setNroCancha(Integer.parseInt(lector.nextLine()));
					System.out.println("ingrese nombre");
					can.setNombre(lector.nextLine());
					System.out.println(""+canLogic.alta(can)+"ha sido agregada");
				}break;
		
		case 3: {
					Cancha c = new Cancha();
					System.out.println("ingrese numero de cancha");
					c.setNroCancha(Integer.parseInt(lector.nextLine()));
					System.out.println("ingrese nombre");
					c.setNombre(lector.nextLine()); 
					System.out.println("se ha actualizado el nombre del estadio numero:"+canLogic.modif(c)+"");
				}break;
	
		case 4: {
					Cancha c = new Cancha();
					System.out.println("ingrese numero de cancha");
					c.setNroCancha(Integer.parseInt(lector.nextLine()));
					System.out.println("la cancha numero:"+c.getNroCancha()+ "sido eliminada de la BD "+canLogic.baja(c));
				}break;
				
		}
	}
	
	public 
	
static void abmc_partido()
{
		int opt;
		Scanner lector = new Scanner(System.in);
		
		menu();
		opt=Integer.parseInt(lector.nextLine());
		switch(opt) {
		case 1: {System.out.println(parLogic.getAll());} break;}

}

		
public static void abmc_Arbitro()

		{
			int opt;
	
			String dateFormat = "dd/MM/yyyy";
			Scanner lector = new Scanner(System.in);
			
			menu();
			opt=Integer.parseInt(lector.nextLine());
			switch(opt) {
			case 1: {System.out.println(arbLogic.getAllArbitro());} break;
			
			case 2: {
						Arbitro arb = new Arbitro();
						System.out.println("ingrese documento del Arbitro");
						arb.setDni(Integer.parseInt(lector.nextLine()));
						System.out.println("ingrese nombre");
						arb.setNombre(lector.nextLine());
						System.out.println("ingrese apellido");
						arb.setApellido(lector.nextLine());
						System.out.println("ingrese la fecha de nacimiento (dd/mm/yyyy)");
						 DateTimeFormatter dFormat = DateTimeFormatter.ofPattern(dateFormat);
						 arb.setFecha_nacimiento(LocalDate.parse(lector.nextLine(),dFormat));
						 System.out.println(""+arbLogic.alta(arb)+"ha sido añadido a la BD");break;}
			
			case 3: {
						Arbitro arb = new Arbitro();
						System.out.println("ingrese documento del Arbitro");
						arb.setDni(Integer.parseInt(lector.nextLine()));
						System.out.println("ingrese nombre");
						arb.setNombre(lector.nextLine());
						System.out.println("ingrese apellido");
						arb.setApellido(lector.nextLine());
						System.out.println("ingrese la fecha de nacimiento (dd/mm/yyyy)");
						DateTimeFormatter dFormat = DateTimeFormatter.ofPattern(dateFormat);
						arb.setFecha_nacimiento(LocalDate.parse(lector.nextLine(),dFormat));
						System.out.println("se ha actualizado los datos de: "+arbLogic.modif(arb)+"");break;}
			
			case 4: {
						Arbitro arb = new Arbitro();
						System.out.println("ingrese documento de la persona para eliminarla de la BD");
						arb.setDni(Integer.parseInt(lector.nextLine()));
						System.out.println(arbLogic.baja(arb)+"El Arbitro de dni:"+arb.getDni()+" fue eliminado de la BD");break;}
			
			case 5: {System.out.println("Saliendo...");}
			
			default:{System.out.println("opcion no valida.\n");}
			
			}
			
		}
	  public static void abmc_dt()
	{
		 int opt;
		String dateFormat = "dd/MM/yyyy";
		Scanner lector = new Scanner(System.in);
		menu();
		opt=Integer.parseInt(lector.nextLine());
		switch(opt) {
		case 1: {System.out.println(dtlogic.getAll());} break;
		
		case 2: {
					Entrenador ent = new Entrenador();
					int equi;
					System.out.println("ingrese documento del entrenador");
					ent.setDni(Integer.parseInt(lector.nextLine()));
					System.out.println("ingrese nombre");
					ent.setNombre(lector.nextLine());
					System.out.println("ingrese apellido");
					ent.setApellido(lector.nextLine());
					System.out.println("ingrese la fecha de nacimiento (dd/mm/yyyy)");
					 DateTimeFormatter dFormat = DateTimeFormatter.ofPattern(dateFormat);
					 ent.setFecha_nacimiento(LocalDate.parse(lector.nextLine(),dFormat));
					 System.out.println("ingresar codigo del equipo que dirige actualmente");
					 ent.setEquipo().setIdEquipo(Integer.parseInt(lector.nextLine()));
					 System.out.println(""+dtlogic.alta(ent)+"ha sido añadido a la BD");break;}
		
		case 3: {
					Entrenador ent = new Entrenador();
					System.out.println("ingrese documento del entrenador");
					ent.setDni(Integer.parseInt(lector.nextLine()));
					System.out.println("ingrese nombre");
					ent.setNombre(lector.nextLine());
					System.out.println("ingrese apellido");
					ent.setApellido(lector.nextLine());
					System.out.println("ingrese la fecha de nacimiento (dd/mm/yyyy)");
					DateTimeFormatter dFormat = DateTimeFormatter.ofPattern(dateFormat);
					ent.setFecha_nacimiento(LocalDate.parse(lector.nextLine(),dFormat));
					System.out.println("se ha actualizado los datos de: "+dtlogic.modif(ent)+"");break;}
		
		case 4: {
					Entrenador ent = new Entrenador();
					System.out.println("ingrese documento de la persona para eliminarla de la BD");
					ent.setDni(Integer.parseInt(lector.nextLine()));
					System.out.println(dtlogic.baja(ent)+"El entrenador de dni:"+ent.getDni()+" fue eliminado de la BD");break;}
		
		case 5: {System.out.println("Saliendo...");}
		
		default:{System.out.println("opcion no valida.\n");}
		
		}
		
	}
	
	
	

	

}
