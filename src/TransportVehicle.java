
package DevicesWithdraw;

import java.util.*;

/**
 *
 * @author Γρηγόρης
 */
public class TransportVehicle {
    
    static final int maxDrivers=1;              //max number of drivers allowed into vehicle
    static final int maxTransporters=2;         //max number of transporters allowed into vehicle
    private String licencePlate;                //vehicle's lince plate
    private int numDrivers;                     //current number of drivers
    private int numTransporters;                //current number of transporters
    private double maxSpace;                    //vehicle's max available space
    private double maxWeight;                   //vehicle's max available weight
    private double pickUpVolume;                //pickUp's volume
    private double pickUpWeight;                //pickUp's weight
    private PickUp pickUp;                      //pickUp that is relative with vehicle
    private Municipality municipality;          //municipality that is relative with vehicle
    private List<Employee> employees;           //list of employees that is relative with vehicle
    
   
    
    //Default constructor
    public TransportVehicle() {
        numDrivers=0;                           
        numTransporters=0;                      
        employees = new ArrayList<>();         
    }

    //Constructor
    public TransportVehicle(String licencePlate, double totalSpace, double totalWeight) {
        this.licencePlate = licencePlate;
        this.maxSpace = totalSpace;
        this.maxWeight = totalWeight;
        employees = new ArrayList<>();
        numDrivers=0;
        numTransporters=0;
    }
    
    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }
    
    public PickUp getPickUp() {
        return pickUp;
    }
    
    public void setPickUp(PickUp p) {
        pickUp = p;
    }
    
    public Municipality getMunicipality() {
        return municipality;
    }
    
    public void setMunicipality(Municipality m) {
        municipality = m;
    }
    
    public double getMaxSpace() {
        return maxSpace;
    }

    public void setMaxSpace(double maxSpace) {
        this.maxSpace = maxSpace;
    }
    
    public double getMaxWeight() {
        return maxWeight;
    }
    
    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getPickUpVolume() {
        return pickUpVolume;
    }

    public void setPickUpVolume(double pickUpVolume) {
        this.pickUpVolume = pickUpVolume;
    }
    
    public double getPickUpWeight() {
        return pickUpWeight;
    }
    
    public void setPickUpWeight(double pickUpWeight) {
        this.pickUpWeight = pickUpWeight;
    }
    
    public void addEmployee(Employee e) throws Exception{
        if (e instanceof Driver){                                                                            
            if (numDrivers<maxDrivers){                                             
                employees.add(e);                                                   
                numDrivers++;                                                      
                Driver d = (Driver)e;                                              
                d.setTransportVehicle(this);                                        
            }
            else{                                                                   
                throw new Exception("Υπέρβαση αριθμού οδηγών για το όχημα");
            }
        }
        if (e instanceof Transporter){                                              
            if (numTransporters<maxTransporters){                                  
                 employees.add(e);                                                  
                 numTransporters++;                                                 
                 Transporter t = (Transporter)e;                                    
                 t.setTransportVehicle(this);                                       
            }
        else{                                                                       
           throw new Exception("Υπέρβαση αριθμού μεταφορέων για το όχημα"); 
            }
        }                
    }
    
    public void removeEmployee(Employee e){                                                    
        employees.remove(e);                            
        if ( e instanceof Driver){                      
            numDrivers--;                               
            Driver d = (Driver)e;                       
            d.setTransportVehicle(null);                
        }
        if (e instanceof Transporter){                  
            numTransporters--;                          
            Transporter t = (Transporter)e;            
            t.setTransportVehicle(null);                
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

}
