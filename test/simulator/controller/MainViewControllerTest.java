package simulator.controller;

import org.junit.AfterClass;
import org.junit.Test;
import simulator.BrailleConvert;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MainViewControllerTest {

    private static MainViewController controller;

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Test
    public void testMainViewController() {
        try {
            controller = new MainViewController();
            controller.buttonPressed(0);
        } catch (Exception e) {
            fail("MainViewController Contructor Failed");
        }
    }

    @Test
    public void testButtonPressed() {
        controller.buttonPressed(0);
        assertEquals(BrailleConvert.A.getPinStates(), controller.getBrailleCellState(0));
        try {
            controller.buttonPressed(-50);
        } catch(Exception e) {
            fail("default case is not handled");
        }
    }

    @Test
    public void testGetBrailleCellState() {
        controller.buttonPressed(0);
        assertEquals(Arrays.toString(BrailleConvert.A.getPinStates()), Arrays.toString(controller.getBrailleCellState(0)));
        assertEquals(null, controller.getBrailleCellState(-50));
        assertEquals(Arrays.toString(BrailleConvert.RESET.getPinStates()), Arrays.toString(controller.getBrailleCellState(1)));
    }

    @Test
    public void testSetBrailleCellState() {
        controller.resetAllBrailleCells();
        controller.setBrailleCellState(0, BrailleConvert.A.getPinStates());
        assertEquals(Arrays.toString(BrailleConvert.A.getPinStates()), Arrays.toString(controller.getBrailleCellState(0)));
        controller.setBrailleCellState(0, new boolean[] {true});
        assertEquals(Arrays.toString(BrailleConvert.A.getPinStates()), Arrays.toString(controller.getBrailleCellState(0)));
        controller.setBrailleCellState(0, new boolean[] {true,true,true,true,true,true,true,true});
        assertEquals(Arrays.toString(new boolean[] {true,true,true,true,true,true,true,true}), Arrays.toString(controller.getBrailleCellState(0)));
        controller.setBrailleCellState(0, new boolean[] {});
        assertEquals(Arrays.toString(new boolean[] {true,true,true,true,true,true,true,true}), Arrays.toString(controller.getBrailleCellState(0)));
    }

    @Test
    public void testSetBrailCellState() {
        controller.setBrailleCellState(0, "A");
        assertEquals(BrailleConvert.A.getPinStates(), controller.getBrailleCellState(0));
        controller.setBrailleCellState(0, "AA");
        assertEquals(BrailleConvert.A.getPinStates(), controller.getBrailleCellState(0));
        controller.setBrailleCellState(0, "");
        assertEquals(BrailleConvert.A.getPinStates(), controller.getBrailleCellState(0));
    }

    @Test
    public void testResetAllBrailleCells() {
        controller.resetAllBrailleCells();
        assertEquals(Arrays.toString(BrailleConvert.RESET.getPinStates()), Arrays.toString(controller.getBrailleCellState(0)));
        assertEquals(Arrays.toString(BrailleConvert.RESET.getPinStates()), Arrays.toString(controller.getBrailleCellState(1)));
    }

   /*
   Removed because this method should be accesed by public
   @Test
    public void testCreateBrailleCell() {
        try {
            controller.createBrailleCell(0);
            controller.createBrailleCell(1);
        } catch (Exception e) {
            fail("FAIL");
        }
    }*/

}