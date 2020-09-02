import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class BradshawMarinaTest  {
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        String cont = "y";
        int choice = 0;      
        while( cont.equalsIgnoreCase("y") ) {  
                clearScreen();            
        	System.out.println("\t\t Welcome to Bradshaw Marina System\n");
	        System.out.println("1 ===> Track Customer Records ");
	        System.out.println("2 ===> Track Slip Records ");	
	        System.out.println("3 ===> Track Covered Slip Records ");
	        System.out.println("4 ===> Track Dock Records ");
	        System.out.println("5 ===> Track Power Boat Records ");	 
                System.out.println("6 ===> Track Sail Boat Records ");
                System.out.println("7 ===> Track Annual Lease Records ");
                System.out.println("8 ===> Track Daily Lease Records ");
                System.out.println("9 ===> Exit ");
	        System.out.print("\n\n");
	        System.out.println("Enter your choice: ");
	        choice = getInt();
                switch (choice) {
                case 1:{
                    trackCustomer();
                  break;}
                  case 2:{
                    System.out.println("case 2");
                  break;}
                  case 3:{
                    System.out.println("case 3");
                  break;}
                  case 4:{
                    System.out.println("case 4");
                  break;}
                  case 5:{
                	  
                	  trackPowerBoat();
                  break;}
                  case 6:{
                	  SailBoat sail = new SailBoat();
                	  trackSailBoat();
                  break;}
                  case 7:{
                    System.out.println("case 7");
                  break;}
                  case 8:{
                    System.out.println("case 8");
                  break;}
                  case 9:{
                    cont = "n";
                  break;}
                } // end switch

	       	
        } // end while
    
    } // end method main
    
    public static void trackCustomer() throws IOException, InterruptedException{
     String cont = "y";
        int choice = 0;      
        while( cont.equalsIgnoreCase("y") ) {  
                clearScreen();            
        	System.out.println("\t\t Customer Records\n");
	        System.out.println("1 ===> Add New Customer ");
	        System.out.println("2 ===> Remove Existing Customer ");	
	        System.out.println("3 ===> View Customer Record ");
	        System.out.println("4 ===> View All Customer Records ");
                System.out.println("5 ===> Back to the main menu ");
	        System.out.print("\n\n");
	        System.out.println("Enter your choice: ");
	        choice = getInt();
                switch (choice) {
                    
                case 1:{
                    while( cont.equalsIgnoreCase("y") ) {  
                    clearScreen();
                    Customer newCustomer = new Customer();
                    System.out.println("\t\t Add New Customer\n");
                    System.out.println("Enter the name: ");
                    newCustomer.setName(getString());
                    System.out.println("Enter the Address: ");
                    newCustomer.setAddress(getString());
                    System.out.println("Enter the Phone Number: ");
                    newCustomer.setPhoneNo(getString());
                    System.out.println("Enter the Boat Registration number: ");
                    newCustomer.setBoatID(getString());
                    System.out.println("Enter the Slip ID: ");
                    newCustomer.setSlipID(getString());
                    System.out.println("Enter the Lease ID: ");
                    newCustomer.setLeaseID(getString());
                    System.out.printf("%n\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", "Name", "Address", 
                            "Phone Number", "Boat", "Slip ID", "Lease ID");
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "====", "=======", "============", "=====", "=======", "========");
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n%n", newCustomer.getName(), 
                            newCustomer.getAddress(), newCustomer.getPhoneNo(), newCustomer.getBoatID(), 
                            newCustomer.getSlipID(), newCustomer.getLeaseID());
                    System.out.println("Save the record? Y/N");    
                    cont = getString();
                    if(cont.equalsIgnoreCase("y")){
                    newCustomer.save();
                    System.out.println("The record saved");}
                    break;
                    } // end while    
                    System.out.println("Do you want to continue with customer records? Y/N");
                    cont = getString();
                    break;}
                
                  case 2:{
                    while( cont.equalsIgnoreCase("y") ) {  
                    clearScreen();
                    Customer newCustomer = new Customer();
                    System.out.println("\t\t Remove Existing Customer\n");
                    System.out.println("Enter the Phone Number: ");
                    newCustomer = Customer.getCustomer(getString());
                    System.out.printf("%n\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", "Name", "Address", 
                            "Phone Number", "Boat", "Slip ID", "Lease ID");
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "====", "=======", "============", "=====", "=======", "========");
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n%n", newCustomer.getName(), 
                            newCustomer.getAddress(), newCustomer.getPhoneNo(), newCustomer.getBoatID(), 
                            newCustomer.getSlipID(), newCustomer.getLeaseID());
                    System.out.println("Remove the record? Y/N");    
                    cont = getString();
                    if(cont.equalsIgnoreCase("y")){
                    newCustomer.remove();
                    System.out.println("The record removed");}
                    break;
                    } // end while    
                    System.out.println("Do you want to continue with customer records? Y/N");
                    cont = getString();
                    break;}
                  
                  case 3:{
                    while( cont.equalsIgnoreCase("y") ) {  
                    clearScreen();
                    Customer newCustomer = new Customer();
                    System.out.println("\t\t View Customer Record\n");
                    System.out.println("Enter the Phone Number: ");
                    newCustomer = Customer.getCustomer(getString());
                    System.out.printf("%n\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", "Name", "Address", 
                            "Phone Number", "Boat", "Slip ID", "Lease ID");
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "====", "=======", "============", "=====", "=======", "========");
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n%n", newCustomer.getName(), 
                            newCustomer.getAddress(), newCustomer.getPhoneNo(), newCustomer.getBoatID(), 
                            newCustomer.getSlipID(), newCustomer.getLeaseID());
                    if (newCustomer.getPhoneNo().equalsIgnoreCase(""))
                    System.out.println("The customer is not found");    
                    break;
                    } // end while    
                    System.out.println("Do you want to continue with customer records? Y/N");
                    cont = getString();
                    break;}
                  
                  case 4:{
                    while( cont.equalsIgnoreCase("y") ) {  
                    clearScreen();
                    ArrayList<Customer> arrlist = new ArrayList<Customer>();
                    arrlist = Customer.getAllCustomer();
                    System.out.println("\t\t View All Customer Records\n");
                    System.out.printf("%n\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", "Name", "Address", 
                            "Phone Number", "Boat", "Slip ID", "Lease ID");
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "====", "=======", "============", "=====", "=======", "========");
                    for (Customer aCustomer : arrlist) {
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", aCustomer.getName(), 
                            aCustomer.getAddress(), aCustomer.getPhoneNo(), aCustomer.getBoatID(), 
                            aCustomer.getSlipID(), aCustomer.getLeaseID());    
                    }
                    break;
                    } // end while    
                    System.out.printf("%nDo you want to continue with customer records? Y/N%n");
                    cont = getString();
                    break;}
                  case 5:{
	          cont = "n";
                  break;}
                } // end switch	       	
        } // end while  
    } // end method trackCustomer
    
    public static int getInt(){
    Scanner input = new Scanner(System.in);
    int value = -1;
    while (value < 0) {
            try{
            if ( input.hasNextInt() ) {
                value = input.nextInt();
                if (value < 0)
                  throw new Exception("The number is negative: " + value);
            } // end if
            else { 
              String junk = input.next();
              throw new Exception("Input is non-digit number: " + junk);
            } // end else
            } // end try
            catch (Exception e){
              System.out.println(e.getMessage());
              System.out.println("Enter the number: ");
            } // catch
        } // end while
    return value;
  } //end method getInt
    
    public static double getDouble(){
    Scanner input = new Scanner(System.in);
    double value = -1;
    while (value < 0) {
            try{
            if ( input.hasNextDouble() ) {
                value = input.nextDouble();
                if (value < 0)
                  throw new Exception("The number is negative: " + value);
            } // end if
            else { 
              String junk = input.next();
              throw new Exception("Input is non-digit number: " + junk);  
            } // end else
            } // end try
            catch (Exception e){
              System.out.println(e.getMessage());
              System.out.println("Enter the number: ");
            } // catch
        } // end while
    return value;
  } //end method getDouble
    
    public static String getString(){
    Scanner input = new Scanner(System.in);
    String value = input.next();              
    return value;
  } //end method getString
    
    public static void clearScreen() throws IOException, InterruptedException  { 
        final String operatingSystem = System.getProperty("os.name");
        if (operatingSystem.contains("Windows")){
    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }  
            else {
            for(int i = 0; i < 1000; i++)
    {
        System.out.println("\b");
    }
        }
    } // end method clearScreen
    
    
    // Boat part. Sail Boat and Power Boat
    // Sail Boat  

public static void trackSailBoat() throws IOException, InterruptedException{
    String cont = "y";
       int choice = 0;      
       while( cont.equalsIgnoreCase("y") ) {  
               clearScreen();            
       	System.out.println("\t\t Sail Boat Records\n");
	        System.out.println("1 ===> Add New Sail Boat ");
	        System.out.println("2 ===> Remove Existing Sail Boat ");	
	        System.out.println("3 ===> View Sail Boat Record ");
	        System.out.println("4 ===> View All Sail Boat Records ");
               System.out.println("5 ===> Back to the main menu ");
	        System.out.print("\n\n");
	        System.out.println("Enter your choice: ");
	        
	        choice = getInt();
               switch (choice) {
                   
               case 1:{
                   while( cont.equalsIgnoreCase("y") ) {  
                   clearScreen();
                   SailBoat sailBoat = new SailBoat();
                   System.out.println("\t\t Add New Sail Boat\n");
                   System.out.println("Enter the state registraition number: ");
                   sailBoat.setStateRegistraitionNo(getString());
                   System.out.println("Enter the boat leangh: ");
                   sailBoat.setBoatLeangh(getDouble());
                   System.out.println("Enter the manufacturer: ");
                   sailBoat.setManufacturer(getString());
                   System.out.println("Enter the year of the boat: ");
                   sailBoat.setYear(getInt());
                   System.out.println("Enter the phone number: ");
                   sailBoat.setPhoneNo(getString());
                   System.out.println("Enter the keel depth: ");
                   sailBoat.setKeelDepth(getDouble());
                   System.out.println("Enter the number sails: ");
                   sailBoat.setNumberSails(getInt());
                   System.out.println("Enter the motor type: ");
                   sailBoat.setMotorType(getString());
                   System.out.printf("%n\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", "Registraition number", "Boat leangh", 
                           "Manufacturer", "Year of the boat", "Phone number", "Keel depth", "Number sails","Motor type");
                   System.out.printf("\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                           "=====================", "===========", "============", "================", "===========", "==========",
                           "============", "==========");
                   System.out.printf("\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t%-10s\t %n%n", sailBoat.getStateRegistraitionNo(), 
                		   sailBoat.getBoatLeangh(), sailBoat.getManufacturer(),  sailBoat.getYear(), 
                		   sailBoat.getPhoneNo(), sailBoat.getKeelDepth(), sailBoat.getNumberSails(), sailBoat.getMotorType());
                   System.out.println("Save the record? Y/N");    
                   cont = getString();
                   if(cont.equalsIgnoreCase("y")){
                	   sailBoat.saveSailBoat();
                   System.out.println("The record saved");}
                   break;
                   } // end while    
                   System.out.println("Do you want to continue with seil boat records? Y/N");
                   cont = getString();
                   break;}
               
                 case 2:{
                   while( cont.equalsIgnoreCase("y") ) {  
                   clearScreen();
                   SailBoat sailBoat = new SailBoat();
                   System.out.println("\t\t Remove Existing seil boat\n");
                   System.out.println("Enter the state registraition Number: ");
                   sailBoat = (SailBoat) SailBoat.getSailBoat(getString()); 
                   System.out.printf("%n\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", "Registraition number", "Boat leangh", 
                           "Manufacturer", "Year of the boat", "Phone number", "Keel depth", "Number sails","Motor type");
                   System.out.printf("\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                           "=====================", "===========", "============", "================", "===========", "==========",
                           "============", "==========");
                   System.out.printf("\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t%-10s\t %n%n", sailBoat.getStateRegistraitionNo(), 
                		   sailBoat.getBoatLeangh(), sailBoat.getManufacturer(),  sailBoat.getYear(), 
                		   sailBoat.getPhoneNo(), sailBoat.getKeelDepth(), sailBoat.getNumberSails(), sailBoat.getMotorType());
                   System.out.println("Remove the record? Y/N");    
                   cont = getString();
                   if(cont.equalsIgnoreCase("y")){
                	   sailBoat.removeSailBoatFromSlip();
                   System.out.println("The record removed");}
                   break;
                   } // end while    
                   System.out.println("Do you want to continue with sail boat records? Y/N");
                   cont = getString();
                   break;}
                 
                 case 3:{
                   while( cont.equalsIgnoreCase("y") ) {  
                   clearScreen();
                   SailBoat sailBoat = new SailBoat();
                   System.out.println("\t\t View sail boat Record\n");
                   System.out.println("Enter the registraition number: ");
                   sailBoat = (SailBoat) SailBoat.getSailBoat(getString()); 
                   System.out.printf("%n\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", "Registraition number", "Boat leangh", 
                           "Manufacturer", "Year of the boat", "Phone number", "Keel depth", "Number sails","Motor type");
                   System.out.printf("\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                           "=====================", "===========", "============", "================", "===========", "==========",
                           "============", "==========");
                   System.out.printf("\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t%-10s\t %n%n", sailBoat.getStateRegistraitionNo(), 
                		   sailBoat.getBoatLeangh(), sailBoat.getManufacturer(),  sailBoat.getYear(), 
                		   sailBoat.getPhoneNo(), sailBoat.getKeelDepth(), sailBoat.getNumberSails(), sailBoat.getMotorType());
                   if (sailBoat.getStateRegistraitionNo().equalsIgnoreCase(""))
                   System.out.println("The sail boat is not found");    
                   break;
                   } // end while    
                   System.out.println("Do you want to continue with sail boat records? Y/N");
                   cont = getString();
                   break;}
                 
                 case 4:{
                   while( cont.equalsIgnoreCase("y") ) {  
                   clearScreen();
                   ArrayList<SailBoat> arrlist = new ArrayList<SailBoat>();
                   arrlist = SailBoat.getAllSailBoat();
                   System.out.println("\t\t View All sail boat Records\n");
                   System.out.printf("%n\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", "Registraition number", "Boat leangh", 
                           "Manufacturer", "Year of the boat", "Phone number", "Keel depth", "Number sails","Motor type");
                   System.out.printf("\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                           "=====================", "===========", "============", "================", "===========", "==========",
                           "============", "==========");
                   for (SailBoat sBoat : arrlist) {
                   System.out.printf("\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", sBoat.getStateRegistraitionNo(), 
                		   sBoat.getBoatLeangh(), sBoat.getManufacturer(),  sBoat.getYear(), 
                		   sBoat.getPhoneNo(), sBoat.getKeelDepth(), sBoat.getNumberSails(), sBoat.getMotorType());
                   }
                   break;
                   } // end while    
                   System.out.printf("%nDo you want to continue with sail boat records? Y/N%n");
                   cont = getString();
                   break;}
                 case 5:{
	          cont = "n";
                 break;}
               } // end switch	       	
       } // end while  
   } 

	// Power Boat
public static void trackPowerBoat() throws IOException, InterruptedException{
    String cont = "y";
       int choice = 0;      
       while( cont.equalsIgnoreCase("y") ) {  
               clearScreen();            
       	System.out.println("\t\t Sail Boat Records\n");
	        System.out.println("1 ===> Add New Power Boat ");
	        System.out.println("2 ===> Remove Existing Power Boat ");	
	        System.out.println("3 ===> View Sail Power Record ");
	        System.out.println("4 ===> View All Sail Power Records ");
               System.out.println("5 ===> Back to the main menu ");
	        System.out.print("\n\n");
	        System.out.println("Enter your choice: ");
	        
	        choice = getInt();
               switch (choice) {
                   
               case 1:{
                   while( cont.equalsIgnoreCase("y") ) {  
                   clearScreen();
                   PowerBoat powerBoat = new PowerBoat();
                   System.out.println("\t\t Add New Sail Boat\n");
                   System.out.println("Enter the state registraition number: ");
                   powerBoat.setStateRegistraitionNo(getString());
                   System.out.println("Enter the boat leangh: ");
                   powerBoat.setBoatLeangh(getDouble());
                   System.out.println("Enter the manufacturer: ");
                   powerBoat.setManufacturer(getString());
                   System.out.println("Enter the year of the boat: ");
                   powerBoat.setYear(getInt());
                   System.out.println("Enter the phone number: ");
                   powerBoat.setPhoneNo(getString());
                   System.out.println("Enter the number engines: ");
                   powerBoat.setNumberEngines(getDouble());
                   System.out.println("Enter the fuel type: ");
                   powerBoat.setFuelType(getString());
                   
                   System.out.printf("%n\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t %n", "Registraition number", "Boat leangh", 
                           "Manufacturer", "Year of the boat", "Phone number", "Number engines", "Fuel type");
                   System.out.printf("\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t %n", 
                           "=====================", "===========", "============", "================", "===========", "==============",
                           "==========");
                   System.out.printf("\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t %n%n", powerBoat.getStateRegistraitionNo(), 
                		   powerBoat.getBoatLeangh(), powerBoat.getManufacturer(),  powerBoat.getYear(), 
                		   powerBoat.getPhoneNo(), powerBoat.getNumberEngines(), powerBoat.getFuelType());
                   System.out.println("Save the record? Y/N");    
                   cont = getString();
                   if(cont.equalsIgnoreCase("y")){
                	   powerBoat.savePowerBoat();
                   System.out.println("The record saved");}
                   break;
                   } // end while    
                   System.out.println("Do you want to continue with power boat records? Y/N");
                   cont = getString();
                   break;}
               
                 case 2:{
                   while( cont.equalsIgnoreCase("y") ) {  
                   clearScreen();
                   PowerBoat powerBoat = new PowerBoat();
                   System.out.println("\t\t Remove Existing seil boat\n");
                   System.out.println("Enter the state registraition Number: ");
                   powerBoat = (PowerBoat) PowerBoat.getPowerBoat(getString()); 
                   System.out.printf("%n\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t %n", "Registraition number", "Boat leangh", 
                           "Manufacturer", "Year of the boat", "Phone number", "Number engines", "Fuel type");
                   System.out.printf("\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t %n", 
                           "=====================", "===========", "============", "================", "===========", "==============",
                           "==========");
                   System.out.printf("\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t %n%n", powerBoat.getStateRegistraitionNo(), 
                		   powerBoat.getBoatLeangh(), powerBoat.getManufacturer(),  powerBoat.getYear(), 
                		   powerBoat.getPhoneNo(), powerBoat.getNumberEngines(), powerBoat.getFuelType());
                   System.out.println("Remove the record? Y/N");    
                   cont = getString();
                   if(cont.equalsIgnoreCase("y")){
                	   powerBoat.removePowerBoatFromSlip();
                   System.out.println("The record removed");}
                   break;
                   } // end while    
                   System.out.println("Do you want to continue with power boat records? Y/N");
                   cont = getString();
                   break;}
                 
                 case 3:{
                   while( cont.equalsIgnoreCase("y") ) {  
                   clearScreen();
                   PowerBoat powerBoat = new PowerBoat();
                   System.out.println("\t\t View power boat Record\n");
                   System.out.println("Enter the registraition number: ");
                   powerBoat = (PowerBoat) PowerBoat.getPowerBoat(getString()); 
                   System.out.printf("%n\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t %n", "Registraition number", "Boat leangh", 
                           "Manufacturer", "Year of the boat", "Phone number", "Number engines", "Fuel type");
                   System.out.printf("\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t %n", 
                           "=====================", "===========", "============", "================", "===========", "==============",
                           "==========");
                   System.out.printf("\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t %n%n", powerBoat.getStateRegistraitionNo(), 
                		   powerBoat.getBoatLeangh(), powerBoat.getManufacturer(),  powerBoat.getYear(), 
                		   powerBoat.getPhoneNo(), powerBoat.getNumberEngines(), powerBoat.getFuelType());
                   if (powerBoat.getStateRegistraitionNo().equalsIgnoreCase(""))
                   System.out.println("The power boat is not found");    
                   break;
                   } // end while    
                   System.out.println("Do you want to continue with power boat records? Y/N");
                   cont = getString();
                   break;}
                 
                 case 4:{
                   while( cont.equalsIgnoreCase("y") ) {  
                   clearScreen();
                   ArrayList<PowerBoat> arrlist = new ArrayList<PowerBoat>();
                   arrlist = PowerBoat.getAllPowerBoat();
                   System.out.println("\t\t View All power boat Records\n");
                   System.out.printf("%n\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t %n", "Registraition number", "Boat leangh", 
                           "Manufacturer", "Year of the boat", "Phone number", "Number engines", "Fuel type");
                   System.out.printf("\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t %n", 
                           "=====================", "===========", "============", "================", "===========", "==============",
                           "==========");
                   for (PowerBoat pBoat : arrlist) {
                	   System.out.printf("\t%-20s\t%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-10s\t %n%n", pBoat.getStateRegistraitionNo(), 
                			   pBoat.getBoatLeangh(), pBoat.getManufacturer(),  pBoat.getYear(), 
                			   pBoat.getPhoneNo(), pBoat.getNumberEngines(), pBoat.getFuelType());
                   }
                   break;
                   } // end while    
                   System.out.printf("%nDo you want to continue with power boat records? Y/N%n");
                   cont = getString();
                   break;}
                 case 5:{
	          cont = "n";
                 break;}
               } // end switch	       	
       } // end while  
   } 
}
    
    
