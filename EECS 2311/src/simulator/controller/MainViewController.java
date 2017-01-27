package simulator.controller;

import simulator.Settings;
import simulator.model.BrailleCell;

import java.awt.event.ActionListener;

import simulator.BrailleConvert;
import simulator.view.MainView;

/**
 * Controller for the MainView.
 * To get the instance of this controller use Simulator.getController().
 * With this controller you can control every aspect of the simulator.
 */
public class MainViewController {

	private MainView view;
	private BrailleCell[] brailleCells;

	/**
	 * Constructor for the MainViewController that initializes
	 * the view with default settings from Settings class.
	 * @param listener The listener to notify the Player App 
	 * when a button was pressed.
	 */
	public MainViewController(ActionListener listener) {
		brailleCells = new BrailleCell[Settings.NUM_OF_CELLS];
		view = new MainView(this, Settings.NUM_OF_CELLS, Settings.NUM_OF_BUTTONS, listener);
	}

    /**
     * Gets the pinStates boolean array containing the values
     * of every pin for the braille cell with the given ID.
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
	 * @param id The ID of the braille cell
	 * @param pinStates The boolean array containing pin states of all 8 pins.
	 * @return True if the braille cell with the given ID was set to the given
     * pinStates boolean array. False if an unused ID or incorrect pinStates array was passed.
	 */
	public boolean setBrailleCellState(int id, boolean[] pinStates) {
		if(id >= 0 && id < brailleCells.length && pinStates.length == 8) {
			brailleCells[id].setPinStates(pinStates);
			view.refreshBrailleCell(id);
			return true;
		}
		return false;
	}

	/**
	 * Sets the braille cell with the given ID to the character passed.
	 * @param id The ID of the braille cell to set.
	 * @param toSet The string to set the braille cell to. String should have length == 1
	 * @return True if the character passed was mapped to a braille cell configuration.
	 */
	public boolean setBrailCellState(int id, String toSet) {
		if(id >= 0 && id < brailleCells.length && toSet.length() == 1) {
			for(BrailleConvert letter : BrailleConvert.values()) {
				if(letter.name().equalsIgnoreCase(toSet)) {
					brailleCells[id].setPinStates(letter.getPinStates());
					view.refreshBrailleCell(id);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Resets all braille cells to have all pins down.
	 */
	public void resetAllBrailleCells() {
		for(int i = 0; i < brailleCells.length; i++) {
			brailleCells[i].setPinStates(BrailleConvert.RESET.getPinStates());
			view.refreshBrailleCell(i);
		}
	}
	
	/**
	 * Called when a braille cell is initialized by the view.
	 * This method will create the corresponding BrailleCell model instance.
	 * @param id The id of the braille cell that was initialized.
	 * @return The BrailleCell model object that was created.
	 */
	public BrailleCell createBrailleCell(int id) {
		brailleCells[id] = new BrailleCell(id);
		return brailleCells[id];
	}

}
