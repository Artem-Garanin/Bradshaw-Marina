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
public class Dock {
    private String dockID;
    private String location;
    private String electricity;
    private String water;
    
    public Dock() {
        this.dockID = "";
        this.location = "";
        this.electricity = "";
        this.water = "";
    }
    public Dock(String dockID, String location, String electricity, String water) {
        this.dockID = dockID;
        this.location = location;
        this.electricity = electricity;
        this.water = water;
    }

    public String getDockID() {
        return dockID;
    }

    public void setDockID(String dockID) {
        this.dockID = dockID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getElectricity() {
        return electricity;
    }

    public void setElectricity(String electricity) {
        this.electricity = electricity;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }
    
    public void save() throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/dock.dat"));
        Scanner linesScanner = new Scanner (new FileReader ("data/dock.dat"));
        boolean dockExist = false;
        // Get the number of lines in the file
        int linesCount = 0;
        while (linesScanner.hasNextLine()) {
              linesScanner.nextLine();
            linesCount++;       
        }
        // Declare an array of  objects
      Dock[] aDock = new Dock [linesCount]; 
      
      // Initialize the array of objects and read the file into the array
      for (int i = 0; i<linesCount; i++){
            aDock[i] = new Dock();
            aDock[i].dockID = inFile.next();
            aDock[i].location = inFile.next();
            aDock[i].electricity = inFile.next();
            aDock[i].water = inFile.next();
            
            // if the dock exist, modify the dock
            if (this.dockID.equalsIgnoreCase(aDock[i].dockID)){
                dockExist = true;
                aDock[i].dockID = this.dockID;
                aDock[i].location = this.location;
                aDock[i].electricity = this.electricity;
                aDock[i].water = this.water;
            } // end if       
        } // end for
        // Stores the array in the file      
      PrintWriter outFile = new PrintWriter("data/dock.dat");
      for (int i = 0; i<linesCount; i++){
            outFile.printf("%s %s %s %s%n", aDock[i].dockID, aDock[i].location, aDock[i].electricity, aDock[i].water);
        }
      
      // Add new line of customer
      if (!dockExist)
      outFile.printf("%s %s %s %s%n", this.dockID, this.location, this.electricity, this.water);
      
      // close the inFile and the outFile
     inFile.close();
     outFile.close();
    } // end method save
    
    public void remove() throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/dock.dat"));
        
        // Declare an ArrayList of  objects
       ArrayList<Dock> aDock = new ArrayList<Dock>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aDock.add(i, new Dock(inFile.next(), inFile.next(), inFile.next(), inFile.next()));
           if (aDock.get(i).dockID.equalsIgnoreCase(this.dockID)){
                aDock.remove(i);
                i--;
            } // end if       
           i++;             
        } // end while
       
               // Stores the array list in the file   
       PrintWriter outFile = new PrintWriter("data/dock.dat");
      for (int j = 0; j<aDock.size(); j++)
           outFile.printf("%s %s %s %s%n", aDock.get(j).dockID, aDock.get(j).location, aDock.get(j).electricity, aDock.get(j).water);
     
       // close the inFile and the outFile
      inFile.close();
     outFile.close();
    } // end method remove
    
    public static Dock getDock(String dockID) throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/dock.dat"));
        Dock result = new Dock();  
        // Declare an ArrayList of  objects
       ArrayList<Dock> aDock = new ArrayList<Dock>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aDock.add(i, new Dock(inFile.next(), inFile.next(), inFile.next(), inFile.next()));
           if (aDock.get(i).dockID.equalsIgnoreCase(dockID)){
               result.dockID = aDock.get(i).dockID;
               result.location = aDock.get(i).location;
               result.electricity = aDock.get(i).electricity;
               result.water = aDock.get(i).water;
           }
           i++;             
        } // end while
       // close the inFile and the outFile
      inFile.close();
    return result;
    } // end method getDock
    
    public static ArrayList getAllDock() throws FileNotFoundException{
        Scanner inFile = new Scanner (new FileReader ("data/dock.dat")); 
        // Declare an ArrayList of  objects
       ArrayList<Dock> aDock = new ArrayList<Dock>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aDock.add(i, new Dock(inFile.next(), inFile.next(), inFile.next(), inFile.next()));
           i++;             
        } // end while
       // close the inFile and the outFile
      inFile.close();
    return aDock;
    } // end method getDock
    
}
