package simulator;

/**
 * Exception should be thrown when there is an issue
 * with setting or getting a braille cell state.
 *
 * USED INTERNALLY BY SIMULATOR.
 * @author Team 6, EECS 2031
 */
class BrailleCellStateException extends Exception {

    /**
     * Constructor that calls super.
     * @param message Exception message.
     */
    BrailleCellStateException(String message) {
        super (message);
    }

}
