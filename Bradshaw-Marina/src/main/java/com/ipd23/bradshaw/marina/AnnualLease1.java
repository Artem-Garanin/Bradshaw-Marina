package com.ipd23.bradshaw.marina;

import java.util.*;
import java.io.*;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;


  class AnnualLease1 extends Lease1{

	static final int NUMBER_OF_MONTHS = 12;
        static final int NUMBER_OF_DAYS = 365;

	//private int leaseID;
	//private String dateBeforeString;
	private double payMonthly;
	private double amountAnnual;
	private double amountPaid;
	private double balanceDue;


	public AnnualLease1() {
		//this.leaseID = 0;
		//this.dateBeforeString = "2017-05-24";
		super();
		this.payMonthly = 0;
		this.amountAnnual = 0;
		this.amountPaid = 0;
		this.balanceDue = 0;
	}

	public AnnualLease1(String leaseID, int numberOfDays, String phoneNo, int slipID, 
                double payMonthly, double amountAnnual, double amountPaid, 
                double balanceDue) {
		//this.leaseID = leaseID;
		//this.dateBeforeString = dateBeforeString;
		super(leaseID, numberOfDays, phoneNo, slipID);
		this.payMonthly = payMonthly;
		this.amountAnnual = amountAnnual;
		this.amountPaid = amountPaid;
		this.balanceDue = balanceDue;
	}

	
	public double getPayMonthly() {
		return payMonthly;
	}

	public void setPayMonthly(double payMonthly) {
		this.payMonthly = payMonthly;
	}

	public double getAmountAnnual() {
		return amountAnnual;
	}

	public void setAmountAnnual(double amountAnnual) {
		this.amountAnnual = amountAnnual;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public double getBalanceDue() {
		return balanceDue;
	}

	public void setBalanceDue(double balanceDue) {
		this.balanceDue = balanceDue;
	}

	
		public void saveAnnualLease1() throws FileNotFoundException{
			
			Scanner inFile = new Scanner (new FileReader ("data/AnnualLease.dat"));
	        Scanner linesScanner = new Scanner (new FileReader ("data/AnnualLease.dat"));
	        boolean annualLease1 = false;
	        // Get the number of lines in the file
	        int linesCount = 0;
	        while (linesScanner.hasNextLine()) {
	        	 
	        	linesScanner.nextLine();
	        	
	            linesCount++;       
		}
	        
	     // Declare an array of  objects
	        AnnualLease1[] sLease = new AnnualLease1 [linesCount]; 
	        
	        // Initialize the array of objects and read the file into the array
	        for (int i = 0; i<linesCount; i++){
	        	sLease[i] = new AnnualLease1();
	        	sLease[i].leaseID = inFile.next();
	        	sLease[i].numberOfDays = inFile.nextInt();
	        	sLease[i].phoneNo = inFile.next();
	        	sLease[i].slipID = inFile.nextInt();
                        sLease[i].payMonthly = inFile.nextDouble();
	        	sLease[i].amountAnnual = inFile.nextDouble();
	        	sLease[i].amountPaid = inFile.nextDouble();
	        	sLease[i].balanceDue = inFile.nextDouble();
                        
                        // calculate balance due
			balanceDue = this.amountAnnual - amountPaid;
	        	
                        // calculate monthly lease
	        	payMonthly = this.balanceDue / NUMBER_OF_MONTHS;
	              
	              // if the customer exist, modify the customer
	              if (this.leaseID.equals(sLease[i].leaseID)){
	            	  annualLease1 = true;
	            	  sLease[i].leaseID = this.leaseID;
	            	  sLease[i].numberOfDays = this.numberOfDays;
	            	  sLease[i].phoneNo = this.phoneNo;
	            	  sLease[i].slipID = this.slipID;
                    	  sLease[i].payMonthly = payMonthly;
	            	  sLease[i].amountAnnual = this.amountAnnual;
	            	  sLease[i].amountPaid = this.amountPaid;
	            	  sLease[i].balanceDue = balanceDue;
	            	  
	            	  
	                  
	                  
	              } // end if       
	          } // end for
	          // Stores the array in the file      
	        PrintWriter outFile = new PrintWriter("data/AnnualLease.dat");
            for (int i = 0; i<linesCount; i++){
                  outFile.printf("%s %d %s %d %f %f %f %f%n", sLease[i].leaseID, 
                          sLease[i].numberOfDays, sLease[i].phoneNo, sLease[i].slipID,
                		  sLease[i].payMonthly, sLease[i].amountAnnual, 
                                  sLease[i].amountPaid, sLease[i].balanceDue);
              }



            // Add new line of customer
            if (!annualLease1)
            outFile.printf("%s %d %s %d %f %f %f %f%n", this.leaseID, NUMBER_OF_DAYS,  
                    this.phoneNo, this.slipID, payMonthly, this.amountAnnual, 
                    this.amountPaid, balanceDue);



            // close the inFile and the outFile
          inFile.close();
          outFile.close();
  } // end method save

        public void remove() throws FileNotFoundException{
                Scanner inFile = new Scanner (new FileReader ("data/AnnualLease.dat"));

                // Declare an ArrayList of  objects
               ArrayList<AnnualLease1> aLease = new ArrayList<AnnualLease1>();
               int i = 0;
               while (inFile.hasNext()) {
                   aLease.add(i, new AnnualLease1(inFile.next(), inFile.nextInt(), 
                           inFile.next(), inFile.nextInt(), inFile.nextDouble(), 
                           inFile.nextDouble(), inFile.nextDouble(), inFile.nextDouble()));
                   if (aLease.get(i).leaseID.equals(this.leaseID)){
                        aLease.remove(i);
                        i--;
                    } // end if
                   i++;
                } // end while

                       // Stores the array list in the file
               PrintWriter outFile = new PrintWriter("data/AnnualLease.dat");
              for (int j = 0; j<aLease.size(); j++)
                   outFile.printf("%s %d %s %d %.2f %.2f %.2f %.2f%n", 
                           aLease.get(j).leaseID, 
                           aLease.get(j).numberOfDays, aLease.get(j).phoneNo, 
                           aLease.get(j).slipID, aLease.get(j).payMonthly, 
                           aLease.get(j).amountAnnual, 
                           aLease.get(j).amountPaid, aLease.get(j).balanceDue);

               // close the inFile and the outFile
              inFile.close();
             outFile.close();
    } // end method remove
        
        public static AnnualLease1 getLease(String leaseID) throws FileNotFoundException{
		        Scanner inFile = new Scanner (new FileReader ("data/AnnualLease.dat"));
		        AnnualLease1 result = new AnnualLease1();
		        // Declare an ArrayList of  objects
		       ArrayList<AnnualLease1> aLease = new ArrayList<AnnualLease1>();
		       int i = 0;
		       while (inFile.hasNext()) {
		           aLease.add(i, new AnnualLease1(inFile.next(), inFile.nextInt(), 
                           inFile.next(), inFile.nextInt(), inFile.nextDouble(), 
                           inFile.nextDouble(), inFile.nextDouble(), inFile.nextDouble()));
		           if (aLease.get(i).leaseID.equals(leaseID) || 
                                   aLease.get(i).phoneNo.equals(leaseID)){
		               result.leaseID = aLease.get(i).leaseID;
		               result.numberOfDays = aLease.get(i).numberOfDays;
		               result.phoneNo = aLease.get(i).phoneNo;
		               result.slipID = aLease.get(i).slipID;
		               result.payMonthly = aLease.get(i).payMonthly;
				result.amountAnnual = aLease.get(i).amountAnnual;
                                result.amountPaid = aLease.get(i).amountPaid;
		               result.balanceDue = aLease.get(i).balanceDue;
                                                       
		           }
		           i++;
		        } // end while
		       // close the inFile and the outFile
		      inFile.close();
		    return result;
    } // end method getLease
        
        public static ArrayList getAllLease() throws FileNotFoundException{
		        Scanner inFile = new Scanner (new FileReader ("data/AnnualLease.dat"));
		        //AnnualLease1 result = new AnnualLease1();
		        // Declare an ArrayList of  objects
		       ArrayList<AnnualLease1> aLease = new ArrayList<AnnualLease1>();
		       int i = 0;
		       while (inFile.hasNext()) {
		           aLease.add(i, new AnnualLease1(inFile.next(), inFile.nextInt(), 
                           inFile.next(), inFile.nextInt(), inFile.nextDouble(), 
                           inFile.nextDouble(), inFile.nextDouble(), inFile.nextDouble()));		                                                                		           
		           i++;
		        } // end while
		       // close the inFile and the outFile
		      inFile.close();
		    return aLease;
    } // end method getLease
        
  }
