package simulator;

/**
 * Model that holds the states of all eight pins on one braille cell.
 * Each braille cell that exists on the screen will have a corresponding
 * BrailleCell model instance.
 *
 * USED INTERNALLY BY SIMULATOR.
 * @author Team 6, EECS 2031
 */
class BrailleCell {

    /**
     * pinStates boolean array that stores the states of each pin.
     */
    private boolean[] pinStates;

    /**
     * Initializes a BrailleCell instance with
     * all pins initially down.
     */
    BrailleCell() {
        pinStates = new boolean[] {false, false, false, false, false, false, false, false};
    }

    /**
     * Set the pin states boolean array directly.
     * @param pinStates The boolean array containing states of each pin.
     */
    void setPinStates(boolean[] pinStates) {
        this.pinStates = pinStates;
    }

    /**
     * Gets the pin states boolean array storing
     * all states of the pins.
     * @return PinStates boolean array.
     */
    boolean[] getPinStates() {
        return pinStates;
    }

}
