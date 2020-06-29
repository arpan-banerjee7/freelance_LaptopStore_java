/*
This Project focuses on method, array and object class.
Design and develop a Java program that can store, edit, search and display the information of Laptops.

The data of Laptop to store include the brand, the model, the manufacturer year, and the price.
The search function allows the user to search by brand, model, price range and manufacturer year. 
The search result shows the number of matching laptops and the list of the laptops with the information.
The system also allows to user to set the same discount rate for all the laptops and displays the discounted price for the laptops in the search result.

Requirements of class design You need to create a 
class for the Laptop object with appropriate attributes (including discount rate), constructors, getters and setter, toString method, 
and a method that can return the discount price of a laptop. The class can keep track of the number of objects and it has a method that returns the data. 
Apply appropriate access modifiers to the members of the class. In your client/driver program, you need to create an array of Laptop 
that can store at least 30 laptops. Initial the array with 10 laptop objects.
*/
package com.store.model;

public class Laptop {
	private String brand;
	private String model;
	private String manufactureYear;
	private double price;
	private double discountRate;
	private double discountedPrice;

	
	static int noOfObjects = 0;

	// Instead of performing increment in the constructor for counting the number of
	// objects created
	// instance block is preferred to make this program generic.
	{
		noOfObjects += 1;
	}

	public Laptop() {
	}

	
	public Laptop(String brand, String model, String manufactureYear, double price) {
		this.brand = brand;
		this.model = model;
		this.manufactureYear = manufactureYear;
		this.price = price;
		
	}


	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}


	public String getManufactureYear() {
		return manufactureYear;
	}


	public void setManufactureYear(String manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	@Override
	public String toString() {
		return "Laptop [brand=" + brand + ", model=" + model + ", manufactureYear=" + manufactureYear + ", price="
				+ price + " discountedPrice=" + discountedPrice + "]";
	}

	// method to calculate and return discounted price
	public double calculateDiscount() {
		double discountedPrice = (this.price - (this.price * this.discountRate) / 100);
		this.setDiscountedPrice(discountedPrice);
		return discountedPrice;
	}

	// method to return number of objects created
	public static int getNumberOfObjects() {
		return Laptop.noOfObjects;
	}

}
