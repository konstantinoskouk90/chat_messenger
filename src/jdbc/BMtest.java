package BMessenger_JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BMtest
{
	Connection connection = null;
	Statement stmt = null;
	PreparedStatement preparedstmt= null;
	
	private static final String db_url = "jdbc:postgresql://dbteach2.cs.bham.ac.uk:5432/belfastmessenger";
	private static final String USER_db = "exs406";
	private static final String PASS_db = "****";
	
	public static void main(String args[]) 
	{
		//getUser("EXS406","msc2015a");
		//sign_UP("Kostas","Koukourakis","kxk432","msc2015c");
		//sign_UP("Elena","Stylianou","exs406","msc2015a","elena","exs406@bham.uk");
		testDatabase();
	}
	
	public static void testDatabase()
	{
		//String username1 = "exs406";
		//String password1 = "msc2015a";
		Connection connection = null;
		Statement stmt = null;
		try{
			connection = DriverManager.getConnection("jdbc:postgresql://dbteach2.cs.bham.ac.uk:5432/belfastmessenger",
					"exs406",
					"*****");
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM users " );
			//ResultSet rs = stmt.executeQuery( "SELECT username,password FROM users WHERE username = "+username1+" AND password= "+MD5.crypt(password1)+";" );
			while(rs.next()){
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String usern = rs.getString("username");
				String code = rs.getString("password");
				String on_screen_name = rs.getString("on_screen_name");
				String email =rs.getString("email");
				Boolean isonline = rs.getBoolean("isonline");
				System.out.println(name+" "+surname+" "+usern+" "+code+" "+on_screen_name+" "+email+" "+isonline);
			}
			rs.close();
			stmt.close();
			connection.close();	
		}
		catch (SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
	}	
	
	public static void getUser(String username, String password)
	{
		Connection connection = null;
	//	Statement stmt = null;
		PreparedStatement preparedstmt= null;
		
		String usern=null;
		String code=null;
		try{
			
			connection = DriverManager.getConnection("jdbc:postgresql://dbteach2.cs.bham.ac.uk:5432/belfastmessenger",
					"exs406",
					"elenas");
			
			String selectUser = "SELECT * FROM users WHERE username = ?";
			preparedstmt = connection.prepareStatement(selectUser);
			preparedstmt.setString(1, username);
			
			ResultSet rs = preparedstmt.executeQuery();
			while(rs.next()){
				usern = rs.getString("username");
				code = rs.getString("password");
				System.out.println(usern+" "+code);
			}
			if (usern==null)
			{
				System.out.println("User not found");
			}
			else if (!(MD5.crypt(password).equals(code)))
			{
				System.out.println(MD5.crypt(password));
				System.out.println("Incorrect password");
			}
			rs.close();
			preparedstmt.close();
			connection.close();	
		}
		catch (SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
	}
	
	public static void sign_UP(String name, String surname, String username,String password, String on_screen_name,String email)
	{

		Connection connection = null;
	//	Statement stmt = null;
		PreparedStatement preparedstmt= null;
		
		try
		{
			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);
	      
			System.out.println("Inserting records into the table...");
			//stmt = connection.createStatement();
			
			password = MD5.crypt(password);
			String insertQuery = "INSERT INTO users (name,surname,username,password,on_screen_name,email)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";
			
			preparedstmt = connection.prepareStatement(insertQuery);
			preparedstmt.setString(1, name);
			preparedstmt.setString(2, surname);
			preparedstmt.setString(3,username);
			preparedstmt.setString(4, password);
			preparedstmt.setString(5, on_screen_name);
			preparedstmt.setString(6, email);
			preparedstmt.executeUpdate();
			
			preparedstmt.close();
			connection.close();

		}
		catch(SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
	    }
		
	}
	
	public static void sign_UP(String name, String surname, String username,String password)
	{

		Connection connection = null;
	//	Statement stmt = null;
		PreparedStatement preparedstmt= null;
		
		String on_screen_name = name+" "+surname;
		
		try
		{
			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);
			
			password = MD5.crypt(password);
			String insertQuery = "INSERT INTO users (name,surname,username,password,on_screen_name)"
					+ " VALUES (?, ?, ?, ?, ?)";
			
			preparedstmt = connection.prepareStatement(insertQuery);
			preparedstmt.setString(1, name);
			preparedstmt.setString(2, surname);
			preparedstmt.setString(3,username);
			preparedstmt.setString(4, password);
			preparedstmt.setString(5, on_screen_name);
			preparedstmt.executeUpdate();
			preparedstmt.close();
			connection.close();

		}
		catch(SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
	    }
	}
	
	
}

