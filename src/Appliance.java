
package DevicesWithdraw;

/**
 *
 * @author Γρηγόρης
 */
public class Appliance {
    
    private int id;                      //appliance's id
    private String type;                 //appliance's type (electrical or simple)
    private double height;               //appliance's height
    private double amplitude;            //appliance's amplitude
    private double length;               //appliance's length
    private double weight;               //appliance's weight
    private double volume;               //appliance's volume
    private String name;                 //appliance's name
    private Application application;     //application that is relative with appliance
   
    //Constructor
    public Appliance(double weight, double volume, String name) {
        this.weight = weight;
        this.volume = volume;
        this.name = name;
    }
           
    public Application getApplication() {
        return application;
    }

    public String getName() {
        return name;
    }

    public double getVolume() {
        return volume;
    }
    
    public double getWeight() {
        return weight;
    }
     
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
    
    public double getHeight() {
        return height;
    }

    public double getAmplitude() {
        return amplitude;
    }
    
    public double getLength() {
        return length;
    }
    
    public void setApplication(Application a) {
        application = a;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setVolume(float vol) {
        volume = vol;
    }
        
    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setAmplitude(float amplitude) {
        this.amplitude = amplitude;
    }

    public void setLength(float length) {
        this.length = length;
    }
}
