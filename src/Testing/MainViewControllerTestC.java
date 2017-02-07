package Testing;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.Test;

import simulator.BrailleCellStateException;
import simulator.BrailleConvert;
import simulator.MainViewController;
import simulator.SimulatorActionListenerExample;
import simulator.SimulatorInitializationException;

public class MainViewControllerTestC {
	
	SimulatorActionListenerExample simulatorActionListenerExample = new SimulatorActionListenerExample();
	MainViewController mvController = MainViewController.initialize(simulatorActionListenerExample,5,5);
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
	
	@Test
	public void testInitialize() throws Exception {
		assertEquals(mvController, MainViewController.getController());
	}
	
	@Test
	public void testGetAmtOfBrailleCells() {
		try {
			assertEquals(5, mvController.getAmtOfBrailleCells());
		} catch (SimulatorInitializationException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBrailleCellState() {
		mvController.resetAllBrailleCells();
		assertEquals(Arrays.toString(mvController.getBrailleCellState(0)),Arrays.toString(BrailleConvert.RESET.getPinStates()));
		try {
			mvController.setBrailleCellState(0, "X");
		} catch (BrailleCellStateException e) {
			e.printStackTrace();
		}
		assertEquals(Arrays.toString(mvController.getBrailleCellState(0)),Arrays.toString(BrailleConvert.X.getPinStates()));
	}

	@Test
	public void testSetBrailleCellStateIntBooleanArray() {
		try {
			mvController.setBrailleCellState(0, new boolean[] {});
			fail("Should throw an exception");
		} catch (BrailleCellStateException e) {
			e.printStackTrace();
		}		
		try {
			mvController.setBrailleCellState(0, new boolean[] {false});
			fail("Should throw an exception");
		} catch (BrailleCellStateException e) {
			e.printStackTrace();
		}		
		try {
			mvController.setBrailleCellState(0, new boolean[] {false,false,false,false,false,false,false,false});
			assertEquals(Arrays.toString(new boolean[] {false,false,false,false,false,false,false,false}), Arrays.toString(mvController.getBrailleCellState(0)));

		} catch (BrailleCellStateException e) {
			e.printStackTrace();
			fail("Should not throw an exception");
		}				
		try {
			mvController.setBrailleCellState(0, new boolean[] {true,true,true,true,true,true,true,true});
			assertEquals(Arrays.toString(new boolean[] {true,true,true,true,true,true,true,true}), Arrays.toString(mvController.getBrailleCellState(0)));
		} catch (BrailleCellStateException e) {
			e.printStackTrace();
			fail("Should not throw an exception");
		}				
	}

	@Test
	public void testSetBrailleCellStateIntString() {
		try {
			assertEquals(false, mvController.setBrailleCellState(0, "0"));
		} catch (BrailleCellStateException e) {
			
		}
		try {
			assertEquals(false, mvController.setBrailleCellState(0, "AA"));
			fail("Should throw an exception");
		} catch (BrailleCellStateException e) {
			e.printStackTrace();
		}
		try {
				assertEquals(true, mvController.setBrailleCellState(0, "Z"));	
		} catch (BrailleCellStateException e) {
			fail("Should not throw an exception");
		}
	}

	@Test
	public void testResetBrailleCell() throws SimulatorInitializationException {
		try {
			mvController.setBrailleCellState(0, "Z");
			mvController.setBrailleCellState(1, "X");
			mvController.setBrailleCellState(2, "Y");
			mvController.setBrailleCellState(3, "A");
			mvController.setBrailleCellState(4, "F");
			assertEquals(BrailleConvert.Z.getPinStates(), mvController.getBrailleCellState(0));
			mvController.resetBrailleCell(0);
			assertEquals(BrailleConvert.RESET.getPinStates(), mvController.getBrailleCellState(0));
		} catch (BrailleCellStateException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testResetAllBrailleCells() {
		try {
			mvController.setBrailleCellState(0, "Z");
			mvController.setBrailleCellState(1, "X");
			mvController.setBrailleCellState(2, "Y");
			mvController.setBrailleCellState(3, "A");
			mvController.setBrailleCellState(4, "F");
			assertEquals(BrailleConvert.Z.getPinStates(), mvController.getBrailleCellState(0));
			mvController.resetAllBrailleCells();
			assertEquals(BrailleConvert.RESET.getPinStates(), mvController.getBrailleCellState(0));
			assertEquals(BrailleConvert.RESET.getPinStates(), mvController.getBrailleCellState(1));
			assertEquals(BrailleConvert.RESET.getPinStates(), mvController.getBrailleCellState(2));
			assertEquals(BrailleConvert.RESET.getPinStates(), mvController.getBrailleCellState(3));
			assertEquals(BrailleConvert.RESET.getPinStates(), mvController.getBrailleCellState(4));
		} catch (BrailleCellStateException e) {
			e.printStackTrace();
		}
	}

}
