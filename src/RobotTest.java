import static org.junit.Assert.assertEquals;
import org.junit.Test;



public class RobotTest {

    @Test
    public void testCase1() {
        Robot robot = new Robot();
        robot.place(0,0, "NORTH");
        robot.move();
        String output = robot.report();
        assertEquals("x: 0, y: 1, direction: NORTH", output);        
    }

    @Test
    public void testCase2() {
        Robot robot = new Robot();
        robot.place(0,0, "NORTH");
        robot.left();
        String output = robot.report();
        assertEquals("x: 0, y: 0, direction: WEST", output);        
    }

    @Test
    public void testCase3() {
        Robot robot = new Robot();
        robot.place(1,2, "EAST");
        robot.move();
        robot.move();
        robot.left();
        robot.move();        
        String output = robot.report();
        assertEquals("x: 3, y: 3, direction: NORTH", output);        
    }

    @Test
    public void testCase4() {
        Robot robot = new Robot();
        robot.place(1,3, "EAST");
        robot.right();
        robot.move();
        robot.right();
        robot.move();
        String output = robot.report();
        assertEquals("x: 0, y: 2, direction: WEST", output);        
    }

    @Test
    public void testFirstCommandHasToBePlaceCommand() {
        Robot robot = new Robot();
        robot.move();
        String output = robot.report();
        assertEquals("", output);
        
        robot.left();
        output = robot.report();
        assertEquals("", output);

        robot.place(3, 2, "SOUTH");
        output = robot.report();
        assertEquals("x: 3, y: 2, direction: SOUTH", output);        
    }

    @Test
    public void testRobotDoesNotFall() {
        Robot robot = new Robot();
        robot.place(4, 2, "EAST");
        robot.move();
        String output = robot.report();
        assertEquals("x: 4, y: 2, direction: EAST", output); 
        
        robot.place(1, 0, "SOUTH");
        robot.move();
        output = robot.report();
        assertEquals("x: 1, y: 0, direction: SOUTH", output); 
    }

    @Test
    public void testValidPlaceCommand() {
        Robot robot = new Robot();
        robot.place(5, 2, "EAST");
        String output = robot.report();
        assertEquals("", output); 

        robot.place(3, 2, "EAST");
        robot.place(2, 4, "SOUTH");
        output = robot.report();
        assertEquals("x: 2, y: 4, direction: SOUTH", output); 
        
    }
}
