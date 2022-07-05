package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import gui.LoginModel;

public class LoginModelJUnitTests {
	
	private LoginModel loginModel;

	/** Test 1 (for both getters and setters)
	 *  Case : Username that exists in the database
	 */
	@Test
	public void usernameTest1() {
		
		loginModel = new LoginModel();
		
		String result;
		String expected;
		
		String test1 = "mxm72";
		loginModel.setUsername(test1);
		result = loginModel.getUsername();
		expected = "mxm72";
		
		assertEquals(expected,result);
	}
	
	/** Test 2 (for both getters and setters)
	 *  Case : Username that exists in the database
	 */
	@Test
	public void usernameTest2() {
		
		loginModel = new LoginModel();
		
		String result;
		String expected;
		
		String test2 = "oxj69";
		loginModel.setUsername(test2);
		result = loginModel.getUsername();
		expected = "oxj69";
		
		assertEquals(expected,result);
	}
	
	/** Test 3 (for both getters and setters)
	 *  Case : Username that exists in the database
	 */
	@Test
	public void usernameTest3() {
		
		loginModel = new LoginModel();
		
		String result;
		String expected;
		
		String test3 = "axy65";
		loginModel.setUsername(test3);
		result = loginModel.getUsername();
		expected = "axy65";
		
		assertEquals(expected,result);
	}
	
	/** Test 4 (for both getters and setters)
	 *  Case : Username that exists in the database
	 */
	@Test
	public void usernameTest4() {
		
		loginModel = new LoginModel();
		
		String result;
		String expected;

		String test4 = "cxb71";
		loginModel.setUsername(test4);
		result = loginModel.getUsername();
		expected = "cxb71";
		
		assertEquals(expected,result);
	}
	
	/** Test 5 (for both getters and setters)
	 *  Case : Username that exists in the database
	 */
	@Test
	public void usernameTest5() {
		
		loginModel = new LoginModel();
		
		String result;
		String expected;

		String test5 = "kxw77";
		loginModel.setUsername(test5);
		result = loginModel.getUsername();
		expected = "kxw77";
		
		assertEquals(expected,result);
	}
	
	/** Test 6 (for both getters and setters)
	 *  Case : Username that exists in the database
	 */
	@Test
	public void usernameTest6() {
		
		loginModel = new LoginModel();
		
		String result;
		String expected;

		String test6 = "jxs68";
		loginModel.setUsername(test6);
		result = loginModel.getUsername();
		expected = "jxs68";
		
		assertEquals(expected,result);
	}
	
	/** Test 1 (for both getters and setters)
	 *  Case : Password that exists in the database
	 */
	@Test
	public void passwordTest1() {
		
		loginModel = new LoginModel();
		
		String result;
		String expected;

		String test1 = "171072";
		loginModel.setUsername(test1);
		result = loginModel.getUsername();
		expected = "171072";
		
		assertEquals(expected,result);
	}
	
	/** Test 2 (for both getters and setters)
	 *  Case : Password that exists in the database
	 */
	@Test
	public void passwordTest2() {
		
		loginModel = new LoginModel();
		
		String result;
		String expected;

		String test2 = "150669";
		loginModel.setUsername(test2);
		result = loginModel.getUsername();
		expected = "150669";
		
		assertEquals(expected,result);
	}
	
	/** Test 3 (for both getters and setters)
	 *  Case : Password that exists in the database
	 */
	@Test
	public void passwordTest3() {
		
		loginModel = new LoginModel();
		
		String result;
		String expected;

		String test3 = "180265";
		loginModel.setUsername(test3);
		result = loginModel.getUsername();
		expected = "180265";
		
		assertEquals(expected,result);
	}
	
	/** Test 4 (for both getters and setters)
	 *  Case : Password that exists in the database
	 */
	@Test
	public void passwordTest4() {
		
		loginModel = new LoginModel();
		
		String result;
		String expected;

		String test4 = "201071";
		loginModel.setUsername(test4);
		result = loginModel.getUsername();
		expected = "201071";
		
		assertEquals(expected,result);
	}
	
	/** Test 5 (for both getters and setters)
	 *  Case : Password that exists in the database
	 */
	@Test
	public void passwordTest5() {
		
		loginModel = new LoginModel();
		
		String result;
		String expected;

		String test5 = "080677";
		loginModel.setUsername(test5);
		result = loginModel.getUsername();
		expected = "080677";
		
		assertEquals(expected,result);
	}
	
	/** Test 6 (for both getters and setters)
	 *  Case : Password that exists in the database
	 */
	@Test
	public void passwordTest6() {
		
		loginModel = new LoginModel();
		
		String result;
		String expected;

		String test6 = "140168" ;
		loginModel.setUsername(test6);
		result = loginModel.getUsername();
		expected = "140168";
		
		assertEquals(expected,result);
	}
}