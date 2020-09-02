package com.ipd23.bradshaw.marina;
public  class Boat {

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
	
	
}
