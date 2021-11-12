package Logic;

import java.util.LinkedList;

import Data.*;
import Entidades.*;

public class LogicPartido {

	private DataPartido dp;
	
public   LogicPartido()
{
	dp= new DataPartido();
}

public LinkedList<Partido> getAll() 
{
    return dp.getAll();
}

}
