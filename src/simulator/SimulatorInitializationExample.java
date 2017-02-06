package simulator;

/**
 * EXAMPLE CLASS
 * This class shows you how you would implement and initialize the simulator.
 */
public class SimulatorInitializationExample {

    public static void main(String[] args) {
        SimulatorActionListenerExample simulatorActionListenerExample = new SimulatorActionListenerExample();
        MainViewController.initialize(simulatorActionListenerExample);
    }
}
