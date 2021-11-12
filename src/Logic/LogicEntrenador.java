package Logic;
import java.util.ArrayList;
import java.util.LinkedList;
import Data.*;
import Entidades.*;


public class LogicEntrenador {
	/*private Data.DataEntrenador _DataEntrenador;
	public DataEntrenador GetDataEntrenador(){return this._DataEntrenador;}
	public void SetDataEntrenador(DataEntrenador dataEn){this._DataEntrenador = dataEn;}*/
	
	private DataEntrenador de;
	
	
	
	/* public LinkedList<Entrenador> getListaEntrenadores() {
		return _listaEntrenadores;
	}


	public void setListaEntrenadores(LinkedList<Entrenador> listaEntrenadores) {
		this._listaEntrenadores = listaEntrenadores;
	}*/

	
	public   LogicEntrenador()
     {
		 de= new DataEntrenador();
     }
	


	
 public LinkedList<Entrenador> getAll() 
 {
     return de.getAll();
 }
 public String alta(Entrenador ent) 
 {
	 return de.Alta(ent);
 }
 public String baja(Entrenador ent) 
 {
	 return de.Baja(ent);
 }
 public String modif(Entrenador ent)
 {
	 return de.Modif(ent);
 }

 

public Entrenador EntrenadorLogic() {
	
	return null;
}




}
 
