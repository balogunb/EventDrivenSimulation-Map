
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the JUnit test for the WareHouse class.
 *
 * @author Basit Balogun & Devin Murphy
 * @version 12/10/2018
 */
public class WareHouseTest
{
    @Before
    public void setUp()
    {
    }

    @Test
    public void testConstructor() {
        WareHouse w = new WareHouse("NewYork");
        assertTrue(w.cityName.equals("NewYork"));
    }

    @Test
    public void testAddCity() {
        WareHouse w = new WareHouse("NewYork");
        City c0 = new City("NewYork");
        w.addCity(c0);
        assertTrue(w.c == c0);
    }

    @Test
    public void testisEmpty() {
        WareHouse w = new WareHouse("NewYork");
        City c0 = new City("NewYork");
        w.addCity(c0);

        assertTrue(w.isEmpty());

    }

    @Test
    public void testaddCargo() {
        WareHouse w = new WareHouse("NewYork");
        City c0 = new City("NewYork");
        w.addCity(c0);

        Cargo cargo0 = new Cargo(1,0,"A");
        Cargo cargo1 = new Cargo(3,1,"A");
        w.addCargo(cargo0);
        w.addCargo(cargo1);

        assertTrue(!w.isEmpty());

    }
}
