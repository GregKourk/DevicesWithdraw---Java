
package DevicesWithdraw;

import java.util.*;

/**
 *
 * @author Γρηγόρης
 */
public class Application {
    
    private int applicatioNumber;                   //application's number
    private String address;                         //application's address
    private int floor;                              //application's floor
    private boolean status;                         //variable relative with application's satisfaction
    private Account account;                        //account that creates application
    private PickUp pickUp;                          //each application concerns 1 pickup
    private final List<Appliance> appliances;       //each application includes list of appliances

    
    //Default constructor
    public Application() {
        appliances = new ArrayList<>();
    }
    
    //Constructor 
    public Application(int applicationNumber, boolean status, String addressofappliance) {
        this.applicatioNumber = applicationNumber;
        this.status = status;
        this.address = addressofappliance;
        appliances = new ArrayList<>();
    }

    public int getApplicatioNumber() {
        return applicatioNumber;
    }
    
    public boolean isStatus() {
        return status;
    }
    
    public String getAddress(){
        return address;
    }

    public int getFloor() {
        return floor;
    }
    
    public PickUp getPickUp() {
        return pickUp;
    }
    
    public void setApplicatioNumber(int applicatioNumber) {
        this.applicatioNumber = applicatioNumber;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void setAddress(String a){
        this.address = a;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
    
    public void setPickUp(PickUp pickUp) {
        this.pickUp = pickUp;
    }
    
    public void addAppliance(Appliance a){
        appliances.add(a);
    }
    
    public List<Appliance> getAppliances() {
        return appliances;
    }
    
    public void removeAppliance(Appliance a){
        appliances.remove(a);
    }
}
