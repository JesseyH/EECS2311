package simulator;

/**
 * Exception should be thrown when there is an issue
 * with setting a braille cell state.
 */
class BrailleCellStateException extends Exception{

    /**
     * Constructor that calls super.
     * @param message Exception message.
     */
    BrailleCellStateException(String message) {
        super (message);
    }

}
