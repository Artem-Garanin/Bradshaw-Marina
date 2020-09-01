package ipd23.vladimir;

import java.util.*;
import java.io.*;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;


  class DailyLease extends Lease1{

//	static final int NUMBER_OF_MONTHS = 12;
//        static final int NUMBER_OF_DAYS = 365;

	//private int leaseID;
	//private String dateBeforeString;
	protected double payDaily;
	protected double amountDaily;
//	protected double amountPaid;
//	protected double balanceDue;


	public DailyLease() {
		//this.leaseID = 0;
		//this.dateBeforeString = "2017-05-24";
		super();
		this.payDaily = 0;
		this.amountDaily = 0;
//		this.amountPaid = 0;
//		this.balanceDue = 0;
	}

	public DailyLease(String leaseID, int numberOfDays, String phoneNo, int slipID, double payDaily, 
			double amountDaily) {
		//this.leaseID = leaseID;
		//this.dateBeforeString = dateBeforeString;
		super(leaseID, numberOfDays, phoneNo, slipID);
		this.payDaily = payDaily;
		this.amountDaily = amountDaily;
//		this.amountPaid = amountPaid;
//		this.balanceDue = balanceDue;
	}

	
	public double getPayDaily() {
		return payDaily;
	}

	public void setPayDaily(double payDaily) {
		this.payDaily = payDaily;
	}

	public double getAmountDaily() {
		return amountDaily;
	}

	public void setAmountDaily(double amountDaily) {
		this.amountDaily = amountDaily;
	}

//	public double getAmountPaid() {
//		return amountPaid;
//	}
//
//	public void setAmountPaid(double amountPaid) {
//		this.amountPaid = amountPaid;
//	}

//	public double getBalanceDue() {
//		return balanceDue;
//	}
//
//	public void setBalanceDue(double balanceDue) {
//		this.balanceDue = balanceDue;
//	}

	
		public void saveDailyLease() throws FileNotFoundException{
			
		Scanner inFile = new Scanner (new FileReader ("DailyLease.txt"));
	        Scanner linesScanner = new Scanner (new FileReader ("DailyLease.txt"));
	        boolean DailyLease = false;
	        // Get the number of lines in the file
	        int linesCount = 0;
	        while (linesScanner.hasNextLine()) {	        	 
	        	linesScanner.nextLine();	        	
	            linesCount++;       
		}
	        
	     // Declare an array of  objects
	        DailyLease[] sLease = new DailyLease [linesCount]; 
	        
	        // Initialize the array of objects and read the file into the array
	        for (int i = 0; i<linesCount; i++){
	        	sLease[i] = new DailyLease();
	        	sLease[i].leaseID = inFile.next();
	        	sLease[i].numberOfDays = inFile.nextInt();
	        	sLease[i].phoneNo = inFile.next();
	        	sLease[i].slipID = inFile.nextInt();
                        sLease[i].payDaily = inFile.nextDouble();
	        	sLease[i].amountDaily = inFile.nextDouble();
//	        	sLease[i].amountPaid = inFile.nextDouble();
//	        	sLease[i].balanceDue = inFile.nextDouble();
	        	
                        // calculate monthly lease
	        	amountDaily = this.payDaily * numberOfDays;
			// calculate balance due
//			balanceDue = this.amountAnnual - amountPaid;
	              
	              // if the customer exist, modify the customer
	              if (this.leaseID.equals(sLease[i].leaseID)){
	            	  DailyLease = true;
	            	  sLease[i].leaseID = this.leaseID;
	            	  sLease[i].numberOfDays = this.numberOfDays;
	            	  sLease[i].phoneNo = this.phoneNo;
	            	  sLease[i].slipID = this.slipID;
                    	  sLease[i].payDaily = payDaily;
	            	  sLease[i].amountDaily = amountDaily;
//	            	  sLease[i].amountPaid = this.amountPaid;
//	            	  sLease[i].balanceDue = balanceDue;	            	  	            	  	                  	                  
	              } // end if       
	          } // end for
	          // Stores the array in the file      
	        PrintWriter outFile = new PrintWriter("DailyLease.txt");
            for (int i = 0; i<linesCount; i++){
                  outFile.printf("%s %d %s %d %f %f%n", sLease[i].leaseID, 
                          sLease[i].numberOfDays,sLease[i].phoneNo, 
                          sLease[i].slipID, sLease[i].payDaily, 
                          sLease[i].amountDaily);
              }

            // Add new line of customer
            if (!DailyLease)
            outFile.printf("%s %d %s %d %f %f%n", this.leaseID, 
                    this.numberOfDays,  this.phoneNo, this.slipID,
                    this.payDaily, amountDaily);

            // close the inFile and the outFile
          inFile.close();
          outFile.close();
  } // end method save

        public void remove() throws FileNotFoundException{
                Scanner inFile = new Scanner (new FileReader ("DailyLease.txt"));

                // Declare an ArrayList of  objects
               ArrayList<DailyLease> aLease = new ArrayList<DailyLease>();
               int i = 0;
               while (inFile.hasNext()) {
                   aLease.add(i, new DailyLease(inFile.next(), inFile.nextInt(), 
                           inFile.next(), inFile.nextInt(), inFile.nextDouble(), 
                           inFile.nextDouble()));
                   if (aLease.get(i).leaseID.equals(this.leaseID)){
                        aLease.remove(i);
                        i--;
                    } // end if
                   i++;
                } // end while

                       // Stores the array list in the file
               PrintWriter outFile = new PrintWriter("DailyLease.txt");
              for (int j = 0; j<aLease.size(); j++)
                   outFile.printf("%s %d %s %d %f %f%n", aLease.get(j).leaseID, 
                           aLease.get(j).numberOfDays, aLease.get(j).phoneNo, 
                           aLease.get(j).slipID, aLease.get(j).payDaily, 
                           aLease.get(j).amountDaily);

               // close the inFile and the outFile
              inFile.close();
             outFile.close();
    } // end method remove
        
        public static DailyLease getLease(String leaseID) throws FileNotFoundException{
		        Scanner inFile = new Scanner (new FileReader ("DailyLease.txt"));
		        DailyLease result = new DailyLease();
		        // Declare an ArrayList of  objects
		       ArrayList<DailyLease> aLease = new ArrayList<DailyLease>();
		       int i = 0;
		       while (inFile.hasNext()) {
		           aLease.add(i, new DailyLease(inFile.next(), inFile.nextInt(), 
                           inFile.next(), inFile.nextInt(), inFile.nextDouble(), 
                           inFile.nextDouble()));
		           if (aLease.get(i).leaseID.equals(leaseID) || 
                                   aLease.get(i).phoneNo.equals(leaseID)){
		               result.leaseID = aLease.get(i).leaseID;
		               result.numberOfDays = aLease.get(i).numberOfDays;
		               result.phoneNo = aLease.get(i).phoneNo;
		               result.slipID = aLease.get(i).slipID;
		               result.payDaily = aLease.get(i).payDaily;
				result.amountDaily = aLease.get(i).amountDaily;                                                                                   
		           }
		           i++;
		        } // end while
		       // close the inFile and the outFile
		      inFile.close();
		    return result;
    } // end method getLease
        
        public static ArrayList getAllLease() throws FileNotFoundException{
		        Scanner inFile = new Scanner (new FileReader ("DailyLease.txt"));
		        //AnnualLease1 result = new AnnualLease1();
		        // Declare an ArrayList of  objects
		       ArrayList<DailyLease> aLease = new ArrayList<DailyLease>();
		       int i = 0;
		       while (inFile.hasNext()) {
		           aLease.add(i, new DailyLease(inFile.next(), inFile.nextInt(), 
                           inFile.next(), inFile.nextInt(), inFile.nextDouble(), 
                           inFile.nextDouble()));		                                                                		           
		           i++;
		        } // end while
		       // close the inFile and the outFile
		      inFile.close();
		    return aLease;
    } // end method getLease
  }
