package UI.UI_Console;

import java.util.Scanner;
import Logic.*;


public class Principal {
	  static Logic.LogicEntrenador dtlogic = new Logic.LogicEntrenador();
	public static int menu() {
		int op=0;
		
		Scanner lector =new Scanner(System.in);
		System.out.println("Ingrese la opcion a realizar: ");
		System.out.println("1) Ver DT");
		System.out.println("2) Cargar DT");
		System.out.println("3) Modificar DT");
		System.out.println("4) Terminar");
		op=Integer.parseInt(lector.nextLine());
		return op;
		
	}
	public static void abmc_dt(int op)
	{
		switch(op) {
		case 1: {System.out.println(dtlogic.getAll());} break;
		case 2: {cargar_dt();break;}
		case 3: {modificar_dt();break;}
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
