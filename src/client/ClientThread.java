package pxv425;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.TreeSet;

import server.History;

/**
 * This class is used in order to split the threads which contains the GUI from
 * the thread which receives messages from server
 * 
 * @author pxv425
 *
 */
public class ClientThread extends Thread {

	// Instance variables

	// The new input stream
	private ObjectInputStream input;
	// An object of ChatModel
	private ChatModel chatModel;

	// Constructor
	/**
	 * Constructor of the class
	 * 
	 * @param ObjectInputStream
	 *            input
	 * @param ChatModel
	 *            chatModel
	 * 
	 * @author axd450
	 * @version 2015-03-21
	 */
	public ClientThread(ObjectInputStream input, ChatModel chatModel) {
		this.input = input;
		this.chatModel = chatModel;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		while (true) {
			Object read;
			try {
				read = input.readObject();
				if (read instanceof HashSet) {
					/*
					 * If the object is of type HashSet - the user list has been
					 * updated
					 */
					chatModel.setOnlineUsers((HashSet<String>) read);
				} else if (read instanceof String) {
					/*
					 * If the object is of type String - new messages
					 */
					chatModel.setMessage((String) read);
				} else if (read instanceof TreeSet) {
					/*
					 * If the object is of type TreeSet - the developers team
					 * has been received
					 */
					chatModel.setDevelopers((TreeSet) read);
				} else if (read instanceof History) {
					/*
					 * If the object is of type History - the history has been
					 * received
					 */
					System.out.println("history got");
					chatModel.setHistory((History) read);
				} else {
					System.out.println(read.toString());
				}

			} catch (ClassNotFoundException e) {

			} catch (IOException e) {
				System.exit(1);

			}

		}
	}
}
