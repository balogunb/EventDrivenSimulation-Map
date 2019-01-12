import java.util.*;
import java.util.concurrent.*;
import java.io.*;
/**
 * This class serves as a map which keeps track of roads and cities and also allows
 * users to create cities and roads while also linking them together. It implements 
 * a HashMap.
 *
 * @author Basit Balogun & Devin Murphy
 * @version 11/27/2018
 */
// ******************PUBLIC OPERATIONS*********************
// void addRoad(String start, String end, int w)  --> create and adds a road to two Cities(undirected implementation)
// City getCity()  --> returns the city associated with the name or creates new city if the city doesnr exist
// ArrayList<WareHouse> calculatePath(City startCity) --> returns an arraylist of warehouses sorted by proximity to city startCity    
// void reset()  --> Resets the parameters of all cities in the graph
// ******************ERRORS********************************
// No errors or exceptions in this class 

public class Graph {
    Map<String, City> cityMap = new HashMap<String, City>();// Graph is an instance of HashMap

    /**
     * method addRoad
     * @param String start, String end, int w
     * add a road which is an undirected edge
     */
    void addRoad(String start, String end, int w){
        City u = getCity(start);
        City v = getCity(end);
        u.nbs.add(new Road(u, v, w));
        v.nbs.add(new Road(v, u, w));
    }

    /** method getCity
     * @param String name
     * @return City 
     * retrieve city associated with the given name or create new city if city doesnt exist
     */
    public City getCity(String name) {
        City v = cityMap.get(name);
        if (v == null) {
            v = new City(name);
            cityMap.put(name, v);
        }
        return v;
    }

    /**calculatePath Method
     * @param City starCity
     * @return ArrayList<WareHouse> destinations
     * finds the shortest path from the given start city to different warehouses implementing
     * dijkstra's shortest path algorithm and returns an arraylist sorted by city 
     * distance */
    public ArrayList<WareHouse> calculatePath(City startCity) {
        reset();
        //arraylist of destinations sorted by distance from current warehouse 
        ArrayList<WareHouse> destinations = new ArrayList<WareHouse>();
        PriorityQueue<City> q = new PriorityQueue<City>();
        q.add(startCity);
        startCity.dist = 0;
        while (!q.isEmpty()) {
            City u = q.poll();
            if (u.visited) continue;//Skip City if it has been visited
            u.visited = true;
            if(u.hasWarehouse ){//if city has a warehouse 
                destinations.add(u.w);//add the city's warehouse
            }
            for (Road e: u.nbs) {
                City v = e.v;
                if (v.dist > u.dist + e.w) {
                    q.remove(v);
                    v.dist = u.dist + e.w;
                    v.prevC = u;
                    q.add(v);
                }
            }
        } 
        return destinations;
    }

    /**reset Method
     * reset the parameters of all Cities */
    public void reset() {
        for (City v: cityMap.values()) {
            v.dist = Integer.MAX_VALUE;
            v.visited = false;
            v.prevC = null;
        }
    }

  
}

