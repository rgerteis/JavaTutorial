package io.roman.tutorial.arrays;

public class IntegerComparison {
	
	Integer[] arr1 = {124,125,130,135};
	Integer[] arr2 = {124,125,130,135};
	
	public static void main(String args[]) {
		
		IntegerComparison ic = new IntegerComparison();
		ic.compare();
		
		
	}

	private void compare() {
		
		// this comparison does not work.
		for (int i=0; i<arr1.length;i++) {
			System.out.println( arr1[i]== arr2[i] );
		}	
		
		// this works suing compareTo method
		for (int i=0; i<arr1.length;i++) {
			System.out.println(arr1[i].compareTo(arr2[i].intValue()));
		}		
		
		// this works too, as true INT values are compared
		for (int i=0; i<arr1.length;i++) {
			System.out.println(arr1[i].intValue() == arr2[i].intValue());
		}			
	}
}
