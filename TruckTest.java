
import java.util.*;
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
public class TruckTest
{
    @Test
    public void testsetLocation() {
        WareHouse w = new WareHouse("NewYork");
        City c = new City("NewYork");
        w.addCity(c);

        WareHouse w0 = new WareHouse("Berlin");
        City c0 = new City("Berlin");
        w0.addCity(c0);
        WareHouse w1 = new WareHouse("Stockholm");
        City c1 = new City("Stockholm");
        w1.addCity(c1);
        WareHouse w2 = new WareHouse("SanFrancisco");
        City c2 = new City("SanFrancico");
        w2.addCity(c2);
        WareHouse w3 = new WareHouse("Warsaw");
        City c3 = new City("Warsaw");
        w3.addCity(c3);

        Cargo cw0_0 = new Cargo(232,0,"Berlin");
        Cargo cw0_1 = new Cargo(431,1,"Berlin");
        w0.addCargo(cw0_0);
        w0.addCargo(cw0_0);

        Cargo cw1_0 = new Cargo(232,0,"Stockholm");
        Cargo cw1_1 = new Cargo(431,1,"Stockholm");
        w1.addCargo(cw1_0);
        w1.addCargo(cw1_1);

        Cargo cw2_0 = new Cargo(232,0,"SanFrancisco");
        Cargo cw2_1 = new Cargo(431,1,"SanFrancisco");
        w1.addCargo(cw2_0);
        w1.addCargo(cw2_1);

        Cargo cw3_0 = new Cargo(232,0,"Warsaw");
        Cargo cw3_1 = new Cargo(431,1,"Warsaw");
        w1.addCargo(cw2_0);
        w1.addCargo(cw2_1);

        ArrayList<WareHouse> arr = new ArrayList<WareHouse>();
        arr.add(w0);
        arr.add(w1);
        arr.add(w2);
        arr.add(w3);

        Truck t = new Truck(1, c);
        assertTrue(t.setLocation(arr));

    }

    @Test
    public void testaddCargo(){
        WareHouse w = new WareHouse("NewYork");
        City c = new City("NewYork");
        w.addCity(c);

        WareHouse w0 = new WareHouse("Berlin");
        City c0 = new City("Berlin");
        w0.addCity(c0);
        WareHouse w1 = new WareHouse("Stockholm");
        City c1 = new City("Stockholm");
        w1.addCity(c1);
        WareHouse w2 = new WareHouse("SanFrancisco");
        City c2 = new City("SanFrancico");
        w2.addCity(c2);
        WareHouse w3 = new WareHouse("Warsaw");
        City c3 = new City("Warsaw");
        w3.addCity(c3);

        Cargo cw0_0 = new Cargo(232,0,"Berlin");
        Cargo cw0_1 = new Cargo(431,1,"Berlin");
        w0.addCargo(cw0_0);
        w0.addCargo(cw0_0);

        Cargo cw1_0 = new Cargo(232,0,"Stockholm");
        Cargo cw1_1 = new Cargo(431,1,"Stockholm");
        w1.addCargo(cw1_0);
        w1.addCargo(cw1_1);

        Cargo cw2_0 = new Cargo(232,0,"SanFrancisco");
        Cargo cw2_1 = new Cargo(431,1,"SanFrancisco");
        w1.addCargo(cw2_0);
        w1.addCargo(cw2_1);

        Cargo cw3_0 = new Cargo(232,0,"Warsaw");
        Cargo cw3_1 = new Cargo(431,1,"Warsaw");
        w1.addCargo(cw2_0);
        w1.addCargo(cw2_1);

        ArrayList<WareHouse> arr = new ArrayList<WareHouse>();
        arr.add(w0);
        arr.add(w1);
        arr.add(w2);
        arr.add(w3);

        Truck t = new Truck(1, c);
        assertTrue(t.setLocation(arr));
        t.addCargo(cw0_0);
        assertTrue(t.remCap<500);
    }
}
