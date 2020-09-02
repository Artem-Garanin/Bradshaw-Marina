package com.ipd23.bradshaw.marina;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PowerBoat extends Boat{

	private double numberEngines;
	private String fuelType;
	
	
	public PowerBoat() {
		super();
		this.numberEngines =0;
		this.fuelType = "";
		
	}
	
	PowerBoat(String stateRegistraitionNo, double boatLeangh, String manufacturer, int year, String phoneNo,
			double numberEngines, String fuelType){
		super(stateRegistraitionNo, boatLeangh, manufacturer, year, phoneNo);
		this.numberEngines = numberEngines;
		this.fuelType = fuelType;
	}
	
	
	public double getNumberEngines() {
		return numberEngines;
	}
	public void setNumberEngines(double numberEngines) {
		this.numberEngines = numberEngines;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
public void  assignBoatToSlip() {
	
	}

public void savePowerBoat() throws FileNotFoundException{
		
		Scanner inFile = new Scanner (new FileReader ("data/PowerBoat.dat"));
        Scanner linesScanner = new Scanner (new FileReader ("data/PowerBoat.dat"));
        boolean powerBoatExist = false;
        // Get the number of lines in the file
        int linesCount = 0;
        while (linesScanner.hasNextLine()) {
        	 
        	linesScanner.nextLine();
        	
            linesCount++;       
	}
        
     // Declare an array of  objects
        PowerBoat[] aBoat = new PowerBoat [linesCount]; 
        
        // Initialize the array of objects and read the file into the array
        for (int i = 0; i<linesCount; i++){
        	aBoat[i] = new PowerBoat();
        	aBoat[i].stateRegistraitionNo = inFile.next();
        	aBoat[i].boatLeangh = inFile.nextDouble();
        	aBoat[i].manufacturer = inFile.next();
        	aBoat[i].year = inFile.nextInt();
        	aBoat[i].phoneNo = inFile.next();
        	aBoat[i].numberEngines = inFile.nextDouble();
        	aBoat[i].fuelType = inFile.next();
              
              // if the customer exist, modify the customer
              if (this.stateRegistraitionNo.equals(aBoat[i].stateRegistraitionNo)){
            	  powerBoatExist = true;
                  aBoat[i].stateRegistraitionNo = this.stateRegistraitionNo;
                  aBoat[i].boatLeangh = this.boatLeangh;
                  aBoat[i].manufacturer = this.manufacturer;
                  aBoat[i].year = this.year;
                  aBoat[i].phoneNo = this.phoneNo;
                  aBoat[i].numberEngines = this.numberEngines;
                  aBoat[i].fuelType = this.fuelType;;
                  
                  
              } // end if       
          } // end for
          // Stores the array in the file      
        PrintWriter outFile = new PrintWriter("data/PowerBoat.dat");
        for (int i = 0; i<linesCount; i++){
              outFile.printf("%s %f %s %d %s %f %s%n", aBoat[i].stateRegistraitionNo, aBoat[i].boatLeangh, aBoat[i].manufacturer,  
            		  aBoat[i].year,  aBoat[i].phoneNo, aBoat[i].numberEngines, aBoat[i].fuelType);
          }
        

        // Add new line of customer
        if (!powerBoatExist)
        outFile.printf("%s %f %s %d %s %f %s%n", this.stateRegistraitionNo, this.boatLeangh, this.manufacturer,
        		this.year, this.phoneNo, this.numberEngines, this.fuelType);
        
        // close the inFile and the outFile
       inFile.close();
       outFile.close();
      } // end method save

public void removePowerBoatFromSlip() throws FileNotFoundException{
	
	 Scanner inFile = new Scanner (new FileReader ("data/PowerBoat.dat"));
       
       // Declare an ArrayList of  objects
      ArrayList<PowerBoat> aBoat = new ArrayList<PowerBoat>(); 
      int i = 0;
      while (inFile.hasNext()) {
   	   aBoat.add(i, new PowerBoat(inFile.next(), inFile.nextDouble(), inFile.next(),inFile.nextInt(),inFile.next(),
   			inFile.nextDouble(),inFile.next()));
          if (aBoat.get(i).stateRegistraitionNo.equals(this.stateRegistraitionNo)){
       	   aBoat.remove(i);
               i--;
           } // end if       
          i++;             
}
      
      // Stores the array list in the file   
      PrintWriter outFile = new PrintWriter("data/PowerBoat.dat");
     for (int j = 0; j<aBoat.size(); j++)
          outFile.printf("%s %f %s %d %s %f %s%n", aBoat.get(j).stateRegistraitionNo, aBoat.get(j).boatLeangh, aBoat.get(j).manufacturer,
        		  aBoat.get(j).year,  aBoat.get(j).phoneNo,aBoat.get(j).numberEngines,aBoat.get(j).fuelType);
    
      // close the inFile and the outFile
     inFile.close();
    outFile.close();
   } // end method remove




	public static  PowerBoat getPowerBoat(String id)throws FileNotFoundException{
		
		Scanner inFile = new Scanner (new FileReader ("data/PowerBoat.dat"));
		PowerBoat result = new PowerBoat();  
        // Declare an ArrayList of  objects
       ArrayList<PowerBoat> aBoat = new ArrayList<PowerBoat>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aBoat.add(i, new PowerBoat(inFile.next(), inFile.nextDouble(), inFile.next(),inFile.nextInt(), inFile.next(),
        		   inFile.nextDouble(),inFile.next()));
           if (aBoat.get(i).phoneNo.equals(id) ||  aBoat.get(i).stateRegistraitionNo.equals(id)){
               result.stateRegistraitionNo = aBoat.get(i).stateRegistraitionNo;;
               result.boatLeangh = aBoat.get(i).boatLeangh;
               result.manufacturer = aBoat.get(i).manufacturer;
               result.year = aBoat.get(i).year;
               result.phoneNo = aBoat.get(i).phoneNo;
               result.numberEngines = aBoat.get(i).numberEngines;
               result.fuelType = aBoat.get(i).fuelType;
               
           }
           i++;             
       } // end while
       // close the inFile and the outFile
      inFile.close();
    return result;
    
	}
	
	 public static ArrayList getAllPowerBoat() throws FileNotFoundException{
	        Scanner inFile = new Scanner (new FileReader ("data/PowerBoat.dat"));
	        PowerBoat result = new PowerBoat();  
	        // Declare an ArrayList of  objects
	       ArrayList<PowerBoat> pBoat = new ArrayList<PowerBoat>(); 
	       int i = 0;
	       while (inFile.hasNext()) {
	    	   pBoat.add(i, new PowerBoat(inFile.next(), inFile.nextDouble(), inFile.next(),inFile.nextInt(),inFile.next(),
	    	   			inFile.nextDouble(),inFile.next()));
	           i++;
	        } // end while
	       // close the inFile
	      inFile.close();
	    return pBoat;
	    } // end method getCustomer

}
