package simulator.controller;

import simulator.Settings;
import simulator.model.BrailleCell;
import simulator.model.BrailleConvert;
import simulator.view.MainView;

/**
 * Controller for the MainView.
 */
public class MainViewController {

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
				setBrailleCellState(0, BrailleConvert.A.getPinStates());
				break;
			case 1:
				setBrailleCellState(1, BrailleConvert.F.getPinStates());
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

	public void setBrailleCellState(int id, boolean[] pinStates) {
		if(id >= 0 && id < brailleCells.length) {
			brailleCells[id].setPinStates(pinStates);
			view.refreshBrailleCell(id);
		}
	}

	/**
	 * Called when a braille cell is initialized by the view.
	 * This method will create the corresponding BrailleCell instance
	 * from the model.
	 * @param id The id of the braille cell that was initialized.
	 * @return The BrailleCell obejct that was created.
	 */
	public BrailleCell createBrailleCell(int id) {
		brailleCells[id] = new BrailleCell(id);
		return brailleCells[id];
	}

}
