
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the JUnit test for the Road class
 *
 * @author Basit Balogun & Devin Murphy
 * @version 12/10/2018
 */
public class RoadTest
{
    @Test
    public void testConstructor() {
        City c0 = new City("London");
        City c1 = new City("NewYork");
        Road r = new Road(c0, c1, 5);
        assertTrue(r.u == c0);
        assertTrue(r.v == c1);
        assertTrue(r.w == 5);
    }

}
