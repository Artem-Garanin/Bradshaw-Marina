/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private int dockID;
    private int slipID;
    private int width;
    private int slipLength;
    private String customerPhoneNo;
    
    public Slip() {
        this.dockID = 0;
        this.slipID = 0;
        this.width = 0;
        this.slipLength = 0;
        this.customerPhoneNo = "";
    }

    public Slip(int dockID, int slipID, int width, int slipLength, String customerPhoneNo) {
        this.dockID = dockID;
        this.slipID = slipID;
        this.width = width;
        this.slipLength = slipLength;
        this.customerPhoneNo = customerPhoneNo;
    }
    
    public int getDockID() {
        return dockID;
    }
    
    public void setDockID(int dockID) {
        this.dockID = dockID;
    }

    public int getSlipID() {
        return slipID;
    }

    public void setSlipID(int slipID) {
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

     public void assignCustomer(String customerPhoneNo) {
        this.customerPhoneNo = customerPhoneNo;
    }
     
      public void assignDock(int dockID) {
        this.dockID = dockID;
    }
    
     public static void save(Slip newSlip) throws FileNotFoundException{
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
            aSlip[i].dockID = inFile.nextInt();
            aSlip[i].slipID = inFile.nextInt();
            aSlip[i].width = inFile.nextInt();
            aSlip[i].slipLength = inFile.nextInt();
            aSlip[i].customerPhoneNo = inFile.next();
            
            // if the slip exist, modify the slip
            if (newSlip.slipID == aSlip[i].slipID){
                slipExist = true;
                aSlip[i].dockID = newSlip.dockID;
                aSlip[i].slipID = newSlip.slipID;
                aSlip[i].width = newSlip.width;
                aSlip[i].slipLength = newSlip.slipLength;
                aSlip[i].customerPhoneNo = newSlip.customerPhoneNo;
            } // end if       
        } // end for
        // Stores the array in the file      
      PrintWriter outFile = new PrintWriter("data/slip.dat");
      for (int i = 0; i<linesCount; i++){
            outFile.printf("%d %d %d %d %s%n",aSlip[i].dockID, aSlip[i].slipID, aSlip[i].width, aSlip[i].slipLength, aSlip[i].customerPhoneNo);
        }
      
      // Add new line of customer
      if (!slipExist)
      outFile.printf("%d %d %d %d %s%n", newSlip.dockID, newSlip.slipID, newSlip.width, newSlip.slipLength, newSlip.customerPhoneNo);
      
      // close the inFile and the outFile
     inFile.close();
     outFile.close();
    } // end method save
    
    public static void remove(int slipID) throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/slip.dat"));
        
        // Declare an ArrayList of  objects
       ArrayList<Slip> aSlip = new ArrayList<Slip>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aSlip.add(i, new Slip(inFile.nextInt(), inFile.nextInt(), inFile.nextInt(), inFile.nextInt(), inFile.next()));
           if (aSlip.get(i).slipID == slipID){
                aSlip.remove(i);
                i--;
            } // end if       
           i++;             
        } // end while
       
               // Stores the array list in the file   
       PrintWriter outFile = new PrintWriter("data/slip.dat");
      for (int j = 0; j<aSlip.size(); j++)
           outFile.printf("%d %d %d %d %s%n", aSlip.get(j).dockID, aSlip.get(j).slipID, aSlip.get(j).width, aSlip.get(j).slipLength, aSlip.get(j).customerPhoneNo);
     
       // close the inFile and the outFile
      inFile.close();
     outFile.close();
    } // end method remove
    
    public static Slip getSlip(int slipID) throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/slip.dat"));
        Slip result = new Slip();  
        // Declare an ArrayList of  objects
       ArrayList<Slip> aSlip = new ArrayList<Slip>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aSlip.add(i, new Slip(inFile.nextInt(), inFile.nextInt(), inFile.nextInt(), inFile.nextInt(), inFile.next()));
           if (aSlip.get(i).slipID == slipID){
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
    } // end method remove
    
}
