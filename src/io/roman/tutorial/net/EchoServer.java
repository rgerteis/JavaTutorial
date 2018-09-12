package io.roman.tutorial.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String args[]) {

		try {
			@SuppressWarnings("resource")
			ServerSocket ss = new ServerSocket(5555);

			while (true) {
				Socket s = ss.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
				String msg;
				while ((msg = in.readLine()) != null) {
					System.out.println("Received:" + msg);
		
					if (msg.equals("quit")) {
						out.write("bye bye ....\n");
						out.flush();
						s.close();
						break;
					}
					out.write(msg + "\n");
					out.flush();
				}
			}

		} catch (Exception e) {

		}

	}

}
