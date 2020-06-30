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
package com.store.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.store.model.Laptop;

public class Driver {

	// method to set the discount of all the laptops inside the array
	public void setDiscount(Double discountRate, Laptop[] lapArr) {
		Arrays.stream(lapArr).filter(Objects::nonNull).forEach(laptop -> laptop.setDiscountRate(discountRate));
	}

	// method to search laptops based on brand, model and manufacture year
	public List<Laptop> search(String criteria, Laptop[] lapArr) {
		try {
			List<Laptop> filteredResults = new ArrayList<Laptop>();
			for (Laptop laptop : lapArr) {
				if (laptop != null) {
					if ((laptop.getBrand().equalsIgnoreCase(criteria)) || (laptop.getModel().equalsIgnoreCase(criteria))
							|| (laptop.getManufactureYear().equals(criteria))) {
						laptop.setDiscountedPrice(laptop.calculateDiscount());
						filteredResults.add(laptop);
					}
				}
			}
			return filteredResults;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// overloaded method to search for laptops based on price range
	public List<Laptop> search(double initialPrice, double finalPrice, Laptop[] lapArr) {
		try {
			List<Laptop> filteredResults = new ArrayList<Laptop>();
			for (Laptop laptop : lapArr) {
				if (laptop != null) {
					if (laptop.getPrice() >= initialPrice && laptop.getPrice() <= finalPrice) {
						laptop.setDiscountedPrice(laptop.calculateDiscount());
						filteredResults.add(laptop);
					}
				}
			}
			return filteredResults;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// main method
	public static void main(String[] args) {

		// creating object of driver class
		Driver driver = new Driver();

		// defining an array which can hold 30 laptop objects
		Laptop[] laptopArr = new Laptop[30];

		// creating laptop objects with the help of constructor
		Laptop hp = new Laptop("HP", "DR0006TX", "2019", 58000);
		Laptop hp1 = new Laptop("HP", "15g-GXT56", "2016", 35000);
		Laptop hp2 = new Laptop("HP", "TR-YOGA56", "2019", 98000);
		Laptop dell = new Laptop("DELL", "XPS-78TR", "2017", 42000);
		Laptop dell1 = new Laptop("DELL", "Inspiron-UU76", "2020", 87000);
		Laptop asus = new Laptop("Asus", "Asus-OOUY8", "2018", 92000);
		Laptop apple = new Laptop("Apple", "Macbook-Pro", "2020", 65000);
		Laptop apple1 = new Laptop("Apple", "Macbook-Air", "2016", 160000);
		Laptop lenovo = new Laptop("Lenovo", "ThinkPad-05T", "2020", 84000);
		Laptop lenovo1 = new Laptop("Lenovo", "IdeaPad-998", "2018", 78000);
		Laptop lenovo2 = new Laptop("Lenovo", "idepad-887", "2015", 25000);
		
		

		// keeping a track of the number of objects created
		System.out.println("Total number of objetcs created : "+Laptop.getNumberOfObjects());

		// initializing the array with 10 laptop objects
		laptopArr[0] = hp;
		laptopArr[1] = hp1;
		laptopArr[2] = hp2;
		laptopArr[3] = dell;
		laptopArr[4] = dell1;
		laptopArr[5] = lenovo;
		laptopArr[6] = lenovo1;
		laptopArr[7] = lenovo2;
		laptopArr[8] = apple;
		laptopArr[9] = apple1;
		laptopArr[10] = asus;

		// setting same discount rate for all laptops
		driver.setDiscount(8.0, laptopArr);

		/*-----------------sample driver methods for the application--------------------*/

		// driver method to search laptops based on brand
		List<Laptop> laptopFilteredByBrand = driver.search("HP", laptopArr);
		System.out.println("Total number of laptops matching your criteria : " + laptopFilteredByBrand.size() + " "
				+ laptopFilteredByBrand);

		// driver method to search laptops based on model
		List<Laptop> laptopFilteredByModel = driver.search("macbook-Air", laptopArr);
		System.out.println("Total number of laptops matching your criteria : " + laptopFilteredByModel.size() + " "
				+ laptopFilteredByModel);

		// driver method to search laptops based on year
		List<Laptop> laptopFilteredByYear = driver.search("2019", laptopArr);
		System.out.println("Total number of laptops matching your criteria : " + laptopFilteredByYear.size() + " "
				+ laptopFilteredByYear);

		// driver method to search laptops based on price range
		List<Laptop> laptopFilteredByPriceRange = driver.search(30000, 40000, laptopArr);
		System.out.println("Total number of laptops matching your criteria : " + laptopFilteredByPriceRange.size() + " "
				+ laptopFilteredByPriceRange);
	}

}
