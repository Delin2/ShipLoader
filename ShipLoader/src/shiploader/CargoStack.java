/**
* Dennis Lin
* 109426873
* Homework #3
* CSE214 R05 
* Recitation TA: Vladimir Yevseenko
 */

package shiploader;

import java.util.ArrayList;

public class CargoStack {

    ArrayList<Cargo> cargos;
    int maxSize;

    public CargoStack(int initMaxHeight) {
        cargos = new ArrayList<>();
        maxSize = initMaxHeight;
    }

    public void push(Cargo c) {
        if (maxSize <= cargos.size()) {
            throw new IllegalArgumentException("Full Stack");
        }else if(cargos.size() !=0 && peek().strength().getvalue() < c.strength().getvalue()){
            throw new IllegalArgumentException("Operation failed! Cargo at top of stack cannot support weight.");
        }else
        cargos.add(c);
    }

    public Cargo pop() {
        if (cargos.size() <= 0) {
            throw new IllegalArgumentException("Empty Stack");
        }
        return cargos.remove(cargos.size()-1);
    }

    public Cargo peek() {
        if (cargos.size() <= 0) {
            throw new IllegalArgumentException("Empty Stack");
        }
        return cargos.get(cargos.size()-1);
    }
    
    public void findAndPrint(String name){
        for(int i = 0; i < cargos.size(); i++)
            if(name.equals(cargos.get(i)))
                System.out.printf("%-10d%-10d%-10d%-10s", i, cargos.get(i).getWeight(), cargos.get(i).strength());
    }
    
    public boolean isEmpty(){
        if(cargos.size()== 0)
            return true;
        else
            return false;
    }
    
    @Override
    public String toString(){
        String cargoStack = "";
        for(int i = 0; i < cargos.size(); i++){
            cargoStack += cargos.get(i).toString();
            cargoStack += " ";
        }
        return cargoStack;
    }
}
