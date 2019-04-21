//Η κλάση αυτή υπάρχει διότι υπάρχει σαν γνώρισμα στην κλάση Application. 
//Δεν έχει καμία άλλη χρήση

package DevicesWithdraw;

/**
 *
 * @author Γρηγορης
 */
public class Account {
    
    private String username;
    private String password;

    //Constructor
    public Account() {
    }

    //Constructor
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
