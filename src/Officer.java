
package DevicesWithdraw;

import java.util.*;

/**
 *
 * @author Γρηγόρης
 */
public class Officer extends Employee{
    
    private EmployeeCategory category;                    //employee's category
    private final List<PickUp> pickUp;                    //lists of applications that officer manages

    //Constructor
    public Officer(String name) {
        super(name);
        pickUp = new ArrayList<>();
    }

    //Constructor
    public Officer(String name, EmployeeCategory k) {
        super(name);
        category = k;
        pickUp = new ArrayList<>();
    }

    public EmployeeCategory getCategory() {
        return category;
    }

    public void setCategory(EmployeeCategory k) {
        category = k;
    }
        
    public void addPickUp(PickUp p){
        pickUp.add(p);
    }
    
    public void removePickUp(PickUp p){
        pickUp.remove(p);
    }
    
    public List<PickUp> getPickUp() {
        return pickUp;    
    }    
}
