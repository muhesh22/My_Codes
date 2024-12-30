package HashProblems;

import java.util.*;

// Main class 
public class Hash { 

	// Main driver method 
	public static void main(String[] args) 
	{ 

		// Creating an empty HashMap 
		HashMap<Integer, String> hash_map 
			= new HashMap<Integer, String>(); 

		// Mapping string values to int keys 
		// Using put() method 

		// Custom input values passed as arguments 
		hash_map.put(10, "Geeks"); 
		hash_map.put(15, "4"); 
		hash_map.put(20, "Geeks"); 
		hash_map.put(25, "Welcomes"); 
		hash_map.put(30, "You"); 

		// Print and display the HashMap 
		System.out.println("Initial Mappings are: "
						+ hash_map); 

		// Print and display the cloned HashMap 
		// using clone() method 
		System.out.println("The cloned map look like this: "
						+ hash_map.clone()); 
	} 
}
