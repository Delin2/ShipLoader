/**
 * Dennis Lin 109426873 Homework #3 CSE214 R05 Recitation TA: Vladimir Yevseenko
 */
package shiploader;

public class CargoShip {

    private CargoStack[] stacks;
    private int maxHeight;
    public double maxWeight;

    /**
     * Brief: Default Constructor. 
     * Parameters: numStacks The number of stacks
     * this ship can support. This parameter should be used to initialize the
     * stacks array to a fixed size. initMaxHeight The maximum height of any
     * stack on this ship. initMaxWeight The maximum weight for all the cargo on
     * the ship. 
     * Preconditions: numStacks > 0. initMaxHeight > 0. maxWeight > 0.
     * Postconditions: This object has been initialized to a CargoShip object
     * with the indicated number of stacks, maxHeight, and maxWeight.
     * Throws:IllegalArgumentException if either of the parameters are now
     * within the appropriate bounds.
     */
    public CargoShip(int numStacks, int initMaxHeight, double initMaxWeight) {
        stacks = new CargoStack[numStacks];
        for (int i = 0; i < numStacks; i++) {
            stacks[i] = new CargoStack(initMaxHeight);
        }
        maxHeight = initMaxHeight;
        maxWeight = initMaxWeight;
    }
    

    /*Brief:
     Pushes a cargo container to the indicated stack on the cargo ship
     Parameters:
        cargo: 
            The container to place on the stack.
        stack:
            The index of the stack on the ship to push cargo onto.
            Note: you may choose to do your actual indexing starting at 0, but from the user's perspective, the leftmost stack must be number 1.
     Preconditions: 
        This CargoShip is initialized and not null. 
        cargo is initialized and not null. 1 ≤ stack ≤ stacks.length.
        The size of the stack at the desired index is less than maxHeight.
        The total weight of all Cargo on the ship and cargo.getWeight()is less than maxWeight.
     Postconditions:
        The cargo has been successfully pushed to the given stack, or the appropriate exception has been thrown, in which case the state of the cargo ship should remain unchanged.
     Throws:
        IllegalArgumentException - If cargo is null or stack is not in the appropriate bounds.
        FullStackException - If the stack being pushed to is at the max height.
        ShipOverweightException - If cargo would make the ship exceed maxWeight and sink. (imaginary bonus points for "yellow submarine" refrerences in the exception message).
        CargoStrengthException - If the cargo would be stacked on top of a weaker cargo (see the CargoStrength rules above for reference).
     */
    public void pushCargo(Cargo cargo, int stack) //throws FullStackException, ShipOverweightException, CargoStrengthException{
    {
        if (stack > maxHeight) {
            throw new IllegalArgumentException("Stack out of range");
        }
        stacks[stack - 1].push(cargo);
    }

    /**
     * Brief: Pops a cargo from one of the specified stack. 
     * Parameters: 
     *  stack
     *      The index of the stack to remove the cargo from. Note: Again, from the
     * user's perspective, the leftmost stack must be indexed 1. 
     * Preconditions:
     *      This CargoShip is initialized and not null. 1 ≤ stack ≤ stacks.length.
     * Postconditions: 
     *      The cargo has been successfully been popped from the
     * stack, and returned, or the appropriate exception has been thrown, in
     * which case the state of the cargo ship should remain unchanged. 
     * Throws:
     *      IllegalArgumentException If stack is not in the appropriate bounds.
     *      EmptyStackException If the stack being popped from is empty.
     */
    public Cargo popCargo(int stack) {
        if (stack > maxHeight) {
            throw new IllegalArgumentException("Stack out of range");
        }
        return stacks[stack - 1].pop();
    }

    /*
     Brief:
     Finds and prints a formatted table of all the cargo on the ship with a given name. If the item could not be found in the stacks, notify the user accordingly. (see sample I/O for an example).
     Parameters:
        name:
            The name of the cargo to find and print.
     Preconditions:
        This CargoShip is initialized and not null.
     Postconditions:
        The details of the cargo with the given name have been found and printed, or the user has been notified that no such cargo has been found.
        The state of the cargo ship should remain unchanged.
     */
    public void findAndPrint(String name) {
        for (CargoStack s : stacks) {
            s.findAndPrint(name);
        }
    }
    

    @Override
    public String toString() {
        String cargoShip = "";
        
        for (int i = 0; i < stacks.length; i++) {
            cargoShip += "stack " +(i+1)+ ":";
            cargoShip += stacks[i].toString();
            cargoShip += "\n";
        }

        cargoShip += "\\=|";
        for (int i = 0; i < stacks.length; i++) {
            cargoShip += "=====|";
        }
        cargoShip += "=/   Dock: |=====|";

        cargoShip += "\n \\ ";
        for (int i = 0; i < stacks.length; i++) {
            cargoShip += "  " + (i + 1) + "   ";
        }
        cargoShip += "/          |=====|";

        cargoShip += "\n  \\";
        for (int i = 0; i < stacks.length - 1; i++) {
            cargoShip += "------";
        }
        cargoShip += "-----/           |=====|";

        return cargoShip;
    }

}
