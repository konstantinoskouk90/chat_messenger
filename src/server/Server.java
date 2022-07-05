package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author AXD450
 * Server class
 *
 */
public class Server {
	
	
	/**
	 * Main method
	 * Starts Server and awaits connections from clients
	 * @param args
	 */
	public static void main (String[] args) {
		ServerSocket serverSocket = null;
		System.out.println("server started");
		try {
			serverSocket = new ServerSocket(1236);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			
			/*
			 * Server runs in an infinite loop and when a client connects 
			 * it assigns a ServerThread object to that client
			 */
			while (true) {
				
				Socket client = serverSocket.accept();
				ServerThread sT = new ServerThread(client);

				sT.start();
			}
		} catch (IOException e) {
			try {
				serverSocket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
				System.err.println("Server has encountered a problem!" );
			}
		}
	}
}
