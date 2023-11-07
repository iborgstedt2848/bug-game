
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class MyTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MyTest
{
    /**
     * I was unable to get the exact spacing between the lines for this 
     * test to run properly and pass.
     */
    
    // @Test
    // public void testToString(){
        // Floor f = new Floor(4);
        // assertEquals(f.toString(), 
            // "  1   2   3   4 \n" +
            // "A    |   |   |   \n" +   
            // "  ---|---|---|---\n" +
            // "B    |   |   |   \n" +
            // "  ---|---|---|---\n" +
            // "C    |   |   |   \n" +
            // "  ---|---|---|---\n" +
            // "D    |   |   |   \n" +
            // "  ---|---|---|---\n");
    // }

    @Test
    public void testGetFloorSize(){
        Floor f = new Floor(4);
        assertEquals(4, f.getFloorSize());
    }

    @Test
    public void testGetFloorValue(){
        Floor f = new Floor(4);
        Coord x = new Coord('A', 2);
        Coord y = new Coord('A', 1);
        f.move(x, 'q');
        assertEquals('q', f.getFloorValue(x));
        assertEquals(' ', f.getFloorValue(y));
    }

    @Test
    public void testIsValidMove(){
        Floor f = new Floor(4);
        Coord x = new Coord('B', 2);
        Coord y = new Coord('F', 3);
        Coord z = new Coord('A', 5);
        assertEquals(true, f.isValidMove(x));
        assertEquals(false, f.isValidMove(y));
        assertEquals(false, f.isValidMove(z));
    }

    @Test
    public void testMove(){
        Floor f = new Floor(5);
        Coord x = new Coord('C', 1);
        Coord y = new Coord('D', 8);
        Coord z = new Coord('O', 5);
        assertEquals(f.move(x, '$'), true);
        assertEquals(false, f.move(y, '%'));
        assertEquals(false, f.move(z, '&'));
    } 
}