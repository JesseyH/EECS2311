package simulator.exceptions;

/**
 * Exception should be thrown when there is an issue
 * with setting a braille cell state.
 */
public class SetBrailleCellStateException extends Exception{

    /**
     * Constructor that calls super.
     * @param message Exception message.
     */
    public SetBrailleCellStateException(String message) {
        super (message);
    }

}
