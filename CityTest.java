
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the JUnit test for the city class.
 *
 * @author Basit Balogun & Devin Murphy
 * @version 12/10/2018
 */
public class CityTest
{
    @Test
    public void testConstructor() {

        City c0 = new City("London");
        City c1 = new City("NewYork");

        assertTrue(c0.name.equals("London"));
        assertTrue(c1.name.equals("NewYork"));
    }

    @Test
    public void testAddWareHouse() {
        WareHouse w = new WareHouse("NewYork");
        City c0 = new City("London");
        City c1 = new City("NewYork");
        c1.addWareHouse(w);
        assertTrue(c1.hasWarehouse = true);
    }

    @Test
    public void testComparable1() {
        City c0 = new City("London");
        City c1 = new City("NewYork");

        assertTrue(0 > c0.compareTo(c1));

    }
}