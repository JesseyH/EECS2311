package simulator.view;

import simulator.controller.MainViewController;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainView extends JFrame {

    private MainViewController controller;

    private int BUTTON_SIZE_X = 50;
	private int BUTTON_SIZE_Y = 50;

	private BrailleCellView[] brailleCellViews;
	private JButton[] buttons;
	private JPanel cellPanel;
	private JPanel buttonPanel;
	private ActionListener listener;

    /**
     * Constructor for the main view
     * 
     */
	public MainView(MainViewController controller, int numOfCells, int numOfButtons, ActionListener listener) {
		super("Braille Simulator");
		this.controller = controller;
		this.listener = listener;

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 250));
        setResizable(true);

		makeCells(numOfCells);
		makeButtons(numOfButtons);
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setVisible(true);
		pack();
	}

    /**
     * Creates the given amount of braille brailleCellViews.
     * @param cellsToMake The amount of braille brailleCellViews to make.
     */
	private void makeCells(int cellsToMake) {
        cellPanel = new JPanel();
        brailleCellViews = new BrailleCellView[cellsToMake];

		for (int i = 0; i < cellsToMake; i++) {
			brailleCellViews[i] = new BrailleCellView(controller.createBrailleCell(i));
			cellPanel.add(brailleCellViews[i]);
		}
		add(cellPanel);
	}

    /**
     * Creates the given amount of buttons.
     * @param buttonsToMake The amount of buttons to create.
     */
	private void makeButtons(int buttonsToMake) {
        buttonPanel = new JPanel();
	    buttons = new JButton[buttonsToMake];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setText("" + i);
			buttons[i].setActionCommand("" + i);
			buttons[i].addActionListener(listener);
			buttons[i].setPreferredSize(new Dimension(BUTTON_SIZE_X, BUTTON_SIZE_Y));
			buttons[i].setMaximumSize(new Dimension(BUTTON_SIZE_X, BUTTON_SIZE_Y));

			buttonPanel.add(buttons[i]);
		}
		add(buttonPanel);
	}

    /**
     * Refreshes the pins on a braille cell with the given id.
     * @param id ID of the braille cell to refresh.
     */
	public void refreshBrailleCell(int id) {
        if(id >= 0 && id < brailleCellViews.length) {
            brailleCellViews[id].refreshPins();
        }
    }
}
