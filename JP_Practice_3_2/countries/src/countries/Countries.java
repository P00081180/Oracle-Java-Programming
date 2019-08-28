package countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Countries {

	public static void main(String[] args) {
		HashSet<String> countries = new HashSet<String>();
		countries.add("United Kingdom");
		countries.add("United Kingdom");
		countries.add("United States");
		countries.add("China");
		countries.add("Egypt");
		countries.add("Nigeria");	
		System.out.println(countries);
		
		
		HashSet<String> countriesSet = new HashSet<String>();
		//Collections.sort(countriesSet);
		ArrayList<String> countriesList = new ArrayList();
		Collections.sort(countriesList);

	}//end method main
}//end class Countries
