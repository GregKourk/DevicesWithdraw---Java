
package DevicesWithdraw;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 *
 * @author Γρηγόρης
 */
public class Main {
    public static void main(String argv[]) throws Exception {
       
      //Applications creation  
      Application application1 = new Application(1 , false, "ΧΑΛΑΝΔΡΙ");               
      Application application2 = new Application(2 , false, "ΜΑΡΟΥΣΙ");
      Application application3 = new Application(3 , false, "ΦΙΛΟΘΕΗ");
      Application application4 = new Application(4 , false, "ΓΑΛΑΤΣΙ");
      Application application5 = new Application(5 , false, "ΝΕΑ ΧΑΛΚΗΔΟΝΑ");
      Application application6 = new Application(6 , false, "ΜΕΤΑΜΟΡΦΩΣΗ");
      
      //Appliances creation
      Appliance appliance1 = new Appliance(90.0 , 1.0 , "ΚΟΥΖΙΝΑ" );
      appliance1.setApplication(application1);
      application1.addAppliance(appliance1);

      Appliance appliance2 = new Appliance(60.0 , 2.0 , "ΨΥΓΕΙΟ" );
      appliance2.setApplication(application1);
      application1.addAppliance(appliance2);
      
      Appliance appliance3 = new Appliance(70.0 , 1.5 , "ΚΑΤΑΨΥΚΤΗΣ" );
      appliance3.setApplication(application2);
      application2.addAppliance(appliance3);
      
      Appliance appliance4 = new Appliance(110.0 , 1.0 , "ΠΛΥΝΤΗΡΙΟ" );
      appliance4.setApplication(application2);
      application2.addAppliance(appliance4);
      
      Appliance appliance5 = new Appliance(120.0 , 0.9 , "ΚΟΥΖΙΝΑ" );
      appliance5.setApplication(application3);
      application3.addAppliance(appliance5);
      
      Appliance appliance6 = new Appliance(90.0 , 1.8 , "ΨΥΓΕΙΟ" );
      appliance6.setApplication(application3);
      application3.addAppliance(appliance6);
      
      Appliance appliance7 = new Appliance(90.0 , 1.7 , "ΚΑΤΑΨΥΚΤΗΣ" );
      appliance7.setApplication(application4);
      application4.addAppliance(appliance7);
      
      Appliance appliance8 = new Appliance(130.0 , 1.2 , "ΠΛΥΝΤΗΡΙΟ" );
      appliance8.setApplication(application4);
      application4.addAppliance(appliance8);
      
      Appliance appliance9 = new Appliance(80.0 , 1.1 , "ΚΟΥΖΙΝΑ" );
      appliance9.setApplication(application5);
      application5.addAppliance(appliance9);
      
      Appliance appliance10 = new Appliance(50.0 , 2.1 , "ΨΥΓΕΙΟ" );
      appliance10.setApplication(application5);
      application5.addAppliance(appliance10);
      
      Appliance appliance11 = new Appliance(60.0 , 1.7 , "ΚΑΤΑΨΥΚΤΗΣ" );
      appliance11.setApplication(application6);
      application6.addAppliance(appliance11);
      
      Appliance appliance12 = new Appliance(100.0 , 1.2 , "ΠΛΥΝΤΗΡΙΟ" );
      appliance12.setApplication(application6);
      application6.addAppliance(appliance12);
       
      //Municipality creation
      Municipality municipality1 = new Municipality("ΑΘΗΝΑ");
      
      //Employees creation
      Officer officer1 = new Officer("Γραφείο1", EmployeeCategory.Officer);
      Driver driver1 = new Driver("Οδηγός1", EmployeeCategory.Driver);
      Driver driver2 = new Driver("Οδηγός2", EmployeeCategory.Driver);
      Transporter transporter11 = new Transporter("Μεταφορέας11", EmployeeCategory.Transporter);
      Transporter transporter12 = new Transporter("Μεταφορέας12", EmployeeCategory.Transporter);
      Transporter transporter21 = new Transporter("Μεταφορέας21", EmployeeCategory.Transporter);
      Transporter transporter22 = new Transporter("Μεταφορέας22", EmployeeCategory.Transporter);
      
      //Vehicles creations
      TransportVehicle vehicle1 = new TransportVehicle("Φορτηγό1", 5, 500);
      TransportVehicle vehicle2 = new TransportVehicle("Φορτηγό2", 7, 600);
      
      municipality1.addEmployee(officer1);
      officer1.setMunicipality(municipality1);
      
      municipality1.addEmployee(driver1);
      driver1.setMunicipality(municipality1);
      
      municipality1.addEmployee(driver2);
      driver2.setMunicipality(municipality1);
      
      municipality1.addEmployee(transporter11);
      transporter11.setMunicipality(municipality1);
      
      municipality1.addEmployee(transporter12);
      transporter12.setMunicipality(municipality1);
      
      municipality1.addEmployee(transporter21);
      transporter21.setMunicipality(municipality1);
      
      municipality1.addEmployee(transporter22);
      transporter22.setMunicipality(municipality1);
      
      vehicle1.addEmployee(driver1);
      driver1.setTransportVehicle(vehicle1);
      
      vehicle1.addEmployee(transporter11);
      transporter11.setTransportVehicle(vehicle1);
      
      vehicle1.addEmployee(transporter12);
      transporter12.setTransportVehicle(vehicle1);
      
      vehicle2.addEmployee(driver2);
      driver2.setTransportVehicle(vehicle2);
      
      vehicle2.addEmployee(transporter21);
      transporter21.setTransportVehicle(vehicle2);
      
      vehicle2.addEmployee(transporter22);
      transporter22.setTransportVehicle(vehicle2);
      
      municipality1.addOximata(vehicle1);
      vehicle1.setMunicipality(municipality1);

      municipality1.addOximata(vehicle2);
      vehicle2.setMunicipality(municipality1);
      
      //DisposalPoint creation
      DisposalPoint disposal = new DisposalPoint("Κεντρική Αποθήκη Ασπροπύργου");
      
      
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
        
        //list of Applications
        List<Application> applicationsToRun = new ArrayList<>();
        applicationsToRun.add(application1);
        applicationsToRun.add(application2);
        applicationsToRun.add(application3);
        applicationsToRun.add(application4);
        applicationsToRun.add(application5);
        applicationsToRun.add(application6);
        
       
        //list of created pickUps
        List<PickUp> createdPickUps = new ArrayList<>();            
                
        int pickUpCounter=1;        
        int servedApplicationsCounter=0;              
        
        
        while (servedApplicationsCounter < applicationsToRun.size()){
            servedApplicationsCounter=0;
            
            PickUp pick = officer1.getMunicipality().createPickUp(officer1, date, pickUpCounter, disposal, applicationsToRun);
            
            createdPickUps.add(pick);
            
            pickUpCounter++;                                                        
            
            for (Application application: applicationsToRun){
                if (application.isStatus()== true){
                    servedApplicationsCounter++;
                }
            }
        }
        
        //document creation
        DocumentBuilderFactory dbFactory =
        DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();
        
        //reportDisposal creation
        ReportDisposal report = new ReportDisposal();
        
        //XML file creation
        report.ReportDisposalXML(createdPickUps, doc);
    }
}