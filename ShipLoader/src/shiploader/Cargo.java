/**
* Dennis Lin
* 109426873
* Homework #3
* CSE214 R05 
* Recitation TA: Vladimir Yevseenko
 */

package shiploader;

public class Cargo {

    private String name;
    private double weight;
    private CargoStrength strength;

    /**
     * Brief: Default Constructor. 
     * Parameters: initName Non-null name for the
     * cargo item. initWeight The weight for the cargo. The weight should be
     * greater than 0, so an exception should be thrown if initWeight ≤ 0 (We do
     * not deal with massless cargo). initStrength Either FRAGILE, MODERATE, or
     * STURDY. 
     * Preconditions: initName is not null. initWeight > 0.
     * Postconditions: This object has been initialized to a Cargo object with
     * the given name, weight, and strength. 
     * Throws: IllegalArgumentException IfinitName is null. If initWeight ≤ 0. Getters ONLY for name, weight,
     * strength
     */
    public Cargo(String initName, double initWeight,CargoStrength initStrength) {
        name = initName;
        weight = initWeight;
        strength = initStrength;
    }
    
    /**
     * getter for name
     * @return name
     *      name of cargo
     */
    public String getName(){
        return name;
    }
    
    /**
     * getter for name
     * @return weight
     *      weight of cargo
     */
    public double getWeight(){
        return weight;
    }
    
    /**
     * getter for strength
     * @return strength
     *      strength of cargo
     */
    public CargoStrength strength(){
        return strength;
    }
    
    @Override
    public String toString(){
        String cargo = "";
        cargo = strength().toString();
        return cargo;
    }
}
