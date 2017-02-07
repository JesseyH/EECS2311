package simulator;

/**
 * EXAMPLE CLASS
 * This class shows you how you would implement and initialize the simulator.
 */
public class SimulatorInitializationExample {

    /**
     * Main method where the simulator's controller is initialized by calling
     * the Initialize() method and passing in the action listener for button events.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        SimulatorActionListenerExample simulatorActionListenerExample = new SimulatorActionListenerExample();
        MainViewController.initialize(simulatorActionListenerExample);
    }
}
