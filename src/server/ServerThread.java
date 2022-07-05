package server;

import exs406.BelfastMessengerDB;
import exs406.PrivateMessage;
import gui.LoginModel;
import gui.SignUpModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import pxv425.User;


/**
 * @author AXD450
 * ServerThread Class
 * Extends Thread
 *
 */
public class ServerThread extends Thread {
	private Socket client;
	private User u;
	static Set<String> online = new HashSet<String>();//used to store all online users' usernames
	static Map<String, OutputStream> onlineUsers= new TreeMap<String, OutputStream>(); //used to store all the connected users output streams
	private ObjectOutputStream output;
    private ObjectInputStream input;
	private boolean run; //used in the infinite loop when the server awaits for the next input from the client. 
						//When a user disconnects this boolean turns to false amd so the loop is stopped. 
    
	/**
	 * ServerThread constructor 
	 * @param client
	 */
	public ServerThread(Socket client) {
		super("ServerThread");
		this.client = client;
		try {
			//Open the output and input stream for each connected client
			output = new ObjectOutputStream(client.getOutputStream());
		    input = new ObjectInputStream(client.getInputStream());

		} catch (IOException e) {
			System.err.println("Could not open Streams!" );
		}
		System.out.println("serverThread");
	}
	
	/* 
	 * run method
	 * manages communication between server and client
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		
		Object inputObject;
		System.out.println("client connected");
	    try {
		    
		    System.out.println("run method");
		    
		    //send message to client that it is connected to server
		    String line = "Server says: \nconnected to server";
		    output.writeObject(line);//writeChars("Server says: /n connected to server");
		    output.flush();
		    
		    inputObject = input.readObject();
		    System.out.println("object received " + (inputObject).toString());
		    
		    //Check whether the client is trying to sign up or log in
			if (inputObject instanceof LoginModel) {
				
				//check if client has sent a username and a password
				if (!(((LoginModel) inputObject).getUsername()).equals("") && !(((LoginModel) inputObject).getPassword()).equals("")) {
					
					//check if information provided by the client is correct according to the information stored in the database
					String logUser = loginUser((LoginModel) inputObject);
					if (logUser.equals("OK")) {
						System.out.println("OK");
						u = BelfastMessengerDB.getUser(((LoginModel) inputObject).getUsername()); 
						System.out.println(u.toString());
						
						synchronized (onlineUsers) {
							synchronized (online) {
								if (!onlineUsers.containsKey(u.getUsername())) {
							
									online.add(u.getUsername());//add new online client to Set
									onlineUsers.put(u.getUsername(), output);//add new online client to map
			
									System.out.println(online.toString());
									System.out.println(onlineUsers.toString());
									synchronized (output) {
										output.writeObject(u);
										output.flush();
										informClients();
									}

								} else {
									output.writeObject("Already connected from other PC!");
									output.flush();
									u = null;
									shutDown();
								}
							}
						}
						
					} else if (logUser.equals("ER01")) {
						System.out.println("User not found!");
						output.writeObject("User not found!");
						output.flush();
						shutDown();
						
					} else if (logUser.equals("ER02")) {
						System.out.println("Incorrect Password!");
						output.writeObject("Incorrect Password!");
						output.flush();
						shutDown();
					}	
					
				} else {
					if ((((LoginModel) inputObject).getUsername()).equals("") && (((LoginModel) inputObject).getPassword()).equals("")) {
						System.out.println("Insert Username and Password!");
						output.writeObject("Insert Username and Password!");
						output.flush();
						shutDown();
					} else if ((((LoginModel) inputObject).getPassword()).equals("")) {
						System.out.println("Insert Password!");
						output.writeObject("Insert Password!");
						output.flush();
						shutDown();
					} else {
						System.out.println("Insert Username!");
						output.writeObject("Insert Username!");
						output.flush();
						shutDown();
					}
					
				}
			} else if(inputObject instanceof SignUpModel) {
				System.out.println("signup");
				
				// checks if all the mandatory information for sign up is sent by the client
				if (((SignUpModel) inputObject).getUsername() != null && ((SignUpModel) inputObject).getPassword() != null && 
						((SignUpModel) inputObject).getFirstname() != null && ((SignUpModel) inputObject).getLastname() != null && 
						((SignUpModel) inputObject).getEmail() != null) {
					
					System.out.println("signningup user\n " + ((SignUpModel) inputObject).getEmail());
					
					//sent information to database in order to check if all is valid and update the database
					String signnedUp = BelfastMessengerDB.signup_user(((SignUpModel) inputObject).getFirstname(), ((SignUpModel) inputObject).getLastname(), 
							((SignUpModel) inputObject).getUsername(), ((SignUpModel) inputObject).getPassword(), ((SignUpModel) inputObject).getAlias(), 
							((SignUpModel) inputObject).getEmail());
					
					/*
					 * jdbc returns strings if client has been added to database or if any conflictions were encountered with other entries
					 * inform client accordingly
					 */
					if(signnedUp.equals("OK")) {
						
						System.out.println("OK");
						output.writeObject("OK");
						output.flush();
						String path = "history/" + ((SignUpModel) inputObject).getUsername() + ".txt";
						File userHistory = new File(path);
						userHistory.createNewFile();
						BelfastMessengerDB.addPath(((SignUpModel) inputObject).getUsername(), path);
						
						shutDown();
					} else if (signnedUp.equals("ER00")) {
						
						System.out.println("ER00");
						output.writeObject("Username already exists");
						output.flush();
						shutDown();
					} else if (signnedUp.equals("ER01")) {
						
						System.out.println("ER01");
						output.writeObject("e-mail already exists");
						output.flush();
						shutDown();
					} else if (signnedUp.equals("ER02")) {
						
						System.out.println("ER02");
						output.writeObject("Username and e-mail already exist");
						output.flush();
						shutDown();
					}
				} else {
					output.writeObject("Please fill in all mandatory fields");
					output.flush();
					shutDown();
				}
			}
			
			//File used for storing private message to recipient's history file path and File
			String pathR = "";
			File rHistory = new File(pathR);
			File myHistory = null;
			//User's history filepath and history file
			String myPath = BelfastMessengerDB.retrievePath(u.getUsername());// from DB

			if (myPath == null || !(myHistory = new File(myPath)).exists()) { 
			System.out.println("file create");

			//Check if user's history file exists. If not create a new one asnd inform database.
			//if (!myHistory.exists()) {
				myPath = "history/" + u.getUsername() + ".txt";
				myHistory = new File(myPath);
				myHistory.createNewFile();
				BelfastMessengerDB.addPath(u.getUsername(), myPath);
			}

			/*
			 * Infinite loop
			 * When user disconnects the loop is cut through the shutDown method
			 * This loop is used to take input objects from the user send back what the user has asked.
			 * In case of String the String will be passe to all online users.
			 * In case of Integer the user will receive a TreeMap with the developers names and e-mail addresses
			 * In case of PrivatMessage object that message will be passed to the recipient stated and back to the user
			 * In case of History object the user will receive aHistory object containing that user's whole history 
			 */
			run = true;
		    while (run) {
	    		Object received = input.readObject();
	    		if (received instanceof String) {
	    			sendToAll(((String) received), u.getUsername());
	    		} else if (received instanceof Integer && (received).equals(7777777)){
	    			TreeSet<String> dev = new TreeSet<String>();
	    			dev =  (TreeSet<String>) BelfastMessengerDB.HelpSupport();
	    			System.out.println("dev : " + dev.toString());
	    			synchronized (output) {
	    				output.writeObject(dev);
	    				output.flush();
	    			}
	    		} else if (received instanceof PrivateMessage) {
	    			PrivateMessage pM = (PrivateMessage) received;
	    			System.out.println(" Private  from @" + u.getUsername() + " to @" + pM.getUsername() + " : " + pM.getMessage());
	    			synchronized (onlineUsers) {
	    				synchronized ((ObjectOutputStream) onlineUsers.get(pM.getUsername())) {
	    					((ObjectOutputStream) onlineUsers.get(pM.getUsername())).writeObject(" Private from @" + u.getUsername() + " to @" + pM.getUsername() + " : " + pM.getMessage());
	    					((ObjectOutputStream) onlineUsers.get(pM.getUsername())).flush();
	    				}
	    			}
	    			pathR = BelfastMessengerDB.retrievePath(pM.getUsername()); 
	    			rHistory = new File(pathR);
	    			setChatHistory(" Private from @" + u.getUsername() + " to @" + pM.getUsername() + " : " + pM.getMessage(), rHistory);
	    			
	    			System.out.println(" Private to @" + pM.getUsername() + " from @" + u.getUsername() + " : " + pM.getMessage());
	    			synchronized (online) {
	    				synchronized ((ObjectOutputStream) onlineUsers.get(u.getUsername())) {
	    					((ObjectOutputStream) onlineUsers.get(u.getUsername())).writeObject(" Private to @" + pM.getUsername() + " from @" + u.getUsername() + " : " + pM.getMessage());
	    					((ObjectOutputStream) onlineUsers.get(u.getUsername())).flush();
	    				}
	    			}
	    			setChatHistory(" Private to @" + pM.getUsername() + " from @" + u.getUsername() + " : " + pM.getMessage(), myHistory);
	    		} else if (received instanceof History){
	    			
	    			FileInputStream fIS = new FileInputStream(myHistory);
	    			int b;
	    			StringBuffer history = new StringBuffer();
	    			
	    			while ((b = fIS.read()) != -1) {
	    				history.append((char) b);
	    			}
	    			fIS.close();
	    			
	    			History historyF = new History(history.toString());
	    			synchronized (output) {
						output.writeObject(historyF);
						output.flush();
    				}
	    		}
		    }

	    } catch (IOException e) {
	    	synchronized (onlineUsers) {
	    		synchronized (online) {
					if (u != null && !online.isEmpty() && !onlineUsers.isEmpty()) {
						online.remove(u.getUsername());
						onlineUsers.remove(u.getUsername());
						informClients();
						System.out.println(online.toString());
						System.out.println(onlineUsers.toString());
					}
				}
	    	}	

			System.err.println("Client has logged out!" );
	    	shutDown();
		} catch (ClassNotFoundException e) {
			System.out.println("ex2");
			shutDown();
			System.err.println("Class not recognized!");
			e.printStackTrace();
		}
	}
	
	/**
	 * Sends HashSet with online users to every user
	 * The username of the user who receives the Set has been removed beforehand
	 */
	private void informClients() {
		synchronized (onlineUsers) {
			synchronized (online) {
				
				for (String usr: onlineUsers.keySet()) {
					HashSet<String> send = new HashSet<String>();
					send.addAll(online);
					send.remove(usr);
					try {
						synchronized ((ObjectOutputStream) (onlineUsers.get(usr))) {
							((ObjectOutputStream) (onlineUsers.get(usr))).writeObject(send);
							((ObjectOutputStream) (onlineUsers.get(usr))).flush();
						}
					} catch (IOException e) {
						System.err.println(usr + "'s OutputStream Problem!");
						e.printStackTrace();
					}
					System.out.println("send users to "  + usr + " set: " + send.toString());
				}
			}	
		}
	}
	
	/**
	 * Sends message from user to all online users
	 * public chat
	 * @param mes
	 * @param user
	 */
	private void sendToAll (String mes, String user) {
		System.out.println(user + " : " + mes);
		synchronized (onlineUsers) {

			for (String usr : onlineUsers.keySet()) {
				String path = BelfastMessengerDB.retrievePath(usr);// from DB
				File chatHistory = new File(path);

				try {
					synchronized ((ObjectOutputStream) (onlineUsers.get(usr))) {
						((ObjectOutputStream) (onlineUsers.get(usr)))
								.writeObject(" " + user + " : " + mes);
						((ObjectOutputStream) (onlineUsers.get(usr))).flush();
					}
					setChatHistory(" " + user + " : " + mes, chatHistory);
				} catch (IOException e) {
					System.err.println(usr + "'s OutputStream Problem!");
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Closes Streams sockert and Thread
	 */
	private void shutDown() {
		try {
			run = false;
			input.close();
			output.close();
			client.close();
			this.finalize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("User " + u.getUsername() + " has logged out!" );
			e.printStackTrace();
		} catch (Throwable e) {
			System.err.println("Problem occured while closing client!");
			e.printStackTrace();
		}
	}
	
	/**
	 * calls jdbc class to check if user exists in database
	 * 
	 * @param m
	 * @return String to client
	 */
	private String loginUser (LoginModel m) {
		return BelfastMessengerDB.loginUser(m.getUsername(), m.getPassword());
	}
	
	/**
	 * Writes messages exchanged to user's file
	 * @author Elena Stylianou (exs406) 
	 * @param currentLine
	 * @param chatFile
	 */
	public void setChatHistory(String currentLine, File chatFile) 
	{
		Calendar date = new GregorianCalendar();
		Calendar time = new GregorianCalendar();
		
		String currentdate = date.get(Calendar.DATE) + "/" + (date.get(Calendar.MONTH) + 1) 
		+ "/" + date.get(Calendar.YEAR);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		time.getTime();
		
		Writer infile = null;
		try 
		{
			infile = new BufferedWriter(new FileWriter(chatFile, true));
			infile.append(currentdate+" "+sdf.format(time.getTime())+" "+currentLine +"\n");
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			System.err.println("Exception while reading and/or appending the history file");
			e.printStackTrace();
		} finally 
		{
			try 
			{
				infile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}