package simulator;

import java.awt.event.ActionListener;

/**
 * This controller can be used to control any aspect of the simulator.
 *
 * Use MainViewController.initialize() to initialize the simulator
 * and also obtain an instance of the controller used to control the simulator.
 * For every other time you require access to the controller, use MainViewController.getController();
 *
 * SEE EXAMPLES: SimulatorInitializationExample and SimulatorActionListenerExample
 */
public class MainViewController {

    /**
     * Instance variables.
     */
    private static MainViewController mainViewController;
	private MainView view;

    /**
     * Player should call this ONCE to initialize the simulator.
     * The player should also pass an ActionListener so that the player may
     * control what happens when a button on the simulator is pressed.
     *
     * @param listener The ActionListener to bind to simulator buttons.
     * @return The simulator API, which is an instance of MainViewController.
     */
    public static MainViewController initialize(ActionListener listener) {
        mainViewController = new MainViewController(listener);
        return mainViewController;
    }

    /**
     * Getter for the controller.
     * This method can be used to obtain refrence to the simulator controller in use.
     * The controller can be used to control every aspect of the simulator.

     * @return The singleton instance of MainViewController.
     * @throws SimulatorInitializationException Thrown when the initialize() method has not been called before using this.
     */
    public static MainViewController getController() throws SimulatorInitializationException{
        if(mainViewController == null) {
                throw new SimulatorInitializationException("SimulatorActionListenerExample has not been initialized! Please call initialize() method.");
        }
        return mainViewController;
    }

    /**
     * Constructor for the MainViewController that initializes the view
     * with the amount of braille cells and buttons specified in Settings.
     * @param listener
     */
	private MainViewController(ActionListener listener) {
        view = new MainView(this, listener);
        view.makeCells(Settings.NUM_OF_CELLS);
        view.makeButtons(Settings.NUM_OF_BUTTONS);
        view.drawView();
    }

    /**
     * Returns how many braille cells have been initialized on the view.
     * @return Integer number representing how many braille cells there are.
     */
    public int getAmtOfBrailleCells() {
        return view.getAmtOfBrailleCells();
    }

    /**
     * Gets the pinStates boolean array containing the values
     * of every pin for the braille cell with the given ID.
     *
     * ID's of braille cells ALWAYS range from: [ 0 ] to [ getAmtOfBrailleCells() - 1 ]
     *
     * @param id The ID Of the braille cell.
     * @return The pinStates boolean array or NULL if the ID passed
     * is not being used by any braille cell.
     */
	public boolean[] getBrailleCellState(int id) {
	    return view.getBrailleCellState(id);
    }

	/**
	 * Sets the specified braille cell to the given pin states.
     *
     * ID's of braille cells ALWAYS range from: [ 0 ] to [ getAmtOfBrailleCells() - 1 ]
     *
     * The pinState boolean array passed to this method is an array of booleans that contain
     * true and false values for every pin in a braille cell. True values = pin up, false values = pin down.
     * Booleans inside the pinStates boolean array with indices [ 0 ] to [ 3 ] inclusive,
     * map from top to bottom in the left column of a braille cell.
     * Booleans inside the pinStates boolean array with indices [ 4 ] to [ 7 ] inclusive,
     * map from top to bottom in the right column of a braille cell.
     * The pinState boolean must have a length of 8.
     *
	 * @param id The ID of the braille cell.
	 * @param pinStates The boolean array containing pin states of all 8 pins.
	 * @return True if the braille cell with the given ID was set to the given
     * pinStates boolean array. False if an unused ID or incorrect pinStates array was passed.
	 */
	public boolean setBrailleCellState(int id, boolean[] pinStates) {
		return view.setBrailleCellState(id, pinStates);
	}

	/**
	 * Sets the braille cell with the given ID to the character passed.
     *
     * ID's of braille cells ALWAYS range from: [ 0 ] to [ getAmtOfBrailleCells() - 1 ]
     * The toSet String passed to this method must have a length of 1.
     *
	 * @param id The ID of the braille cell to set.
	 * @param toSet The string to set the braille cell to. String should have length == 1
	 * @return True if the character passed was mapped to a braille cell configuration and successfully set.
	 */
	public boolean setBrailleCellState(int id, String toSet)  {
	    return view.setBrailleCellState(id, toSet);
	}

    /**
     * Resets a SINGLE braille cell with the given ID to have all pins down.
     * ID's of braille cells ALWAYS range from: [ 0 ] to [ getAmtOfBrailleCells() - 1 ]
     *
     * @param id The ID of the braille cell to reset.
     * @return True if the braille cell with the given ID was succesfully reset.
     */
	public boolean resetBrailleCell(int id) {
        return view.resetBrailleCell(id);
    }

	/**
	 * Resets all braille cells to have all pins down.
     *
     * @return How many braille cells were reset.
	 */
	public int resetAllBrailleCells() {
		return view.resetAllBrailleCells();
	}

}
