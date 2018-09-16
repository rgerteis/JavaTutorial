package io.roman.tutorial.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HttpReader {

	public static void main(String args[]) {
		try {
			
			URL url = new URL("http://www.google.com");
			URLConnection uc = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			
			String ln;
			
			while ((ln = in.readLine()) != null) {
				System.out.println(ln);
			}
			in.close();
			
		} catch (Exception e) {
			
		}
	}
}
