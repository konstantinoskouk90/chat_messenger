package Tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import pxv425.Client;
import pxv425.User;
import gui.LoginModel;
import gui.SignUpModel;
import gui.SignUpView;

/**
 * This class contains the JUnit tests for the Client class
 * 
 * @author pxv425
 * @version 2015-03-22
 *
 */
public class TestClient {
	

	@Test
	/**
	 * Test login method with username and password filled and correct
	 */
	public void loginTest1(){
		LoginModel loginModel = new LoginModel();
		String username = "ab" ;
		char[] password = {'a','b'};
		loginModel.setUsername(username);
		loginModel.setPassword(password);
		Client client = new Client();
		try {
			client.login(loginModel);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String expected = "OK";
		String result = client.getMessageToGui();
		
		assertEquals(expected, result);
	}
	
	@Test
	/**
	 * Test login method with unfilled username and filled password
	 */
	public void loginTest2(){
		LoginModel loginModel = new LoginModel();
		String username = "";
		char[] password = {'3','2','3','2'};
		loginModel.setUsername(username);
		loginModel.setPassword(password);
		Client client = new Client();
		try {
			client.login(loginModel);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String expected = "Insert Username!";
		String result = client.getMessageToGui();
		
		assertEquals(expected, result);
	}
	
	@Test
	/**
	 * Test login method with filled username and unfilled password
	 */
	public void loginTest3(){
		LoginModel loginModel = new LoginModel();
		String username = "pani169";
		char[] password = {};
		loginModel.setUsername(username);
		loginModel.setPassword(password);
		Client client = new Client();
		try {
			client.login(loginModel);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String expected = "Insert Password!";
		String result = client.getMessageToGui();
		
		assertEquals(expected, result);
	}
	
	@Test
	/**
	 * Test login method with a username which does not exist
	 */
	public void loginTest4(){
		LoginModel loginModel = new LoginModel();
		//This user does not exist
		String username = "abcdefg" ;
		char[] password = {'3','2','3','2'};
		loginModel.setUsername(username);
		loginModel.setPassword(password);
		Client client = new Client();
		try {
			client.login(loginModel);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String expected = "User not found!";
		String result = client.getMessageToGui();
		
		assertEquals(expected, result);
	}
	
	@Test
	/**
	 * Test login method with a wrong password
	 */
	public void loginTest5(){
		LoginModel loginModel = new LoginModel();
		String username = "pani169";
		char[] password = {'3','3','3','3'};
		loginModel.setUsername(username);
		loginModel.setPassword(password);
		Client client = new Client();
		try {
			client.login(loginModel);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String expected = "Incorrect Password!";
		String result = client.getMessageToGui();
		
		assertEquals(expected, result);
	}
	
	@Test
	/**
	 * Test login method with a username which does not exists and unfilled password
	 */
	public void loginTest6(){
		LoginModel loginModel = new LoginModel();
		String username = "abcdefg";
		char[] password = {};
		loginModel.setUsername(username);
		loginModel.setPassword(password);
		Client client = new Client();
		try {
			client.login(loginModel);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String expected = "Insert Password!";
		String result = client.getMessageToGui();
		
		assertEquals(expected, result);
	}
	
	@Test
	/**
	 * Test login method with unfilled username and a wrong password
	 */
	public void loginTest7(){
		LoginModel loginModel = new LoginModel();
		String username = "";
		char[] password = {'3','3','3','3'};
		loginModel.setUsername(username);
		loginModel.setPassword(password);
		Client client = new Client();
		try {
			client.login(loginModel);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String expected = "Insert Username!";
		String result = client.getMessageToGui();
		
		assertEquals(expected, result);
	}
	
	@Test
	/**
	 * Test login method with a username which is already connected
	 */
	public void loginTest8(){
		//User logs in for the first time
		LoginModel loginModel1 = new LoginModel();
		String username1 = "pani169";
		char[] password1 = {'3','2','3','2'};
		loginModel1.setUsername(username1);
		loginModel1.setPassword(password1);
		Client client1 = new Client();
		try {
			client1.login(loginModel1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//User tries to log in again while he is already connected
		LoginModel loginModel2 = new LoginModel();
		String username2 = "pani169";
		char[] password2 = {'3','2','3','2'};
		loginModel1.setUsername(username2);
		loginModel1.setPassword(password2);
		Client client2 = new Client();
		try {
			client2.login(loginModel1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String expected = "Already connected from other PC!";
		String result = client2.getMessageToGui();
		
		assertEquals(expected, result);
	}
	
//	@Test
//	/**
//	 * Test signUp method when all the fields are not filled
//	 */
//	public void signUpTest1(){
//		SignUpModel signUpModel = new SignUpModel();
//		char[] firstName = {};
//		char[] lastName = {};
//		char[] userName = {};
//		char[] password = {};
//		char[] confirmPassword = {};
//		char[] alias = {};
//		char[] email = {};
//		char[] confirmEmail = {};
//		
//		signUpModel.setFirstname(firstName);
//		signUpModel.setLastname(lastName);
//		signUpModel.setUsername(userName);
//		signUpModel.setPassword(password);
//		signUpModel.setConfirmPassword(confirmPassword);
//		signUpModel.setAlias(alias);
//		signUpModel.setEmail(email);
//		signUpModel.setConfirmEmail(confirmEmail);
//
//		Client client = new Client();
//		Client client2 = new Client(new User());
//		client.changePanel(new SignUpView(client,signUpModel));
//		
//		try {
//			client2.signUp(signUpModel);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		String expected = "Empty mandatory field in sign up form!";
//		String result = client2.getMessageToGui2();
//		
//		assertEquals(expected, result);
//	}
}
