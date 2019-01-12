import java.util.*;
/**
 * Write a description of class WareHouse here.
 *
 * @author Basit Balogun & Devin Murphy
 * @version 12/10/2018
 */
// ******************PUBLIC OPERATIONS*********************
// void addCity(City c)  --> allows warehouse to keep track of its city c
// boolean isEmpty()  --> returns true is there is no cargo in warehouse and false otherwise
// void addCargo(Cargo c) --> adds cargo c to warehouse  
// ******************ERRORS********************************
// No errors or exceptions in this class 
public class WareHouse
{
    public PriorityQueue<Cargo> cargos;//contains all cargos in the warehouse
    private int cargoIndex;
    public City c;
    public String cityName;
    private ArrayList<WareHouse> destinations;//list of closest warehouses

    /**
     * @param String c City Name
     * Constructor creates a warehouse which is aware of its city's Name */
    public WareHouse(String c ){
        cargos = new PriorityQueue<Cargo>();
        cityName = c;
    }
    
    /**
     * @param City element
     * Allows warehouse to keep track of the city its in*/
    void addCity(City c ){
     this.c = c;
    }
        
    /**
     *@return boolean 
     *checks if warehouse has no cargo *
     */
    public boolean isEmpty(){
        return cargos.isEmpty();
    }
        
    /**
     * @param Cargo element
     * adds Cargo to WareHouse
     */
    void addCargo(Cargo c){
        cargos.add(c);
    }
}
