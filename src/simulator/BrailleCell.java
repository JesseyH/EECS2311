package simulator;

/**
 * Model that holds the state of the pinState on one braille cell.
 * Also allows the modification of pin states.
 */
class BrailleCell {

    private int id;
    private boolean[] pinState;

    /**
     * Initializes a BrailleCell object with
     * given id and with all pinState down.
     * @param id Id of the braille cell.
     */
    BrailleCell(int id) {
        this.id = id;
        pinState = new boolean[] {false, false, false, false, false, false, false, false};
        System.out.println("Braille cell model object with id "+ id +" created.");
    }

    /**
     * Set the pin states boolean array directly.
     * @param pinStates The boolean array containing states of each pin.
     */
    void setPinStates(boolean[] pinStates) {
        this.pinState = pinStates;
    }

    /**
     * Gets the pin states boolean array storing
     * all states of the pins.
     * @return PinStates boolean array.
     */
    boolean[] getPinStates() {
        return pinState;
    }

}
