
package DevicesWithdraw;

import java.util.*;


/**
 *
 * @author Γρηγόρης
 */
public class Municipality {
    
    private String name;                                //municipality's name
    private String id;                                  //municipality's id
    private final List<TransportVehicle> vehicles;       //list of vehicles that municipality has
    private final List<Employee> employees;             //list of employees that municipality has
    private final List<PickUp> pickUp;                  //list of pickUps that municipality serves
    
    //Default constructor
    public Municipality(){
        vehicles = new ArrayList<>();                      
        employees = new ArrayList<>();                  
        pickUp = new ArrayList<>();                     
    }

    //Constructor
    public Municipality(String name) {
        this.name = name;
        vehicles = new ArrayList<>();                        
        employees = new ArrayList<>();                  
        pickUp = new ArrayList<>();     
    }

    public String getName() {
        return name;
    }
    
    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void addEmployee(Employee e){
        employees.add(e);
    } 
    
    public void removeEmployee(Employee e){
        employees.remove(e);
    }
    
    public List<Employee> getEmployee() {
        return employees;
    }
    
    public void addOximata(TransportVehicle t){
        vehicles.add(t);
    }
    
    public void removeOximata(TransportVehicle t){
        vehicles.remove(t);
    }
    
    public List<TransportVehicle> getVehicles() {
        return vehicles;
    }
    
    public void addPickUp(PickUp p){
        pickUp.add(p);
    }
    
    public void removePickUp(PickUp p){
        pickUp.remove(p);
    }
    
    public List<PickUp> getPickUp() {
        return pickUp;
    }
           
    public PickUp createPickUp(Officer officer, Date disposalDate, Integer disposalNumber, DisposalPoint disposalPoint, List<Application> applications){
        
        double totalVolumeOfAppliancesOfPickUp=0;                               
        double totalWeightOfAppliancesOfPickUp=0;                               
        double applicationVolume=0;                         
        double applicationWeight=0;                         
        double vehicleAvailableVolume=0;                           
        double vehicleAvailableWeight=0;                           
        double vehicleInitialVolume=0;                             
        double vehicleInitialWeight=0;                             
        double vehicleTotalAvailableVolume=0;                                    
        double vehicleTotalAvailableWeight=0;                                    
        int numberOfApplicationsOfPickUpCounter=0;                                      
        
        PickUp newpickUp = new PickUp(disposalDate, disposalNumber);
        
        List<Appliance> appliancesToExam = new ArrayList<>();        
        List<Appliance> appliancesToPrint = new ArrayList<>();       
        List<Employee> employees = new ArrayList<>();                
        
        newpickUp.addDisposalPoints(disposalPoint);
        

        
        
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println("<PICKUP>");
        System.out.println("\tPICKUP NUMBER: " + newpickUp.getNumberOfPickUp());
        System.out.println("\tDISPOSAL POINT: " + disposalPoint.toString());
        System.out.println("\tPICKUP DATE: " + newpickUp.getDisposalDate());
        
        
        for (TransportVehicle vehicle: vehicles){                                            
            vehicleInitialVolume = vehicle.getMaxSpace();                                        
            vehicleInitialWeight = vehicle.getMaxWeight();                                       
            vehicleAvailableVolume = vehicleInitialVolume;                                                
            vehicleAvailableWeight = vehicleInitialWeight;                                               
            appliancesToPrint.clear();                                                      
            numberOfApplicationsOfPickUpCounter=0;                                                                      
            for (Application application: applications){                                    
                if (application.isStatus()==false){                                          
                    applicationVolume=0;
                    applicationWeight=0;
                    appliancesToExam = application.getAppliances();
                    for (Appliance appliance : appliancesToExam){                           
                        applicationVolume += appliance.getVolume();
                        applicationWeight += appliance.getWeight();
                    }
                    if (vehicleAvailableVolume >= applicationVolume && vehicleAvailableWeight >= applicationWeight){      
                        vehicleAvailableVolume -= applicationVolume;                               
                        vehicleAvailableWeight -= applicationWeight;                               
                        totalVolumeOfAppliancesOfPickUp += applicationVolume;                                   
                        totalWeightOfAppliancesOfPickUp += applicationWeight;                                   
                        application.setStatus(true);                                        
                        application.setPickUp(newpickUp);                                   
                        newpickUp.addApplication(application);                              
                        appliancesToPrint.addAll(appliancesToExam);                          
                        numberOfApplicationsOfPickUpCounter++;                                                         
                    } 
                }
            }
            
            if(vehicleAvailableVolume != vehicleInitialVolume && vehicleAvailableWeight!=vehicleInitialWeight){
                newpickUp.addTransportVehicle(vehicle);                                             
                vehicle.setPickUp(newpickUp);                                                       
                vehicle.setPickUpVolume(vehicleInitialVolume - vehicleAvailableVolume);                           
                vehicle.setPickUpWeight(vehicleInitialWeight - vehicleAvailableWeight);                          
            }
            
            newpickUp.addpickUpVolumeVehicle(vehicleInitialVolume - vehicleAvailableVolume);
            newpickUp.addpickUpWeightVehicle(vehicleInitialWeight - vehicleAvailableWeight);
            
            newpickUp.addtotalApplicationsByVehicle(numberOfApplicationsOfPickUpCounter);
            
            //ΣΥΝΕΧΙΣΗ ΕΚΤΥΠΩΣΗΣ ΑΠΟ ΑΥΤΟ ΤΟ ΣΗΜΕΙΟ
            System.out.println("\tVEHICLE:");
            System.out.println("\t\tLICENCE PLATE: " + vehicle.getLicencePlate());
            employees = vehicle.getEmployees();                                                    
            for (Employee employee: employees){                                                    
                if (employee instanceof Driver)
                    System.out.println("\t\tHas driver: " + employee.getName());}
            System.out.print("\t\tHas transporters:");
            for (Employee employee: employees)  {                                                     
                if (employee instanceof Transporter){                    
                    System.out.print("  " + employee.getName());
                }                    
            }
            System.out.println();
            System.out.println("\tBENEFICIAL VOLUME: " + vehicleInitialVolume);
            System.out.println("\tBENEFICIAL WEIGHT: " + vehicleInitialWeight);
            System.out.println("\tPICKUP VOLUME: " + (vehicle.getPickUpVolume()) );
            System.out.println("\tPICKUP WEIGHT:" + (vehicle.getPickUpWeight())); 
            System.out.println("\tAPPLIANCE: ");
            for (Appliance appliance : appliancesToPrint){                                          
                System.out.println("\t\tNAME: " + appliance.getName());
                System.out.println("\t\tWEIGHT: " + appliance.getWeight());
                System.out.println("\t\tVOLUME: " + appliance.getVolume());
            }
        }
         
        newpickUp.setTotalVolume(totalVolumeOfAppliancesOfPickUp);                                                  
        newpickUp.setTotalWeight(totalWeightOfAppliancesOfPickUp);                                                  
        System.out.println("\tPICKUP TOTAL VOLUME: " + newpickUp.getTotalVolume());
        System.out.println("\tPICKUP TOTAL WEIGHT: " + newpickUp.getTotalWeight());      
            
        System.out.println("---------------------------");
        System.out.println("---------------------------");
            
        return newpickUp; 
    }
   
}