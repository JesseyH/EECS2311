package simulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

	private Model model;
	private View view;

	/**
	 * Returns the Model used by this controller.
	 * 
	 * @return the model
	 */
	public Model getModel() {
		return this.model;
	}

	/**
	 * Sets the Model used by this controller.
	 * 
	 * @param model
	 *            the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * Returns the View used by this controller.
	 * 
	 * @return the view
	 */
	public View getView() {
		return this.view;
	}

	/**
	 * Sets the View used by this controller.
	 * 
	 * @param view
	 *            the view to set
	 */
	public void setView(View view) {
		this.view = view;
	}

	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
	}

}
