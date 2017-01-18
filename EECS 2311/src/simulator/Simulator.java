package simulator;

public class Simulator {

	public static void main(String[] args) {

		Model model = new Model();
		Controller controller = new Controller();
		View view = new View(controller);

		controller.setModel(model);
		controller.setView(view);

		view.setVisible(true);
		
		//Test for setCell
		view.setCell(new boolean[] { true, false, true, true, true, true, true, true });

	}

}
