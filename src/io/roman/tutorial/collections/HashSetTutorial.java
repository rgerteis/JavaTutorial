package io.roman.tutorial.collections;

import java.util.*;

public class HashSetTutorial {

	HashSet<String> mySet = new HashSet<>();
	
	public static void main (String args[]) {
		HashSetTutorial hs = new HashSetTutorial();
		
		hs.modifyElements();
		hs.convertToArrayList();
	}
	
	private void convertToArrayList() {
		
		// ArrayList constructure allows Sets as an argument
		List<String> lst = new ArrayList<String>(mySet);
		
		for (String s:lst) {
			System.out.println(s.toString());
		}
		
	}

	private void modifyElements() {
		mySet.add("Janice");
		mySet.add("Rachel"); // Rachel already exists. So she won't be added again
		System.out.println(mySet);
		mySet.remove("Janice");
		System.out.println(mySet);
		
	}

	public HashSetTutorial() {
		mySet.add("Rachel");
		mySet.add("Joey");
		mySet.add("Phoebe");
		mySet.add("Chandler");
		mySet.add("Monica");
		mySet.add("Rachel");
	}


}
