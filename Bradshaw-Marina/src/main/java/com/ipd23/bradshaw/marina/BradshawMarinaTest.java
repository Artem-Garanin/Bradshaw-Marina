/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipd23.bradshaw.marina;
import java.io.FileNotFoundException;

/**
 *
 * @author artem
 */
public class BradshawMarinaTest {
    public static void main(String[] args) throws FileNotFoundException {
        Customer newCustomer = new Customer();
        newCustomer.setName("Artem");
        newCustomer.setAddress("Montreal");
        newCustomer.setPhoneNo("514-795-3288");
        newCustomer.save();
        //newCustomer.remove();
        //newCustomer = Customer.getCustomer("514-123-4567");
        //System.out.println("Name: " + newCustomer.getName() + " Address: " 
        //     + newCustomer.getAddress() + " Phone: " + newCustomer.getPhoneNo());

    } // end method main
} //end class BradshawMarinaTest
