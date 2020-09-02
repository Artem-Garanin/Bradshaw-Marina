// CoveredSlip.java

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

    public CoveredSlip(String dockID, String slipID, int width, int slipLength, String customerPhoneNo, int height, String door) {
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
    
     public void save() throws FileNotFoundException{
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
            aSlip[i].dockID = inFile.next();
            aSlip[i].slipID = inFile.next();
            aSlip[i].width = inFile.nextInt();
            aSlip[i].slipLength = inFile.nextInt();
            aSlip[i].customerPhoneNo = inFile.next();
            aSlip[i].height = inFile.nextInt();
            aSlip[i].door = inFile.next();
            
            // if the slip exist, modify the slip
            if (this.slipID.equalsIgnoreCase(aSlip[i].slipID)){
                slipExist = true;
                aSlip[i].dockID = this.dockID;
                aSlip[i].slipID = this.slipID;
                aSlip[i].width = this.width;
                aSlip[i].slipLength = this.slipLength;
                aSlip[i].customerPhoneNo = this.customerPhoneNo;
                aSlip[i].height = this.height;
                aSlip[i].door = this.door;
            } // end if       
        } // end for
        // Stores the array in the file      
      PrintWriter outFile = new PrintWriter("data/coveredSlip.dat");
      for (int i = 0; i<linesCount; i++){
            outFile.printf("%s %s %d %d %s %d %s%n",aSlip[i].dockID, aSlip[i].slipID, aSlip[i].width, 
                    aSlip[i].slipLength, aSlip[i].customerPhoneNo, aSlip[i].height, aSlip[i].door);
        }
      
      // Add new line of customer
      if (!slipExist)
      outFile.printf("%s %s %d %d %s %d %s%n", this.dockID, this.slipID, this.width, this.slipLength, 
              this.customerPhoneNo, this.height, this.door);
      
      // close the inFile and the outFile
     inFile.close();
     outFile.close();
    } // end method save
    
    public static void remove(String slipID) throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/coveredSlip.dat"));
        
        // Declare an ArrayList of  objects
       ArrayList<CoveredSlip> aSlip = new ArrayList<CoveredSlip>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aSlip.add(i, new CoveredSlip(inFile.next(), inFile.next(), inFile.nextInt(), 
                   inFile.nextInt(), inFile.next(), inFile.nextInt(), inFile.next()));
           if (aSlip.get(i).slipID.equalsIgnoreCase(slipID)){
                aSlip.remove(i);
                i--;
            } // end if       
           i++;             
        } // end while
       
               // Stores the array list in the file   
       PrintWriter outFile = new PrintWriter("data/coveredSlip.dat");
      for (int j = 0; j<aSlip.size(); j++)
           outFile.printf("%s %s %d %d %s %d %s%n", aSlip.get(j).dockID, aSlip.get(j).slipID, 
                   aSlip.get(j).width, aSlip.get(j).slipLength, aSlip.get(j).customerPhoneNo, 
                   aSlip.get(j).height, aSlip.get(j).door);
     
       // close the inFile and the outFile
      inFile.close();
     outFile.close();
    } // end method remove
    
    public static CoveredSlip getSlip(String slipID) throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/coveredSlip.dat"));
        CoveredSlip result = new CoveredSlip();  
        // Declare an ArrayList of  objects
       ArrayList<CoveredSlip> aSlip = new ArrayList<CoveredSlip>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aSlip.add(i, new CoveredSlip(inFile.next(), inFile.next(), inFile.nextInt(), inFile.nextInt(), 
                   inFile.next(), inFile.nextInt(), inFile.next()));
           if (aSlip.get(i).slipID.equalsIgnoreCase(slipID)){
               result.dockID = aSlip.get(i).dockID;
               result.slipID = aSlip.get(i).slipID;
               result.width = aSlip.get(i).width;
               result.slipLength = aSlip.get(i).slipLength;
               result.customerPhoneNo = aSlip.get(i).customerPhoneNo;
               result.height = aSlip.get(i).height;
               result.door = aSlip.get(i).door;
           }
           i++;             
        } // end while
       // close the inFile and the outFile
      inFile.close();
    return result;
    } // end method getSlip
    
    public static ArrayList getAllSlip() throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/coveredSlip.dat"));
        // Declare an ArrayList of  objects
       ArrayList<CoveredSlip> aSlip = new ArrayList<CoveredSlip>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aSlip.add(i, new CoveredSlip(inFile.next(), inFile.next(), inFile.nextInt(), inFile.nextInt(), 
                   inFile.next(), inFile.nextInt(), inFile.next()));
           i++;             
        } // end while
       // close the inFile and the outFile
      inFile.close();
    return aSlip;
    } // end method getAllSlip
    
}
