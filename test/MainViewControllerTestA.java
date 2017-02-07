import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.AfterClass;
import org.junit.Test;

import simulator.MainViewController;
import simulator.SimulatorActionListenerExample;
import simulator.SimulatorInitializationException;

public class MainViewControllerTestA {
	
	private SimulatorActionListenerExample simulatorActionListenerExample = new SimulatorActionListenerExample();
	private MainViewController mvController;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetController() {		
		try {
			MainViewController.getController();
			fail("Should Throw an Exception");
		} catch (SimulatorInitializationException e) {
			System.out.println("Passed");
		}
		mvController = MainViewController.initialize(simulatorActionListenerExample);
		try {
			assertEquals(mvController, MainViewController.getController());
		} catch (SimulatorInitializationException e) {
			fail("Should not Throw an Exception");
		}		
	}

}
