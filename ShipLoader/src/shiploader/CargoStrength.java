/**
* Dennis Lin
* 109426873
* Homework #3
* CSE214 R05 
* Recitation TA: Vladimir Yevseenko
 */

package shiploader;

public enum CargoStrength {
    F(1), M(2), S(3);
    
    private final int CargoStrID;

    private CargoStrength(int CargoStrID) {
        this.CargoStrID = CargoStrID;
    }
    
    public int getvalue(){
        return CargoStrID;
    }
}
