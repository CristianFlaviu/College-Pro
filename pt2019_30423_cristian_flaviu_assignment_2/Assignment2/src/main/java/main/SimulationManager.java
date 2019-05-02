package main;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import gui.GraphicInterface;
import randomgenerator.*;

import structure.*;

public class SimulationManager implements Runnable {

	private static  int timeLimit = 60;
	private static int currentTime = 0;
	private int maxServiceTime = 20;
	private  int minServiceTime = 10;

	private static int minArrivaltime=2;
	private static int maxArrvialTime=5;
	
	private int numberOfServers = 4;
	private int numberOfClientsGenerated=100;
	
	private int numberOfClients = 5;

	private Scheduler aScheduler;
	
	public static int peakValue;
	public static int peakTime;

	public static Boolean runningCondition;
	
	private List<Client> clients;
	Boolean check;
	
	
	public SimulationManager(int minArrivaltime,int maxArrivalTime,int minServiceTime,int maxServiceTime,int LimitTime) {
		
		this.minArrivaltime=minArrivaltime;
		this.maxArrvialTime=maxArrivalTime;
		
		this.minServiceTime=minServiceTime;
		this.maxServiceTime=maxServiceTime;
		peakTime=0;
		peakValue=0;
		
		runningCondition=true;
		
		this.timeLimit=LimitTime;
		
		
		aScheduler = new Scheduler(numberOfServers, numberOfClients);
		clients = new ArrayList<Client>();

		clients = RandomGenerator.generateSomeClients(numberOfClientsGenerated,this.minArrivaltime,this.maxArrvialTime,this.minServiceTime,this.maxServiceTime);

		for(int i=0;i<numberOfServers;i++)
		{
			aScheduler.addServer(new Server(numberOfClients, "Server "+(i+1)));
		}

		for (Client acClient : clients)
		{
			System.out.println("Client:" + acClient.getId() + "   arr:" + acClient.getArrivaltime() + "  service:"
					+ acClient.getServiceTime());
			GraphicInterface.setTextArea1("Client:" + acClient.getId() + "   arr:" + acClient.getArrivaltime() + "  service:"
					+ acClient.getServiceTime()+"\n");
		}
		
	}
	
	

	public void run() {
		
			int aux_peak=0;
		while (currentTime <= timeLimit||runningCondition) {

			aux_peak=0;
			System.out.println("\n-----------time " + currentTime + "----------\n");
			GraphicInterface.setTextArea("\n-----------time " + currentTime + "----------\n\n");
		
		
			for (Client aClient : clients) {
				if (aClient.getArrivaltime() == currentTime) 
				{
					aScheduler.addClient(aClient);
				}

			
			}

		
			for (Server aServer : aScheduler.getServerList()) {
				if (aServer.getServerQueue().peek() != null)

				{aux_peak=aux_peak+aServer.getServerQueue().size();
					if(aServer.getServerQueue().peek().getFinishingTime()==currentTime)
					{
						
						if(aServer.getServerName().contains("1")) {
							
						System.out.println("\nClient " + aServer.getServerQueue().peek().getId() + " finished at server: " +aServer.getServerName()+"\n");
							GraphicInterface.setTextArea("\nClient " + aServer.getServerQueue().peek().getId() + " finished at server: " +aServer.getServerName()+"\n");
							GraphicInterface.aBuilder.delete(0, (""+aServer.getServerQueue().peek().getId()).length()+1);
							GraphicInterface.setLblServer1Q();
							
							}
							else if(aServer.getServerName().contains("2"))
							{System.out.println("\nClient " + aServer.getServerQueue().peek().getId() + " finished at server: " +aServer.getServerName()+"\n");
							GraphicInterface.setTextArea("\nClient " + aServer.getServerQueue().peek().getId() + " finished at server: " +aServer.getServerName()+"\n");
							GraphicInterface.aBuilder2.delete(0, (""+aServer.getServerQueue().peek().getId()).length()+1);
							GraphicInterface.setLblServer2Q();
							
							}
							else if(aServer.getServerName().contains("3"))
							{System.out.println("\nClient " + aServer.getServerQueue().peek().getId() + " finished at server: " +aServer.getServerName()+"\n");
							GraphicInterface.setTextArea("\nClient " + aServer.getServerQueue().peek().getId() + " finished at server: " +aServer.getServerName()+"\n");
							GraphicInterface.aBuilder3.delete(0, (""+aServer.getServerQueue().peek().getId()).length()+1);
							GraphicInterface.setLblServer3Q();
							}
							else if(aServer.getServerName().contains("4"))
							{System.out.println("\nClient " + aServer.getServerQueue().peek().getId() + " finished at server: " +aServer.getServerName()+"\n");
							GraphicInterface.setTextArea("\nClient " + aServer.getServerQueue().peek().getId() + " finished at server: " +aServer.getServerName()+"\n");
							GraphicInterface.aBuilder4.delete(0, (""+aServer.getServerQueue().peek().getId()).length()+1);
							GraphicInterface.setLblServer4Q();
							}
						try {
							aServer.getServerQueue().take();
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
					
					}
					
					
					
					if(aServer.getServerQueue().peek()!=null)
						System.out.println("Id:" + aServer.getServerQueue().peek().getId() +  " finishTime  "+ aServer.getServerQueue().peek().getFinishingTime() + "\n");
				}
				
				
				
			}
			
			if(aux_peak>peakValue)
			{
				peakTime=currentTime;
				peakValue=aux_peak;
				GraphicInterface.setLblPeakTime(peakTime+"");
				GraphicInterface.setLblPeakValue(peakValue+"");
			}
			 check=false;
			for(Server aux_server:aScheduler.getServerList())
			{
				if(!aux_server.getServerQueue().isEmpty())
				{	check=true;
					System.out.println(aux_server.getServerName()+"****************************");
					
					
				}
			}
			System.out.println(check+"");
			if(check==false && currentTime < timeLimit)
			{	
				runningCondition=false;
				
			}
			else
			{
				runningCondition=true;
			}
			if(runningCondition)
			{
				System.out.println("----true------");
			}
			try {
				Thread.sleep(1000);
				currentTime++;
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	//	System.out.println("the peaktime is " + peakTime +" "+peakValue );
		
	}


	public static int getCurrentTime() {
		return currentTime;
	}
	public static int getTimeLimit()
	{
		return timeLimit;
	}
	public static int getMinArrivalTime()
	{
		return minArrivaltime;
	}
	public static int getMaxArrivalTime()
	{
		return maxArrvialTime;
	}
	
	public static int getPeakValue()
	{
		return peakValue;
	}
	public static int getPeakTime()
	{
		return peakTime;
	}
}


