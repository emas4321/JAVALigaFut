package Logic;

import java.util.LinkedList;

import Data.DataArbitro;
import Entidades.Arbitro;
import Entidades.Cancha;

public class ArbitroLogic {
	private DataArbitro dArbitro;
	public ArbitroLogic()
	{
		dArbitro= new DataArbitro();
	}

	public LinkedList<Arbitro> getAll () {
		return dArbitro.getall();
	}

}
