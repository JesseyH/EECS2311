package simulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * EXAMPLE CLASS
 * This is an example of how you would listen to action events
 * in your player app.
 *
 * @author Team 6, EECS 2031
 */
public class SimulatorActionListenerExample implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // Do stuff in here to handle button presses.

        System.out.println(e.getActionCommand());
    }
}
