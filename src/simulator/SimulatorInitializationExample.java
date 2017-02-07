package simulator;

/**
 * EXAMPLE CLASS
 * This class shows you how you would implement and initialize the simulator.
 *
 * @author Team 6, EECS 2031
 */
public class SimulatorInitializationExample {

    /**
     * Recommended static variable to store the controller instance for later use.
     * This prevents frequent calls to MainViewController.getController();.
     */
    private static MainViewController controller;

    /**
     * Main method where the simulator's controller is initialized by calling
     * the Initialize() method and passing in the action listener for button events.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // Construct your ActionListener implementation.
        SimulatorActionListenerExample simulatorActionListenerExample = new SimulatorActionListenerExample();

        // Initialize the MainViewController by calling the initialize method and passing the action listener above.
        // Also set the controller variable to hold reference. to the newly intialized controller.
       	controller = MainViewController.initialize(simulatorActionListenerExample);
	}
 }

