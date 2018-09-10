package io.roman.tutorial.collections;
import java.util.*;

public class StringArrayListTutorial {
	
	private ArrayList<String> myArraylist;
	
	public static void main(String args[]) {
		
		StringArrayListTutorial tutorial = new StringArrayListTutorial();
		
		tutorial.addValues();
		tutorial.addValuesAtPosition();
		tutorial.removeValues();
		tutorial.replaceValue("Regina", "Kurt");
		tutorial.readValue();
		tutorial.iterateList();
		tutorial.updateValue();
		tutorial.listSize();
		tutorial.createSubList(1,4);
		tutorial.indexValues();
		tutorial.copyToArray();
		tutorial.compareTwoLists();
		tutorial.sortArrayList();
		tutorial.swapElements();
		tutorial.combineTwoListsIntoOne();
		tutorial.cloning();
		
	}
	
	private void cloning() {
		System.out.println("** Cloning **");
		// Use the clone method of Arraylist, but you are required to cast it
		ArrayList<String> clone = (ArrayList<String>) myArraylist.clone();
		
		// now let's modify the clone and the original
		myArraylist.set(3, "Marianne");
		myArraylist.remove("Jo");
		clone.add("Maria");
		
		System.out.println(myArraylist);
		System.out.println(clone);
		
	}

	private void combineTwoListsIntoOne() {
		ArrayList<String> newList = new ArrayList<>();
		newList.addAll(myArraylist);
		newList.addAll(myArraylist);
		Collections.sort(newList);
		System.out.println("** two combined arrays into one and then sorted **");
		System.out.println(newList);
		
	}

	private void swapElements() {
		System.out.println("** Swapping two elements **");
		System.out.println(myArraylist);
		Collections.swap(myArraylist, 1, 5);
		System.out.println(myArraylist);		
		Collections.swap(myArraylist, 1, 5);
	}

	private void compareTwoLists() {
		@SuppressWarnings("unchecked")
		ArrayList<String> anotherArrayList = (ArrayList<String>) myArraylist.clone();
		
		boolean eq;
		
		eq = myArraylist.equals(anotherArrayList);
		System.out.println(eq);
		
		anotherArrayList.add("Hanna");
		
		eq = myArraylist.equals(anotherArrayList);
		System.out.println(eq);
		
		anotherArrayList.remove("Hanna");
		
		// Another approach is to use array level comparison
		eq = Arrays.equals(myArraylist.toArray(), anotherArrayList.toArray());
		System.out.println(eq);
		

	}

	private void sortArrayList() {
		// You can use collections static method to sort an ArrayList
		Collections.sort(myArraylist);

		// Or use the class method sort off the ArrayList Object 
		myArraylist.sort(null);
		
		System.out.println(myArraylist);
	}

	private void copyToArray() {
		// getting an Object Array
		Object[] oArr = myArraylist.toArray();
		for(int i=0; i<oArr.length; i++) {
			System.out.println(oArr[i]);
		}
		
		// get a String Array
		String[] sArr = myArraylist.toArray(new String[myArraylist.size()]);
		for(int i=0; i< sArr.length; i++) {
			System.out.println(sArr[i]);
			
		}
		
		
	}

	private void indexValues() {
		myArraylist.add("Joachim");
		System.out.println(myArraylist);
		System.out.println(myArraylist.indexOf("Joachim"));		
		System.out.println(myArraylist.lastIndexOf("Joachim"));
		myArraylist.remove(myArraylist.lastIndexOf("Joachim"));
		
	}

	private void createSubList(int from, int to) {
		// Create new ArrayList object
		ArrayList<String> subList = new ArrayList<>(myArraylist.subList(from,to));
		System.out.println(subList);
		
		// Retrieve the List object as return from ArrayList
		List<String> otherList = myArraylist.subList(from, to);		
		System.out.println(otherList);
		
	}

	private void listSize() {
		System.out.println(myArraylist.size());
		
	}

	private void readValue() {
		String val = myArraylist.get(5);
		System.out.println(val);
		
	}

	public void updateValue() {
		myArraylist.set(2, "Jo");
		for(String str:myArraylist) {
			System.out.println(str);
		}
		
	}

	public void iterateList() {
		for (String str:myArraylist) {
			System.out.println(str);
		}
		
	}

	public void replaceValue(String oVal, String nVal) {
		
		if(myArraylist.indexOf(oVal) >= 0) {
			myArraylist.remove(myArraylist.indexOf(oVal));
			myArraylist.add(nVal);
			System.out.println(this.myArraylist);
		}
		
	}

	public void removeValues() {
		myArraylist.remove(3);
		System.out.println(myArraylist);
		
	}

	public void arrayOperations() {
	
		
	}

	public void addValuesAtPosition() {
		this.myArraylist.add(3, "Stefan");
		System.out.println(this.myArraylist);
		
	}

	public void addValues() {
		// Let's just add some values here
		
		this.myArraylist.add("Roman");
		this.myArraylist.add("Joachim");
		this.myArraylist.add("Pia");
		this.myArraylist.add("Eugen");
		this.myArraylist.add("Rita");
		this.myArraylist.add("Regina");
		
		System.out.println(this.myArraylist);
		
	}

	public StringArrayListTutorial() {
		
		myArraylist = new ArrayList<>();
		
	}
	
}