package Logic;

import Data.DataArbitro;
import Entidades.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class LogicArbitro {
	private DataArbitro da;
	
	public LogicArbitro() {
		da =new DataArbitro();
	}

	public LinkedList<Arbitro> getAllArbitro()
	 {
		 return da.getAll();
	 }
	public String alta(Arbitro a)
	{
		return da.Alta(a);
	}
	public String baja(Arbitro a)
	{
		return da.Baja(a);
	}
	public String modif(Arbitro a)
	{
		return da.Modif(a);
	}

	public Arbitro ArbitroLogic()
	{
		return null;
	}
	

}

