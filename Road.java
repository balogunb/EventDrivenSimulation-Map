
/**
 * This class implements a graph's edge as a Road. It stores the two cities connected and the
 * distance between them.
 * @author Basit Balogun & Devin Murphy
 * @version 12/9/2018
 */
// ******************PUBLIC OPERATIONS*********************
// No public operations  
// ******************ERRORS********************************
// No errors or exceptions in this class 
public class Road
{
    City u,v;
    int w;//Distance between both cities 

    /**
     * @param City u, City v, int w (weight)
     * Constructor for road */
    public Road(City u, City v, int w){
        this.u =u;
        this.v = v;
        this.w = w;
    }
}
