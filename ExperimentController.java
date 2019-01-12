import java.util.*;
import java.io.*;

/**
 * This class conducts the experiment and prints out the result both to the command line and to a text file
 *
 * @author Basit Balogun & Devin Murphy
 * @version 12/9/2018
 */
// ******************PUBLIC OPERATIONS*********************
// void populateMap()   --> Uses data from two input files to populate the Graph with Roads and WareHouses
// ******************ERRORS********************************
// An Exception is throw in both the run method and populateMap when the
// input file data is incorrect
public class ExperimentController
{
    int totalDistT;//total distance all trucks have travelled 
    Graph map; //Map which contains all the cities and roads 
    Scanner sc;
    int totalNumCargo = 0; //keeps tracks of the totalnum of cargo left to be delivered 

    /**
     * Constructor for this class */
    public ExperimentController(){
        map = new Graph();
    }

    /**
     * Main method
     * runs the run method */
    public static void main(String[] args){
        ExperimentController e = new ExperimentController();
        e.run();
    }

    /**
     *Run method
     *Prints out solution in console
      */
    public void run(){
        populateMap();//populates the map with all cities and roads 

        try{
            sc = new Scanner(new FileReader("center.txt"));
            String center = sc.next();
            City centerCity = map.getCity(center);

            //Sets up a file writer that writes to the output text file
            File output = new File("result1.txt");
            //PrintWriter writer = new PrintWriter(output);

            int i = 0;//Truck index tracker
            //while there is still cargo to be shipped
            while(totalNumCargo != 0){

                //Creates a new Truck
                Truck t = new Truck(++i,centerCity);
                //writer.println("Truck "+i+ ":");
                System.out.println("Truck "+i+ ":");
                int distT = 0;//distance traveled by the Truck

                //while truck is not full
                while(t.setLocation(map.calculatePath(t.currentCity))){//sets location to deliver to 
                    int totalWW = 0; //total weight gotten from wareHouse 
                    String orders = ""; 
                    boolean addComma = false;//used for output formatting purposes 

                    //while cargo can be taken from current warehouse
                    while(!t.w.isEmpty() && t.w.cargos.peek().cargoSize <= t.remCap){
                        if(addComma) orders+= ", ";

                        Cargo c = t.w.cargos.poll();//remove the cargo demand from the warehouse
                        totalNumCargo--;
                        totalWW += c.cargoSize;
                        t.remCap -= c.cargoSize;
                        orders += c.toString();
                        addComma = true;
                    }
                    //writer.println("Deliver to warehouse " + t.w.cityName + " total weight: " + totalWW + " (["+ orders + "]) dist: "+ t.w.c.dist);
                    System.out.println("Deliver to warehouse " + t.w.cityName + " total weight: " + totalWW + " (["+ orders + "]) dist: "+ t.w.c.dist);
                    distT += t.w.c.dist;
                }
                map.calculatePath(centerCity);//recalculate distances from center city
                distT += t.goHome();//increment distance traveled by truct by distance required to go home 
                System.out.println("Distance traveled " + distT);
                //writer.println("Distance traveled " + distT);
                totalDistT += distT;
                distT = 0;
            }
            System.out.println("Total distance traveled: " +totalDistT);
            //writer.println("Total distance traveled: " +totalDistT);
            //writer.close();//close writer 
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * method populateMap
     * Populates the map with all cities and roads
     */ 
    public void populateMap(){
        totalNumCargo = 0;      
        try{            
            sc = new Scanner(new FileReader("roads.txt"));
            
            
            //add roads while also creating a city 
            int numOfRoads = Integer.valueOf(sc.nextLine());            
            while (sc.hasNextLine()){
                String line = sc.nextLine();               
                String[] s = line.split(" ");
                int dist = Integer.valueOf(s[2]);
                map.addRoad(s[0],s[1],dist);// add road not only creates roads but in the case where the city doesnt exist yet it creates a new city 
            }

            
            //Creates a warehouse and adds it to graph
            sc = new Scanner(new FileReader("warehouses.txt"));
            int numOfWH = Integer.valueOf(sc.nextLine());  
            while (sc.hasNextLine()){
                String line = sc.nextLine();               
                String[] s = line.split(" ");
                WareHouse w = new WareHouse(s[0]);

                //add all Cargos to each warehouses 
                for (int i = 1; i < s.length; i++){
                    Cargo c = new Cargo(Integer.valueOf(s[i]),i, s[0]);
                    totalNumCargo++;//keeps track of the number of cargos 
                    w.addCargo(c);  //add cargo to warehouse                   
                } 
                
                
                // add warehouses to their respective city 
                City v = map.getCity(s[0]);// gets city from the map using name
                v.addWareHouse(w);
                w.addCity(v);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
