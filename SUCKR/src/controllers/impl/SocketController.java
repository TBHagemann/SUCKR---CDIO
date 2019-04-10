package controllers.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

import controllers.interfaces.ISocketController;

public class SocketController implements ISocketController {

	String port;
	Socket socket;
	Writer output;
	InputStream input;
	int sendData;
	String receiveData;
	
	public void sendData(String port, int sendData) {
		try {
			Socket socket = new Socket(port,3000);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("Host not known");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Virkede ikke");
			e.printStackTrace();
		}
		
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			OutputStream output = socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter print = new PrintWriter(output, true);
		
		try {
			InputStream input = socket.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedReader readread = new BufferedReader(new InputStreamReader(input));
		
		while(true) {
			sendData = this.sendData;
			print.println(sendData);
			print.flush();
			try {
				receiveData = readread.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(receiveData != null) {
				System.out.println(receiveData);
			}
		}
	}
	
	

}
