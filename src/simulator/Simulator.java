package simulator;

import simulator.controller.MainViewController;

/**
 * Main class that initializes the MainViewController which controls
 * the state of the simulator.
 */
public class Simulator {

	private static MainViewController mainViewController;

    /**
     * Main method. Initializes all controllers.
     * @param args Command line arguments
     */
	public static void main(String[] args) {
		mainViewController = new MainViewController();
	}

    /**
     * Getter for the MainViewController.
	 * By accessing this controller you are able to control every
	 * aspect of the simulator.
     * @return Instance of MainViewController.
     */
	public static MainViewController getController() {
	    return mainViewController;
    }
}
