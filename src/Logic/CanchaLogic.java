package Logic;

import java.util.LinkedList;

import Data.DataCancha;
import Entidades.Cancha;

public class CanchaLogic {
	private DataCancha dCancha;
	public CanchaLogic()
	{
		dCancha= new DataCancha();
	}

	public LinkedList<Cancha> getAll () {
		return dCancha.getall();
	}

}
