import java.io.FileNotFoundException;

public class Main {

	 public static void main(String[] args) throws FileNotFoundException{
		 /*
		// read from file
		        try {
		            FileReader reader = new FileReader("PowerBoat.txt");
		            int character;
		 
		            while ((character = reader.read()) != -1) {
		                System.out.print((char) character);
		            }
		            reader.close();
		 
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		 
		       */     
	
		 	PowerBoat p = new PowerBoat();
//	        p.setStateRegistraitionNo("AlmaMater3");
//	        p.setBoatLeangh(3692);
//	        p.setManufacturer("NewJersey1");
//	        p.setYear(2003);
//	        p.setNumberEngines(3);
//	        p.setFuelType("L65");
//	        p.setPhoneNo("NotAssignt");
	//        System.out.println("Saved");
	        p.getBoat("AlmaMater1");
	     System.out.println("R number: " + p.getStateRegistraitionNo() + " Length: " 
	            + p.getBoatLeangh() + " Phone: " + p.getManufacturer() +" Year " + p.getYear() +" Phone " +  p.getPhoneNo());
	// p.saveBoat();
	        
	 
	      //  p.removeBoatFromSlip();
	        //newCustomer = Customer.getCustomer("514-123-4567");
	        //System.out.println("Name: " + newCustomer.getName() + " Address: " 
	        //     + newCustomer.getAddress() + " Phone: " + newCustomer.getPhoneNo());

	    } // end method main
	} //end class BradshawMarinaTest
