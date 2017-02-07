import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import simulator.MainViewController;
import simulator.SimulatorActionListenerExample;
import simulator.SimulatorInitializationException;

public class MainViewControllerTestB {
	
	private SimulatorActionListenerExample simulatorActionListenerExample = new SimulatorActionListenerExample();
	private MainViewController mvController;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testInitializeActionListenerIntInt() {
		mvController =  MainViewController.initialize(simulatorActionListenerExample,0,0);
		try {
			MainViewController.getController();
			fail("Should return an exception");
		} catch (SimulatorInitializationException e) {
			e.printStackTrace();
		}
		mvController =  MainViewController.initialize(simulatorActionListenerExample,0,1);
		try {
			MainViewController.getController();
			fail("Should return an exception");
		} catch (SimulatorInitializationException e) {
			e.printStackTrace();
		}
		mvController =  MainViewController.initialize(simulatorActionListenerExample,1,0);
		try {
			MainViewController.getController();
			fail("Should return an exception");
		} catch (SimulatorInitializationException e) {
			e.printStackTrace();
		}
		mvController =  MainViewController.initialize(null,1,0);
		try {
			MainViewController.getController();
			fail("Should return an exception");
		} catch (SimulatorInitializationException e) {
			e.printStackTrace();
		}
		mvController =  MainViewController.initialize(simulatorActionListenerExample,5,5);
		try {
			MainViewController.getController();
		} catch (SimulatorInitializationException e) {
			e.printStackTrace();
			fail("Should not return an exception");
		}
		
	}

}
