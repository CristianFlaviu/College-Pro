package structure;



import java.util.ArrayList;
import java.util.List;

import gui.GraphicInterface;
import main.SimulationManager;


public class Scheduler {

	List <Server> shop;
	
	private int maxNumberOfServers;
	private int maxNumberOfClients;
	

	public Scheduler(int maxNumberOfServers, int maxNumberOfClients) {
	
	
		this.maxNumberOfClients=maxNumberOfClients;
		this.maxNumberOfServers=maxNumberOfServers;
		shop=new ArrayList<Server>();	
		
	}
	
	public List<Server> getServerList()
	{
		return shop;
	}
	
	
	public void  addServer(Server server)
	{
		if(shop.size()<maxNumberOfServers)
			{shop.add(server);	
			Thread aThread=new Thread(server);
			aThread.start();
			}
			
		else
			System.out.println("to many servers");
	}
	
	public void addClient(Client aClient )
	{
		Server auxServer=new Server(100,"a");
		int minimalTime=10000;
	
		for(Server aServer:shop)
		{	
			if(aServer.getTotalServiceTime()<minimalTime && aServer.getServerQueue().size() <maxNumberOfClients )
			{
				auxServer=aServer;
				minimalTime=aServer.getTotalServiceTime();
				
			
				
			}
			
		}
		
if(SimulationManager.getCurrentTime() <= SimulationManager.getTimeLimit())
{
			auxServer.addClient(aClient);
	if(auxServer.getServerName().contains("1"))
	{
		GraphicInterface.aBuilder.append(aClient.getId() +" ");
		GraphicInterface.setLblServer1Q();
	}
	else if(auxServer.getServerName().contains("2"))
	{
		GraphicInterface.aBuilder2.append(aClient.getId() +" ");
		GraphicInterface.setLblServer2Q();
	}
	else if(auxServer.getServerName().contains("3"))
	{
		GraphicInterface.aBuilder3.append(aClient.getId() +" ");
		GraphicInterface.setLblServer3Q();
	}
	else if(auxServer.getServerName().contains("4"))
	{
		GraphicInterface.aBuilder4.append(aClient.getId() +" ");
		GraphicInterface.setLblServer4Q();
	}
	System.out.println("client "+aClient.getId()+" ---- " +auxServer.getServerName()+"--finish at "+aClient.getFinishingTime());
	GraphicInterface.setTextArea("client "+aClient.getId()+" added to " +auxServer.getServerName()+"  finish at "+aClient.getFinishingTime());
	}
}
}
