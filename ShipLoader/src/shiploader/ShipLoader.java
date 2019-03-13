/**
 * Dennis Lin 109426873 Homework #3 CSE214 R05 Recitation TA: Vladimir Yevseenko
 */
package shiploader;

import java.util.Scanner;

public class ShipLoader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double totalWeight = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to ShipLoader\n"
                + "\nCargo Ship Parameters"
                + "\n--------------------------------------------------"
                + "\nNumber of stacks:");
        int stack = input.nextInt();
        System.out.println("Maximum height of stacks:");
        int initMaxHeight = input.nextInt();
        System.out.println("Maximum total cargo weight");
        double initMaxWeight = input.nextFloat();
        CargoShip cShip = new CargoShip(stack, initMaxHeight, initMaxWeight);
        System.out.println("\nCargo ship created."
                + "\nPulling ship in to dock..."
                + "\nCargo ship ready to be loaded.\n");
        CargoStack dock = new CargoStack(initMaxHeight);

        String response;
        boolean programOn = true;
        while (programOn) {
            System.out.print("Please select an option:"
                    + "\nC) Create new cargo."
                    + "\nL) Load cargo from dock."
                    + "\nU) Unload cargo from ship."
                    + "\nM) Move cargo between stacks"
                    + "\nK) Clear dock"
                    + "\nP) Print ship stacks"
                    + "\nS) Search for cargo"
                    + "\nQ) Quit.\n\n"
                    + "Select a menu option: ");
            response = input.next().toUpperCase();
            System.out.println();
            input.nextLine();
            try {
                switch (response) {
                    case "C":
                        System.out.println("Enter the name of the cargo:");
                        String name = input.nextLine();

                        System.out.println("Enter the weight of the cargo:");
                        int initWeight = input.nextInt();
                        input.nextLine();

                        System.out.println("Enter the container strength (F/M/S):");
                        String initstrength = input.nextLine();
                        if (initstrength.toUpperCase().equals("F")) {
                            initstrength = "F";
                        } else if (initstrength.toUpperCase().equals("M")) {
                            initstrength = "M";
                        } else if (initstrength.toUpperCase().equals("S")) {
                            initstrength = "S";
                        }
                        CargoStrength cS = CargoStrength.valueOf(initstrength);
                        Cargo cargo = new Cargo(name, initWeight, cS);
                        dock.push(cargo);
                        System.out.println("\nCargo '" + name + "' pushed onto the dock.\n");
                        System.out.println(cShip.toString());
                        System.out.println("Dock stack: "+dock.toString());
                        System.out.println("\nTotal Weight = " +totalWeight+"/" + cShip.maxWeight + "\n");
                        break;
                    case "U":
                        System.out.println("Select the unload source stack index:");
                        stack = input.nextInt();
                        dock.push(cShip.popCargo(stack));
                        totalWeight = totalWeight - dock.peek().getWeight();
                        System.out.println("\nTotal Weight = " +totalWeight+"/" + cShip.maxWeight + "\n");
                        break;
                    case "L":
                        System.out.println("Select the load destination stack index:");
                        stack = input.nextInt();
                        name = dock.peek().getName();
                        double weight = dock.peek().getWeight();
                        cShip.pushCargo(dock.pop(), stack);
                        System.out.println("Cargo '" +name+ "' moved from dock to stack " +stack+ ".\n");
                        totalWeight = totalWeight + weight;
                        System.out.println(cShip.toString());
                        System.out.println("Dock stack: "+dock.toString());
                        System.out.println("\nTotal Weight = " +totalWeight+"/" + cShip.maxWeight + "\n");
                        break;
                    case "M":
                        System.out.println("Source stack index:");
                        int stack1 = input.nextInt();
                        System.out.println("Destination stack index:");
                        int stack2 = input.nextInt();
                        cShip.pushCargo(cShip.popCargo(stack1), stack2);
                        break;
                    case "K":
                        for (int i = -1; i <= dock.cargos.size(); i++) {
                            dock.pop();
                        }
                        System.out.println("Dock cleared.");
                        System.out.println(cShip.toString());
                        System.out.println("Dock stack: "+dock.toString());
                        System.out.println("\nTotal Weight = " +totalWeight+"/" + cShip.maxWeight + "\n");
                        break;
                    case "P":
                        System.out.println(cShip.toString());
                        System.out.println("Dock stack: "+dock.toString());
                        System.out.println("\nTotal Weight = " +totalWeight+"/" + cShip.maxWeight + "\n");
                        break;
                    case "S":
                        System.out.println("Enter the name of the cargo:");
                        name = input.nextLine();
                        cShip.findAndPrint(name);
                        System.out.println("Cargo '" + name + "' found at the following locations:");
                        break;
                    case "Q":
                        programOn = false;
                        break;
                    default:
                        System.out.println("\"" + response + "\" is not one of the menu options.\n");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("An error has occured. Please try again.\n");
            }
        }
        System.out.println("Program terminating normally...");
        input.close();
    }
}
