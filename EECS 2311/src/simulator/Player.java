package simulator;

public class Player {
	static PlayerSimulator player = new PlayerSimulator();
	public static void main(String[] args) {
		Simulator.main(args, player);
		player.setController(Simulator.getController());
	}
}
