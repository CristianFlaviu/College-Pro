package randomgenerator;

import java.util.Comparator;

import structure.Client;

public class Compare implements Comparator<Client>{

	public int compare(Client arg0, Client arg1) {
		
		
		return arg0.getArrivaltime()-arg1.getArrivaltime();
	}

	
	
}
