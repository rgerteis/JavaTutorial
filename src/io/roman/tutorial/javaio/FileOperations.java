package io.roman.tutorial.javaio;

import java.io.*;

public class FileOperations {

	@SuppressWarnings("unused")
	private static String aFile = "/tmp/a_file.txt";
	@SuppressWarnings("unused")
	private static String oFile = "/tmp/other_file.txt";
	private static String csvFile = "/tmp/csv_file.txt";

	public FileOperations() {
		
		// generate the CSV file
		String csv_values = "'Rachel','Chandler','Monica','Phoebe','Ross','Joey'";

		try {
			File file = new File(csvFile);
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(csv_values);
			bw.close();
			fw.close();
		} catch (IOException e) {
    		System.out.println("Exception Occurred:");
	        e.printStackTrace();
		} 
	}

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		FileOperations fo = new FileOperations();
		
	}

}
