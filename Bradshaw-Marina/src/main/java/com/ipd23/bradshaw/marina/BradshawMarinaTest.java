
package com.ipd23.bradshaw.marina;
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
                    trackSlip();
                  break;}
                  case 3:{
                    trackCoveredSlip();
                  break;}
                  case 4:{
                    trackDock();
                  break;}
                  case 5:{
                    System.out.println("case 5");
                  break;}
                  case 6:{
                    System.out.println("case 6");
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
    
    public static void trackSlip() throws IOException, InterruptedException{
     String cont = "y";
        int choice = 0;      
        while( cont.equalsIgnoreCase("y") ) {  
                clearScreen();            
        	System.out.println("\t\t Slip Records\n");
	        System.out.println("1 ===> Add New Slip ");
	        System.out.println("2 ===> Remove Existing Slip ");	
	        System.out.println("3 ===> View Slip Record ");
	        System.out.println("4 ===> View All Slip Records ");
                System.out.println("5 ===> Back to the main menu ");
	        System.out.print("\n\n");
	        System.out.println("Enter your choice: ");
	        choice = getInt();
                switch (choice) {
                    
                case 1:{
                    while( cont.equalsIgnoreCase("y") ) {  
                    clearScreen();
                    Slip newSlip = new Slip();
                    System.out.println("\t\t Add New Slip\n");
                    System.out.println("Enter Dock ID: ");
                    newSlip.setDockID(getString());
                    System.out.println("Enter Slip ID: ");
                    newSlip.setSlipID(getString());
                    System.out.println("Enter the Width: ");
                    newSlip.setWidth(getInt());
                    System.out.println("Enter the Slip Length: ");
                    newSlip.setSlipLength(getInt());
                    System.out.println("Enter Customer Phone Number: ");
                    newSlip.setCustomerPhoneNo(getString());
                    System.out.printf("%n\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", "Dock ID", "Slip ID", 
                            "Width", "Slip Length", "Customer Phone Number");
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "=======", "=======", "=====", "===========", "=====================");
                    System.out.printf("\t%-10s\t%-10s\t%-10d\t%-10d\t%-10s\t %n%n", newSlip.getDockID(), 
                            newSlip.getSlipID(), newSlip.getWidth(), newSlip.getSlipLength(), 
                            newSlip.getCustomerPhoneNo());
                    System.out.println("Save the record? Y/N");    
                    cont = getString();
                    if(cont.equalsIgnoreCase("y")){
                    newSlip.save();
                    System.out.println("The record saved");}
                    break;
                    } // end while    
                    System.out.println("Do you want to continue with slip records? Y/N");
                    cont = getString();
                    break;}
                
                  case 2:{
                    while( cont.equalsIgnoreCase("y") ) {  
                    clearScreen();
                    Slip newSlip = new Slip();
                    System.out.println("\t\t Remove Existing Slip\n");
                    System.out.println("Enter the Slip ID: ");
                    newSlip = Slip.getSlip(getString());
                    System.out.printf("%n\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "Dock ID", "Slip ID", "Width", "Slip Length", "Customer Phone Number");
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "=======", "=======", "=====", "===========", "=====================");
                    System.out.printf("\t%-10s\t%-10s\t%-10d\t%-10d\t%-10s\t %n%n", newSlip.getDockID(), 
                            newSlip.getSlipID(), newSlip.getWidth(), newSlip.getSlipLength(), 
                            newSlip.getCustomerPhoneNo());
                    System.out.println("Remove the record? Y/N");    
                    cont = getString();
                    if(cont.equalsIgnoreCase("y")){
                    Slip.remove(newSlip.getSlipID());
                    System.out.println("The record removed");}
                    break;
                    } // end while    
                    System.out.println("Do you want to continue with customer records? Y/N");
                    cont = getString();
                    break;}
                  
                  case 3:{
                    while( cont.equalsIgnoreCase("y") ) {  
                    clearScreen();
                    Slip newSlip = new Slip();
                    System.out.println("\t\t View Slip Record\n");
                    System.out.println("Enter the Slip ID: ");
                    newSlip = Slip.getSlip(getString());
                    System.out.printf("%n\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "Dock ID", "Slip ID", "Width", "Slip Length", "Customer Phone Number");
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "=======", "=======", "=====", "===========", "=====================");
                    System.out.printf("\t%-10s\t%-10s\t%-10d\t%-10d\t%-10s\t %n%n", newSlip.getDockID(), 
                            newSlip.getSlipID(), newSlip.getWidth(), newSlip.getSlipLength(), 
                            newSlip.getCustomerPhoneNo());
                    if (newSlip.getSlipID().equalsIgnoreCase(""))
                    System.out.println("The slip is not found");    
                    break;
                    } // end while    
                    System.out.println("Do you want to continue with slip records? Y/N");
                    cont = getString();
                    break;}
                  
                  case 4:{
                    while( cont.equalsIgnoreCase("y") ) {  
                    clearScreen();
                    ArrayList<Slip> arrlist = new ArrayList<Slip>();
                    arrlist = Slip.getAllSlip();
                    System.out.println("\t\t View All Slip Records\n");
                    System.out.printf("%n\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "Dock ID", "Slip ID", "Width", "Slip Length", "Customer Phone Number");
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "=======", "=======", "=====", "===========", "=====================");
                    for (Slip arrSlip : arrlist) {
                    System.out.printf("\t%-10s\t%-10s\t%-10d\t%-10d\t%-10s\t %n", arrSlip.getDockID(), 
                            arrSlip.getSlipID(), arrSlip.getWidth(), arrSlip.getSlipLength(), 
                            arrSlip.getCustomerPhoneNo());    
                    }
                    break;
                    } // end while    
                    System.out.printf("%nDo you want to continue with slip records? Y/N%n");
                    cont = getString();
                    break;}
                  case 5:{
	          cont = "n";
                  break;}
                } // end switch	       	
        } // end while  
    } // end method trackSlip
    
    public static void trackCoveredSlip() throws IOException, InterruptedException{
     String cont = "y";
        int choice = 0;      
        while( cont.equalsIgnoreCase("y") ) {  
                clearScreen();            
        	System.out.println("\t\t Covered Slip Records\n");
	        System.out.println("1 ===> Add New Covered Slip ");
	        System.out.println("2 ===> Remove Existing Covered Slip ");	
	        System.out.println("3 ===> View Covered Slip Record ");
	        System.out.println("4 ===> View All Covered Slip Records ");
                System.out.println("5 ===> Back to the main menu ");
	        System.out.print("\n\n");
	        System.out.println("Enter your choice: ");
	        choice = getInt();
                switch (choice) {
                    
                case 1:{
                    while( cont.equalsIgnoreCase("y") ) {  
                    clearScreen();
                    CoveredSlip newSlip = new CoveredSlip();
                    System.out.println("\t\t Add New Covered Slip\n");
                    System.out.println("Enter Dock ID: ");
                    newSlip.setDockID(getString());
                    System.out.println("Enter Slip ID: ");
                    newSlip.setSlipID(getString());
                    System.out.println("Enter the Width: ");
                    newSlip.setWidth(getInt());
                    System.out.println("Enter the Slip Length: ");
                    newSlip.setSlipLength(getInt());                  
                    System.out.println("Enter the Height: ");
                    newSlip.setHeight(getInt());
                    System.out.println("Enter the Door: ");
                    newSlip.setDoor(getString());
                    System.out.println("Enter Customer Phone Number: ");
                    newSlip.setCustomerPhoneNo(getString());
                    System.out.printf("%n\t%-1s\t%-1s\t%-1s\t%-11s\t%-11s\t%-9s\t%-9s\t %n", 
                            "Dock ID", "Slip ID", "Width", "Slip Length", "Slip Height", "Slip Door", "Customer Phone Number");
                    System.out.printf("\t%-1s\t%-1s\t%-1s\t%-11s\t%-11s\t%-9s\t%-9s\t %n", 
                            "=======", "=======", "=====", "===========", "===========", "=========", "=====================");
                    System.out.printf("\t%-1s\t%-1s\t%-1d\t%-11d\t%-11d\t%-9s\t%-9s\t %n%n", newSlip.getDockID(), 
                            newSlip.getSlipID(), newSlip.getWidth(), newSlip.getSlipLength(), 
                            newSlip.getHeight(), newSlip.getDoor(), newSlip.getCustomerPhoneNo());
                    System.out.println("Save the record? Y/N");    
                    cont = getString();
                    if(cont.equalsIgnoreCase("y")){
                    newSlip.save();
                    System.out.println("The record saved");}
                    break;
                    } // end while    
                    System.out.println("Do you want to continue with covered slip records? Y/N");
                    cont = getString();
                    break;}
                
                  case 2:{
                    while( cont.equalsIgnoreCase("y") ) {  
                    clearScreen();
                    CoveredSlip newSlip = new CoveredSlip();
                    System.out.println("\t\t Remove Existing Covered Slip\n");
                    System.out.println("Enter the Slip ID: ");
                    newSlip = CoveredSlip.getSlip(getString());
                    System.out.printf("%n\t%-1s\t%-1s\t%-1s\t%-11s\t%-11s\t%-9s\t%-9s\t %n", 
                            "Dock ID", "Slip ID", "Width", "Slip Length", "Slip Height", "Slip Door", "Customer Phone Number");
                    System.out.printf("\t%-1s\t%-1s\t%-1s\t%-11s\t%-11s\t%-9s\t%-9s\t %n", 
                            "=======", "=======", "=====", "===========", "===========", "=========", "=====================");
                    System.out.printf("\t%-1s\t%-1s\t%-1d\t%-11d\t%-11d\t%-9s\t%-9s\t %n%n", newSlip.getDockID(), 
                            newSlip.getSlipID(), newSlip.getWidth(), newSlip.getSlipLength(), 
                            newSlip.getHeight(), newSlip.getDoor(), newSlip.getCustomerPhoneNo());
                    System.out.println("Remove the record? Y/N");    
                    cont = getString();
                    if(cont.equalsIgnoreCase("y")){
                    CoveredSlip.remove(newSlip.getSlipID());
                    System.out.println("The record removed");}
                    break;
                    } // end while    
                    System.out.println("Do you want to continue with customer records? Y/N");
                    cont = getString();
                    break;}
                  
                  case 3:{
                    while( cont.equalsIgnoreCase("y") ) {  
                    clearScreen();
                    CoveredSlip newSlip = new CoveredSlip();
                    System.out.println("\t\t View Covered Slip Record\n");
                    System.out.println("Enter the Slip ID: ");
                    newSlip = CoveredSlip.getSlip(getString());
                    System.out.printf("%n\t%-1s\t%-1s\t%-1s\t%-11s\t%-11s\t%-9s\t%-9s\t %n", 
                            "Dock ID", "Slip ID", "Width", "Slip Length", "Slip Height", "Slip Door", "Customer Phone Number");
                    System.out.printf("\t%-1s\t%-1s\t%-1s\t%-11s\t%-11s\t%-9s\t%-9s\t %n", 
                            "=======", "=======", "=====", "===========", "===========", "=========", "=====================");
                    System.out.printf("\t%-1s\t%-1s\t%-1d\t%-11d\t%-11d\t%-9s\t%-9s\t %n%n", newSlip.getDockID(), 
                            newSlip.getSlipID(), newSlip.getWidth(), newSlip.getSlipLength(), 
                            newSlip.getHeight(), newSlip.getDoor(), newSlip.getCustomerPhoneNo());
                    if (newSlip.getSlipID().equalsIgnoreCase(""))
                    System.out.println("The covered slip is not found");    
                    break;
                    } // end while    
                    System.out.println("Do you want to continue with slip records? Y/N");
                    cont = getString();
                    break;}
                  
                  case 4:{
                    while( cont.equalsIgnoreCase("y") ) {  
                    clearScreen();
                    ArrayList<CoveredSlip> arrlist = new ArrayList<CoveredSlip>();
                    arrlist = CoveredSlip.getAllSlip();
                    System.out.println("\t\t View All Covered Slip Records\n");
                    System.out.printf("%n\t%-1s\t%-1s\t%-1s\t%-11s\t%-11s\t%-9s\t%-9s\t %n", 
                            "Dock ID", "Slip ID", "Width", "Slip Length", "Slip Height", "Slip Door", "Customer Phone Number");
                    System.out.printf("\t%-1s\t%-1s\t%-1s\t%-11s\t%-11s\t%-9s\t%-9s\t %n", 
                            "=======", "=======", "=====", "===========", "===========", "=========", "=====================");
                    for (CoveredSlip arrSlip : arrlist) {
                    System.out.printf("\t%-1s\t%-1s\t%-1d\t%-11d\t%-11d\t%-9s\t%-9s\t %n", arrSlip.getDockID(), 
                            arrSlip.getSlipID(), arrSlip.getWidth(), arrSlip.getSlipLength(), 
                            arrSlip.getHeight(), arrSlip.getDoor(), arrSlip.getCustomerPhoneNo());
                    }
                    break;
                    } // end while    
                    System.out.printf("%nDo you want to continue with slip records? Y/N%n");
                    cont = getString();
                    break;}
                  case 5:{
	          cont = "n";
                  break;}
                } // end switch	       	
        } // end while  
    } // end method trackCustomer
    
    public static void trackDock() throws IOException, InterruptedException{
     String cont = "y";
        int choice = 0;      
        while( cont.equalsIgnoreCase("y") ) {  
                clearScreen();            
        	System.out.println("\t\t Dock Records\n");
	        System.out.println("1 ===> Add New Dock ");
	        System.out.println("2 ===> Remove Existing Dock ");	
	        System.out.println("3 ===> View Dock Record ");
	        System.out.println("4 ===> View All Dock Records ");
                System.out.println("5 ===> Back to the main menu ");
	        System.out.print("\n\n");
	        System.out.println("Enter your choice: ");
	        choice = getInt();
                switch (choice) {
                    
                case 1:{
                    while( cont.equalsIgnoreCase("y") ) {  
                    clearScreen();
                    Dock newDock = new Dock();
                    System.out.println("\t\t Add New Dock\n");
                    System.out.println("Enter Dock ID: ");
                    newDock.setDockID(getString());
                    System.out.println("Enter Location: ");
                    newDock.setLocation(getString());
                    System.out.println("Enter Electricity: ");
                    newDock.setElectricity(getString());
                    System.out.println("Enter Water: ");
                    newDock.setWater(getString());
                    System.out.printf("%n\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "Dock ID", "Location", "Electricity", "Water");
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "=======", "========", "===========", "=====");
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t %n%n", newDock.getDockID(), 
                            newDock.getLocation(), newDock.getElectricity(), newDock.getWater());
                    System.out.println("Save the record? Y/N");    
                    cont = getString();
                    if(cont.equalsIgnoreCase("y")){
                    newDock.save();
                    System.out.println("The record saved");}
                    break;
                    } // end while    
                    System.out.println("Do you want to continue with dock records? Y/N");
                    cont = getString();
                    break;}
                
                  case 2:{
                    while( cont.equalsIgnoreCase("y") ) {  
                    clearScreen();
                    Dock newDock = new Dock();
                    System.out.println("\t\t Remove Existing Dock\n");
                    System.out.println("Enter the Dock ID: ");
                    newDock = Dock.getDock(getString());
                    System.out.printf("%n\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "Dock ID", "Location", "Electricity", "Water");
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "=======", "========", "===========", "=====");
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t %n%n", newDock.getDockID(), 
                            newDock.getLocation(), newDock.getElectricity(), newDock.getWater());
                    System.out.println("Remove the record? Y/N");    
                    cont = getString();
                    if(cont.equalsIgnoreCase("y")){
                    newDock.remove();
                    System.out.println("The record removed");}
                    break;
                    } // end while    
                    System.out.println("Do you want to continue with dock records? Y/N");
                    cont = getString();
                    break;}
                  
                  case 3:{
                    while( cont.equalsIgnoreCase("y") ) {  
                    clearScreen();
                    Dock newDock = new Dock();
                    System.out.println("\t\t View Dock Record\n");
                    System.out.println("Enter the Dock ID: ");
                    newDock = Dock.getDock(getString());
                    System.out.printf("%n\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "Dock ID", "Location", "Electricity", "Water");
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "=======", "========", "===========", "=====");
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t %n%n", newDock.getDockID(), 
                            newDock.getLocation(), newDock.getElectricity(), newDock.getWater());
                    if (newDock.getDockID().equalsIgnoreCase(""))
                    System.out.println("The dock is not found");    
                    break;
                    } // end while    
                    System.out.println("Do you want to continue with dock records? Y/N");
                    cont = getString();
                    break;}
                  
                  case 4:{
                    while( cont.equalsIgnoreCase("y") ) {  
                    clearScreen();
                    ArrayList<Dock> arrlist = new ArrayList<Dock>();
                    arrlist = Dock.getAllDock();
                    System.out.println("\t\t View All Dock Records\n");
                    System.out.printf("%n\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "Dock ID", "Location", "Electricity", "Water");
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t %n", 
                            "=======", "========", "===========", "=====");
                    for (Dock arrDock : arrlist) {
                    System.out.printf("\t%-10s\t%-10s\t%-10s\t%-10s\t %n", arrDock.getDockID(), 
                            arrDock.getLocation(), arrDock.getElectricity(), arrDock.getWater());
                    }
                    break;
                    } // end while    
                    System.out.printf("%nDo you want to continue with dock records? Y/N%n");
                    cont = getString();
                    break;}
                  case 5:{
	          cont = "n";
                  break;}
                } // end switch	       	
        } // end while  
    } // end method trackDock
    
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
    
} //end class BradshawMarinaTest