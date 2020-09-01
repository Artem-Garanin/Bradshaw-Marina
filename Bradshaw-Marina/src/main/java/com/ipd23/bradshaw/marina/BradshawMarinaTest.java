
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
                    System.out.println("case 2");
                  break;}
                  case 3:{
                    System.out.println("case 3");
                  break;}
                  case 4:{
                    System.out.println("case 4");
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