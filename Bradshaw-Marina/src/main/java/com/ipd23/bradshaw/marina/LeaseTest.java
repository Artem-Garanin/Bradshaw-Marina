// LeaseTest.java

package com.ipd23.bradshaw.marina;
import java.io.FileNotFoundException;

/**
 *
 * @author ihor
 */
public class LeaseTest {
    
    public static void main(String[] args) throws FileNotFoundException {
        Lease newLease = new Lease();
    	newLease.setLeaseID("1");
        newLease.setAmount("100.00");
	newLease.setStartDate("2020-08-28");
        newLease.setEndDate("2020-09-03");
        newLease.save();
        //newCustomer = Customer.getLease("1");
        //newCustomer.remove();        
        //System.out.println("LeaseNo: " + newLease.getgetLeaseID() + " Amount: " 
        /*     + newLease.getAmount() + " Lease Start: " + newLease.getStartDate() 
                                    + " Lease End: " + newLease.getEndtDate());*/

    } // end method main
} //end class LeaseTest
    

