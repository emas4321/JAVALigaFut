package Logic;
import java.util.ArrayList;
import java.util.LinkedList;
import Data.DataEntrenador;
import Entidades.Entrenador;

public class LogicEntrenador {
	private Data.DataEntrenador _DataEntrenador;
	public DataEntrenador GetDataEntrenador(){return this._DataEntrenador;}
	public void SetDataEntrenador(DataEntrenador dataEn){this._DataEntrenador = dataEn;}
	private LinkedList<Entrenador> _listaEntrenadores= new LinkedList<>();
	
	 public LinkedList<Entrenador> getListaEntrenadores() {
		return _listaEntrenadores;
	}


	public void setListaEntrenadores(LinkedList<Entrenador> listaEntrenadores) {
		this._listaEntrenadores = listaEntrenadores;
	}

	
	public void EntrenadorLogic()
     {
     this._DataEntrenador= new DataEntrenador();
     }



 
 
 public LinkedList<Entrenador> GetAll() 
 {
     return this._DataEntrenador.GetAll();
 }

 public Entrenador GetOne(int id)
 {
     return DataEntrenador.GetOne(id);
 }

 public void Delete(int id)
 {
     this._DataEntrenador.Delete(id);
 }

/* public void Save(Usuario usr)
 {
     this.DataEntrenador.SaveChanges(usr);
 }*/

}
