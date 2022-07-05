package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import BMessenger_JDBC.MD5;
import pxv425.User;
import exs406.BelfastMessengerDB;;

public class TestBelfastMessengerDB 
{
	/** Test 1
	 * 
	 */
	@Test
	public void getUserTest1()
	{
		User expectedUser, resultUser;
		boolean result;
		expectedUser= new User("Marshall","Mathers","mxm72","171072","Eminem","eminem@yahoo.com");
		resultUser = BelfastMessengerDB.getUser("mxm72");
		result = resultUser.getFirstName().equals(expectedUser.getFirstName()) && resultUser.getLastName().equals(expectedUser.getLastName()) 
				 && resultUser.getUsername().equals(expectedUser.getUsername()) && resultUser.getPassword().equals(MD5.crypt(expectedUser.getPassword()))
				 && resultUser.getEmail().equals(expectedUser.getEmail());
		
		assertTrue(result);	
		
	}

	/** Test 2
	 * 
	 */
	@Test
	public void getUserTest2()
	{
		User expectedUser, resultUser;
		boolean result;
		expectedUser= new User("Oshea","Jackson","oxj69","150669","IceCube","iceyahoo.com");
		resultUser = BelfastMessengerDB.getUser("oxj69");
		result = resultUser.getFirstName().equals(expectedUser.getFirstName()) && resultUser.getLastName().equals(expectedUser.getLastName()) 
				 && resultUser.getUsername().equals(expectedUser.getUsername()) && resultUser.getPassword().equals(MD5.crypt(expectedUser.getPassword()))
				 && resultUser.getEmail().equals(expectedUser.getEmail());
		
		assertTrue(result);	
	}
	
	/** Test 3
	 * 
	 */
	@Test
	public void getUserTest3()
	{
		User expectedUser, resultUser;
		boolean result;
		expectedUser= new User("Andre","Young","axy65","180265","Dr.Dre","doctor@yahoo.com");
		resultUser = BelfastMessengerDB.getUser("axy65");
		result = resultUser.getFirstName().equals(expectedUser.getFirstName()) && resultUser.getLastName().equals(expectedUser.getLastName()) 
				 && resultUser.getUsername().equals(expectedUser.getUsername()) && resultUser.getPassword().equals(MD5.crypt(expectedUser.getPassword()))
				 && resultUser.getEmail().equals(expectedUser.getEmail());
		
		assertTrue(result);	
	}
	
	/** Test 4
	 * 
	 */
	@Test
	public void getUserTest4()
	{
		User expectedUser, resultUser;
		boolean result;
		expectedUser= new User("Calvin","Broadus","cxb71","201071","SnoopDogg","snoop@yahoo.com");
		resultUser = BelfastMessengerDB.getUser("cxb71");
		result = resultUser.getFirstName().equals(expectedUser.getFirstName()) && resultUser.getLastName().equals(expectedUser.getLastName()) 
				 && resultUser.getUsername().equals(expectedUser.getUsername()) && resultUser.getPassword().equals(MD5.crypt(expectedUser.getPassword()))
				 && resultUser.getEmail().equals(expectedUser.getEmail());
		
		assertTrue(result);	
	}
	
	/** Test 5
	 * 
	 */
	@Test
	public void getUserTest5()
	{
		User expectedUser, resultUser;
		boolean result;
		expectedUser= new User("Kanye","West","kxw77","080677","KanyeWest","kanye@yahoo.com");
		resultUser = BelfastMessengerDB.getUser("kxw77");
		result = resultUser.getFirstName().equals(expectedUser.getFirstName()) && resultUser.getLastName().equals(expectedUser.getLastName()) 
				 && resultUser.getUsername().equals(expectedUser.getUsername()) && resultUser.getPassword().equals(MD5.crypt(expectedUser.getPassword()))
				 && resultUser.getEmail().equals(expectedUser.getEmail());
		
		assertTrue(result);	
	}
	
	/** Test 6
	 * 
	 */
	@Test
	public void getUserTest6()
	{
		User expectedUser, resultUser;
		boolean result;
		expectedUser= new User("Todd","Smith","jxs68","140168","LLCoolJ","cool@yahoo.com");
		resultUser = BelfastMessengerDB.getUser("jxs68");
		result = resultUser.getFirstName().equals(expectedUser.getFirstName()) && resultUser.getLastName().equals(expectedUser.getLastName()) 
				 && resultUser.getUsername().equals(expectedUser.getUsername()) && resultUser.getPassword().equals(MD5.crypt(expectedUser.getPassword()))
				 && resultUser.getEmail().equals(expectedUser.getEmail());
		
		assertTrue(result);	
	}
	
	/** Test 1
	 *  Case : User that exist in the database
	 */
	@Test
	public void loginUserTest1()
	{
		String result;
		String expected;
		
		result = BelfastMessengerDB.loginUser("exs406","msc2015a");
		expected = "OK";
		
		assertEquals(expected,result);
	}
	
	/** Test 2
	 *  Case : User that exist in the database
	 */
	@Test
	public void loginUserTest2()
	{
		String result;
		String expected;
		
		result = BelfastMessengerDB.loginUser("mm","1");
		expected = "OK";
		
		assertEquals(expected,result);
	}
	
	/** Test 3
	 *  Case : username correct, password incorrect
	 */
	@Test
	public void loginUserTest3()
	{
		String result;
		String expected;
		
		result = BelfastMessengerDB.loginUser("exs406","fghsj");
		expected = "ER02";
		
		assertEquals(expected,result);
	}
	
	/** Test 4
	 *  Case : username correct, password incorrect
	 */
	@Test
	public void loginUserTest4()
	{
		String result;
		String expected;
		
		result = BelfastMessengerDB.loginUser("mm","34de");
		expected = "ER02";
		
		assertEquals(expected,result);
	}
	
	/** Test 5
	 *  Case : username does not exist in the database
	 */
	@Test
	public void loginUserTest5()
	{
		String result;
		String expected;
		
		result = BelfastMessengerDB.loginUser("drake10","mmm3");
		expected = "ER01";
		
		assertEquals(expected,result);
	}
	
	/** Test 6
	 *  Case : username does not exist in the database
	 */
	@Test
	public void loginUserTest6()
	{
		String result;
		String expected;
		
		result = BelfastMessengerDB.loginUser("kate32","doll5");
		expected = "ER01";
		
		assertEquals(expected,result);
	}
	
	
	/** Test 1
	 *  Case : Successfull signup 
	 *  NOte : This test can only run once because the user will be signed up.
	 */
	@Test
	public void signup_UserTest1()
	{
//		String result;
//		String expected;
//		
//		result = BelfastMessengerDB.signup_user("Stelios","Stylianou", "s_st", "s!22", "stelios", "stelios@gmail.com");
//		expected = "OK";
//		
//		assertEquals(expected,result);
	}
	
	/** Test 2
	 *  Case : Successfull signup 
	 *  NOte : This test can only run once because the user will be signed up.
	 * 
	 */
	@Test
	public void signup_UserTest2()
	{
//		String result;
//		String expected;
//		
//		result = BelfastMessengerDB.signup_user("Evrydiki","St", "evry85", "est", "", "evry@gmail.com");
//		expected = "OK";
//		
//		assertEquals(expected,result);
	}
	
	/** Test 3
	 *  Case : username already exist
	 */
	@Test
	public void signup_UserTest3()
	{
		String result;
		String expected;
		
		result = BelfastMessengerDB.signup_user("Eleonora","Michael", "exs406", "eeee", "", "elli@gmail.com");
		expected = "ER00";
		
		assertEquals(expected,result);
	}
	
	/** Test 4
	 *  Case : username already exist
	 */
	@Test
	public void signup_UserTest4()
	{
		String result;
		String expected;
		
		result = BelfastMessengerDB.signup_user("Eleonora","Michael", "mm", "eeee", "", "elli@gmail.com");
		expected = "ER00";
		
		assertEquals(expected,result);
	}
	
	/** Test 5
	 *  Case : Email already exists
	 */
	@Test
	public void signup_UserTest5()
	{
		String result;
		String expected;
		
		result = BelfastMessengerDB.signup_user("Markos","Michael", "erfgdf", "eeee", "", "maria@yahoo.com");
		expected = "ER01";
		
		assertEquals(expected,result);
	}
	
	/** Test 6
	 *  Case : Email already exists
	 */
	@Test
	public void signup_UserTest6()
	{
		String result;
		String expected;
		
		result = BelfastMessengerDB.signup_user("Marios","Pe", "marioulis2", "e23456eee", "", "pani.vak@outlook.com.gr");
		expected = "ER01";
		
		assertEquals(expected,result);
	}
	
	/** Test 7
	 *  Case: username and email already exist
	 */
	@Test
	public void signup_UserTest7()
	{
		String result;
		String expected;
		
		result = BelfastMessengerDB.signup_user("Eleonora","Michael", "mm", "eeee", "", "maria@yahoo.com");
		expected = "ER02";
		
		assertEquals(expected,result);
	}
	
	/** Test 8
	 *  Case: username and email already exist
	 */
	@Test
	public void signup_UserTest8()
	{
		String result;
		String expected;
		
		result = BelfastMessengerDB.signup_user("Marios","Pe", "pani169", "e23456eee", "", "pani.vak@outlook.com.gr");
		expected = "ER02";
		
		assertEquals(expected,result);
	}
	
	/** Test 1
	 *  Case : username exists
	 * 
	 */
	@Test
	public void findUserTest1()
	{
		boolean result = BelfastMessengerDB.findUser("mxm72");
		assertTrue(result);
	}
	
	/** Test 2
	 *  Case: username exists
	 * 
	 */
	@Test
	public void findUserTest2()
	{
		boolean result = BelfastMessengerDB.findUser("jxs68");
		assertTrue(result);
	}
	
	/** Test 3
	 *  Case: username does not exist
	 */
	@Test
	public void findUserTest3()
	{
		boolean result = BelfastMessengerDB.findUser("halaaa");
		assertFalse(result);
	}
	
	/** Test 4
	 *  Case: username does not exist
	 */
	@Test
	public void findUserTest4()
	{
		boolean result = BelfastMessengerDB.findUser("amman32");
		assertFalse(result);
	}
	
	/** Test 1
	 *  Case : email exists
	 */
	@Test
	public void findUserEmailTest1()
	{
		boolean result = BelfastMessengerDB.findUserEmail("cool@yahoo.com");
		assertTrue(result);
	}
	
	/** Test 2
	 *  Case : email exists
	 */
	@Test
	public void findUserEmailTest2()
	{
		boolean result = BelfastMessengerDB.findUserEmail("snoop@yahoo.com");
		assertTrue(result);
	}
	
	/** Test 3
	 *  Case : email does not exist
	 */
	@Test
	public void findUserEmailTest3()
	{
		boolean result = BelfastMessengerDB.findUserEmail("angel@hotmail.com");
		assertFalse(result);
	}
	
	/** Test 4
	 *  Case : email does not exist
	 */
	@Test
	public void findUserEmailTest4()
	{
		boolean result = BelfastMessengerDB.findUserEmail("katerinio87@outlook.com");
		assertFalse(result);
	}
	
	/** Test 1
	 *  Case: Testing developers
	 */
	@Test
	public void helpSupportTest1()
	{
		String expected = "[axd450@student.bham.ac.uk, exs406@student.bham.ac.uk, kxk432@student.bham.ac.uk, pxv425@student.bham.ac.uk]" ;
		String result = BelfastMessengerDB.HelpSupport().toString();
		
		assertEquals(expected,result);
	}
	
	/** Test 1
	 *  Case : Retrieve path that exists in the database
	 */
	@Test
	public void retrievePathTest1()
	{
		String result;
		String expected;
		
		result = BelfastMessengerDB.retrievePath("M");
		expected = "history/M.txt";
		
		assertEquals(expected,result);
	}
	
	/** Test 2
	 *  Case : Retrieve path that exists in the database
	 */
	@Test
	public void retrievePathTest2()
	{
		String result;
		String expected;
		
		result = BelfastMessengerDB.retrievePath("mm");
		expected = "history/mm.txt";
		
		assertEquals(expected,result);
	}
	
	/*idealy test 3 and test 4 are not needed because the path should be set when a user signs up by calling the addPath method
	  from the server */
	
	/** Test 3
	 *  Case : Retrieve path that does not exist in the database
	 */
	@Test
	public void retrievePathTest3()
	{
		String result;
		String expected;
		
		result = BelfastMessengerDB.retrievePath("es");
		expected = null;
		
		assertEquals(expected,result);
	}
	
	/** Test 4
	 *  Case : Retrieve path that does not exist in the database
	 */
	@Test
	public void retrievePathTest4()
	{
		String result;
		String expected;
		
		result = BelfastMessengerDB.retrievePath("pani169");
		expected = null;
		
		assertEquals(expected,result);
	}
	
	//Chat tests could not be implemented yet
	@Test
	public void createChatsTest1()
	{
		
	}
	
	
	
	@Test
	public void findChatTest1()
	{
		
	}
	
	
}
