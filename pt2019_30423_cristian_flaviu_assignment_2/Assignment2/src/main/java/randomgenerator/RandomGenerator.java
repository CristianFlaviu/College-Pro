package randomgenerator;

import structure.Client;
import main.*;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class RandomGenerator {
	
	private  static int number=1;
	private static int previousArrival=0;
	
	public  static  Client generate(int minInterval,int maxInterval,int minServiceTime,int maxserviceTime)
	{
		Client aClient =new Client();
		Random rand=new Random();
		
		int arrivalTime=previousArrival+minInterval+rand.nextInt(maxInterval-minInterval+1);
		int serviceTime=minServiceTime+rand.nextInt(maxserviceTime-minServiceTime+1);
		
		previousArrival=arrivalTime;
		
		aClient.setId(number++);
		aClient.setArrivaltime(arrivalTime);
		aClient.setServiceTime(serviceTime);
		aClient.setFinishingTime(0);
		
		return aClient;
	}
	
	public static List<Client> generateSomeClients(int numberOfclients,int minInterval,int maxInterval,int minServiceTime,int maxserviceTime)
	{
		
		List<Client> aList=new ArrayList<Client>();
		
		for(int i=0;i<numberOfclients;i++)
		{
			aList.add(generate( minInterval,maxInterval,minServiceTime,maxserviceTime));
			
		}
		aList.sort( new Compare());
		return aList;
	}
	

}
