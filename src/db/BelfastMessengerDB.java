package exs406;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;

import pxv425.User;

/**JDBC Class
 * Note: In try/catch blocks a finally block is used to close connections, preparedStatements, results sets etc.
 * 
 * @author exs406
 *
 */
public class BelfastMessengerDB
{
	//final static String fields to establish connection to the database
	private static final String db_url = "jdbc:postgresql://dbteach2.cs.bham.ac.uk:5432/belfastmessenger";
	private static final String USER_db = "exs406";
	private static final String PASS_db = "elenass";
	
	//setting the jdbc connection and query components null
	static Connection connection = null;
	static PreparedStatement preparedstmt= null;
	static PreparedStatement preparedstmt2 = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	static Set<String> developersEmail = new TreeSet<String>();
	
	
	/**Adds in a record for a specific user his/hers history file path
	 * @param username String
	 * @param path String
	 */
	public static void addPath (String username, String path)
	{
		try{
			//connection with the database
			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);
			
			//creating sql query
			String setPath = "UPDATE users SET chatpath = ? WHERE username = ?";
			preparedstmt = connection.prepareStatement(setPath);
			preparedstmt.setString(1, path);
			preparedstmt.setString(2, username);
			
			preparedstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				rs.close();
				preparedstmt.close();
				connection.close();	
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
	}
	
	/** Finds and returns a chatpath for a specific user
	 * @param username
	 * @return
	 */
	public static String retrievePath(String username)
	{ 
		String chatPath= null;
		
		try{
			//connection with the database
			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);
			
			//creating sql query
			String selectPath = "SELECT chatpath FROM users WHERE username = ?";
			preparedstmt = connection.prepareStatement(selectPath);
			preparedstmt.setString(1, username);
			
			//executing sql query
			rs = preparedstmt.executeQuery();
			while(rs.next())
			{
				chatPath = rs.getString("chatpath");
			}
		
		}
		catch (SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				rs.close();
				preparedstmt.close();
				connection.close();	
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		return chatPath;
		
		
	}
	
	
	/**Method that gets a user's username and returns the user that the username belongs
	 * @param username
	 * @return User object
	 */
	public static User getUser(String username)
	{
		User ruser = new User();
		try
		{
			//connection with the above final fields
			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);
			
			//String to set the postgres query
			String selectUser = "SELECT username,name,surname,password,on_screen_name,email FROM users WHERE username = ?";
			preparedstmt = connection.prepareStatement(selectUser);
			preparedstmt.setString(1, username);
			
			//executing query
			rs = preparedstmt.executeQuery();
			while(rs.next()){
				String usern = rs.getString("username");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String code = rs.getString("password");
				String on_screen_name = rs.getString("on_screen_name");
				String email =rs.getString("email");
				//saving the new user with his/hers fields based on what is in the database
				ruser = new User(name,surname,usern,code,on_screen_name,email);
			}
			return ruser;
		}
		catch (SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				rs.close();
				preparedstmt.close();
				connection.close();	
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		return ruser;
		
	}
	
	/**Method that finds if a user is registered in the database using his username, if he/she exists
	 * then we check if the password given matches the password stored in the database.
	 * According to what is a found in the database a String is returned to the server
	 * @param username
	 * @param password
	 * @return String (OK or ER01 or ER02)
	 */
	public static String loginUser(String username, String password)
	{
		String usern=null;
		String code=null;
		String usermessage ="OK";
		
		try{
			
			//connection to the database
			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);
			
			//finding user in the database based on his username
			String selectUser = "SELECT username, password FROM users WHERE username = ?";
			preparedstmt = connection.prepareStatement(selectUser);
			preparedstmt.setString(1, username);
			
			//executing query
			rs = preparedstmt.executeQuery();
			while(rs.next())
			{
				//because the username is unique the variables usern and code will take values once
				usern = rs.getString("username");
				code = rs.getString("password");
				System.out.println(usern+" "+code);
			}
			
			//calling the find user with the variable usern in order to check if the database found the user
		   // and if not returns an error message
 			if (!findUser(usern))
			{
				usermessage = "ER01"; //user not found message
			}
			else 
			{
				//if the username exists we check if the password given is valid
			   // else returns an error the password given by the user is wrong
				try
				{
					if (!(MD5.crypt(password).equals(code)))
					{
						usermessage = "ER02";
					}
				} 
				catch (IllegalArgumentException e)
					{
						System.out.println("Code not given");
					}
			}
			
			return usermessage;
		}
		catch (SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				rs.close();
				preparedstmt.close();
				connection.close();	
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		return usermessage;
	}
	
	/**Method that enters a new record in the table users.
	 * Takes as String parameters all the user's information and returns a String message accordingly 
	 * if the sign_up was succesfull or not 
	 * @param name String
	 * @param surname String
	 * @param username String
	 * @param password String
	 * @param on_screen_name String
	 * @param email String
	 * @return String message
	 */
	public static String signup_user (String name, String surname, String username,String password, String on_screen_name, String email)
	{
		//message appears to the server console
		System.out.println("DB: IN signup_user");
		//calling the methods findUser && findUserEmail in order to prevent a user to add the same username and email
	   // with another user (and also prevent sql exception because both username & email are unique fields)
		boolean fUser = findUser(username);
		boolean fEmail = findUserEmail(email);
		
		//if both of them are false then everything is ok to proceed with the sign_up
		if (!fUser && !fEmail)
		{
			System.out.println("DB: calling sign_up");
			//calling the sign_UP method to insert the new record in the database
			sign_UP(name,surname, username,password,on_screen_name, email);
			//return message OK
			return "OK";
		}
		// if the username already exists
		else if (fUser && !fEmail)
			return "ER00";
		//if the email already exists
		else if (!fUser && fEmail)
			return "ER01";
		//if both email and username already exist
		else
			return "ER02";
	}
	
	/**Method that checks if a username already exists in the database and returns a boolean true if its found,
	 * boolean false if not
	 * @param username
	 * @return boolean whether the username is found or not
	 */
	public static boolean findUser(String username)
	{
		System.out.println("DB: in findUser");
		boolean userFound = true;
		String usern=null;
		
		try{
			//connection with the database
			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);
			
			//creating sql query
			String selectUser = "SELECT username, password FROM users WHERE username = ?";
			preparedstmt = connection.prepareStatement(selectUser);
			preparedstmt.setString(1, username);
			
			//executing sql query
			rs = preparedstmt.executeQuery();
			while(rs.next()){
				usern = rs.getString("username");
			}
			// if the username is not found in the database userFound becomes false
			if (usern==null)
			{
				System.out.println("DB in findUser: User not found");
				userFound = false;
			}
		
			return userFound;
		}
		catch (SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				rs.close();
				preparedstmt.close();
				connection.close();	
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		return userFound;
		
		
	}
	
	/**Method that checks if a email already exists in the database and returns a boolean true if its found,
	 * boolean false if not
	 * @param email
	 * @return boolean whether the email is found or not
	 */
	public static boolean findUserEmail(String email)
	{ 
		System.out.println("DB: in findEmail");
		boolean userEmailFound = true;
		String useremail=null;
		
		try{
			//connection with the database
			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);
			
			//creating sql query
			String selectUser = "SELECT email FROM users WHERE email = ?";
			preparedstmt = connection.prepareStatement(selectUser);
			preparedstmt.setString(1, email);
			
			//executing sql query
			rs = preparedstmt.executeQuery();
			while(rs.next()){
				useremail = rs.getString("email");
			}
			// if the email is not found in the database userFound becomes false
			if (useremail==null)
			{
				userEmailFound =false;
			}
		
			return userEmailFound;
		}
		catch (SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				rs.close();
				preparedstmt.close();
				connection.close();	
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		return userEmailFound;
		
		
	}
	
	/**Method that insert a new user record in the database
	 * @param name
	 * @param surname
	 * @param username
	 * @param password
	 * @param on_screen_name
	 * @param email
	 */
	public static void sign_UP(String name, String surname, String username,String password, String on_screen_name, String email)
	{  
		System.out.println("DB: in sign_up");
		try
		{
			//connection with the database
			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);

			System.out.println("DB allias input : " + on_screen_name);

			//if on_screen_name (alias) not given from the user we create a default one based on his name and surname
			if (on_screen_name.equals(""))
			{
				System.out.println("DB allias2 input : " + on_screen_name);
				on_screen_name = name +" "+surname;
			}
			System.out.println("Inserting records into the table...");
			
			//encrypting user's password
			password = MD5.crypt(password);
			//creating sql query
			String insertQuery = "INSERT INTO users (name,surname,username,password,on_screen_name,email)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";
			//executing sql query
			preparedstmt = connection.prepareStatement(insertQuery);
			preparedstmt.setString(1, name);
			preparedstmt.setString(2, surname);
			preparedstmt.setString(3,username);
			preparedstmt.setString(4, password);
			preparedstmt.setString(5, on_screen_name);
			preparedstmt.setString(6, email);
			
			preparedstmt.executeUpdate();
		
		}
		catch(SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
	    }
		finally
		{
			try 
			{
				preparedstmt.close();
				connection.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	/**Method that when is called returns the emails of the developers of the system
	 * @return Set<String> emails
	 */
	public static Set<String> HelpSupport()
	{
		try
		{
			//connection with the above final fields
			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);
			
			//String to set the postgres query
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT email FROM developers");
			
			while(rs.next()){
				String devemail = rs.getString("email");
				developersEmail.add(devemail);
			}
			
			return developersEmail;
		}
		catch (SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		finally
		{
			try {
				connection.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return developersEmail;
		
	}
	
	/**Method that inserts a new chat record in the chat table and returns a String message if the
	 * insertion was succesfull or not. If the insertion was not succesfull it means that the chatPath
	 * given already exists in the database.
	 * @param chatName String
	 * @param chatPath String
	 * @param chatID int
	 * @return a String "OK" if the insertions was succesfull, "ER00" if not
	 */
	public static String createChats (String chatName, String chatPath, int chatID)
	{
		System.out.println("DB: IN signup_user");
		//true if chat found, false if not
		boolean fChat = findChat(chatPath);
		
		if (!fChat)
		{
			System.out.println("DB: calling void createChat");
			//if the chatpath does not exist in the database then we create the chat record
			createChat (chatName,chatPath,chatID);
			return "OK";
		}
		else
			//if the chatpath already exist return the error message
			return "ER00"; //"Chatpath already exist";
	}
	
	
	/**Method that inserts a new chat record in the chat table.
	 * This method is called only when the chatPath is unique.
	 * @param chatName String
	 * @param chatPath String
	 * @param chatID integer
	 */
	public static void createChat (String chatName, String chatPath, int chatID)
	{
		System.out.println("DB: in createChat");
		try
		{
			//connection with the database
			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);
      
			System.out.println("Inserting records into the table chats");
			
			//creating sql query
			String insertQuery = "INSERT INTO chats (chatid,chatname,chatpath)"
				+ " VALUES (?, ?, ?)";
		
			preparedstmt = connection.prepareStatement(insertQuery);
			preparedstmt.setInt(1, chatID);
			preparedstmt.setString(2, chatName);
			preparedstmt.setString(3, chatPath);
		
			//executing sql query
			preparedstmt.executeUpdate();
	
		}
		catch(SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				preparedstmt.close();
				connection.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}	
		
		}
	
	}
	
	/**Method that finds if the chatPath given already exists in the database
	 * @param chatPath String
	 * @return true if the chatPath exists in the database, false if not
	 */
	public static boolean findChat(String chatPath)
	{
		System.out.println("DB: in findChat");
		Boolean chatFound = true;
		String chat=null;
		
		try{
			//connection with the database
			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);
			
			//creating sql query
			String selectUser = "SELECT chatpath FROM chats WHERE chatpath = ?";
			preparedstmt = connection.prepareStatement(selectUser);
			preparedstmt.setString(1, chatPath);
			
			//executing sql query
			rs = preparedstmt.executeQuery();
			while(rs.next()){
				chat = rs.getString("chatpath");
			}
			if (chat==null)
			{
				chatFound = false;
			}
		
			return chatFound;
		}
		catch (SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				rs.close();
				preparedstmt.close();
				connection.close();	
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		return chatFound;
		
		
	}
//	public static Chat createChat(String chatName,String directory)
//	{  
//		Chat chat1 = new Chat();
//		try
//		{
//			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);
//	      
//			System.out.println("Inserting records into the table createChat");
//			
//			String insertQuery = "INSERT INTO chats (chatname)"
//					+ " VALUES (?)";
//			
//			preparedstmt = connection.prepareStatement(insertQuery);
//			preparedstmt.setString(1, chatName);
//			preparedstmt.executeUpdate();
//			
//			String selectChat = "SELECT chatname, ChatID FROM chats WHERE chatname = ?";
//			preparedstmt2 = connection.prepareStatement(selectChat);
//			preparedstmt2.setString(1, chatName);
//			
//			rs = preparedstmt.executeQuery();
//			while(rs.next()){
//				String chatn = rs.getString("chatname");
//				int chatID = rs.getInt("ChatID");
//				chat1 = new Chat(chatn,chatID);
//			}
//			
//			return chat1;
//		
//		}
//		catch(SQLException e)
//		{
//			System.out.println("Connection Failed! Check output console");
//			e.printStackTrace();
//	    }
//		finally
//		{
//			try 
//			{
//				preparedstmt.close();
//				preparedstmt2.close();
//				connection.close();
//			} 
//			catch (SQLException e) 
//			{
//				e.printStackTrace();
//			}
//			
//		}
//		return chat1;
//		
//	}
	

}
