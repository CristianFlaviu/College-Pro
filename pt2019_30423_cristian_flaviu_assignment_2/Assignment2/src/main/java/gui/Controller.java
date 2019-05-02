package gui;

import main.*;

public class Controller {

	GraphicInterface aGraphicInterface = new GraphicInterface();

	public Controller() {
		initializeButtons();
	}

	public void initializeButtons() {
		aGraphicInterface.setSaveBtnActionListener(e -> {
			int maxServicetime = 0;
			int minServiceTime = 0;
			int minArrtime = 0;
			int maxArrtime = 0;
			int timeLimit = 0;

			maxServicetime = Integer.parseInt(aGraphicInterface.getMaxServiceTimetextField().getText());
			minServiceTime = Integer.parseInt(aGraphicInterface.getMinServiceTimeTextField().getText());

			minArrtime = Integer.parseInt(aGraphicInterface.getMinArrTimeTextField().getText());
			maxArrtime = Integer.parseInt(aGraphicInterface.getMaxArrTimetextField().getText());

			timeLimit = Integer.parseInt(aGraphicInterface.getSimulationIntervaltextField().getText());

			SimulationManager aManager = new SimulationManager(minArrtime, maxArrtime, minServiceTime, maxServicetime,
					timeLimit);

			Thread aThread = new Thread(aManager);
			aThread.start();
		});
	}

}
