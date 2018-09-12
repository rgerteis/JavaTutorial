package io.roman.tutorial.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SumServer {

	private static int port = 5555;

	public SumServer() {

	}

	public static void main(String args[]) throws IOException {
		
		System.out.println("SumServer is Running on Port: " + port);
		@SuppressWarnings("resource")
		ServerSocket mysocket = new ServerSocket(port);

		while (true) {
			Socket connectionSocket = mysocket.accept();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));
			
			writer.write("*** Welcome to the Calculation Server (Addition Only) ***\r\n");
			writer.write("*** Please type in the first number and press Enter : \n");
			writer.flush();
			String data1 = reader.readLine().trim();
			writer.write("*** Please type in the second number and press Enter : \n");
			writer.flush();
			String data2 = reader.readLine().trim();

			int num1 = Integer.parseInt(data1);
			int num2 = Integer.parseInt(data2);

			int result = num1 + num2;
			System.out.println("Addition operation done ");

			writer.write("\r\n=== Result is  : " + result + "\n");
			writer.flush();
			connectionSocket.close();
		}
		
	}
}
