
package DevicesWithdraw;

/**
 *
 * @author Γρηγόρης
 */
public class Employee {
    
    protected int id;                         //employee's id
    protected String name;                    //employee's name 
    protected Municipality municipality;      //municipality that employee is working

    //Constructor
    public Employee(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public Municipality getMunicipality() {
        return municipality;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setMunicipality(Municipality m) {
        municipality = m;
    }
}
