package simulator;

import java.awt.event.ActionListener;

import simulator.controller.MainViewController;

/**
 * Main class that initializes the MainViewController which controls
 * the state of the simulator.
 */
public class Simulator{
	private static MainViewController controller;
	private static boolean isCreated = false;
	
    /**
     * Main method. Initializes all controllers.
     * @param args Command line arguments
     */
	public Simulator(ActionListener player) {
		if (!isCreated){
			controller = new MainViewController(player);
			isCreated = true;
		}
	}

    /**
     * Getter for the MainViewController.
	 * By accessing this controller you are able to control every
	 * aspect of the simulator.
     * @return Instance of MainViewController.
     */
	public MainViewController getController() {
	    return controller;
    }
	
	/**
	 * Sets the specified braille cell to the given pin states.
	 * @param id The ID of the braille cell
	 * @param pinStates The boolean array containing pin states of all 8 pins.
	 * @return True if the braille cell with the given ID was set to the given
     * pinStates boolean array. False if an unused ID or incorrect pinStates array was passed.
	 */
	public boolean setBrailleCellState(int id, boolean[] pinStates) {
		return controller.setBrailleCellState(id, pinStates);
	}
	
	/**
	 * Sets the braille cell with the given ID to the character passed.
	 * @param id The ID of the braille cell to set.
	 * @param toSet The string to set the braille cell to. String should have length == 1
	 * @return True if the character passed was mapped to a braille cell configuration.
	 * @throws Exception 
	 */
	public boolean setBrailleCellState(int id, String toSet){
		return controller.setBrailleCellState(id, toSet);
	}
	
	/**
	 * Resets all braille cells to have all pins down.
	 */
	public void resetAllBrailleCells() {
		controller.resetAllBrailleCells();
	}
}
