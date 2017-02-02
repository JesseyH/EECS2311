package simulator;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class SimulatorTest {

	Simulator simulator;
	PlayerSimulator player;
	Random rand = new Random();
	
	@Before
	public void setUp() throws Exception {
		player = new PlayerSimulator();
		simulator = new Simulator(player);
		player.setSimulator(simulator);
	}

	@Test
	public void testSetBrailleCellState_INT_STRING() {
		for (int i = 0; i < 400; i++){
			String letter = String.valueOf((char) (65 + rand.nextInt(25)));
			int id = rand.nextInt(5);
			simulator.setBrailleCellState(id, letter);
			
			assertEquals(BrailleConvert.valueOf(letter).getPinStates(), simulator.getController().getBrailleCellState(id));
		}
	}
	
	@Test 
	public void testSetBrailleCellState_INT_BOOLEAN() {
		for (int i = 0; i < 400; i++){
			boolean[] pinStates = {rand.nextBoolean(), rand.nextBoolean(), rand.nextBoolean(), rand.nextBoolean(), rand.nextBoolean(), rand.nextBoolean(), rand.nextBoolean(), rand.nextBoolean()};
			int id = rand.nextInt(5);
			simulator.setBrailleCellState(id, pinStates);
	
			assertEquals(pinStates, simulator.getController().getBrailleCellState(id));
		}
	}
	
	@Test
	public void testResetAllBrailleCells(){
		simulator.resetAllBrailleCells();
		boolean[] FALSE = BrailleConvert.RESET.getPinStates();
		for (int id = 0; id < 5; id++){
			assertEquals(FALSE, simulator.getController().getBrailleCellState(id));
		}
	}
}
