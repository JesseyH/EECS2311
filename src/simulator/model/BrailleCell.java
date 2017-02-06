package simulator.model;

/**
 * Model that holds the state of the pinState on one braille cell.
 * Also allows the modification of pin states.
 */
public class BrailleCell {

    private int id;
    private boolean[] pinState;

    /**
     * Initializes a BrailleCell object with
     * given id and with all pinState down.
     * @param id Id of the braille cell.
     */
    public BrailleCell(int id) {
        this.id = id;
        pinState = new boolean[] {false, false, false, false, false, false, false, false};
        System.out.println("Braille cell model object with id "+ id +" created.");
    }

    /**
     * Gets the ID of the braille cell this object
     * represents.
     * @return The ID of the braille cell.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the pin state on this braille cell to either up or down.
     * @param pin The pin to set.
     * @param up True to set the pin to up, false to set it down.
     * @return If the pin was successfully modified.
     */
    public boolean setPinState(int pin, boolean up) {
        if(pin >= 0 && pin <= pinState.length) {
            pinState[pin] = up;
            return true;
        }
        return false;
    }

    /**
     * Set the pin states boolean array directly.
     * @param pinStates The boolean array containing states of each pin.
     */
    public void setPinStates(boolean[] pinStates) {
        this.pinState = pinStates;
    }

    /**
     * Gets the pin states boolean array storing
     * all states of the pins.
     * @return PinStates boolean array.
     */
    public boolean[] getPinStates() {
        return pinState;
    }

}
