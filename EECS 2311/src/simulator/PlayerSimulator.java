package simulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerSimulator implements ActionListener{
	private Simulator simulator;
	
	public void setSimulator(Simulator simulator){
		this.simulator = simulator;
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
        if(s.equals("4")){
        	simulator.resetAllBrailleCells();
        } else {
        	simulator.setBrailleCellState(Integer.valueOf(s), "A");
        }
    }
}
