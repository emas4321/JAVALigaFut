package UI.UI_Console;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Entidades.*;
import Logic.*;


public class Principal {
	  static Logic.LogicEntrenador dtlogic = new Logic.LogicEntrenador();
	
	  public static int menu() {
		int op=0;
		
		Scanner lector = new Scanner(System.in);
		System.out.println("Ingrese la opcion a realizar: ");
		System.out.println("1) Ver DT");
		System.out.println("2) Cargar DT");
		System.out.println("3) Modificar DT");
		System.out.println("4) Borrar DT");
		op=Integer.parseInt(lector.nextLine());
		Entrenador e = dtlogic.EntrenadorLogic();
		return op;
		
	}
	public static void abmc_dt(int op)
	{
		 
		String dateFormat = "dd/MM/yyyy";
		Scanner lector = new Scanner(System.in);
		switch(op) {
		case 1: {System.out.println(dtlogic.getAll());} break;
		case 2: {
					Entrenador ent = new Entrenador();
					System.out.println("ingrese documento del entrenador");
					ent.setDni(Integer.parseInt(lector.nextLine()));
					System.out.println("ingrese nombre");
					ent.setNombre(lector.nextLine());
					System.out.println("ingrese apellido");
					ent.setApellido(lector.nextLine());
					System.out.println("ingrese la fecha de nacimiento");
					 DateTimeFormatter dFormat = DateTimeFormatter.ofPattern(dateFormat);
					 ent.setFecha_nacimiento(LocalDate.parse(lector.nextLine(),dFormat));
					 
					System.out.println("se ha eliminado de la BD a la persona"+dtlogic.alta(ent));break;}
		case 3: {modificar_dt();break;}
		case 4: {
					Entrenador ent = new Entrenador();
					System.out.println("ingrese documento de la persona para eliminarla de la BD");
					ent.setDni(Integer.parseInt(lector.nextLine()));
					System.out.println("se ha eliminado de la BD a la persona"+dtlogic.baja(ent));break;}
		default:{System.out.println("opcion no valida.\n");}
		
		}
		
	}
	/*public static void listar_dt()
	{
		EntrenadorLogic dtLogic= new EntrenadorLogic();
		dt_list=dtLogic.getAll();
		mostrar_dt(dt_list);
		
	}*/
	public static void  cargar_dt()
	{}
	public static void modificar_dt()
	{}

	public static void main(String[] args) {
		int opcion=0;
		while(opcion!=4 ) {
			opcion=menu();
			abmc_dt(opcion);
			}
				

	}

}
