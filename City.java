import java.util.*;
/**
 * This class implements a graph's vertex as a City.
 *
 * @author Basit Balogun & Devin Murphy
 * @version 12/9/2018
 */
// ******************PUBLIC OPERATIONS*********************
// void addWareHouse(WareHouse w)  --> allows City to keep track of its wareHouse w.
// int compareTo(City c) --> returns city comparison by distance and name if distance is the same.
// ******************ERRORS********************************
// No errors or exceptions in this class 
public class City implements Comparable<City>{
    String name;//City name 
    List<Road> nbs = new ArrayList<Road>();//ArrayList of all roads linked to the city
    int dist = Integer.MAX_VALUE;
    boolean hasWarehouse;
    City prevC;
    WareHouse w;
    boolean visited;

    /**
     * City method
     * @param String
    constructor for City class*/
    public City(String n){
        name = n;
        hasWarehouse = false;//cities should have no warehouse initially 
        visited = false;//start with the city not being visited 
    }

    /**
     * addWareHouse method
     * @param WareHouse element
     * Allows city to keep track of its warehouse */
    public void addWareHouse(WareHouse w){
        this.hasWarehouse = true;
        this.w = w;
    }

    /**
     * compareTo Method
     * @param City c 
     * @return a value that reflects the nature of the comparison
     */
    public int compareTo(City c){
        if(dist - c.dist != 0) return dist - c.dist;
        else return name.compareTo(c.name);
    }

}
