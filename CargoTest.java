
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the JUnit test for the cargo class.
 *
 * @author Basit Balogun & Devin Murphy
 * @version 12/10/2018
 */
public class CargoTest
{
    @Test
    public void testComparable() {

        Cargo c0 = new Cargo(1,0,"A");
        Cargo c1 = new Cargo(3,1,"A");

        assertTrue(0> c0.compareTo(c1));
    }

    @Test
    public void testToStirng() {

        Cargo c0 = new Cargo(1,0,"A");
        Cargo c1 = new Cargo(3,1,"A");

        assertTrue(c1.toString().equals("A(1): 3"));
    }
}
