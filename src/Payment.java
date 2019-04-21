
package DevicesWithdraw;

/**
 *
 * @author Γρηγορης
 */
public class Payment {
    
    
    private int paymentCode;                    //playment's code
    private PickUp pickUp;                      //pickUp that playment is relative with
    

    //Constructor
    public Payment(int paymentCode) {
        this.paymentCode = paymentCode;
    }

    public int getPaymentCode() {
        return paymentCode;
    }

    public PickUp getPickUp() {
        return pickUp;
    }

    public void setPaymentCode(int paymentCode) {
        this.paymentCode = paymentCode;
    }

    public void setPickUp(PickUp pickUp) {
        this.pickUp = pickUp;
    }
}
