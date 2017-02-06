package simulator.view;

import simulator.controller.MainViewController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainView extends JFrame implements ActionListener{

    private MainViewController controller;

    private int BUTTON_SIZE_X = 50;
	private int BUTTON_SIZE_Y = 50;

	private BrailleCellView[] brailleCellViews;
	private JButton[] buttons;
	private JPanel cellPanel;
	private JPanel buttonPanel;

    /**
     * Constructor for the main view
     */
	public MainView(MainViewController controller, int numOfCells, int numOfButtons) {
		super("Braille Simulator");
		this.controller = controller;

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 250));
        setResizable(false);

		makeCells(numOfCells);
		makeButtons(numOfButtons);
		pack();

		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setVisible(true);
	}

    /**
     * Creates the given amount of braille brailleCellViews.
     * @param cellsToMake The amount of braille brailleCellViews to make.
     */
	private void makeCells(int cellsToMake) {
        cellPanel = new JPanel();
        brailleCellViews = new BrailleCellView[cellsToMake];

		for (int i = 0; i < cellsToMake; i++) {
			brailleCellViews[i] = new BrailleCellView(controller.createdBrailleCell(i));
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
			buttons[i].setActionCommand("BUTTON " + i);
			buttons[i].addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < buttons.length; i++) {
            if(buttons[i] == e.getSource()) {
                controller.buttonPressed(i);
            }
        }
    }
}
