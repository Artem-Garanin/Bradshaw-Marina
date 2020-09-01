// Lease.java

package com.ipd23.bradshaw.marina;
import java.util.*;
import java.io.*;
/**
 * 
 * @author ihor
 */
abstract class Lease {
    private int leaseID;
    private double amount;
    private String startDate;
    private String endDate;
    
    public Lease() {
        this.leaseID = 0;
        this.amount = 0;
        this.startDate = "";
        this.endDate = "";
    }

    public Lease(int leaseID, double amount, String startDate, String endDate) {
        this.leaseID = leaseID;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public void setLeaseID(int leaseID) {
        this.leaseID = leaseID;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
    public int getLeaseID() {
        return leaseID;
    }

    public double getAmount() {
        return amount;
    }

    public String getStartDate() {
        return startDate;
    }
    
    public String getEndtDate() {
        return endDate;
    }
    
    public abstract void calculateFee(double fee){
        
    }
    
    public static Lease getLease(int leaseID) throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/lease.dat"));
        Lease result = new Lease();  
        // Declare an ArrayList of  objects
       ArrayList<Lease> aLease = new ArrayList<Lease>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aLease.add(i, new Lease(inFile.next(), inFile.next(), inFile.next()));
           if (aLease.get(i).leaseID.equals(leaseID)){
               result.leaseID = aLease.get(i).leaseID;
               result.amount = aLease.get(i).amount;
               result.startDate = aLease.get(i).startDate;
               result.endDate = aLease.get(i).endDate;
           }
           i++;             
        } // end while
       // close the inFile and the outFile
      inFile.close();
      outFile.close();
    return result;
    } // end method getLease
    
    public void save() throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/lease.dat"));
        Scanner linesScanner = new Scanner (new FileReader ("data/lease.dat"));
        boolean leaseExist = false;
        // Get the number of lines in the file
        int linesCount = 0;
        while (linesScanner.hasNextLine()) {
              linesScanner.nextLine();
            linesCount++;       
        }
        // Declare an array of  objects
      Lease[] aLease = new Lease [linesCount]; 

      // Initialize the array of objects and read the file into the array
      for (int i = 0; i<linesCount; i++){
            aLease[i] = new Lease();
            aLease[i].leaseID = inFile.next();
            aLease[i].amount = inFile.next();
            aLease[i].startDate = inFile.next();
            aLease[i].endDate = inFile.next();

            // if the customer exist, modify the customer
            if (this.leaseID.equals(aLease[i].leaseID)){
                leaseExist = true;
                aLease[i].leaseID = this.leaseID;
                aLease[i].amount = this.amount;
                aLease[i].startDate = this.startDate;
                aLease[i].endDate = this.endDate;
            } // end if       
        } // end for
        // Stores the array in the file      
      PrintWriter outFile = new PrintWriter("data/lease.dat");
      for (int i = 0; i<linesCount; i++){
            outFile.printf("%s %s %s %s%n", aLease[i].leaseID, aLease[i].amount, aLease[i].startDate,aLease[i].endDate);
        }

      // Add new line of customer
      if (!leaseExist)
      outFile.printf("%s %s %s %s%n", this.leaseID, this.amount, this.startDate, this.endDate);

      // close the inFile and the outFile
     inFile.close();
     outFile.close();
    } // end method save
    }


}
