package io.roman.riddle;

import java.util.*;
import java.io.*;

/**
 * Given two sorted Arrays with integers return an array that contains the
 * intersection. The first Array is large, the second is smaller
 */
public class Intersect {

	static String fileOne = "/tmp/file_one.txt";
	static String fileTwo = "/tmp/file_two.txt";
	static int arrayOneValues = 50;
	static int arrayTwoValues = 121;

	public static void main(String args[]) {

		Intersect is = new Intersect();

		Integer[] arr1 = {};
		Integer[] arr2 = {};

		try {
			generateFile(arrayOneValues, fileOne);
			generateFile(arrayTwoValues, fileTwo);
		} catch (IOException e) {
			System.out.println("Couldn't generate files");
		}

		try {
			arr1 = getValuesFromFile(fileOne);
			arr2 = getValuesFromFile(fileTwo);
		} catch (IOException e) {
			System.out.println("Couldn't read file");
		}

		long startTime;
		long endTime;

		System.out.println("Intersecting two Integer Arrays below");
		System.out.println(new ArrayList<Integer>(Arrays.asList(arr1)));
		System.out.println(new ArrayList<Integer>(Arrays.asList(arr2)));

		System.out.println("Solution runtimes");
		// Run the first solution of TrivialIntersect
		startTime = System.nanoTime();
		List<Integer> solution1 = is.trivialIntersect(arr1, arr2);
		endTime = System.nanoTime();
		System.out.println("Runtime: " + (endTime - startTime) + " nano secs\t" + " | " + solution1);

		// Run the second solution with Collections
		startTime = System.nanoTime();
		List<Integer> solution2 = is.intersectWithCollections(arr1, arr2);
		endTime = System.nanoTime();
		System.out.println("Runtime: " + (endTime - startTime) + " nano sec\t" + " | " + solution2);

		// Run the second solution with optimized sliding
		startTime = System.nanoTime();
		List<Integer> solution3 = is.movingPositionsIntersect(arr1, arr2);
		endTime = System.nanoTime();
		System.out.println("Runtime: " + (endTime - startTime) + " nano secs\t" + " | " + solution3);

		// Run the second solution with optimized sliding
		startTime = System.nanoTime();
		List<Integer> solution4 = is.slicedIntersect(arr1, arr2);
		endTime = System.nanoTime();
		System.out.println("Runtime: " + (endTime - startTime) + " nano secs\t" + " | " + solution4);

	}

	/**
	 * Using slices of the secondList
	 * @param firstList
	 * @param secondList
	 * @return intersected values
	 */
	private ArrayList<Integer> slicedIntersect(Integer[] firstList, Integer[] secondList) {

		ArrayList<Integer> result = new ArrayList<>();

		// slice the secondList
		int slideSize = 5;
		int lastPos = 0;

		for (int i = 0; i < firstList.length; i++) {

			// Go through secondList in slices
			for (int k = lastPos; k < secondList.length; k += slideSize) {
							
				Integer[] slice = new Integer[slideSize];
				
				// create a slice of the original array 
				System.arraycopy(secondList, k, slice, 0, slideSize);
				
				if (firstList[i].intValue() < slice[0].intValue()) {
					// This slice where lowest number is already higher than the 
					// value we look for can be skipped. We won't find no match.
					break;
				} else if (firstList[i].intValue() >= slice[0].intValue() && 
					firstList[i].intValue() <= slice[slideSize - 1].intValue()) {
					// This slice contains a potential match. Lets find investigate
					for (int j = 0; j < slice.length; j++) {
						if (firstList[i].intValue() == slice[j].intValue()) {
							result.add(firstList[i].intValue());
							lastPos=k;
							break;
						}
					}
				}
				lastPos = k;
			}
		}

		return result;
	}

	/**
	 * Use moving pointer through second set to avoid re-reads
	 * @param firstList
	 * @param secondList
	 * @return
	 */
	private ArrayList<Integer> movingPositionsIntersect(Integer[] firstList, Integer[] secondList) {

		ArrayList<Integer> result = new ArrayList<>();

		int lastPos = 0;

		
		for (int i = 0; i < firstList.length; i++) {

			for (int j = lastPos; j < secondList.length; j++) {
				if (firstList[i].intValue() == secondList[j].intValue()) {
					result.add(firstList[i]);
					lastPos++;
					break;
				} else if (secondList[j].intValue() > firstList[i].intValue()) {
					break;
				}
				lastPos++;
			}

		}

		return result;
	}

	/**
	 * Using two Arrays to loop through
	 * 
	 * @param firstList
	 * @param secondList
	 * @return intersected ArrayList
	 */
	private ArrayList<Integer> trivialIntersect(Integer[] firstList, Integer[] secondList) {

		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < firstList.length; i++) {
			for (int j = 0; j < secondList.length; j++) {
				if (Integer.compare(firstList[i], secondList[j]) == 0) {
					result.add(firstList[i]);
				}
			}
		}
		return result;
	}

	/**
	 * Using a collection to use the contains function
	 * 
	 * @param firstList
	 * @param secondList
	 * @return
	 */
	private ArrayList<Integer> intersectWithCollections(Integer[] firstList, Integer[] secondList) {

		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<Integer> second = new ArrayList<>(Arrays.asList(secondList));

		for (int i = 0; i < firstList.length; i++) {
			if (second.contains(firstList[i])) {
				result.add(firstList[i]);
			}
		}

		return result;
	}

	/**
	 * Helper Function to generate files to disk
	 * 
	 * @param amountOfValues
	 * @param path
	 */
	public static void generateFile(int amountOfValues, String path) throws IOException {

		int cnt = 0;
		int val = 0;
		Random rand = new Random();
		File f = new File(path);
		FileWriter w = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(w);

		while (cnt < amountOfValues) {
			if (rand.nextBoolean()) {
				bw.write(Integer.toString(val) + "\n");
				cnt++;
			}
			val++;
		}
		bw.close();
		w.close();

	}

	/**
	 * Helper function to read the files from Disk
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static Integer[] getValuesFromFile(String path) throws IOException {

		File f = new File(path);
		FileReader r = new FileReader(f);
		BufferedReader br = new BufferedReader(r);
		LinkedList<Integer> lst = new LinkedList<>();

		String line = br.readLine();
		;

		while (line != null) {
			try {
				lst.add(Integer.parseInt(line));
			} catch (NumberFormatException e) {
				System.out.println("Couldn't convert value to int");
			}
			line = br.readLine();
		}

		br.close();

		return lst.toArray(new Integer[lst.size()]);

	}

}
