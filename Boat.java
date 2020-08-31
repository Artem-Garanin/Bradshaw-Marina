
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Boat {

	protected String stateRegistraitionNo;
	protected double boatLeangh;
	protected String manufacturer;
	protected int year;
	protected String phoneNo;
	
	public Boat() {
		this.stateRegistraitionNo = "";
		this.boatLeangh = 0;
		this.manufacturer = "";
		this.year = 0;
		this.phoneNo = "";
		
	}	
	
	public Boat(String stateRegistraitionNo, double boatLeangh, String manufacturer, int year, String phoneNo) {
		
		this.stateRegistraitionNo = stateRegistraitionNo;
		this.boatLeangh = boatLeangh;
		this.manufacturer = manufacturer;
		this.year = year;
		this.phoneNo = phoneNo;
	}
	
	public String getStateRegistraitionNo() {
		return stateRegistraitionNo;
	}
	public void setStateRegistraitionNo(String stateRegistraitionNo) {
		this.stateRegistraitionNo = stateRegistraitionNo;
	}
	public double getBoatLeangh() {
		return boatLeangh;
	}
	public void setBoatLeangh(double boatLeangh) {
		this.boatLeangh = boatLeangh;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
		
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public void  assignBoatToSlip() {
		
		
	}
	
public void saveBoat() throws FileNotFoundException{
		
		Scanner inFile = new Scanner (new FileReader ("PowerBoat.txt"));
        Scanner linesScanner = new Scanner (new FileReader ("PowerBoat.txt"));
        boolean boatExist = false;
        // Get the number of lines in the file
        int linesCount = 0;
        while (linesScanner.hasNextLine()) {
        	 
        	linesScanner.nextLine();
        	
            linesCount++;       
	}
        
     // Declare an array of  objects
        Boat[] aBoat = new Boat [linesCount]; 
        
        // Initialize the array of objects and read the file into the array
        for (int i = 0; i<linesCount; i++){
        	aBoat[i] = new Boat();
        	aBoat[i].stateRegistraitionNo = inFile.next();
        	aBoat[i].boatLeangh = inFile.nextDouble();
        	aBoat[i].manufacturer = inFile.next();
        	aBoat[i].year = inFile.nextInt();
        	aBoat[i].phoneNo = inFile.next();
              
              // if the customer exist, modify the customer
              if (this.phoneNo.equals(aBoat[i].phoneNo)){
                  boatExist = true;
                  aBoat[i].stateRegistraitionNo = this.stateRegistraitionNo;
                  aBoat[i].boatLeangh = this.boatLeangh;
                  aBoat[i].manufacturer = this.manufacturer;
                  aBoat[i].year = this.year;
                  aBoat[i].phoneNo = this.phoneNo;
                  
                  
              } // end if       
          } // end for
          // Stores the array in the file      
        PrintWriter outFile = new PrintWriter("PowerBoat.txt");
        for (int i = 0; i<linesCount; i++){
              outFile.printf("%s %f %s %d %s%n", aBoat[i].stateRegistraitionNo, aBoat[i].boatLeangh, aBoat[i].manufacturer,  
            		  aBoat[i].year,  aBoat[i].phoneNo);
          }
        

        // Add new line of customer
        if (!boatExist)
        outFile.printf("%s %f %s %d %s%n", this.stateRegistraitionNo, this.boatLeangh, this.manufacturer,
        		this.year, this.phoneNo);
        
        // close the inFile and the outFile
       inFile.close();
       outFile.close();
      } // end method save

public void removeBoatFromSlip() throws FileNotFoundException{
	
	 Scanner inFile = new Scanner (new FileReader ("PowerBoat.txt"));
       
       // Declare an ArrayList of  objects
      ArrayList<Boat> aBoat = new ArrayList<Boat>(); 
      int i = 0;
      while (inFile.hasNext()) {
   	   aBoat.add(i, new Boat(inFile.next(), inFile.nextDouble(), inFile.next(),inFile.nextInt(),inFile.next()));
          if (aBoat.get(i).phoneNo.equals(this.phoneNo)){
       	   aBoat.remove(i);
               i--;
           } // end if       
          i++;             
}
      
      // Stores the array list in the file   
      PrintWriter outFile = new PrintWriter("PowerBoat.txt");
     for (int j = 0; j<aBoat.size(); j++)
          outFile.printf("%s %f %s %d %s%n", aBoat.get(j).stateRegistraitionNo, aBoat.get(j).boatLeangh, aBoat.get(j).manufacturer,
        		  aBoat.get(j).year,  aBoat.get(j).phoneNo );
    
      // close the inFile and the outFile
     inFile.close();
    outFile.close();
   } // end method remove




	public  Boat getBoat(String id)throws FileNotFoundException{
		
		Scanner inFile = new Scanner (new FileReader ("PowerBoat.txt"));
        Boat result = new Boat();  
        // Declare an ArrayList of  objects
       ArrayList<Boat> aBoat = new ArrayList<Boat>(); 
       int i = 0;
       while (inFile.hasNext()) {
           aBoat.add(i, new Boat(inFile.next(), inFile.nextDouble(), inFile.next(),inFile.nextInt(), inFile.next()));
           if (aBoat.get(i).phoneNo.equals(id) &&  aBoat.get(i).stateRegistraitionNo.equals(id)){
               result.stateRegistraitionNo = aBoat.get(i).stateRegistraitionNo;;
               result.boatLeangh = aBoat.get(i).boatLeangh;
               result.manufacturer = aBoat.get(i).manufacturer;
               result.year = aBoat.get(i).year;
               result.phoneNo = aBoat.get(i).phoneNo;
               
           }
           i++;             
       } // end while
       // close the inFile and the outFile
      inFile.close();
    return result;
    
	}


	
}
