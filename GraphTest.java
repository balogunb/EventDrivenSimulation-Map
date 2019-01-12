
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the JUnit test forthe Graph class (modified from provided)
 *
 * @author Basit Balogun & Devin Murphy
 * @version 12/10/2018
 */
public class GraphTest
{
    @Test
    public void testcalculatePath() {
        Graph g = new Graph();
        WareHouse w0 = new WareHouse("Berlin");
        City c0 = g.getCity("Berlin");
        c0.addWareHouse(w0);

        WareHouse w1 = new WareHouse("Stockholm");
        City c1 = g.getCity("Stockholm");
        c1.addWareHouse(w1);

        WareHouse w2 = new WareHouse("SanFrancisco");
        City c2 = g.getCity("SanFrancico");
        c2.addWareHouse(w2);

        WareHouse w3 = new WareHouse("Warsaw");
        City c3 = g.getCity("Warsaw");
        c3.addWareHouse(w3);

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

        g.addRoad("Berlin", "Stockholm", 500);
        g.addRoad("Berlin", "Warsaw", 350);
        g.addRoad("Berlin", "SanFrancisco", 1350);
        g.addRoad("Stockholm", "Warsaw", 100);
        // WareHouse end = new WareHouse("End");
        // end = g.calculatePath(c0).get(1);         
        assertEquals(g.calculatePath(c0).get(1).cityName, "Warsaw");

    }

    @Test
    public void testcalculatePath2() {
        Graph g = new Graph();
        WareHouse w0 = new WareHouse("Berlin");
        City c0 = g.getCity("Berlin");
        c0.addWareHouse(w0);

        WareHouse w1 = new WareHouse("Stockholm");
        City c1 = g.getCity("Stockholm");
        c1.addWareHouse(w1);

        WareHouse w2 = new WareHouse("SanFrancisco");
        City c2 = g.getCity("SanFrancico");
        c2.addWareHouse(w2);

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
        w2.addCargo(cw2_0);
        w2.addCargo(cw2_1);

        g.addRoad("Berlin", "Stockholm", 500);
        g.addRoad("Berlin", "Warsaw", 350);
        g.addRoad("Berlin", "SanFrancisco", 1350);
        g.addRoad("Stockholm", "Warsaw", 100);
        // WareHouse end = new WareHouse("End");
        // end = g.calculatePath(c0).get(1);         
        assertEquals(g.calculatePath(c0).get(1).cityName, "Stockholm");

    }

    @After
    public void tearDown()
    {
    }
}
