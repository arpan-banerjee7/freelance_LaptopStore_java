package com.store.client;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.store.model.Laptop;

public class Driver {
	
	public void setDiscount(Double discountRate,Laptop[] lapArr) {
		Arrays.stream(lapArr).forEach(laptop->laptop.setDiscountRate(discountRate));
		
	}

	public List<Laptop> search(String brand,Laptop[] lapArr){
		
		List<Laptop> filteredLaptopBrands=Arrays.stream(lapArr)
				.peek(x->System.out.println("operation on"+x))
				.filter(laptop->laptop.getBrand().equals(brand)).collect(Collectors.toList()); 
		return filteredLaptopBrands;
		
	}
	public static void main(String[] args) {
		Driver driver = new Driver();
		Laptop[] laptopArr = new Laptop[30];
		Laptop hp= new Laptop("HP", "DR0006TX", 2019, 58000);
		Laptop hp1= new Laptop("HP", "15g-GXTT556", 2016, 35000);
		Laptop hp2= new Laptop("HP", "TR-YOGA56", 2019, 98000);
		Laptop dell= new Laptop("DELL", "XPS-78TR", 2017, 42000);
		Laptop dell1= new Laptop("DELL", "Inspiron-UU76", 2020, 87000);
		Laptop lenovo= new Laptop("Lenovo", "ThinkPad-05T", 2020, 84000);
		
		//keeping a track of the number of objects created
		System.out.println(Laptop.getNumberOfObjects());
		
		laptopArr[0]=hp;
		laptopArr[1]=hp1;
		laptopArr[2]=hp2;
		laptopArr[3]=dell;
		laptopArr[4]=dell1;
		laptopArr[5]=lenovo;
	    
		//setting same discount rate for all laptops
		driver.setDiscount(12.0, Arrays.copyOfRange(laptopArr, 0, 6));
		
	     for(int i=0; i<6; i++) {
			System.out.println(laptopArr[i].toString());
		}
		
//		hp.setDiscountRate(12);
//		dell.setDiscountRate(12);
//		lenovo.setDiscountRate(12);
//		
//		System.out.println(hp.calculateDiscount());
//		System.out.println(dell.calculateDiscount());
//		System.out.println(lenovo.calculateDiscount());
//		
//		Laptop[] laptopArrCopy=Arrays.copyOfRange(laptopArr, 0, 6);
//		 Stream<Laptop> stm = Arrays.stream(laptopArrCopy); 
//		  
//	        // Displaying elements in Stream 
//	        stm.forEach(str -> System.out.print(str + " "));
		
		
		List<Laptop> laptopFilteredByBrand=driver.search("HP",Arrays.copyOfRange(laptopArr, 0, 6));
		//System.out.println(laptopFilteredByBrand);
	}

}
