package Testing;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import simulator.MainViewController;
import simulator.SimulatorActionListenerExample;
import simulator.SimulatorInitializationException;

public class MainViewControllerTestA {
	
	SimulatorActionListenerExample simulatorActionListenerExample = new SimulatorActionListenerExample();
	MainViewController mvController;
	
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
