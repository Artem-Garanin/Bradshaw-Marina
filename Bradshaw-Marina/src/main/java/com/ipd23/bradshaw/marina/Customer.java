/* Customer.java
 *
 *
 */
package com.ipd23.bradshaw.marina;
import java.util.*;
import java.io.*;

/**
 *
 * @author artem
 */
public class Customer {
    private String name;
    private String address;
    private String phoneNo;
    private String boatID;
    private String slipID;
    private String leaseID;
    
    public Customer() {
        this.name = "";
        this.address = "";
        this.phoneNo = "";
        this.boatID = "";
        this.slipID = "";
        this.leaseID = "";
    }

    public Customer(String name, String address, String phoneNo, String boatID, String slipID, String leaseID) {
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.boatID = boatID;
        this.slipID = slipID;
        this.leaseID = leaseID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getBoatID() {
        return boatID;
    }

    public void setBoatID(String boatID) {
        this.boatID = boatID;
    }

    public String getSlipID() {
        return slipID;
    }

    public void setSlipID(String slipID) {
        this.slipID = slipID;
    }

    public String getLeaseID() {
        return leaseID;
    }

    public void setLeaseID(String leaseID) {
        this.leaseID = leaseID;
    }
    
    public void save() throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/customer.dat"));
        Scanner linesScanner = new Scanner (new FileReader ("data/customer.dat"));
        boolean customerExist = false;
        // Get the number of lines in the file
        int linesCount = 0;
        while (linesScanner.hasNextLine()) {
              linesScanner.nextLine();
            linesCount++;       
        }
        // Declare an array of  objects
      Customer[] aCustomer = new Customer [linesCount]; 
      
      // Initialize the array of objects and read the file into the array
      for (int i = 0; i<linesCount; i++){
            aCustomer[i] = new Customer();
            aCustomer[i].name = inFile.next();
            aCustomer[i].address = inFile.next();
            aCustomer[i].phoneNo = inFile.next();
            aCustomer[i].boatID = inFile.next();
            aCustomer[i].slipID = inFile.next();
            aCustomer[i].leaseID = inFile.next();
            
            // if the customer exist, modify the customer
            if (this.phoneNo.equals(aCustomer[i].phoneNo)){
                customerExist = true;
                aCustomer[i].name = this.name;
                aCustomer[i].address = this.address;
                aCustomer[i].phoneNo = this.phoneNo;
                aCustomer[i].boatID = this.boatID;
                aCustomer[i].slipID = this.slipID;
                aCustomer[i].leaseID = this.leaseID;
            } // end if       
        } // end for
        // Stores the array in the file      
      PrintWriter outFile = new PrintWriter("data/customer.dat");
      for (int i = 0; i<linesCount; i++){
            outFile.printf("%s %s %s %s %s %s%n", aCustomer[i].name, aCustomer[i].address, 
                    aCustomer[i].phoneNo, aCustomer[i].boatID, aCustomer[i].slipID, aCustomer[i].leaseID);
        }
      
      // Add new line of customer
      if (!customerExist)
      outFile.printf("%s %s %s %s %s %s%n", this.name, this.address, this.phoneNo, this.boatID, this.slipID, this.leaseID);
      
      // close the inFile and the outFile
     inFile.close();
     outFile.close();
    } // end method save
    
    public void remove() throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/customer.dat"));
        
        // Declare an ArrayList of  objects
       ArrayList<Customer> aCustomer = new ArrayList<Customer>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aCustomer.add(i, new Customer(inFile.next(), inFile.next(), inFile.next(), inFile.next(), inFile.next(), inFile.next()));
           if (aCustomer.get(i).phoneNo.equals(this.phoneNo)){
                aCustomer.remove(i);
                i--;
            } // end if       
           i++;             
        } // end while
       
               // Stores the array list in the file   
       PrintWriter outFile = new PrintWriter("data/customer.dat");
      for (int j = 0; j<aCustomer.size(); j++){
           outFile.printf("%s %s %s %s %s %s%n", aCustomer.get(j).name, aCustomer.get(j).address, 
                   aCustomer.get(j).phoneNo, aCustomer.get(j).boatID, aCustomer.get(j).slipID, aCustomer.get(j).leaseID);
      }
       // close the inFile and the outFile
      inFile.close();
     outFile.close();
    } // end method remove
    
    public static Customer getCustomer(String phoneNo) throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/customer.dat"));
        Customer result = new Customer();  
        // Declare an ArrayList of  objects
       ArrayList<Customer> aCustomer = new ArrayList<Customer>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aCustomer.add(i, new Customer(inFile.next(), inFile.next(), inFile.next(), inFile.next(), inFile.next(), inFile.next()));
           if (aCustomer.get(i).phoneNo.equals(phoneNo)){
               result.name = aCustomer.get(i).name;
               result.address = aCustomer.get(i).address;
               result.phoneNo = aCustomer.get(i).phoneNo;
               result.boatID = aCustomer.get(i).boatID;
               result.slipID = aCustomer.get(i).slipID;
               result.leaseID = aCustomer.get(i).leaseID;
           }
           i++;             
        } // end while
       // close the inFile and the outFile
      inFile.close();
    return result;
    } // end method getCustomer
    
    public static ArrayList getAllCustomer() throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/customer.dat"));
        // Declare an ArrayList of  objects
       ArrayList<Customer> aCustomer = new ArrayList<Customer>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aCustomer.add(i, new Customer(inFile.next(), inFile.next(), inFile.next(), inFile.next(), inFile.next(), inFile.next()));
           i++;
        } // end while
       // close the inFile
      inFile.close();
    return aCustomer;
    } // end method getCustomer
    
      
} // end class Customer
