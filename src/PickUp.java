
package DevicesWithdraw;


import java.util.*;

/**
 *
 * @author Γρηγόρης
 */
public class PickUp {
    
    private Date disposalDate;                          //pickUp's diasposal date
    private int numberOfPickUp;                         //pickUp's number
    private double totalVolume;                         //pickUp's total volume
    private double totalWeight;                         //pickUp's total weight
    private List<Double> pickUpVolumeVehicle;           //list to store volume of each vehicle that executes this pickUp
    private List<Double> pickUpWeightVehicle;           //list to store weight of each vehicle that executes this pickUp
    private List<Integer> totalApplicationsByVehicle;   //list to store number of applications that are served by vehicle by pickUp
    private Municipality municipality;                  //municipality that is responsible for pickUp
    private Officer officer;                            //officer that manages pickUp
    private Payment payment;                            //payment that is responsible for pickUp
    private ReportDisposal reportDisposal;              //XML file relative with pickUp
    private final List<DisposalPoint> disposalPoints;   //list with disposalPoints relative with pickUp
    private final List<Application> application;        //list with applications relative with pickUp
    private final List<TransportVehicle> vehicles;      //list with vehicles that executes pickUp
    
    
    //Default constructor
    public PickUp() {
        vehicles = new ArrayList<>();
        application = new ArrayList<>();
        pickUpVolumeVehicle = new ArrayList<>();
        pickUpWeightVehicle = new ArrayList<>();
        totalApplicationsByVehicle = new ArrayList<>();
        disposalPoints = new ArrayList<>();
    }

    //Constructor
    public PickUp(Date dateOfPickup, int numberOfPickUp) {
        this.disposalDate = dateOfPickup;
        this.numberOfPickUp = numberOfPickUp;
        pickUpVolumeVehicle = new ArrayList<>();
        pickUpWeightVehicle = new ArrayList<>();
        totalApplicationsByVehicle = new ArrayList<>();
        vehicles = new ArrayList<>();
        application = new ArrayList<>();
        disposalPoints = new ArrayList<>();
    }

    public Date getDisposalDate() {
        return disposalDate;
    }

    public void setDisposalDate(Date disposalDate) {
        this.disposalDate = disposalDate;
    }
    
    public int getNumberOfPickUp() {
        return numberOfPickUp;
    }

    public void setNumberOfPickUp(int numberOfPickUp) {
        this.numberOfPickUp = numberOfPickUp;
    }
    
    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }
    
    public Officer getOfficer() {
        return officer;
    }

    public void setOfficer(Officer o) {
        officer = o;
    }
    
    public double getTotalVolume() {
        return totalVolume;
    }
    
    public void setTotalVolume(double totalVolume) {
        this.totalVolume = totalVolume;
    }
    
     public double getTotalWeight() {
        return totalWeight;
    }
     
    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public ReportDisposal getReportDisposal() {
        return reportDisposal;
    }

    public void setReportDisposal(ReportDisposal reportDisposal) {
        this.reportDisposal = reportDisposal;
    }
    
    public void addApplication(Application a){
        application.add(a);
    }
    
    public void removeApplication(Application a){
        application.remove(a);
    }
    
    public List<Application> getApplication() {
        return application;
    }
    
    public void addTransportVehicle(TransportVehicle t){
        vehicles.add(t);
    }

    public void removeTransportVehicle(TransportVehicle t){
        vehicles.remove(t);
    }
    
    public List<TransportVehicle> getVehicles() {
        return vehicles;
    }
    
    public void d(Double d){
        pickUpVolumeVehicle.add(d);
    }
    
    public void addpickUpVolumeVehicle(Double d){
        pickUpVolumeVehicle.add(d);
    }
    
    public void removepickUpVolumeVehicle(Double d){
        pickUpVolumeVehicle.remove(d);
    }
    
    public List<Double> getpickUpVolumeVehicle() {
        return pickUpVolumeVehicle;
    }
    
    public void addpickUpWeightVehicle(Double d){
        pickUpWeightVehicle.add(d);
    }
    
    public void removepickUpWeightVehicle(Double d){
        pickUpWeightVehicle.remove(d);
    }
    
    public List<Double> getpickUpWeightVehicle() {
        return pickUpWeightVehicle;
    }
    
    public void addtotalApplicationsByVehicle(Integer i){
        totalApplicationsByVehicle.add(i);
    }
    
    public void removetotalApplicationsByVehicle(Integer i){
        totalApplicationsByVehicle.remove(i);
    }
    
    public List<Integer> gettotalApplicationsByVehicle() {
        return totalApplicationsByVehicle;
    }
    
    public void addDisposalPoints(DisposalPoint d){
        disposalPoints.add(d);
    }
    
    public void removeDisposalPoints(DisposalPoint d){
        disposalPoints.remove(d);
    }
    
    public List<DisposalPoint> getDisposalPoints(){
        return disposalPoints;
    }
}
