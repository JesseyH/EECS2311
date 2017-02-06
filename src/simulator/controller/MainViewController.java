package simulator.controller;

import simulator.Settings;
import simulator.exceptions.SetBrailleCellStateException;
import simulator.model.BrailleCell;
import simulator.BrailleConvert;
import simulator.view.MainView;

/**
 * Controller for the MainView.
 * To get the instance of this controller use Simulator.getController().
 * With this controller you can control every aspect of the simulator.
 */
public class MainViewController {

    /**
     * Instance variables.
     */
	private MainView view;
	private BrailleCell[] brailleCells;

	/**
	 * Constructor for the MainViewController that initializes
	 * the view with default settings from Settings class.
	 */
	public MainViewController() {
		brailleCells = new BrailleCell[Settings.NUM_OF_CELLS];
		view = new MainView(this, Settings.NUM_OF_CELLS, Settings.NUM_OF_BUTTONS);

	}

	/**
	 * Handles what action to take when a button with the given button
	 * index is pressed.
	 * @param button The button index in the "buttons" array from the view.
	 */
	public void buttonPressed(int button) {
		System.out.println("Button "+ button +" pressed.");
		switch(button) {
			case 0:
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				System.out.println("No action to handle button " + button + ".");
				break;
		}
	}

    /**
     * Returns how many braille cells have been initialized on the view.
     * @return Integer number representing how many braille cells there are.
     */
	public int getAmtOfBrailleCells() {
	    return brailleCells.length;
    }

    /**
     * THIS METHOD SHOULD NOT BE CALLED BY ANYTHING OTHER THAN THE VIEW.
     *
     * Called when a braille cell is initialized by the view.
     * This method will create the corresponding BrailleCell model instance.
     * @param id The id of the braille cell that was initialized.
     * @return The BrailleCell model object that was created.
     */
    public BrailleCell createdBrailleCell(int id) {
        brailleCells[id] = new BrailleCell(id);
        return brailleCells[id];
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
	    if(id >= 0 && id < brailleCells.length) {
            return brailleCells[id].getPinStates();
        }
        return null;
    }

	/**
	 * Sets the specified braille cell to the given pin states.
     * ID's of braille cells ALWAYS range from: [ 0 ] to [ getAmtOfBrailleCells() - 1 ]
     * The pinState boolean array passed to this method must have a length of 8.
	 * @param id The ID of the braille cell.
	 * @param pinStates The boolean array containing pin states of all 8 pins.
	 * @return True if the braille cell with the given ID was set to the given
     * pinStates boolean array. False if an unused ID or incorrect pinStates array was passed.
	 */
	public boolean setBrailleCellState(int id, boolean[] pinStates) {
		try {

			if(!(id >= 0 && id < brailleCells.length)) {
				throw new SetBrailleCellStateException("The braille cell with ID " + id + " does not exist!");
			}
			if(pinStates.length != 8) {
				throw new SetBrailleCellStateException("The pinStates boolean array must have a length of exactly 8.");
			}

			brailleCells[id].setPinStates(pinStates);
			view.refreshBrailleCell(id);
			return true;

		} catch(SetBrailleCellStateException e) {
			System.out.println(e);
		}
		return false;
	}

	/**
	 * Sets the braille cell with the given ID to the character passed.
     * ID's of braille cells ALWAYS range from: [ 0 ] to [ getAmtOfBrailleCells() - 1 ]
     * The toSet String passed to this method must have a length of 1.
	 * @param id The ID of the braille cell to set.
	 * @param toSet The string to set the braille cell to. String should have length == 1
	 * @return True if the character passed was mapped to a braille cell configuration and succesfully set.
	 */
	public boolean setBrailleCellState(int id, String toSet) {
	    try {
            if (!(id >= 0 && id < brailleCells.length)) {
                throw new SetBrailleCellStateException("The braille cell with ID " + id + " does not exist!");
            }
            if (toSet.length() != 1) {
                throw new SetBrailleCellStateException("You may only set a braille cell to 1 character.");
            }
            for (BrailleConvert letter : BrailleConvert.values()) {
                if (letter.name().equalsIgnoreCase(toSet)) {
                    brailleCells[id].setPinStates(letter.getPinStates());
                    view.refreshBrailleCell(id);
                    return true;
                }
            }
        } catch (SetBrailleCellStateException e) {
	        System.out.println(e);
        }
		return false;
	}

	/**
	 * Resets all braille cells to have all pins down.
     * @return How many braille cells were reset.
	 */
	public int resetAllBrailleCells() {
		for(int i = 0; i < brailleCells.length; i++) {
			brailleCells[i].setPinStates(BrailleConvert.RESET.getPinStates());
			view.refreshBrailleCell(i);
		}
		return brailleCells.length;
	}

}
