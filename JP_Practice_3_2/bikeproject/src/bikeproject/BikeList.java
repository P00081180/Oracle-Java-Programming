package bikeproject;

import java.util.ArrayList;
import java.util.Random;

public class BikeList {

	public static void main(String[] args) {
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		int mountainBikeSales = 0;
		int roadBikeSales = 0;
		
		fillArray(bikes);
		displayStock(bikes);
		displayBikeNumbers(bikes);
	}//end method main

	static void displayBikeNumbers(ArrayList<Bike> bikes){
		int mb = calculateStock(bikes);
		int rb = (bikes.size() - mb);
		System.out.println("\nStock Levels");
		System.out.println("We have " + mb + " Mountain Bikes in stock");
		System.out.println("We have " + rb + " Road Bikes in stock");
	}//end method displayBikeNumbers
	
	static int calculateStock(ArrayList<Bike> bikes){
		int bikesSold = 0;
		for(Bike bike: bikes)
		   if (bike instanceof MountainBike)
			   bikesSold++;
		   //endif
		//endfor
		return bikesSold;
	}//end method calculateStock
	
	static void displayStock(ArrayList<Bike> bikes){
		for(Bike bike: bikes)
		   System.out.println(bike);
	    //endfor
	}//end method displayStock
	
	static void fillArray(ArrayList<Bike> bikes) {
		Random randomGenerator = new Random();
		
		for(int i = 0; i < 10; i++){
			if(randomGenerator.nextInt(2)<1)
				bikes.add(new MountainBike());
			else
				bikes.add(new RoadBike());
			//endif
		}//endfor
	}//end method fillArray
	
}//end class BikeList
