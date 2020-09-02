// Slip.java
package com.ipd23.bradshaw.marina;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author artem
 */
public class Slip {
    protected String dockID;
    protected String slipID;
    protected int width;
    protected int slipLength;
    protected String customerPhoneNo;
    
    public Slip() {
        this.dockID = "";
        this.slipID = "";
        this.width = 0;
        this.slipLength = 0;
        this.customerPhoneNo = "";
    }

    public Slip(String dockID, String slipID, int width, int slipLength, String customerPhoneNo) {
        this.dockID = dockID;
        this.slipID = slipID;
        this.width = width;
        this.slipLength = slipLength;
        this.customerPhoneNo = customerPhoneNo;
    }
    
    public String getDockID() {
        return dockID;
    }
    
    public void setDockID(String dockID) {
        this.dockID = dockID;
    }

    public String getSlipID() {
        return slipID;
    }

    public void setSlipID(String slipID) {
        this.slipID = slipID;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSlipLength() {
        return slipLength;
    }

    public void setSlipLength(int slipLength) {
        this.slipLength = slipLength;
    }

    public String getCustomerPhoneNo() {
        return customerPhoneNo;
    }

    public void setCustomerPhoneNo(String customerPhoneNo) {
        this.customerPhoneNo = customerPhoneNo;
    }
    
    public void save() throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/slip.dat"));
        Scanner linesScanner = new Scanner (new FileReader ("data/slip.dat"));
        boolean slipExist = false;
        // Get the number of lines in the file
        int linesCount = 0;
        while (linesScanner.hasNextLine()) {
              linesScanner.nextLine();
            linesCount++;       
        }
        // Declare an array of  objects
      Slip[] aSlip = new Slip [linesCount]; 
      
      // Initialize the array of objects and read the file into the array
      for (int i = 0; i<linesCount; i++){
            aSlip[i] = new Slip();
            aSlip[i].dockID = inFile.next();
            aSlip[i].slipID = inFile.next();
            aSlip[i].width = inFile.nextInt();
            aSlip[i].slipLength = inFile.nextInt();
            aSlip[i].customerPhoneNo = inFile.next();
            
            // if the slip exist, modify the slip
            if (this.slipID.equalsIgnoreCase(aSlip[i].slipID)){
                slipExist = true;
                aSlip[i].dockID = this.dockID;
                aSlip[i].slipID = this.slipID;
                aSlip[i].width = this.width;
                aSlip[i].slipLength = this.slipLength;
                aSlip[i].customerPhoneNo = this.customerPhoneNo;
            } // end if       
        } // end for
        // Stores the array in the file      
      PrintWriter outFile = new PrintWriter("data/slip.dat");
      for (int i = 0; i<linesCount; i++){
            outFile.printf("%s %s %d %d %s%n",aSlip[i].dockID, aSlip[i].slipID, aSlip[i].width, aSlip[i].slipLength, aSlip[i].customerPhoneNo);
        }
      
      // Add new line of customer
      if (!slipExist)
      outFile.printf("%s %s %d %d %s%n", this.dockID, this.slipID, this.width, this.slipLength, this.customerPhoneNo);
      
      // close the inFile and the outFile
     inFile.close();
     outFile.close();
    } // end method save
    
    public static void remove(String slipID) throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/slip.dat"));
        
        // Declare an ArrayList of  objects
       ArrayList<Slip> aSlip = new ArrayList<Slip>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aSlip.add(i, new Slip(inFile.next(), inFile.next(), inFile.nextInt(), inFile.nextInt(), inFile.next()));
           if (aSlip.get(i).slipID.equalsIgnoreCase(slipID)){
                aSlip.remove(i);
                i--;
            } // end if       
           i++;             
        } // end while
       
               // Stores the array list in the file   
       PrintWriter outFile = new PrintWriter("data/slip.dat");
      for (int j = 0; j<aSlip.size(); j++)
           outFile.printf("%s %s %d %d %s%n", aSlip.get(j).dockID, aSlip.get(j).slipID, aSlip.get(j).width, aSlip.get(j).slipLength, aSlip.get(j).customerPhoneNo);
     
       // close the inFile and the outFile
      inFile.close();
     outFile.close();
    } // end method remove
    
    public static Slip getSlip(String slipID) throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/slip.dat"));
        Slip result = new Slip();  
        // Declare an ArrayList of  objects
       ArrayList<Slip> aSlip = new ArrayList<Slip>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aSlip.add(i, new Slip(inFile.next(), inFile.next(), inFile.nextInt(), inFile.nextInt(), inFile.next()));
           if (aSlip.get(i).slipID.equalsIgnoreCase(slipID)){
               result.dockID = aSlip.get(i).dockID;
               result.slipID = aSlip.get(i).slipID;
               result.width = aSlip.get(i).width;
               result.slipLength = aSlip.get(i).slipLength;
               result.customerPhoneNo = aSlip.get(i).customerPhoneNo;
           }
           i++;             
        } // end while
       // close the inFile and the outFile
      inFile.close();
    return result;
    } // end method getSlip
    
    public static ArrayList getAllSlip() throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/slip.dat"));
        // Declare an ArrayList of  objects
       ArrayList<Slip> aSlip = new ArrayList<Slip>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aSlip.add(i, new Slip(inFile.next(), inFile.next(), inFile.nextInt(), inFile.nextInt(), inFile.next()));
           i++;             
        } // end while
       // close the inFile and the outFile
      inFile.close();
    return aSlip;
    } // end method getSlip
    
}
