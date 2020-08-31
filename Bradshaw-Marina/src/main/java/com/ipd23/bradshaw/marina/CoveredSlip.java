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
public class CoveredSlip extends Slip {
    private int height;
    private String door;

    public CoveredSlip() {
        super();
        this.height = 0;
        this.door = "";
    }

    public CoveredSlip(int dockID, int slipID, int width, int slipLength, String customerPhoneNo, int height, String door) {
        super(dockID, slipID, width, slipLength, customerPhoneNo);
        this.height = height;
        this.door = door;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }
    
     public static void save(CoveredSlip newSlip) throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/coveredSlip.dat"));
        Scanner linesScanner = new Scanner (new FileReader ("data/coveredSlip.dat"));
        boolean slipExist = false;
        // Get the number of lines in the file
        int linesCount = 0;
        while (linesScanner.hasNextLine()) {
              linesScanner.nextLine();
            linesCount++;       
        }
        // Declare an array of  objects
      CoveredSlip[] aSlip = new CoveredSlip [linesCount]; 
      
      // Initialize the array of objects and read the file into the array
      for (int i = 0; i<linesCount; i++){
            aSlip[i] = new CoveredSlip();
            aSlip[i].setDockID(inFile.nextInt());
            aSlip[i].setSlipID(inFile.nextInt());
            aSlip[i].setWidth(inFile.nextInt());
            aSlip[i].setSlipLength(inFile.nextInt());
            aSlip[i].setCustomerPhoneNo(inFile.next());
            aSlip[i].height = inFile.nextInt();
            aSlip[i].door = inFile.next();
            
            // if the slip exist, modify the slip
            if (newSlip.getSlipID() == aSlip[i].getSlipID()){
                slipExist = true;
                aSlip[i].setDockID(newSlip.getDockID());
                aSlip[i].setSlipID(newSlip.getSlipID());
                aSlip[i].setWidth(newSlip.getWidth());
                aSlip[i].setSlipLength(newSlip.getSlipLength());
                aSlip[i].setCustomerPhoneNo(newSlip.getCustomerPhoneNo());
                aSlip[i].height = newSlip.height;
                aSlip[i].door = newSlip.door;
            } // end if       
        } // end for
        // Stores the array in the file      
      PrintWriter outFile = new PrintWriter("data/coveredSlip.dat");
      for (int i = 0; i<linesCount; i++){
            outFile.printf("%d %d %d %d %s %d %s%n",aSlip[i].getDockID(), aSlip[i].getSlipID(), aSlip[i].getWidth(), 
                    aSlip[i].getSlipLength(), aSlip[i].getCustomerPhoneNo(), aSlip[i].getHeight(), aSlip[i].getDoor());
        }
      
      // Add new line of customer
      if (!slipExist)
      outFile.printf("%d %d %d %d %s %d %s%n", newSlip.getDockID(), newSlip.getSlipID(), newSlip.getWidth(), newSlip.getSlipLength(), 
              newSlip.getCustomerPhoneNo(), newSlip.getHeight(), newSlip.getDoor());
      
      // close the inFile and the outFile
     inFile.close();
     outFile.close();
    } // end method save
    
    public static void remove(int slipID) throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/coveredSlip.dat"));
        
        // Declare an ArrayList of  objects
       ArrayList<CoveredSlip> aSlip = new ArrayList<CoveredSlip>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aSlip.add(i, new CoveredSlip(inFile.nextInt(), inFile.nextInt(), inFile.nextInt(), inFile.nextInt(), inFile.next(), inFile.nextInt(), inFile.next()));
           if (aSlip.get(i).getSlipID() == slipID){
                aSlip.remove(i);
                i--;
            } // end if       
           i++;             
        } // end while
       
               // Stores the array list in the file   
       PrintWriter outFile = new PrintWriter("data/coveredSlip.dat");
      for (int j = 0; j<aSlip.size(); j++)
           outFile.printf("%d %d %d %d %s %d %s%n", aSlip.get(j).getDockID(), aSlip.get(j).getSlipID(), aSlip.get(j).getWidth(), 
                   aSlip.get(j).getSlipLength(), aSlip.get(j).getCustomerPhoneNo(), aSlip.get(j).getHeight(), aSlip.get(j).getDoor());
     
       // close the inFile and the outFile
      inFile.close();
     outFile.close();
    } // end method remove
    
    public static CoveredSlip getSlip(int slipID) throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/coveredSlip.dat"));
        CoveredSlip result = new CoveredSlip();  
        // Declare an ArrayList of  objects
       ArrayList<CoveredSlip> aSlip = new ArrayList<CoveredSlip>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aSlip.add(i, new CoveredSlip(inFile.nextInt(), inFile.nextInt(), inFile.nextInt(), inFile.nextInt(), 
                   inFile.next(), inFile.nextInt(), inFile.next()));
           if (aSlip.get(i).getSlipID() == slipID){
               result.setDockID(aSlip.get(i).getDockID());
               result.setSlipID(aSlip.get(i).getSlipID());
               result.setWidth(aSlip.get(i).getWidth());
               result.setSlipLength(aSlip.get(i).getSlipLength());
               result.setCustomerPhoneNo(aSlip.get(i).getCustomerPhoneNo());
               result.height = aSlip.get(i).height;
               result.door = aSlip.get(i).door;
           }
           i++;             
        } // end while
       // close the inFile and the outFile
      inFile.close();
    return result;
    } // end method remove
    
}
