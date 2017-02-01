package simulator;

public class Player {
	static PlayerSimulator player = new PlayerSimulator();
	public static void main(String[] args) {
		Simulator simulator = new Simulator(player);
		player.setSimulator(simulator);
	}

}
