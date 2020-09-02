import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SailBoat extends Boat{
	
	protected double keelDepth;
	protected int numberSails;
	protected String motorType;
	
	public SailBoat() {
		super();
		this.keelDepth =0;
		this.numberSails = 0;
		this.motorType = "";
		
	}
	
	SailBoat(String stateRegistraitionNo, double boatLeangh, String manufacturer, int year, String phoneNo,
			double keelDepth,int numberSails, String motorType){
		super(stateRegistraitionNo, boatLeangh, manufacturer, year, phoneNo);
		this.keelDepth = keelDepth;
		this.numberSails = numberSails;
		this.motorType = motorType;
	}
	

	public double getKeelDepth() {
		return keelDepth;
	}

	public void setKeelDepth(double keelDepth) {
		this.keelDepth = keelDepth;
	}

	public int getNumberSails() {
		return numberSails;
	}

	public void setNumberSails(int numberSails) {
		this.numberSails = numberSails;
	}

	public String getMotorType() {
		return motorType;
	}

	public void setMotorType(String motorType) {
		this.motorType = motorType;
	}
	
public void saveSailBoat() throws FileNotFoundException{
		
		Scanner inFile = new Scanner (new FileReader ("SailBoat.txt"));
        Scanner linesScanner = new Scanner (new FileReader ("SailBoat.txt"));
        boolean sailBoatExist = false;
        // Get the number of lines in the file
        int linesCount = 0;
        while (linesScanner.hasNextLine()) {
        	 
        	linesScanner.nextLine();
        	
            linesCount++;       
	}
        
     // Declare an array of  objects
        SailBoat[] sBoat = new SailBoat [linesCount]; 
        
        // Initialize the array of objects and read the file into the array
        for (int i = 0; i<linesCount; i++){
        	sBoat[i] = new SailBoat();
        	sBoat[i].stateRegistraitionNo = inFile.next();
        	sBoat[i].boatLeangh = inFile.nextDouble();
        	sBoat[i].manufacturer = inFile.next();
        	sBoat[i].year = inFile.nextInt();
        	sBoat[i].phoneNo = inFile.next();
        	sBoat[i].keelDepth = inFile.nextDouble();
        	sBoat[i].numberSails = inFile.nextInt();
        	sBoat[i].motorType = inFile.next();
              
              // if the customer exist, modify the customer
              if (this.stateRegistraitionNo.equals(sBoat[i].stateRegistraitionNo)){
            	  sailBoatExist = true;
            	  sBoat[i].stateRegistraitionNo = this.stateRegistraitionNo;
            	  sBoat[i].boatLeangh = this.boatLeangh;
            	  sBoat[i].manufacturer = this.manufacturer;
            	  sBoat[i].year = this.year;
            	  sBoat[i].phoneNo = this.phoneNo;
            	  sBoat[i].keelDepth = this.keelDepth;
            	  sBoat[i].numberSails = this.numberSails;
            	  sBoat[i].motorType = this.motorType;
                  
                  
              } // end if       
          } // end for
          // Stores the array in the file      
        PrintWriter outFile = new PrintWriter("SailBoat.txt");
        for (int i = 0; i<linesCount; i++){
              outFile.printf("%s %f %s %d %s %f %d %s%n", sBoat[i].stateRegistraitionNo, sBoat[i].boatLeangh, sBoat[i].manufacturer,  
            		  sBoat[i].year,  sBoat[i].phoneNo, sBoat[i].keelDepth, sBoat[i].numberSails, sBoat[i].motorType);
          }
        

        // Add new line of customer
        if (!sailBoatExist)
        outFile.printf("%s %f %s %d %s %f %d %s%n", this.stateRegistraitionNo, this.boatLeangh, this.manufacturer,
        		this.year, this.phoneNo, this.keelDepth, this.numberSails, this.motorType);
        
        // close the inFile and the outFile
       inFile.close();
       outFile.close();
      } // end method save

public void removeSailBoatFromSlip() throws FileNotFoundException{
	
	 Scanner inFile = new Scanner (new FileReader ("SailBoat.txt"));
       
       // Declare an ArrayList of  objects
      ArrayList<SailBoat> sBoat = new ArrayList<SailBoat>(); 
      int i = 0;
      while (inFile.hasNext()) {
   	   sBoat.add(i, new SailBoat(inFile.next(), inFile.nextDouble(), inFile.next(),inFile.nextInt(),inFile.next(),
   			inFile.nextDouble(),inFile.nextInt(),inFile.next()));
          if (sBoat.get(i).stateRegistraitionNo.equals(this.stateRegistraitionNo)){
       	   sBoat.remove(i);
               i--;
           } // end if       
          i++;             
}
      
      // Stores the array list in the file   
      PrintWriter outFile = new PrintWriter("SailBoat.txt");
     for (int j = 0; j<sBoat.size(); j++)
          outFile.printf("%s %f %s %d %s %f %d %s%n", sBoat.get(j).stateRegistraitionNo, sBoat.get(j).boatLeangh, sBoat.get(j).manufacturer,
        		  sBoat.get(j).year,  sBoat.get(j).phoneNo,sBoat.get(j).keelDepth,sBoat.get(j).numberSails,sBoat.get(j).motorType);
    
      // close the inFile and the outFile
     inFile.close();
    outFile.close();
   } // end method remove




	public  static SailBoat getSailBoat(String id)throws FileNotFoundException{
		
		Scanner inFile = new Scanner (new FileReader ("SailBoat.txt"));
		SailBoat result = new SailBoat();  
        // Declare an ArrayList of  objects
       ArrayList<SailBoat> sBoat = new ArrayList<SailBoat>(); 
       int i = 0;
       while (inFile.hasNext()) {
           sBoat.add(i, new SailBoat(inFile.next(), inFile.nextDouble(), inFile.next(),inFile.nextInt(), inFile.next(),
        		   inFile.nextDouble(),inFile.nextInt(),inFile.next()));
           if (sBoat.get(i).phoneNo.equals(id) ||  sBoat.get(i).stateRegistraitionNo.equals(id)){
               result.stateRegistraitionNo = sBoat.get(i).stateRegistraitionNo;;
               result.boatLeangh = sBoat.get(i).boatLeangh;
               result.manufacturer = sBoat.get(i).manufacturer;
               result.year = sBoat.get(i).year;
               result.phoneNo = sBoat.get(i).phoneNo;
               result.keelDepth = sBoat.get(i).keelDepth;
               result.numberSails = sBoat.get(i).numberSails;
               result.motorType = sBoat.get(i).motorType;
               
           }
           i++;             
       } // end while
       // close the inFile and the outFile
      inFile.close();
    return result;
    
	}
	 public static ArrayList getAllSailBoat() throws FileNotFoundException{
	        Scanner inFile = new Scanner (new FileReader ("SailBoat.txt"));
	        SailBoat result = new SailBoat();  
	        // Declare an ArrayList of  objects
	       ArrayList<SailBoat> sBoat = new ArrayList<SailBoat>(); 
	       int i = 0;
	       while (inFile.hasNext()) {
	    	   sBoat.add(i, new SailBoat(inFile.next(), inFile.nextDouble(), inFile.next(),inFile.nextInt(), inFile.next(),
	        		   inFile.nextDouble(),inFile.nextInt(),inFile.next()));
	           i++;
	        } // end while
	       // close the inFile
	      inFile.close();
	    return sBoat;
	    } // end method getCustomer
}




