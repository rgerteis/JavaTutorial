package io.roman.tutorial.collections;

import java.util.*;

public class VectorTutorial {
	
	private Vector<String> myVector = new Vector<>();

	public static void main (String args[]) {
		VectorTutorial tutorial = new VectorTutorial();
		tutorial.addItem();
		tutorial.iterate();
	}
	
	private void iterate() {
		
		System.out.println("** Iterate using iterator **");
		Iterator<String> i = myVector.iterator();
		String s="";
		while (i.hasNext()) {
			s = i.next();
			System.out.println(s);
		}
		
		System.out.println("** Iterate with new FOR iterate method **");		
		for(String str:myVector) {
			s = str;
			System.out.println(s);
		}

		System.out.println("** Traditional iteration with FOR loop **");
		for(int it=0; it < myVector.size(); it++) {
			s = myVector.get(it);
			System.out.println(s);
		}
	}

	private void addItem() {
		myVector.add("Eliot");
		System.out.println(myVector);
	}

	public VectorTutorial () {
		myVector.add("Roman");
		myVector.add("Pia");
		myVector.add("Joachim");		
	}
}
