package pxv425;

import java.io.IOException;
import java.io.ObjectOutputStream;

import server.History;

/**
 * This class contains the thread in order to send messages to the server
 * 
 * @author axd450
 *
 */
public class BasicChat extends Thread {
	private static ObjectOutputStream output;
	private String message;

	/**
	 * Constructor of the class
	 * 
	 * @param ObjectOutputStream
	 *            output
	 * 
	 * @author axd450
	 * @version 2015-03-21
	 */
	public BasicChat(ObjectOutputStream output) {
		this.output = output;
	}

	/**
	 * This method waits for the developer team
	 * 
	 * @author pxv425
	 * @version 2015-03-23
	 */
	public static void devTeam() {
		try {
			/*
			 * It sends a message to server which is a signal that client waits
			 * for a specific answer
			 */
			output.writeObject(new Integer(7777777));
			output.flush();
		} catch (IOException e) {
			System.err.println("Something went wrong with the streams");
		}
	}
	
	/**
	 * This method waits for the history file
	 * 
	 * @author pxv425
	 * @version 2015-03-24
	 */
	public static void getHistory(){
		System.out.println("Inside basic chat getHistory");
		try {
			output.writeObject(new History());
			output.flush();
		} catch (IOException e) {
			System.err.println("Something went wrong with the streams");
		}
	}

	/**
	 * Sets the message instance variable
	 * 
	 * @param String
	 *            s
	 * 
	 * @author axd450
	 * @version 2015-03-21
	 */
	public void setMessage(String s) {
		System.out.println("Basic chat " + s);
		message = s;
		send();

	}

	/**
	 * Sends a private message
	 * 
	 * @param Object
	 *            o
	 * 
	 * @author axd450
	 * @version 2015-03-21
	 */
	public void sendPrivate(Object o) {
		try {
			output.writeObject(o);
		} catch (IOException e) {
			System.err.println("Something went wrong with the streams");
		}
	}

	/**
	 * Sends a message
	 * 
	 * @author axd450
	 * @version 2015-03-24
	 */
	private void send() {
		try {
			output.writeObject(message);
			output.flush();
		} catch (IOException e) {
			System.err.println("Something went wrong with the streams");
		}

	}

	@Override
	public void run() {
		/*
		 * This method does not have any body. It is situated here in order to
		 * start the client
		 */
	}
}
