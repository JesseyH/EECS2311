package simulator;

/**
 * Exception that should be thrown when there are issues with the simulators' initialization.
 *
 * USED INTERNALLY BY SIMULATOR.
 * @author Team 6, EECS 2031
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
