package simulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import simulator.controller.MainViewController;

public class PlayerSimulator implements ActionListener{
	
	private MainViewController controller;
    
    /**
     * Returns the MainViewController used by the player.
     * 
     * @return the model
     */
    public MainViewController getContoller() {
        return this.controller;
    }

    /**
     * Sets the MainViewController used by the player.
     * 
     * @param model the model to set
     */
    public void setController(MainViewController controller) {
        this.controller = controller;
    }

    /**
     * Processes an event initiated by a user clicking on a button in an RPSView.
     * 
     * The <code>ActionEvent</code> object has-a string representing the button
     * that has been clicked.
     * @param e an action event object received from a button in the MainView
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    	String s = e.getActionCommand(); 
        System.out.println("Button " + s + " was pressed.");
        this.getContoller().setBrailCellState(Integer.valueOf(s), "A");
    }
}
