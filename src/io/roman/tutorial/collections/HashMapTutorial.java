package io.roman.tutorial.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapTutorial {

	private HashMap<Integer, String> myMap = new HashMap<>();
	private HashMap<String, String> myStringMap = new HashMap<>();

	public HashMapTutorial() {
		myMap.put(1, "Rachel");
		myMap.put(2, "Joey");
		myMap.put(3, "Phoebe");
		myMap.put(4, "Chandler");
		myMap.put(5, "Monica");
		myMap.put(6, "Rachel");

		// with friendly support from Wikipedia.org
		myStringMap.put("S01E01", "The Pilot");
		myStringMap.put("S01E02", "The One with the Sonogram at the End");
		myStringMap.put("S01E03", "The One with the Thumb");
		myStringMap.put("S01E04", "The One with George Stephanopoulos");
		myStringMap.put("S01E05", "The One with the East German Laundry Detergent");
		myStringMap.put("S01E06", "The One with the Butt");
	}

	public static void main(String[] args) {

		HashMapTutorial hs = new HashMapTutorial();

		hs.printHashMap();
		hs.modifyHashNMap();
		hs.iterate();

		hs.workWithStringHashes();

	}

	private void workWithStringHashes() {
		// lookup a value
		boolean b = false;

		b = myStringMap.containsKey("S01E01");
		System.out.println("Is S01E01 in the list?: " + b);

		b = myStringMap.containsValue("The One with the Butt");
		System.out.println("Is S01E01 in the list?: " + b);

		// find a value, unfortunately you'll have to seek manually
		for (Map.Entry<String, String> el : myStringMap.entrySet()) {
			if (el.getValue() == "The One with the Butt") {
				System.out.println("Found Episode: '" + el.getValue() + "' with Key: " + el.getKey());
			}

		}
	}

	private void iterate() {

		// Use Entry Object
		for (Map.Entry<Integer, String> el : myMap.entrySet()) {
			System.out.println("Key: " + el.getKey() + " | Value: " + el.getValue());
		}

		// Use Iterator Object
		Iterator<Entry<Integer, String>> i = myMap.entrySet().iterator();
		while (i.hasNext()) {
			Map.Entry<Integer, String> el = (Map.Entry<Integer, String>) i.next();
			System.out.println("Key: " + el.getKey() + " | Value: " + el.getValue());
		}

	}

	private void modifyHashNMap() {
		System.out.println(myMap.get(1));
		// Add another key/value
		myMap.put(7, "Janice");

		// overwrite existing value
		myMap.put(6, "Rachayl");
		// you should use replace, so it's clear
		myMap.replace(6, "Rachayl");
		System.out.println(myMap);

		myMap.remove(6);
		myMap.remove(7);

		// Let's put Rachel back
		myMap.put(6, "Rachel");
		System.out.println(myMap);

	}

	private void printHashMap() {
		System.out.println(myMap);
	}

}
