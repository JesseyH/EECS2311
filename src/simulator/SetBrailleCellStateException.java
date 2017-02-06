package simulator;

/**
 * Exception should be thrown when there is an issue
 * with setting a braille cell state.
 */
class SetBrailleCellStateException extends Exception{

    /**
     * Constructor that calls super.
     * @param message Exception message.
     */
    SetBrailleCellStateException(String message) {
        super (message);
    }

}
