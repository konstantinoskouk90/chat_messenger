package exs406;
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
	private static final String PASS_db = "elenass";
	
	public static void main(String args[]) 
	{
		//getUser("EXS406","msc2015a");
//		sign_UP("Marshall","Mathers","mxm72","171072","Eminem","eminem@yahoo.com");
//		sign_UP("Oshea","Jackson","oxj69","150669","IceCube","iceyahoo.com");
//		sign_UP("Andre","Young","axy65","180265","Dr.Dre","doctor@yahoo.com");
//		sign_UP("Calvin","Broadus","cxb71","201071","SnoopDogg","snoop@yahoo.com");
//		sign_UP("Kanye","West","kxw77","080677","KanyeWest","kanye@yahoo.com");
//		sign_UP("Todd","Smith","jxs68","140168","LLCoolJ","cool@yahoo.com");
		addPath("mm","history/mm.txt");
		testDatabase();
	}
	
	public static void addPath (String username, String path)
	{
		Connection connection = null;
		PreparedStatement preparedstmt= null;
		
		String db_url = "jdbc:postgresql://dbteach2.cs.bham.ac.uk:5432/belfastmessenger";
		String USER_db = "exs406";
		String PASS_db = "elenass";
		
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
				preparedstmt.close();
				connection.close();	
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
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
					"elenass");
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
				String path = rs.getString("chatpath");
				System.out.println(name+" "+surname+" "+usern+" "+code+" "+on_screen_name+" "+email+" "+path);
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
	
	public static void sign_UP(String name, String surname, String username,String password,String email)
	{

		Connection connection = null;
	//	Statement stmt = null;
		PreparedStatement preparedstmt= null;
		
		String on_screen_name = name+" "+surname;
		
		try
		{
			connection = DriverManager.getConnection(db_url,USER_db,PASS_db);
			
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
	
	
}

