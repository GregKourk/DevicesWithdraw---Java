
package DevicesWithdraw;

/**
 *
 * @author Γρηγόρης
 */
public class DisposalPoint {
    
    private String adress;              //disposal point's address
    private PickUp pickUp;              //disposal point's is relative with 1 pickUp

    //Constructor
    public DisposalPoint(String adress) {
        this.adress = adress;
    }
    
    public String getAdress() {
        return adress;
    }
    
    public PickUp getPickUp() {
        return pickUp;
    }
    
    public void setAdress(String adress) {
        this.adress = adress;
    }
    
    public void setPickUp(PickUp p) {
        pickUp = p;
    }
    
    @Override
    public String toString(){
       return (adress); 
    }
}
