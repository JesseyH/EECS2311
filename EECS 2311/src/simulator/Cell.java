package simulator;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class Cell extends JPanel {
	private boolean pinValue[] = new boolean[] { false, false, false, false, false, false, false, false };
	private JLabel pin[] = new JLabel[8];
	private JPanel col1 = new JPanel();
	private JPanel col2 = new JPanel();

	/**
	 * 
	 */
	public Cell() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.makePin();

		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.setPreferredSize(new Dimension(50, 100));
		this.setMaximumSize(new Dimension(50, 100));

	}

	/**
	 * 
	 */
	private void makePin() {
		for (int i = 0; i < 8; i++) {
			this.pin[i] = new JLabel();
			this.pin[i].setPreferredSize(new Dimension(25, 25));
			this.pin[i].setMaximumSize(new Dimension(25, 25));
			this.pin[i].setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			if (i < 4) {
				this.col1.add(pin[i]);
			} else {
				this.col2.add(pin[i]);
			}
		}
		col1.setLayout(new BoxLayout(this.col1, BoxLayout.Y_AXIS));
		col2.setLayout(new BoxLayout(this.col2, BoxLayout.Y_AXIS));
		this.add(col1);
		this.add(col2);
	}

	/**
	 * 
	 * @param raisedPins
	 */
	public void setPin(boolean[] raisedPins) {
		this.pinValue = raisedPins;
		for (int i = 0; i < 8; i++) {
			if (pinValue[i] == true) {
				pin[i].setBackground(Color.black);
			}
		}
	}
}
