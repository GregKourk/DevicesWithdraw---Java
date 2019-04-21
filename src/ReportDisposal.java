
package DevicesWithdraw;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;


/**
 *
 * @author Γρηγόρης
 */
public class ReportDisposal {
    
    private final List<PickUp> pickUps;                     //list of pickUp's that is relative with report of disposal
    private int vehicleListCounter=0;                                        
    private int employeeListCounter=0;                                       
    private int applianceListCounter=0;                                       
    
    
    //Constructor
    public ReportDisposal(){
        pickUps = new ArrayList<>();
    }

    public void addPickUps(PickUp p){
        pickUps.add(p);
    }
    
    public void removePickUps(PickUp p){
        pickUps.remove(p);
    }
    
    public List<PickUp> getPickUps() {
        return pickUps;    
    }  

    
    //Function with input list of pivkUps and a document, in order to draw elements of each pickUp and isert them into XML file
    public void ReportDisposalXML(List<PickUp> pickUps, Document documento) throws ParserConfigurationException, TransformerConfigurationException, TransformerException{
        
        //Create initial header
        Element rootElement = documento.createElement("Disposal");
        documento.appendChild(rootElement);
        
        for (PickUp picks: pickUps){
            Element PickUpNumber = documento.createElement("PickUp_Number");
            PickUpNumber.appendChild(documento.createTextNode(Integer.toString(picks.getNumberOfPickUp())));
            rootElement.appendChild(PickUpNumber);
            
            Element pickUpDisposalPoint = documento.createElement("Disposal_Point");
            pickUpDisposalPoint.appendChild(documento.createTextNode(picks.getDisposalPoints().get(vehicleListCounter).toString()));
            rootElement.appendChild(pickUpDisposalPoint);
            
            Element PickUpDate = documento.createElement("PickUP_Date");
            Date disposalDate = picks.getDisposalDate();
            DateFormat dateFormats = new SimpleDateFormat("dd/MM/yyyy");
            String strDate = dateFormats.format(disposalDate);
            PickUpDate.appendChild(documento.createTextNode(strDate));
            rootElement.appendChild(PickUpDate);
        
            Element totalVolume = documento.createElement("PickUp_Total_Volume");
            totalVolume.appendChild(documento.createTextNode(String.valueOf(picks.getTotalVolume())));
            rootElement.appendChild(totalVolume);
        
            Element totalWeight = documento.createElement("PickUp_Total_Weight");
            totalWeight.appendChild(documento.createTextNode(String.valueOf(picks.getTotalWeight())));
            rootElement.appendChild(totalWeight);
        
            Element vehicle = documento.createElement("Vehicle");
            rootElement.appendChild(vehicle);
        
            int servedApplicationsByPickUpCounter=0;            
            int vehicleNumberUsedByPickUpCounter=0;            
            
            while (vehicleNumberUsedByPickUpCounter<picks.getVehicles().size()){
                Element vehicleLicence = documento.createElement("Vehicle_Licence_Plate");
                vehicleLicence.appendChild(documento.createTextNode(picks.getVehicles().get(vehicleNumberUsedByPickUpCounter).getLicencePlate()));
                vehicle.appendChild(vehicleLicence);
            
                //List with employees
                 List<Employee> employees = new ArrayList<>();           
                 
                //Employees list by vehicle
                employees = picks.getVehicles().get(vehicleNumberUsedByPickUpCounter).getEmployees();
                int employeeListExamineToFindDriverAndTrasportersCounter=0;        
                //find vehicle's driver
                while (employeeListExamineToFindDriverAndTrasportersCounter<employees.size()){
                    if (employees.get(employeeListExamineToFindDriverAndTrasportersCounter) instanceof Driver){
                        Element vehicleDriver = documento.createElement("Vehicle_Driver");
                        vehicleDriver.appendChild(documento.createTextNode(picks.getVehicles().get(vehicleNumberUsedByPickUpCounter).getEmployees().get(employeeListExamineToFindDriverAndTrasportersCounter).getName()));
                        vehicle.appendChild(vehicleDriver);
                    }
                    employeeListExamineToFindDriverAndTrasportersCounter++;
                }
                employeeListExamineToFindDriverAndTrasportersCounter=0;
                //find vehicle's transporter's
                while (employeeListExamineToFindDriverAndTrasportersCounter<employees.size()){
                    if (employees.get(employeeListExamineToFindDriverAndTrasportersCounter) instanceof Transporter){
                        Element vehicleTransporter = documento.createElement("Vehicle_Transporter");
                        vehicleTransporter.appendChild(documento.createTextNode(picks.getVehicles().get(vehicleNumberUsedByPickUpCounter).getEmployees().get(employeeListExamineToFindDriverAndTrasportersCounter).getName()));
                        vehicle.appendChild(vehicleTransporter);
                    }
                    employeeListExamineToFindDriverAndTrasportersCounter++;
                }
            
                Element vehicleVolume = documento.createElement("Initial_Space");
                vehicleVolume.appendChild(documento.createTextNode(String.valueOf(picks.getVehicles().get(vehicleNumberUsedByPickUpCounter).getMaxSpace())));
                vehicle.appendChild(vehicleVolume);
            
                Element vehicleWeight = documento.createElement("Initial_Weight");
                vehicleWeight.appendChild(documento.createTextNode(String.valueOf(picks.getVehicles().get(vehicleNumberUsedByPickUpCounter).getMaxWeight())));
                vehicle.appendChild(vehicleWeight);
            
                Element disposalVolume = documento.createElement("PickUP_Volume");
                disposalVolume.appendChild(documento.createTextNode(String.valueOf(picks.getpickUpVolumeVehicle().get(vehicleNumberUsedByPickUpCounter))));
                vehicle.appendChild(disposalVolume);
            
                Element disposalWeight = documento.createElement("PickUp_Weight");
                disposalWeight.appendChild(documento.createTextNode(String.valueOf(picks.getpickUpWeightVehicle().get(vehicleNumberUsedByPickUpCounter))));
                vehicle.appendChild(disposalWeight);
            
                Element PickUpAppliances = documento.createElement("Appliances");
                vehicle.appendChild(PickUpAppliances);
                int numberOfAppliancesCounter=0;
                while (numberOfAppliancesCounter<picks.gettotalApplicationsByVehicle().get(vehicleNumberUsedByPickUpCounter)){
                    for (Appliance appliances: picks.getApplication().get(servedApplicationsByPickUpCounter).getAppliances() ){
                        Element appliance = documento.createElement("Appliance");
                        PickUpAppliances.appendChild(appliance);
                    
                        Element applianceName = documento.createElement("Name");
                        applianceName.appendChild(documento.createTextNode(appliances.getName()));
                        appliance.appendChild(applianceName);
                    
                        Element applianceWeight = documento.createElement("Weight");
                        applianceWeight.appendChild(documento.createTextNode(String.valueOf(appliances.getWeight())));
                        appliance.appendChild(applianceWeight);
                    
                        Element applianceVolume = documento.createElement("Volume");
                        applianceVolume.appendChild(documento.createTextNode(String.valueOf(appliances.getVolume())));
                        appliance.appendChild(applianceVolume);
                    }
                    numberOfAppliancesCounter++;
                    servedApplicationsByPickUpCounter++;
                }
                vehicleNumberUsedByPickUpCounter++;
            }
            
            //Insert elements into XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File("D:Disposal_Report.xml"));
            transformer.transform(source, result);
        }

    }
}