package simulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * EXAMPLE CLASS
 * This is an example of how you would listen to action events
 * in your player app.
 */
public class SimulatorActionListenerExample implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
