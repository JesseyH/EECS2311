package simulator;

import simulator.controller.MainViewController;

/**
 * Main class that initializes all controllers and provides
 * getters for each controller.
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
     * @return Instance of MainViewController.
     */
	public static MainViewController getMainViewController() {
	    return mainViewController;
    }
}
