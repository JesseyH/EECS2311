package simulator;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is the JPanel for a single braille cell presented on the screen.
 * The BrailleCellView JPanel manages drawing and refreshing of the eight pins
 * in one braille cell.
 *
 * USED INTERNALLY BY SIMULATOR.
 * @author Team 6, EECS 2031
 */
class BrailleCellView extends JPanel {

    /**
     * Instance variables.
     */
    private BrailleCell brailleCell;
	private JLabel pin[] = new JLabel[8];
	private ImageIcon lowered = new ImageIcon(getClass().getResource("/lowered.png"));
	private ImageIcon raised = new ImageIcon(getClass().getResource("/raised.png"));

    /**
     * Constructor for a BrailleCellView.
     * @param brailleCell The brailleCell model object that stores the states of each pin
     *                    on this braille cell.
     */
	BrailleCellView(BrailleCell brailleCell) {
		super();
		this.brailleCell = brailleCell;

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		makePin();
        refreshPins();

		//setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		setPreferredSize(new Dimension(50, 100));
		setMaximumSize(new Dimension(50, 100));
	}

	/**
	 * Creates two columns of type JPanel and then inserts
     * 4 JLabels in each column. Each JLabel represents a pin
     * and both columns combined (each with 4 pins) creates a braille
     * cell.
	 */
	private void makePin() {
        JPanel col1 = new JPanel();
        JPanel col2 = new JPanel();

		for (int i = 0; i < 8; i++) {
			pin[i] = new JLabel();
			pin[i].setPreferredSize(new Dimension(25, 25));
			pin[i].setMaximumSize(new Dimension(25, 25));
			pin[i].setIcon(lowered);
			if (i < 4) {
				col1.add(pin[i]);
			} else {
				col2.add(pin[i]);
			}
		}
		col1.setLayout(new BoxLayout(col1, BoxLayout.Y_AXIS));
		col2.setLayout(new BoxLayout(col2, BoxLayout.Y_AXIS));

		add(col1);
		add(col2);
	}

    /**
     * Refreshes all the pins within a braille cell to either be raised
     * or lowered depending on the pinStates configuration contained within
     * the BrailleCell model instance.
     */
    void refreshPins() {
        boolean[] pinState = brailleCell.getPinStates();

        for (int i = 0; i < pinState.length; i++) {
            if (pinState[i]) {
                pin[i].setIcon(raised);
            } else {
                pin[i].setIcon(lowered);
            }
        }
    }

}
