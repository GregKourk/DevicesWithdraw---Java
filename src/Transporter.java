
package DevicesWithdraw;

/**
 *
 * @author Γρηγόρης
 */
public class Transporter extends Employee{

   private EmployeeCategory category;                     //employee's category
   private TransportVehicle transportVehicle;             //vehicle that is relative with transporter
   
   //Constructor
   public Transporter(String name) {
        super(name);        
    }

   //Constructor
    public Transporter(String name, EmployeeCategory k) {
        super(name);
        category = k;
    }

    public EmployeeCategory getCategory() {
        return category;
    }

    public void setCategory(EmployeeCategory k) {
        category = k;
    }
    
    public TransportVehicle getTransportVehicle() {
        return transportVehicle;
    }
    
    public void setTransportVehicle(TransportVehicle t) {
        transportVehicle = t;
    }
}
