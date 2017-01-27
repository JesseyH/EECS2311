package simulator;



import java.awt.event.ActionListener;

import simulator.controller.MainViewController;

/**
 * Main class that initializes the MainViewController which controls
 * the state of the simulator.
 */
public class Simulator{
	//private static PlayerSimulator player = new PlayerSimulator();
	private static MainViewController controller;
	
    /**
     * Main method. Initializes all controllers.
     * @param args Command line arguments
     */
	public static void main(String[] args, ActionListener player) {
		controller = new MainViewController(player);
		//player.setController(controller);
		controller.setBrailleCellState(0, BrailleConvert.E.getPinStates());
		controller.setBrailleCellState(1, BrailleConvert.E.getPinStates());
		controller.setBrailleCellState(2, BrailleConvert.C.getPinStates());
		controller.setBrailleCellState(3, BrailleConvert.S.getPinStates());
		
	}

    /**
     * Getter for the MainViewController.
	 * By accessing this controller you are able to control every
	 * aspect of the simulator.
     * @return Instance of MainViewController.
     */
	public static MainViewController getController() {
	    return controller;
    }
	
	
}
