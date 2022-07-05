package pxv425;

import exs406.PrivateMessage;
import gui.Intro;
import gui.LoginModel;
import gui.SignUpModel;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class is part of the client part
 * 
 * @author pxv425
 * @version 2015-02-28
 */
public class Client extends JFrame {

	// Instance Variables

	// This variable stores the address of the server
	private static final String IP = "147.188.195.217";
	// This variable stores the port number in which the server "listens"
	private static final int PORT = 1236;
	// Stream to server
	private ObjectOutputStream output;
	// Stream from server
	private ObjectInputStream input;
	/*
	 * I used Object instead of Data because the former takes objects instead of
	 * primitive data variables. In this case we want to send objects and not a
	 * primitive data variable.
	 */
	// Socket for client
	private Socket client;
	// User
	private User user;
	/*
	 * These variables are part of the communication protocol between the server
	 * and the client These variables are supposed to be changed according to
	 * the server's replies
	 */
	private Object receivedFromServer2;
	private String messageToGui = "OK";
	private String messageToGui2 = "OK";
	private Object messageToGui3 = "dev";
	/*
	 * This is the instance of the ClientThread which will be used. This
	 * contains the thread which is used during the chatting in order to receive
	 * input
	 */
	private ClientThread clientThread;
	private static final long serialVersionUID = 1L;
	// The LoginModel object instance
	private LoginModel loginModel;
	// The ChatView object instance
	private ChatView chatView;
	// The ChatModel object instance
	private ChatModel chatModel;
	/*
	 * This is the instance of the BasicChat which will be used. This contains
	 * the thread which is used during the chatting in order to send output
	 */
	private BasicChat chat;
	private PrivateMessage privateMessage;

	// Constructors

	/**
	 * Constructor of the class
	 * 
	 * @param User
	 *            user
	 * 
	 * @author pxv425
	 * @version 2015-02-28
	 */
	public Client(User user) {
		/*
		 * Calls the connect method in order to open the socket as well as the
		 * input and output streams.
		 */
		connect(IP, PORT, user);
	}

	/**
	 * Default - empty constructor of the class This constructor draws the
	 * frame.
	 * 
	 * @author pxv425
	 * @version 2015-02-28
	 */
	public Client() {
		// Shows the introduction panel
		changePanel(new Intro(this));
		// Makes it visible
		setVisible(true);
		// Sets the title
		setTitle("Chat City");
		// The icon which will be displayed on the title bar
		setIconImage(new ImageIcon(".//pics//ChatCityIcon.png").getImage());
		// Does not allow the user to resize the window
		setResizable(false);
		// This code places your JFrame in the middle of the screen
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int) screen.getWidth() / 2 - getWidth() / 2,
				(int) screen.getHeight() / 2 - getHeight() / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Getters and setters

	/**
	 * Makes the messageToGui3 private variable accessible to outer classes
	 * 
	 * @return String messageToGui3
	 * 
	 * @author pxv425
	 * @version 2015-03-17
	 */
	public String getMessageToGui3() {
		return messageToGui3.toString();
	}

	/**
	 * This method sets the messageToGui3 variable
	 * 
	 * @param Object
	 *            obj
	 * 
	 * @author pxv425
	 * @version 2015-03-17
	 */
	public void setMessageToGui3(Object obj) {
		this.messageToGui3 = obj;
	}

	/**
	 * This method makes the user private variable accessible to outer classes
	 * 
	 * @return User user
	 * 
	 * @author pxv425
	 * @version 2015-02-28
	 */
	public User getUser() {
		return user;
	}

	/**
	 * This method makes the receivedFromServer2 private variable accessible to
	 * outer classes
	 * 
	 * @return Object receivedFromServer2
	 * 
	 * @author pxv425
	 * @version 2015-03-17
	 */
	public Object getReceivedFromServer2() {
		return receivedFromServer2;
	}

	/**
	 * This method makes the messageToGui private variable accessible to outer
	 * classes
	 * 
	 * @return String messageToGui
	 * 
	 * @author pxv425
	 * @version 2015-03-17
	 */
	public String getMessageToGui() {
		return messageToGui;
	}

	/**
	 * This method makes the messageToGui2 private variable accessible to outer
	 * classes
	 * 
	 * @return String messageToGui2
	 * 
	 * @author pxv425
	 * @version 2015-03-17
	 */
	public String getMessageToGui2() {
		return messageToGui2;
	}

	/**
	 * This method sets the messageToGui instance variable
	 * 
	 * @param String
	 *            s
	 * 
	 * @author pxv425
	 * @version 2015-03-17
	 */
	public void setMessageToGui(String s) {
		this.messageToGui = s;
	}

	/**
	 * This method sets the messageToGui2 instance variable
	 * 
	 * @param String
	 *            s
	 * 
	 * @author pxv425
	 * @version 2015-03-17
	 */
	public void setMessageToGui2(String s) {
		this.messageToGui2 = s;
	}

	// Methods to manipulate the instance variables

	/**
	 * This method connects the client with the server
	 * 
	 * @param String
	 *            address
	 * @param int portNumber
	 * @param User
	 *            user
	 * 
	 * @author pxv425
	 * @version 2015-03-06
	 */
	private void connect(String address, int portNumber, User user) {
		System.out.println("Attempting connection");
		// Assign the user argument to the user instance variable
		this.user = user;
		try {
			// Socket object using the address and the port
			client = new Socket(address, portNumber);
			System.out.println("Connected to "
					+ client.getInetAddress().getHostName());
			/*
			 * ObjectInputStream using the getInputStream method of the Socket
			 * class
			 */
			input = new ObjectInputStream(client.getInputStream());
			/*
			 * ObjectOutputStream using the getOutputStream method of the Socket
			 * class
			 */
			output = new ObjectOutputStream(client.getOutputStream());
			// Delete remaining bytes
			output.flush();
			System.out.println("Got I/O streams");
		} catch (UnknownHostException e) {
			// If error occurs, call error() method using message
			error(address + " - Unknown host.");
		} catch (IOException e) {
			// If error occurs, call error() method using message
			error("Could not get I/O for the connection to " + address);
		}
	}

	/**
	 * Method which is called in order to login
	 * 
	 * @param LoginModel
	 *            loginModel
	 * @throws IOException
	 *             , if something goes wrong with the streams
	 * @throws ClassNotFoundException
	 *             , if this method will receive an unknown class
	 * 
	 * @author pxv425
	 * @version 2015-03-14
	 */
	@SuppressWarnings("unchecked")
	public void login(LoginModel loginModel) throws IOException,
			ClassNotFoundException {

		// Calls the connect method in order to get connected
		connect(IP, PORT, user);

		// LoginModel is sent to the server
		output.writeObject(loginModel);
		output.flush();

		/*
		 * These two Objects are part of the login protocol between the server
		 * and the client
		 */
		Object receivedFromServer1 = receivedFromServer();
		Object receivedFromServer2 = receivedFromServer();

		System.out.println(receivedFromServer1.toString());
		// Prints: "server says: connected to server"

		if (receivedFromServer2 instanceof User) {
			/*
			 * If client receives a User object from the server, the method
			 * assigns this object into the user instance variable and sets the
			 * messageToGui variable to "OK". Finally, it calls the chatting
			 * method using a Set of String which contains the online users.
			 */

			System.out.println(receivedFromServer2.toString());
			// Prints the User
			this.user = (User) receivedFromServer2;
			setMessageToGui("OK");

			Object receivedFromServer3 = receivedFromServer();
			chatting(((Set<String>) receivedFromServer3));
		} else {
			/*
			 * If client will not receive a User then this method calls the
			 * setMessageToGui in order to assign the messageToGui instance
			 * variable using the message from server
			 */
			setMessageToGui(receivedFromServer2.toString());
		}
	}

	/**
	 * This method is called in order to start the chat
	 * 
	 * @param Set
	 *            <String> onlineUsers
	 * 
	 * @author pxv425
	 * @version 2015-03-16
	 */
	private void chatting(Set<String> onlineUsers) {
		System.out.println("Chatting started");
		// Create a new ChatModel object
		chatModel = new ChatModel(onlineUsers);
		// Create a new ChatView object
		chatView = new ChatView(this, chatModel);
		/*
		 * calls the method changePanel in order to change the pannel to
		 * chatView
		 */
		changePanel(chatView);

		/*
		 * Creates a new ClientThread object using the ObjectInputStream and the
		 * chatModel. This thread is used in order to receive from server while
		 * the GUI thread is running. After that it starts the thread.
		 */
		ClientThread clientThread = new ClientThread(input, chatModel);
		clientThread.start();
		/*
		 * Creates a new BasicChat object using the ObjectOutputStream. This
		 * thread is used in order to send to server while the GUI thread and
		 * the clientThread is running. After that it starts the thread.
		 */
		chat = new BasicChat(output);
		chat.start();
		/*
		 * After these two threads have been started the inputs and the outputs
		 * will be received and sent using these two new threads.
		 */
	}

	/**
	 * This method is used by the GUI in order to send the message
	 * 
	 * @param String
	 *            s
	 * 
	 * @author axd450
	 * @version 2015-03-21
	 */
	public void sendMessage(String s) {
		/*
		 * Calls the BasicChat instance and it uses the setMessage using the
		 * argument from the BasicChat class
		 */
		chat.setMessage(s);
	}

	/**
	 * This method is used by the GUI in order to send a private message
	 * 
	 * @param Object
	 *            obj
	 * 
	 * @author axd450
	 * @version 2015-03-24
	 */
	public void sendPrivateMessage(Object obj) {
		/*
		 * Calls the BasicChat instance and it uses the sendPrivate using the
		 * object argument
		 */
		chat.sendPrivate(obj);
	}

	/**
	 * This method is used in order to sign up a new user
	 * 
	 * @param SignUpModel
	 *            signUpModel
	 * 
	 * @throws IOException
	 *             , if something goes wrong with the streams
	 * @throws ClassNotFoundException
	 *             , if this method will receive an unknown class
	 * 
	 * @author pxv425
	 * @version 2015-03-14
	 */
	public void signUp(SignUpModel signUpModel) throws IOException,
			ClassNotFoundException {

		// SignUpModel is sent to the server
		output.writeObject(signUpModel);
		output.flush();

		/*
		 * Server sends two replies which are stored in two variables using the
		 * receivedFromServer method
		 */
		Object receivedFromServer1 = receivedFromServer();
		receivedFromServer2 = receivedFromServer();

		if (receivedFromServer2 instanceof User) {
			/*
			 * If the reply from server is a User object, that means that
			 * everything is ok. After that it prints the User object on
			 * console.
			 */
			System.out.println(receivedFromServer2.toString());
		} else {
			/*
			 * If the reply from server is not a User object, that means that
			 * something went wrong. In this situation the messageToGui2 is
			 * assigned using the setMessageToGui2 method with the reply from
			 * the server.
			 */
			setMessageToGui2(receivedFromServer2.toString());
		}
	}

	/**
	 * This method is used in order to change the panels
	 * 
	 * @param JPanel
	 *            panel
	 * 
	 * @author pxv425
	 * @version 2015-03-14
	 */
	public void changePanel(JPanel panel) {
		this.setContentPane(panel);
		this.pack();
	}

	/**
	 * Method which prints the error message and terminates the program
	 * 
	 * @param String
	 *            message
	 * 
	 * @author pxv425
	 * @version 2015-02-28
	 */
	private void error(String message) {
		System.err.println(message);
		System.exit(1);
	}

	@Override
	public void finalize() {
		System.out.println("Closing connection");
		try {
			// Close the streams and the socket
			output.close();
			input.close();
			client.close();
		} catch (IOException e) {
			// If an error occurs, call error() method using message
			error("Something went wrong ending the client");
		}
		System.out.println("Connection closed");
	}

	/**
	 * This method receives the input from the server
	 * 
	 * @return Object server's reply
	 * @throws IOException
	 *             , if something goes wrong with the streams
	 * @throws ClassNotFoundException
	 *             , if this method will receive an unknown class
	 * 
	 * @author pxv425
	 * @version 2015-02-28
	 */
	public Object receivedFromServer() throws ClassNotFoundException,
			IOException {
		/*
		 * Calls the readObject method from the ObjectInputStream class in order
		 * to receive the input.
		 */
		return input.readObject();
	}

	/**
	 * This method is called by the GUI if user presses the exit button
	 * 
	 * @author pxv425
	 * @version 2015-03-23
	 */
	public void logout() {
		System.exit(0);

	}
}