package simulator.view;

import simulator.model.BrailleCell;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class BrailleCellView extends JPanel {

    private BrailleCell brailleCell;
	private JLabel pin[] = new JLabel[8];

	/**
	 * Constructor for the braille cell view.
	 */
	public BrailleCellView(BrailleCell brailleCell) {
		super();
		this.brailleCell = brailleCell;

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		makePin();
        refreshPins();

		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		setPreferredSize(new Dimension(50, 100));
		setMaximumSize(new Dimension(50, 100));
	}

	/**
	 * Creates the JLabels that represent each pin.
	 */
	private void makePin() {
        JPanel col1 = new JPanel();
        JPanel col2 = new JPanel();

		for (int i = 0; i < 8; i++) {
			pin[i] = new JLabel();
			pin[i].setPreferredSize(new Dimension(25, 25));
			pin[i].setMaximumSize(new Dimension(25, 25));
			pin[i].setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
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
     * Draws the proper background on each pin depending on state.
     */
    public void refreshPins() {
        boolean[] pinState = brailleCell.getPinStates();

        for (int i = 0; i < pinState.length; i++) {
            if (pinState[i]) {
                pin[i].setBackground(Color.black);
            } else {
                pin[i].setBackground(null);
            }
        }
    }

}
