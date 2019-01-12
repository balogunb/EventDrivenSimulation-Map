/**
 * Creates a cargo and stores its index, size and city name.
 *
 * @author Basit Balogun & Devin Murphy
 * @version 12/9/2018
 */
// ******************PUBLIC OPERATIONS*********************
// int compareTo(Cargo c)  --> return cargo comparison by cargoSize
// String toString()  --> returns String with all details of Cargo  
// ******************ERRORS********************************
// No errors or exceptions in this class 
public class Cargo implements Comparable<Cargo>
{
    public int cargoSize;//size of the Cargo 
    private int index;//serves as id for each cargo
    private String cityName;//city cargo belongs to 

    /**
     * @param int cargoSize, int index, String cityName
     * Constructor for Cargo */
    public Cargo( int cargoSize, int index,String cityName){
        this.cargoSize = cargoSize;
        this.index = index; 
        this.cityName = cityName;
    }

    /**
     * compareTo Method
     * @param Cargo c 
     * @return a value that reflects the nature of the comparison
     */
    public int compareTo(Cargo c){
        return cargoSize - c.cargoSize;
    }

    /**
     * toString method
     * Convert the cargo to a string with all cargo info
     *@return String
     */
    public String toString(){
        return cityName +"("+index+"): " +cargoSize;
    }
}
