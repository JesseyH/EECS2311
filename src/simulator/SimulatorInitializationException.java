package simulator;

/**
 * Exception that should be thrown when there are issues with the simulators
 * initial initialization.
 */
public class SimulatorInitializationException extends Exception {

    /**
     * Constructor passes exception message to super.
     * @param message Exception message.
     */
    SimulatorInitializationException(String message) {
        super(message);
    }

}
