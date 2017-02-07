package simulator;

import java.awt.event.ActionListener;

/**
 * This controller can be used to control any aspect of the simulator.
 *
 * Use MainViewController.initialize(actionListener); and pass in an action listener to initialize the simulator and
 * its controller. The controller instance that was initialized will then be returned. It is recommended to save
 * the controller instance returned in a static variable for later use. This saves you from using getController()
 * repeatedly.
 *
 * For every other time you require access to the controller, use MainViewController.getController();
 *
 * SEE EXAMPLES: SimulatorInitializationExample and SimulatorActionListenerExample
 * @author Team 6, EECS 2031
 */
public class MainViewController {

    /**
     * Static variable containing the MainViewController singleton.
     */
    private static MainViewController mainViewController;

    /**
     * Instance variables.
     */
	private MainView view;

    /**
     * Private constructor for the MainViewController that initializes the view
     * with the amount of braille cells and buttons specified in Settings.
     * Player should call initialize() method instead of using this constructor.
     *
     * @param listener The ActionListener that will be attached to every button.
     * @throws SimulatorInitializationException Thrown either when the simulator has already been
     * initialized, or the ActionListener passed is null.
     */
    private MainViewController(ActionListener listener) throws SimulatorInitializationException {
        if(mainViewController != null) {
            throw new SimulatorInitializationException("The simulator has already been initialized!");
        }
        if(listener == null) {
            throw new SimulatorInitializationException("The ActionListener passed to the initialize() method is null!");
        }
        view = new MainView(this, listener);
        view.makeCells(Settings.NUM_OF_CELLS);
        view.makeButtons(Settings.NUM_OF_BUTTONS);
        view.drawView();
    }

    /**
     * Private constructor for the MainViewController that initializes the view
     * with the specified amount of braille cells and buttons.
     * @param listener The ActionListener that will be attached to every button.
     * @param numOfCells The number of braille cells to initialize the view with.
     * @param numOfButtons The number of buttons to initialize the view with.
     * @throws SimulatorInitializationException Thrown either when the simulator has already been initialized,
     * the ActionHandler passed is null, the braille cell amount is less than or equal to 0,
     * or the button amount is less than or equal to 0.
     */
    private MainViewController(ActionListener listener, int numOfCells, int numOfButtons)
            throws SimulatorInitializationException {
        if(mainViewController != null) {
            throw new SimulatorInitializationException("The simulator has already been initialized!");
        }
        if(listener == null) {
            throw new SimulatorInitializationException("The ActionListener passed to the initialize() method is null!");
        }
        if(numOfCells <= 0) {
            throw new SimulatorInitializationException("You cannot initialize the simulator with 0 or less braille cells.");
        }
        if(numOfButtons <= 0) {
            throw new SimulatorInitializationException("You cannot initialize the simulator with 0 or less buttons.");
        }
        view = new MainView(this, listener);
        view.makeCells(numOfCells);
        view.makeButtons(numOfButtons);
        view.drawView();
    }

    /**
     * Player should call this ONCE to initialize the simulator with the simulators default Settings.
     * The player should also pass an ActionListener so that the player may
     * control what happens when a button on the simulator is pressed.
     *
     * @param listener The ActionListener to bind to the simulator buttons.
     * @return The newly created simulator's controller, which is an instance of MainViewController.
     */
    public static MainViewController initialize(ActionListener listener) {
        try {
			mainViewController = new MainViewController(listener);
		} catch (SimulatorInitializationException e) {
			e.printStackTrace();
		}
        return mainViewController;
    }

    /**
     * Player should call this ONCE to initialize the simulator with the specified settings.
     * The Player should pass an ActionListener so that button events can be forwarded to the
     * Player. The player must also specify how many braille cells and buttons they would like
     * on the simulator.
     *
     * @param listener The ActionListener to bind to the simulator buttons.
     * @param numOfCells The number of braille cells to generate on the simulator.
     * @param numOfButtons The number of buttons to generate on the simulator.
     * @return The newly created simulator's controller, which is an instance of MainViewController.
     */
    public static MainViewController initialize(ActionListener listener, int numOfCells, int numOfButtons) {
        try {
			mainViewController = new MainViewController(listener, numOfCells, numOfButtons);
		} catch (SimulatorInitializationException e) {
			e.printStackTrace();
		}
        return mainViewController;
    }

    /**
     * Getter for the controller.
     * This method can be used to obtain reference to the controller AFTER
     * the initialize() method has been called.
     *
     * @return The current instance of MainViewController.
     * @throws SimulatorInitializationException Thrown when the initialize() method has not been called before using this.
     */
    public static MainViewController getController() throws SimulatorInitializationException {
        if(mainViewController == null) {
                throw new SimulatorInitializationException("Simulator has not been initialized! " +
                        "Please call initialize() method.");
        }
        return mainViewController;
    }

    /**
     * Returns how many buttons have been initialized on the view.
     * @return Integer number representing how many buttons there are.
     */
    public int getAmtOfButtons() {
        return view.getAmtOfButtons();
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
     * @return The pinStates boolean array for the specified braille cell
     * @throws BrailleCellStateException Thrown if the braille cell ID passed is out of bounds.
     */
	public boolean[] getBrailleCellState(int id) throws BrailleCellStateException {
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
     * The pinState boolean array must have a length of 8.
     *
	 * @param id The ID of the braille cell.
	 * @param pinStates The boolean array containing pin states of all 8 pins.
     * @throws BrailleCellStateException Thrown if the ID passed is out of bounds or the length of pinStates != 8.
	 */
	public void setBrailleCellState(int id, boolean[] pinStates) throws BrailleCellStateException {
		view.setBrailleCellState(id, pinStates);
	}

	/**
	 * Sets the braille cell with the given ID to the string passed.
     *
     * ID's of braille cells ALWAYS range from: [ 0 ] to [ getAmtOfBrailleCells() - 1 ]
     * The toSet String passed to this method must have a length of 1. Only letters [ A ] to [ Z ]
     * will work and will cause the method to return true. All other characters passed will
     * make the method return false.
     *
	 * @param id The ID of the braille cell to set.
	 * @param toSet The string to set the braille cell to. String should have length == 1
	 * @return True if the character passed was successfully mapped to a braille cell configuration. False if otherwise.
     * @throws BrailleCellStateException Thrown if the ID passed is out of bounds or the length of toSet != 1.
	 */
	public boolean setBrailleCellState(int id, String toSet) throws BrailleCellStateException  {
	    return view.setBrailleCellState(id, toSet);
	}

    /**
     * Resets a SINGLE braille cell with the given ID to have all pins down.
     * ID's of braille cells ALWAYS range from: [ 0 ] to [ getAmtOfBrailleCells() - 1 ]
     *
     * @param id The ID of the braille cell to reset.
     * @throws BrailleCellStateException Thrown if no braille cell exists for the given ID.
     */
	public void resetBrailleCell(int id) throws BrailleCellStateException {
        view.resetBrailleCell(id);
    }

	/**
	 * Resets ALL braille cells to have all pins down.
     *
     * @return How many braille cells were reset.
	 */
	public int resetAllBrailleCells() {
		return view.resetAllBrailleCells();
	}

}
