package io.roman.tutorial.collections;

import java.util.*;

public class TreeSetTutorial {

	TreeSet<String> myTree = new TreeSet<>();

	public static void main(String args[]) {
		TreeSetTutorial tutorial = new TreeSetTutorial();

		tutorial.iterate();
		tutorial.polls();
		tutorial.floorAndCeiling();
		tutorial.subSets();

	}

	private void subSets() {
		
		SortedSet<String> s = myTree.headSet("Phoebe",true);
		for(String str:s) {
			System.out.println(str);
		}
		
		
	}

	private void floorAndCeiling() {
		String s = "";
		s = myTree.first();
		System.out.println("First item in TreeMap = " + s);
		s = myTree.last();
		System.out.println("Last item in TreeMap = " + s);
		s= myTree.higher("Phoebe");
		System.out.println("Higher of Phoebe = " + s);
		s = myTree.lower("Phoebe");
		System.out.println("Lower of Phoebe = " + s);

	}

	private void polls() {

		String s = "";
		s = myTree.pollFirst();
		System.out.println("Polled: " + s);
		s = myTree.pollLast();
		System.out.println("Polled: " + s);

		System.out.println("Remaining: " + myTree);

	}

	private void iterate() {

		// Iterating through a TreeSet
		Iterator<String> i = myTree.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

		// Iterating through a TreeSet
		Iterator<String> j = myTree.descendingIterator();
		while (j.hasNext()) {
			System.out.println(j.next());
		}
		
		// Another approach with for
		for (String str : myTree) {
			System.out.println(str);
		}
		
		// Another approach is forEach since Java 1.8
		myTree.forEach( (value) -> System.out.println( value) );

	}

	public TreeSetTutorial() {
		myTree.add(Friends.CHANDLER.getName());
		myTree.add(Friends.RACHEL.getName());
		myTree.add(Friends.JOEY.getName());
		myTree.add(Friends.MONICA.getName());
		myTree.add(Friends.PHOEBE.getName());
		myTree.add(Friends.ROSS.getName());

	}

}
