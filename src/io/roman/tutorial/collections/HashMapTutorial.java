package io.roman.tutorial.collections;

import java.util.HashMap;

public class HashMapTutorial {
	
	private HashMap<Integer, String> myMap = new HashMap<>();

	public HashMapTutorial() {
		myMap.put(1, "Rachel");
		myMap.put(2, "Joey");
		myMap.put(3, "Phoebe");
		myMap.put(4, "Chandler");
		myMap.put(5, "Monica");
		myMap.put(6, "Rachel");
	}

	public static void main(String[] args) {
		
		HashMapTutorial hs = new HashMapTutorial();
		
		hs.printHashMap();
		hs.modifyHashNMap();

	}

	private void modifyHashNMap() {
		System.out.println( myMap.get(1) );
		// Add another key/value
		myMap.put(7, "Janice"); 
		
		// overwrite existing value
		myMap.put(6,"Rachayl");
		System.out.println(myMap);
		
		myMap.remove(6);
		myMap.remove(7);
		myMap.put(6, "Rachel");
		System.out.println(myMap);
		
	}

	public void printHashMap() {
		System.out.println(myMap);
	}

}
