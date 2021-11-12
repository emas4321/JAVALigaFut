package Logic;

import java.util.LinkedList;

import Data.DataCancha;
import Data.*;
import Entidades.*;


public class LogicCancha {

	private DataCancha dc;
	
	
	public   LogicCancha()
    {
		 dc= new DataCancha();
    }
	
	public LinkedList<Cancha> getAll() 
	 {
	     return dc.getAll();
	 }

	public String alta(Cancha can) 
	 {
		 return dc.Alta(can);
	 }
	
	public String baja(Cancha can) 
	 {
		 return dc.Baja(can);
	 }

	 public int modif(Cancha can)
	 {
		 return dc.Modif(can);
	 }

	 public Cancha CanchaLogic() {
			
			return null;
		}
}
