package io.roman.tutorial.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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
		hs.iterate();

	}

	private void iterate() {
		
		// Use Entry Object
		for (Map.Entry<Integer, String> el : myMap.entrySet()) {			
			System.out.println("Key: " + el.getKey() + " | Value: " + el.getValue());			
		}
		
		// Use Iterator Object
		Iterator<Entry<Integer, String>> i = myMap.entrySet().iterator();		
		while(i.hasNext()) {			
			Map.Entry<Integer, String> el = (Map.Entry<Integer,String>) i.next();
			System.out.println("Key: " + el.getKey() + " | Value: " + el.getValue());						
		}
		
	}

	private void modifyHashNMap() {
		System.out.println( myMap.get(1) );
		// Add another key/value
		myMap.put(7, "Janice"); 
		
		// overwrite existing value
		myMap.put(6,"Rachayl");
		// you should use replace, so it's clear
		myMap.replace(6, "Rachayl");
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
