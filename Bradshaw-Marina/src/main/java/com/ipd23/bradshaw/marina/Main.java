import java.io.FileNotFoundException;

public class Main {

	 public static void main(String[] args) throws FileNotFoundException{
	
		 SailBoat s = new SailBoat();
		 SailBoat s2 = new SailBoat();
		
		 
	
//		 	s.setStateRegistraitionNo("AlmaMater2");
//        	s.setBoatLeangh(3692);
//        	s.setManufacturer("NewJersey1");
//	        s.setYear(2003);
//	        s.setPhoneNo("369258147");
//	        s.setKeelDepth(293);
//	        s.setNumberSails(25);
//	        s.setMotorType("Lima8");
//	        System.out.println("Saved");
//	        
//	        s.saveSailBoat();
//	          s.removeSailBoatFromSlip();
//	         
//	        s = s2.getSailBoat("AlmaMater1");
// 	     System.out.println("R number: " + s.getStateRegistraitionNo() + " Length: " 
//	      	            + s.getBoatLeangh() + " Phone: " + s.getManufacturer() +" Year " + s.getYear() +" Phone " +  s.getPhoneNo()
//	      	            +" KeelDepth " +  s.getKeelDepth() +" NumberSails " +  s.getNumberSails() +" MotorType " +  s.getMotorType());
//	        
	        // print all Sail boats
		 
		 	s.printAllSailBoat();
		 	
		 	PowerBoat p = new PowerBoat();
			PowerBoat p2 = new PowerBoat();
//	 	
//		 	p.setStateRegistraitionNo("AlmaMater5");
//        	p.setBoatLeangh(3692);
//        	p.setManufacturer("NewJersey1");
//	        p.setYear(2003);
//	        p.setPhoneNo("369258147");
//	        p.setNumberEngines(3);
//	        p.setFuelType("L65");
//	        System.out.println("Saved");
	 //   	p.savePowerBoat();
	 //       p.removePowerBoatFromSlip();
	    
	        // get powerBoat
//	        p = p2.getPowerBoat("AlmaMater3");
//		     System.out.println("R number: " + p.getStateRegistraitionNo() + " Length: " 
//		            + p.getBoatLeangh() + " Phone: " + p.getManufacturer() +" Year " + p.getYear() +" Phone " +  p.getPhoneNo()
//		            +" NumberEngines " +  p.getNumberEngines() +" FuelType " +  p.getFuelType());
//	        
			// print all PowerBoat boats
		//	p.printAllPowerBoat();
			
	    
	    } // end method main
	} //end class BradshawMarinaTest
