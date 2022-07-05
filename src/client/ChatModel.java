package pxv425;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.SwingUtilities;

import server.History;
import exs406.Chat;

/**
 * Model class for Chat
 * 
 * @author exs406 & pxv425
 *
 */
public class ChatModel extends Observable {
	// set with chat object
	private Set<Chat> chatSet;
	// set of string (usernames) with onlineUsers
	private Set<String> onlineUsers;
	// message sent
	private String message;
	private Set<String> developers;
	private History history = new History();

	// runnable object
	private Runnable runnable = new Runnable() {
		// nested class with run method
		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@SuppressWarnings("rawtypes")
		@Override
		public void run() {
			// setting onlineUsers set to string
			onlineUsers.toString();
			// updating to inform Observer (ChatView)
			update((HashSet) onlineUsers);

		}
	};

	/**
	 * ChatModel constructor with one parameter onlineUsers
	 * 
	 * @param onlineUsers
	 */
	public ChatModel(Set<String> onlineUsers) {
		setOnlineUsers(onlineUsers);
		chatSet = new HashSet<>();
	}

	/**
	 * 
	 * @return Set of chat objects
	 */
	public Set<Chat> getChat() {
		return chatSet;
	}

	/**
	 * 
	 * @param Chat
	 *            object chat
	 */
	public void setChatSet(Chat chat) {
		this.chatSet.add(chat);
		update(chat);
	}

	/**
	 * 
	 * @return Set of String with onlineUsers
	 */
	public Set<String> getOnlineUsers() {
		return onlineUsers;
	}

	/**
	 * Setter for online users
	 * 
	 * @param onlineUsers
	 */
	public void setOnlineUsers(Set<String> onlineUsers) {
		System.out.println("setting online users update ");
		System.out.println("online users " + onlineUsers.toString());
		this.onlineUsers = onlineUsers;
		// method called to update GUI through runnable
		SwingUtilities.invokeLater(runnable);

	}

	/**
	 * 
	 * @return String message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @param String
	 *            message
	 */
	public void setMessage(String message) {
		this.message = message;
		update(message);
		SwingUtilities.invokeLater(runnable);
	}

	/**
	 * 
	 * @param TreeSet
	 *            of Strings containing developers
	 */
	public void setDevelopers(TreeSet<String> developers) {
		this.developers = developers;
		System.out.println("inside setDev: " + developers);
		System.out.println("Developers set");
	}

	/**
	 * 
	 * @return String with the history file path
	 */
	public String getHistory() {
		return history.getHistory();
	}

	/**
	 * 
	 * @param History
	 *            object read
	 */
	public void setHistory(History read) {
		this.history = read;
		System.out.println("inside setHist / chat model");
	}

	/**
	 * 
	 * @return Set of String containing the developers
	 */
	public Set<String> getDevelopers() {
		return developers;
	}

	/**
	 * Update method implemented (Observable)
	 * 
	 * @param arg
	 */
	private void update(Object arg) {
		setChanged();
		notifyObservers(arg);
	}
}