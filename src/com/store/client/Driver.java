package com.store.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.store.model.Laptop;

public class Driver {
	
	//method to set the discount of all the laptops inside the array
	public void setDiscount(Double discountRate,Laptop[] lapArr) {
		Arrays.stream(lapArr).filter(Objects::nonNull).forEach(laptop->laptop.setDiscountRate(discountRate));
	}

	//method to search laptops based on brand, model and manufacture year
	public List<Laptop> search(String criteria,Laptop[] lapArr){
		List<Laptop> filteredResults=new ArrayList<Laptop>();
		for (Laptop laptop : lapArr) {
			if(laptop!=null) {
				if((laptop.getBrand().equalsIgnoreCase(criteria))||(laptop.getModel().equalsIgnoreCase(criteria))||(laptop.getManufactureYear().equals(criteria))){
					laptop.setDiscountedPrice(laptop.calculateDiscount());
					filteredResults.add(laptop);
				}
			}
		}
		return filteredResults;
	}
	
	
	//overloaded method to search for laptops based on price range
	public List<Laptop> search(double initialPrice,double finalPrice,Laptop[] lapArr){
		List<Laptop> priceFilter =Arrays.stream(lapArr)
				.filter(Objects::nonNull)
				.filter(laptop->laptop.getPrice()>=initialPrice&& laptop.getPrice()<=finalPrice)
				.collect(Collectors.toList()); 
	return priceFilter;
	}
	
	//main method
	public static void main(String[] args) {
		Driver driver = new Driver();
		Laptop[] laptopArr = new Laptop[30];
		
		Laptop hp= new Laptop("HP", "DR0006TX", "2019", 58000);
		Laptop hp1= new Laptop("HP", "15g-GXTT556", "2016", 35000);
		Laptop hp2= new Laptop("HP", "TR-YOGA56", "2019", 98000);
		Laptop dell= new Laptop("DELL", "XPS-78TR", "2017", 42000);
		Laptop dell1= new Laptop("DELL", "Inspiron-UU76", "2020", 87000);
		Laptop lenovo= new Laptop("Lenovo", "ThinkPad-05T", "2020", 84000);
		Laptop lenovo1= new Laptop("Lenovo", "IdeaPad-998", "2018", 78000);
		Laptop lenovo2= new Laptop("Lenovo", "idepad-887", "2015", 25000);
		Laptop apple= new Laptop("Apple", "Macbook-Pro", "2020", 65000);	
		Laptop apple1= new Laptop("Apple", "Macbook-Air", "2016", 160000);
		Laptop asus= new Laptop("Asus", "Asus-OOUY8", "2018", 92000);
		
	
		
		//keeping a track of the number of objects created
		System.out.println(Laptop.getNumberOfObjects());
		
		laptopArr[0]=hp;
		laptopArr[1]=hp1;
		laptopArr[2]=hp2;
		laptopArr[3]=dell;
		laptopArr[4]=dell1;
		laptopArr[5]=lenovo;
		laptopArr[6]=lenovo1;
		laptopArr[7]=lenovo2;
		laptopArr[8]=apple;
		laptopArr[9]=apple1;
		laptopArr[10]=asus;
	
		//setting same discount rate for all laptops
		driver.setDiscount(12.0,laptopArr );
		
		
		//driver method to search laptops based on brand
		List<Laptop> laptopFilteredByBrand=driver.search("HP",laptopArr);
		System.out.println(laptopFilteredByBrand);
		
		//driver method to search laptops based on year
		List<Laptop> laptopFilteredByYear=driver.search("2019",laptopArr);
		System.out.println(laptopFilteredByYear);
		
		//driver method to search laptops based on price range
		List<Laptop> laptopFilteredByPriceRange=driver.search(40000,60000,laptopArr);
		System.out.println(laptopFilteredByPriceRange);
	}

}
