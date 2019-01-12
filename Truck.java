import java.util.*;
/**
 * This class handles the movement of trucks between logistics center and warehouses
 * and also maintains and updates the remaining capacity of the truck itself.
 *
 * @author Basit Balogun and Devin Murphy
 * @version 12/9/2018
 */
// ******************PUBLIC OPERATIONS*********************
// boolean setLocation(ArrayList<WareHouse> arr)   --> Uses arr to get the next shipment location.returns false if truck is full
// int goHome()  --> returns distance to go back home
// addCargo (Cargo c) --> reduces the capacity of truck by cargo size 
// ******************ERRORS********************************
// No errors or exceptions in this class 
public class Truck{
    public int remCap; //remaining capacity of the truck
    public City currentCity;
    public WareHouse w;
    private ArrayList<WareHouse> dest;//arraylist of destinations sorted by distance from current city.  
    private int name; //city name 
    
    /**
     * @param int name, City currentCity element
     * Construtor for Truck */
    public Truck(int name, City currentCity){
        this.name = name;
        this.w = currentCity.w;
        this.currentCity = currentCity;
        remCap = 500;
    }

    /**
     * setLocation Method
     * @param ArrayList<WareHouse> arr
     * @return boolean
     * change the warehouse the truck is and returns false if truck is full
     */
    boolean setLocation(ArrayList<WareHouse> arr){
        dest = arr;
        boolean isFull;
        for(WareHouse wH: dest){
            //set the location of the truck to the nearest warehouse that can take a cargo 
            if(!wH.isEmpty() && wH.cargos.peek().cargoSize <= remCap){
                this.w = wH;
                currentCity = wH.c;
                return true;
            }        
        }
        return false;
    }

    /**method goHome
     * @return distance of current city
     * returns the distance to be travelled when going home 
     */
    int goHome(){
        return currentCity.dist;
    }

    /**addCargo method
     * @param Cargo c
     * reduces the capacity of the truck by cargo size and updates it
     */
    void addCargo(Cargo c){
        remCap = remCap - c.cargoSize;//subtract the weight of the added cargo
    }
}