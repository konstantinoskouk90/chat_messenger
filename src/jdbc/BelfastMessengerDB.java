package BMessenger_JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pxv425.User;

public class BelfastMessengerDB
{
	private static final String db_url = "jdbc:postgresql://dbteach2.cs.bham.ac.uk:5432/belfastmessenger";
	private static final String USER_db = "exs406";
	private static final String PASS_db = "elenass";
	
	static Connection connection = null;
	static PreparedStatement preparedstmt= null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	public static boolean findUser(String username)
	{
		Boolean userFound = true;
		String usern=null;
		
		try{
			
			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);
			
			String selectUser = "SELECT username, password FROM users WHERE username = ?";
			preparedstmt = connection.prepareStatement(selectUser);
			preparedstmt.setString(1, username);
			
			rs = preparedstmt.executeQuery();
			while(rs.next()){
				usern = rs.getString("username");
			}
			if (usern==null)
			{
				//System.out.println("User not found");
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
	
	public static boolean findUserEmail(String email)
	{ //check if email already exists
		Boolean userEmailFound = true;
		String useremail=null;
		
		try{
			
			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);
			
			String selectUser = "SELECT email FROM users WHERE email = ?";
			preparedstmt = connection.prepareStatement(selectUser);
			preparedstmt.setString(1, email);
			
			rs = preparedstmt.executeQuery();
			while(rs.next()){
				useremail = rs.getString("email");
			}
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
	
	//return user
	public static User getUser(String username)
	{
		User ruser = new User();
		try
		{
			
			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);
			
			String selectUser = "SELECT username,name,surname,password,on_screen_name,email FROM users WHERE username = ?";
			preparedstmt = connection.prepareStatement(selectUser);
			preparedstmt.setString(1, username);
			
			rs = preparedstmt.executeQuery();
			while(rs.next()){
				String usern = rs.getString("username");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String code = rs.getString("password");
				String on_screen_name = rs.getString("on_screen_name");
				String email =rs.getString("email");
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
	
	public static String loginUser(String username, String password)
	{
		String usern=null;
		String code=null;
		String usermessage ="OK";
		
		try{
			
			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);
			
			String selectUser = "SELECT username, password FROM users WHERE username = ?";
			preparedstmt = connection.prepareStatement(selectUser);
			preparedstmt.setString(1, username);
			
			rs = preparedstmt.executeQuery();
			while(rs.next()){
				usern = rs.getString("username");
				code = rs.getString("password");
				System.out.println(usern+" "+code);
			}
			if (!findUser(usern))
			{
				System.out.println("User not found");
				usermessage = "ER01";
			}
			else 
			{
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
	
	public static String signup_user (User user)
	{
		if (!findUser(user.getUsername()) && !findUserEmail(user.getEmail()))
		{
			sign_UP(user.getFirstName(),user.getLastName(),user.getUsername(),user.getPassword(),user.getOnScreenName(),user.getEmail());
			return "User inserted: "+loginUser(user.getUsername(),user.getPassword());
		}
		else if (findUser(user.getUsername()) && !findUserEmail(user.getEmail()))
			return "Username already exists";
		else if (!findUser(user.getUsername()) && findUserEmail(user.getEmail()))
			return "Email already exists";
		else
			return "Username and Email already exist";
	}
	
	public static void sign_UP(String name, String surname, String username,String password, String on_screen_name, String email)
	{ 
		try
		{
			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);
	      
			if (on_screen_name==null)
			{
				on_screen_name = name +" "+surname;
			}
			System.out.println("Inserting records into the table...");
			
			password = MD5.crypt(password);
			String insertQuery = "INSERT INTO users (name,surname,username,password,on_screen_name)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";
			
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

}
