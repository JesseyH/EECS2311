package simulator;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class View extends JFrame {
	private int NUM_OF_CELLS = 1;
	private int NUM_OF_BUTTONS = 5;
	private int BUTTON_SIZE_X = 50;
	private int BUTTON_SIZE_Y = 50;

	Cell[] cells = new Cell[NUM_OF_CELLS];
	JButton[] buttons = new JButton[NUM_OF_BUTTONS];
	JPanel cellPanel = new JPanel();
	JPanel buttonPanel = new JPanel();

	/**
	 * 
	 * @param listener
	 */
	public View(ActionListener listener) {
		super("Braille Simulator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.makeCells();
		this.makeButtons(listener);

		this.setMinimumSize(new Dimension(300, 250));
		this.pack();
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		this.setVisible(true);
	}

	/**
	 * 
	 */
	private void makeCells() {
		for (int i = 0; i < NUM_OF_CELLS; i++) {
			this.cells[i] = new Cell();
			this.cellPanel.add(this.cells[i]);
		}
		this.add(cellPanel);
	}

	/**
	 * 
	 */
	private void makeButtons(ActionListener listener) {
		for (int i = 0; i < buttons.length; i++) {
			this.buttons[i] = new JButton();
			this.buttons[i].setText("" + i);
			this.buttons[i].setActionCommand("BUTTON " + i);
			this.buttons[i].addActionListener(listener);
			this.buttons[i].setPreferredSize(new Dimension(BUTTON_SIZE_X, BUTTON_SIZE_Y));
			this.buttons[i].setMaximumSize(new Dimension(BUTTON_SIZE_X, BUTTON_SIZE_Y));

			this.buttonPanel.add(this.buttons[i]);
		}
		this.add(buttonPanel);
	}

	/**
	 * 
	 * @param raisedPin
	 */
	public void setCell(boolean[] raisedPin) {
		setCell(0, raisedPin);
	}

	/**
	 * 
	 * @param cellNum
	 * @param raisedPin
	 */
	public void setCell(int cellNum, boolean[] raisedPin) {
		this.cells[cellNum].setPin(raisedPin);
	}
}
