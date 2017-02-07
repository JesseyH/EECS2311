package simulator;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * MainView sets up the entire simulator interface and ties all components together.
 * The MainView is the main simulator interface. In this class the button objects are
 * created and attached to the main view along with each braille cell being created
 * and attached as well.
 *
 * USED INTERNALLY BY SIMULATOR.
 * @author Team 6, EECS 2031
 */
public class MainView extends JFrame{

	/**
	 * Instance Variables
	 */
    private MainViewController controller;
    private ActionListener listener;

    private JButton[] buttons;

    private BrailleCellView[] brailleCellViews;
	private BrailleCell[] brailleCells;

    /**
     * Constructor for the MainView.
     * @param controller The controller instance controlling this view.
     * @param listener The ActionLister instance that will handle button presses.
     */
    MainView(MainViewController controller, ActionListener listener) {
		super("Braille SimulatorActionListenerExample");
		this.controller = controller;
		this.listener = listener;
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 250));
        setResizable(false);
	}

    /**
     * Packs the layout and draws the view to the screen.
     * Is called by the controller after all cells and buttons
     * are created.
     */
    void drawView() {
        pack();
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);
    }

    /**
     * Creates the given amount of braille cells by creating BrailleCellView objects
     * and attaching them to the main view. This method also instantiates a BrailleCell
     * model instance for every BrailleCellView created.
     * @param cellsToMake The amount of braille brailleCellViews to make.
     */
    void makeCells(int cellsToMake) {
		brailleCells = new BrailleCell[cellsToMake];
        JPanel cellPanel = new JPanel();
        brailleCellViews = new BrailleCellView[cellsToMake];

		for (int i = 0; i < cellsToMake; i++) {
			brailleCellViews[i] = new BrailleCellView(createdBrailleCell(i));
			cellPanel.add(brailleCellViews[i]);
		}
		add(cellPanel);
	}

    /**
     * Called when a braille cell is initialized.
     * This method will create the corresponding BrailleCell model instance
     * and insert it into the array holding all instances.
     * @param id The id of the braille cell that was initialized.
     * @return The BrailleCell model object that was created.
     */
    private BrailleCell createdBrailleCell(int id) {
        brailleCells[id] = new BrailleCell();
        return brailleCells[id];
    }

    /**
     * Creates the given amount of buttons.
     * @param buttonsToMake The amount of buttons to create.
     */
    void makeButtons(int buttonsToMake) {
        JPanel buttonPanel = new JPanel();
        buttons = new JButton[buttonsToMake];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setText("" + i);
			buttons[i].setActionCommand("BUTTON " + i);
			buttons[i].addActionListener(listener);
            int BUTTON_SIZE_X = 50;
            int BUTTON_SIZE_Y = 50;
            buttons[i].setPreferredSize(new Dimension(BUTTON_SIZE_X, BUTTON_SIZE_Y));
			buttons[i].setMaximumSize(new Dimension(BUTTON_SIZE_X, BUTTON_SIZE_Y));

			buttonPanel.add(buttons[i]);
		}
		add(buttonPanel);
	}

    /**
     * Returns how many buttons have been initialized on the view.
     * @return Integer number representing how many buttons there are.
     */
	int getAmtOfButtons() {
        return buttons.length;
    }

    /**
     * Returns how many braille cells have been initialized on the view.
     * ID's of braille cells ALWAYS range from [ 0 ] to [ getAmtOfBrailleCells -1 ].
     * @return Integer number representing how many braille cells there are.
     */
    int getAmtOfBrailleCells() {
	    return brailleCells.length;
    }

    /**
     * Gets the pinStates boolean array containing the values
     * of every pin for the braille cell with the given ID.
     * @param id The ID Of the braille cell.
     * @return The pinStates boolean array.
     * @throws BrailleCellStateException Thrown when the ID is out of bounds.
     */
    boolean[] getBrailleCellState(int id) throws BrailleCellStateException {
        if(!(id >= 0 && id < brailleCells.length)) {
            throw new BrailleCellStateException("The braille cell with ID " + id + " does not exist!");
        }
        return brailleCells[id].getPinStates();
    }

    /**
     * Sets the braille cell with the given ID to the given pinStates
     * boolean array.
     * @param id The ID of the braille cell.
     * @param pinStates The pinStates boolean array to set.
     * @throws BrailleCellStateException Thrown if the ID is out of bounds or
     * the pinStates boolean array has a length that is != 8.
     */
    void setBrailleCellState(int id, boolean[] pinStates)
            throws BrailleCellStateException{

        if(!(id >= 0 && id < brailleCells.length)) {
            throw new BrailleCellStateException("The braille cell with ID " + id + " does not exist!");
        }
        if(pinStates.length != 8) {
            throw new BrailleCellStateException("The pinStates boolean array must have a length of exactly 8.");
        }

        brailleCells[id].setPinStates(pinStates);
        refreshBrailleCell(id);
    }

    /**
     * Sets the braille cell with the given ID to the character passed.
     * @param id The ID of the braille cell to set.
     * @param toSet The string to set the braille cell to. String should have length == 1
     * @return True if the character passed was successfully mapped to a braille cell configuration. False if otherwise.
     * @throws BrailleCellStateException Thrown if the ID passed is out of bounds or the length of toSet != 1.
     */
    boolean setBrailleCellState(int id, String toSet)
            throws BrailleCellStateException {
        if (!(id >= 0 && id < brailleCells.length)) {
            throw new BrailleCellStateException("The braille cell with ID " + id + " does not exist!");
        }
        if (toSet.length() != 1) {
            throw new BrailleCellStateException("You may only set a braille cell to 1 character.");
        }
        for (BrailleConvert letter : BrailleConvert.values()) {
            if (letter.name().equalsIgnoreCase(toSet)) {
                brailleCells[id].setPinStates(letter.getPinStates());
                refreshBrailleCell(id);
                return true;
            }
        }
        return false;
    }

    /**
     * Refreshes the pins on a braille cell with the given id.
     * @param id ID of the braille cell to refresh.
     */
    private void refreshBrailleCell(int id) {
        if(id >= 0 && id < brailleCellViews.length) {
            brailleCellViews[id].refreshPins();
        }
    }

    /**
     * Resets a SINGLE braille cell with the given ID to have all pins down.
     * @param id The ID of the braille cell to reset.
     * @throws BrailleCellStateException Thrown if no braille cell exists for the given ID.
     */
    void resetBrailleCell(int id) throws BrailleCellStateException{
        if (!(id >= 0 && id < brailleCells.length)) {
            throw new BrailleCellStateException("The braille cell with ID " + id + " does not exist!");
        }
        brailleCells[id].setPinStates(BrailleConvert.RESET.getPinStates());
        refreshBrailleCell(id);
    }

    /**
     * Resets all braille cells to have all pins down.
     * @return How many braille cells were reset.
     */
    int resetAllBrailleCells() {
        for(int i = 0; i < brailleCells.length; i++) {
            brailleCells[i].setPinStates(BrailleConvert.RESET.getPinStates());
            refreshBrailleCell(i);
        }
        return brailleCells.length;
    }

}
