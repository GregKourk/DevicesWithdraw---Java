
package DevicesWithdraw;

/**
 *
 * @author Γρηγόρης
 */
public class Driver extends Employee{
    
    private EmployeeCategory category;                 //employee category
    private TransportVehicle transportVehicle;         //vehicle that is relative with driver

    //Constructor
    public Driver(String name) {
        super(name);        
    }

    //Constructor
    public Driver(String name, EmployeeCategory k) {
        super(name);
        category = k;
    }

    public EmployeeCategory getCategory() {
        return category;
    }
    
    public TransportVehicle getTransportVehicle() {
        return transportVehicle;
    }
    
    public void setTransportVehicle(TransportVehicle t) {
        transportVehicle = t;
    }
    
    public void setCategory(EmployeeCategory k) {
        category = k;
    }
}
