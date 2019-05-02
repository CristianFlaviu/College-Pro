package structure;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import gui.GraphicInterface;
import main.SimulationManager;

public class Server implements Runnable {
	private AtomicInteger totalServiceTime;
	private String serverName;
	private int watingTime;
	private int serviceTime;
	private int emptyService;
	private int nrClients;
	private BlockingQueue<Client> casaDeMarcat;

	public Server(int maxNumberOfClients, String name) {
		totalServiceTime = new AtomicInteger(0);
		totalServiceTime.set(0);
		watingTime = 0;
		nrClients=0;
		emptyService = 0;
		serverName = name;
		casaDeMarcat = new ArrayBlockingQueue<Client>(maxNumberOfClients);
	}

	public int getAverageWaitingTime() {
		if(nrClients>0)
			return watingTime/nrClients;
	return 0;
	}


	public int getAverageServiceTime() {
		
		if(nrClients>0)
				return serviceTime/nrClients;
		return 0;
	}

	

	public int getAverageEmptyServer() {
		return emptyService/nrClients;
	}

	
	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public void addClient(Client aClient) {
		casaDeMarcat.add(aClient);
		totalServiceTime.set(totalServiceTime.get() + aClient.getServiceTime());

		aClient.setFinishingTime(totalServiceTime.get() + SimulationManager.getCurrentTime());
		aClient.setWatingTime(totalServiceTime.get());
		serviceTime = serviceTime + aClient.getServiceTime();
		watingTime = watingTime + aClient.getWatingTime();
		nrClients++;

	}

	public int getTotalServiceTime() {

		return totalServiceTime.get();

	}

	public BlockingQueue<Client> getServerQueue() {
		return casaDeMarcat;
	}

	public void run() {

		while (SimulationManager.getCurrentTime() <= SimulationManager.getTimeLimit()) {
			try {

				if (casaDeMarcat.size() > 0)
					totalServiceTime.set(totalServiceTime.get() - 1);

				else {
					emptyService++;
				}

				if(serverName.contains("1"))
				{
					GraphicInterface.setLblServer1Time(totalServiceTime+"");
					GraphicInterface.setEMptyServer1(emptyService+"");
					GraphicInterface.setServTime1(""+getAverageServiceTime());
					GraphicInterface.setWaitingTime1(""+getAverageWaitingTime());
				}
				if(serverName.contains("2"))
				{
					GraphicInterface.setLblServer2Time(totalServiceTime+"");
					GraphicInterface.setEMptyServer2(emptyService+"");
					GraphicInterface.setServTime2(""+getAverageServiceTime());
					GraphicInterface.setWaitingTime2(""+getAverageWaitingTime());
				}
				if(serverName.contains("3"))
				{
					GraphicInterface.setLblServer3Time(totalServiceTime+"");
					GraphicInterface.setEMptyServer3(emptyService+"");
					GraphicInterface.setServTime3(""+getAverageServiceTime());
					GraphicInterface.setWaitingTime3(""+getAverageWaitingTime());
				}
				if(serverName.contains("4"))
				{
					GraphicInterface.setLblServer4time(totalServiceTime+"");
					GraphicInterface.setEMptyServer4(emptyService+"");
					GraphicInterface.setServTime4(""+getAverageServiceTime());
					GraphicInterface.setWaitingTime4(""+getAverageWaitingTime());
				}
				Thread.sleep(1000);
			}

			catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

	}

}
