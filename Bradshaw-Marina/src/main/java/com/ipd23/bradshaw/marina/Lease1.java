package ipd23.vladimir;

public class Lease1 {

            protected String leaseID;
            protected int numberOfDays;
	    protected String phoneNo;
	    protected int slipID;
	    
	    public Lease1() {
	        this.leaseID = "";
	        this.numberOfDays = 0;
	        this.phoneNo = "";
	        this.slipID = 0;
	    }

	    public Lease1(String leaseID, int numberOfDays, String phoneNo, int slipID) {
	        this.leaseID = leaseID;
	        this.phoneNo = phoneNo;
	        this.slipID = slipID;
                this.numberOfDays = numberOfDays;
	       
	    }

		public String getLeaseID() {
			return leaseID;
		}

		public void setLeaseID(String leaseID) {
			this.leaseID = leaseID;
		}

		public int getNumberOfDays() {
			return numberOfDays;
		}

		public void setNumberOfDays(int numberOfDays) {
			this.numberOfDays = numberOfDays;
		}

		public String getPhoneNo() {
			return phoneNo;
		}

		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}

		public int getSlipID() {
			return slipID;
		}

		public void setSlipID(int slipID) {
			this.slipID = slipID;
		}
	    
	    
}
