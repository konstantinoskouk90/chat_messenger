package Tests;

import static org.junit.Assert.*;
import gui.SignUpModel;
import org.junit.Test;

public class SignUpModelJUnitTests {

	private SignUpModel signUpModel;
	
	/** Test 1 (for both getters and setters)
	 *  Case : First name that exists in the database
	 */
	@Test
	public void firstnameTest1() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test1 = {'M','a','r','s','h','a','l','l'};
		signUpModel.setFirstname(test1);
		result = signUpModel.getFirstname();
		expected = "Marshall";
		
		assertEquals(expected,result);
	}
	
	/** Test 2 (for both getters and setters)
	 *  Case : First name that exists in the database
	 */
	@Test
	public void firstnameTest2() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test2 = {'O','S','h','e','a'};
		signUpModel.setFirstname(test2);
		result = signUpModel.getFirstname();
		expected = "OShea";
		
		assertEquals(expected,result);
	}
	
	/** Test 3 (for both getters and setters)
	 *  Case : First name that exists in the database
	 */
	@Test
	public void firstnameTest3() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test3 = {'A','n','d','r','e'};
		signUpModel.setFirstname(test3);
		result = signUpModel.getFirstname();
		expected = "Andre";
		
		assertEquals(expected,result);
	}
	
	/** Test 4 (for both getters and setters)
	 *  Case : First name that exists in the database
	 */
	@Test
	public void firstnameTest4() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test4 = {'C','a','l','v','i','n'};
		signUpModel.setFirstname(test4);
		result = signUpModel.getFirstname();
		expected = "Calvin";
		
		assertEquals(expected,result);
	}
	
	/** Test 5 (for both getters and setters)
	 *  Case : First name that exists in the database
	 */
	@Test
	public void firstnameTest5() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test5 = {'K','a','n','y','e'};
		signUpModel.setFirstname(test5);
		result = signUpModel.getFirstname();
		expected = "Kanye";
		
		assertEquals(expected,result);
	}
	
	/** Test 6 (for both getters and setters)
	 *  Case : First name that exists in the database
	 */
	@Test
	public void firstnameTest6() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test6 = {'T','o','d','d'};
		signUpModel.setFirstname(test6);
		result = signUpModel.getFirstname();
		expected = "Todd";
		
		assertEquals(expected,result);
	}
	
	/** Test 1 (for both getters and setters)
	 *  Case : Last name that exists in the database
	 */
	@Test
	public void lastnameTest1() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test1 = {'M','a','t','h','e','r','s'};
		signUpModel.setLastname(test1);
		result = signUpModel.getLastname();
		expected = "Mathers";
		
		assertEquals(expected,result);
	}
	
	/** Test 2 (for both getters and setters)
	 *  Case : Last name that exists in the database
	 */
	@Test
	public void lastnameTest2() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test2 = {'J','a','c','k','s','o','n'};
		signUpModel.setLastname(test2);
		result = signUpModel.getLastname();
		expected = "Jackson";
		
		assertEquals(expected,result);
	}
	
	/** Test 3 (for both getters and setters)
	 *  Case : Last name that exists in the database
	 */
	@Test
	public void lastnameTest3() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test3 = {'Y','o','u','n','g'};
		signUpModel.setLastname(test3);
		result = signUpModel.getLastname();
		expected = "Young";
		
		assertEquals(expected,result);
	}
	
	/** Test 4 (for both getters and setters)
	 *  Case : Last name that exists in the database
	 */
	@Test
	public void lastnameTest4() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test4 = {'B','r','o','a','d','u','s'};
		signUpModel.setLastname(test4);
		result = signUpModel.getLastname();
		expected = "Broadus";
		
		assertEquals(expected,result);
	}
	
	/** Test 5 (for both getters and setters)
	 *  Case : Last name that exists in the database
	 */
	@Test
	public void lastnameTest5() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test5 = {'W','e','s','t'};
		signUpModel.setLastname(test5);
		result = signUpModel.getLastname();
		expected = "West";
		
		assertEquals(expected,result);
	}
	
	/** Test 6 (for both getters and setters)
	 *  Case : Last name that exists in the database
	 */
	@Test
	public void lastnameTest6() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test6 = {'S','m','i','t','h'};
		signUpModel.setLastname(test6);
		result = signUpModel.getLastname();
		expected = "Smith";
		
		assertEquals(expected,result);
	}
	
	/** Test 1 (for both getters and setters)
	 *  Case : Alias that exists in the database
	 */
	@Test
	public void aliasTest1() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test1 = {'E','m','i','n','e','m'};
		signUpModel.setAlias(test1);
		result = signUpModel.getAlias();
		expected = "Eminem";
		
		assertEquals(expected,result);
	}
	
	/** Test 2 (for both getters and setters)
	 *  Case : Alias that exists in the database
	 */
	@Test
	public void aliasTest2() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test2 = {'I','c','e','C','u','b','e'};
		signUpModel.setAlias(test2);
		result = signUpModel.getAlias();
		expected = "IceCube";
		
		assertEquals(expected,result);
	}
	
	/** Test 3 (for both getters and setters)
	 *  Case : Alias that exists in the database
	 */
	@Test
	public void aliasTest3() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test3 = {'D','r','.','D','r','e'};
		signUpModel.setAlias(test3);
		result = signUpModel.getAlias();
		expected = "Dr.Dre";
		
		assertEquals(expected,result);
	}
	
	/** Test 4 (for both getters and setters)
	 *  Case : Alias that exists in the database
	 */
	@Test
	public void aliasTest4() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test4 = {'S','n','o','o','p','D','o','g','g'};
		signUpModel.setAlias(test4);
		result = signUpModel.getAlias();
		expected = "SnoopDogg";
		
		assertEquals(expected,result);
	}
	
	/** Test 5 (for both getters and setters)
	 *  Case : Alias that exists in the database
	 */
	@Test
	public void aliasTest5() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test5 = {'K','a','n','y','e','W','e','s','t'};
		signUpModel.setAlias(test5);
		result = signUpModel.getAlias();
		expected = "KanyeWest";
		
		assertEquals(expected,result);
	}
	
	/** Test 6 (for both getters and setters)
	 *  Case : Alias that exists in the database
	 */
	@Test
	public void aliasTest6() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test6 = {'L','L','C','o','o','l','J'};
		signUpModel.setAlias(test6);
		result = signUpModel.getAlias();
		expected = "LLCoolJ";
		
		assertEquals(expected,result);
	}

	/** Test 1 (for both getters and setters)
	 *  Case : Username that exists in the database
	 */
	@Test
	public void usernameTest1() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test1 = {'m','x','m','7','2'};
		signUpModel.setUsername(test1);
		result = signUpModel.getUsername();
		expected = "mxm72";
		
		assertEquals(expected,result);
	}
	
	/** Test 2 (for both getters and setters)
	 *  Case : Username that exists in the database
	 */
	@Test
	public void usernameTest2() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test2 = {'o','x','j','6','9'};
		signUpModel.setUsername(test2);
		result = signUpModel.getUsername();
		expected = "oxj69";
		
		assertEquals(expected,result);
	}
	
	/** Test 3 (for both getters and setters)
	 *  Case : Username that exists in the database
	 */
	@Test
	public void usernameTest3() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test3 = {'a','x','y','6','5'};
		signUpModel.setUsername(test3);
		result = signUpModel.getUsername();
		expected = "axy65";
		
		assertEquals(expected,result);
	}
	
	/** Test 4 (for both getters and setters)
	 *  Case : Username that exists in the database
	 */
	@Test
	public void usernameTest4() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test4 = {'c','x','b','7','1'};
		signUpModel.setUsername(test4);
		result = signUpModel.getUsername();
		expected = "cxb71";
		
		assertEquals(expected,result);
	}
	
	/** Test 5 (for both getters and setters)
	 *  Case : Username that exists in the database
	 */
	@Test
	public void usernameTest5() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test5 = {'k','x','w','7','7'};
		signUpModel.setUsername(test5);
		result = signUpModel.getUsername();
		expected = "kxw77";
		
		assertEquals(expected,result);
	}
	
	/** Test 6 (for both getters and setters)
	 *  Case : Username that exists in the database
	 */
	@Test
	public void usernameTest6() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test6 = {'j','x','s','6','8'};
		signUpModel.setUsername(test6);
		result = signUpModel.getUsername();
		expected = "jxs68";
		
		assertEquals(expected,result);
	}
	
	/** Test 1 (for both getters and setters)
	 *  Case : Password that exists in the database
	 */
	@Test
	public void passwordTest1() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test1 = {'1','7','1','0','7','2'};
		signUpModel.setPassword(test1);
		result = signUpModel.getPassword();
		expected = "171072";
		
		assertEquals(expected,result);
	}
	
	/** Test 2 (for both getters and setters)
	 *  Case : Password that exists in the database
	 */
	@Test
	public void passwordTest2() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test2 = {'1','5','0','6','6','9'};
		signUpModel.setPassword(test2);
		result = signUpModel.getPassword();
		expected = "150669";
		
		assertEquals(expected,result);
	}
	
	/** Test 3 (for both getters and setters)
	 *  Case : Password that exists in the database
	 */
	@Test
	public void passwordTest3() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test3 = {'1','8','0','2','6','5'};
		signUpModel.setPassword(test3);
		result = signUpModel.getPassword();
		expected = "180265";
		
		assertEquals(expected,result);
	}
	
	/** Test 4 (for both getters and setters)
	 *  Case : Password that exists in the database
	 */
	@Test
	public void passwordTest4() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test4 = {'2','0','1','0','7','1'};
		signUpModel.setPassword(test4);
		result = signUpModel.getPassword();
		expected = "201071";
		
		assertEquals(expected,result);
	}
	
	/** Test 5 (for both getters and setters)
	 *  Case : Password that exists in the database
	 */
	@Test
	public void passwordTest5() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test5 = {'0','8','0','6','7','7'};
		signUpModel.setPassword(test5);
		result = signUpModel.getPassword();
		expected = "080677";
		
		assertEquals(expected,result);
	}
	
	/** Test 6 (for both getters and setters)
	 *  Case : Password that exists in the database
	 */
	@Test
	public void passwordTest6() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test6 = {'1','4','0','1','6','8'};
		signUpModel.setPassword(test6);
		result = signUpModel.getPassword();
		expected = "140168";
		
		assertEquals(expected,result);
	}
	
	/** Test 1 (for both getters and setters)
	 *  Case : Password that exists in the database
	 */
	@Test
	public void confirmPasswordTest1() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test1 = {'1','7','1','0','7','2'};
		signUpModel.setConfirmPassword(test1);
		result = signUpModel.getConfirmPassword();
		expected = "171072";
		
		assertEquals(expected,result);
	}
	
	/** Test 2 (for both getters and setters)
	 *  Case : Password that exists in the database
	 */
	@Test
	public void confirmPasswordTest2() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test2 = {'1','5','0','6','6','9'};
		signUpModel.setConfirmPassword(test2);
		result = signUpModel.getConfirmPassword();
		expected = "150669";
		
		assertEquals(expected,result);
	}
	
	/** Test 3 (for both getters and setters)
	 *  Case : Password that exists in the database
	 */
	@Test
	public void confirmPasswordTest3() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test3 = {'1','8','0','2','6','5'};
		signUpModel.setConfirmPassword(test3);
		result = signUpModel.getConfirmPassword();
		expected = "180265";
		
		assertEquals(expected,result);
	}
	
	/** Test 4 (for both getters and setters)
	 *  Case : Password that exists in the database
	 */
	@Test
	public void confirmPasswordTest4() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test4 = {'2','0','1','0','7','1'};
		signUpModel.setConfirmPassword(test4);
		result = signUpModel.getConfirmPassword();
		expected = "201071";
		
		assertEquals(expected,result);
	}
	
	/** Test 5 (for both getters and setters)
	 *  Case : Password that exists in the database
	 */
	@Test
	public void confirmPasswordTest5() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test5 = {'0','8','0','6','7','7'};
		signUpModel.setConfirmPassword(test5);
		result = signUpModel.getConfirmPassword();
		expected = "080677";
		
		assertEquals(expected,result);
	}
	
	/** Test 6 (for both getters and setters)
	 *  Case : Password that exists in the database
	 */
	@Test
	public void confirmPasswordTest6() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test6 = {'1','4','0','1','6','8'};
		signUpModel.setConfirmPassword(test6);
		result = signUpModel.getConfirmPassword();
		expected = "140168";
		
		assertEquals(expected,result);
	}
	
	/** Test 1 (for both getters and setters)
	 *  Case : Email that exists in the database
	 */
	@Test
	public void emailTest1() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test1 = {'e','m','i','n','e','m','@','y','a','h','o','o','.','c','o','m'};
		signUpModel.setEmail(test1);
		result = signUpModel.getEmail();
		expected = "eminem@yahoo.com";
		
		assertEquals(expected,result);
	}
	
	/** Test 2 (for both getters and setters)
	 *  Case : Email that exists in the database
	 */
	@Test
	public void emailTest2() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test2 = {'i','c','e','@','y','a','h','o','o','.','c','o','m'};
		signUpModel.setEmail(test2);
		result = signUpModel.getEmail();
		expected = "ice@yahoo.com";
		
		assertEquals(expected,result);
	}
	
	/** Test 3 (for both getters and setters)
	 *  Case : Email that exists in the database
	 */
	@Test
	public void emailTest3() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test3 = {'d','o','c','t','o','r','@','y','a','h','o','o','.','c','o','m'};
		signUpModel.setEmail(test3);
		result = signUpModel.getEmail();
		expected = "doctor@yahoo.com";
		
		assertEquals(expected,result);
	}
	
	/** Test 4 (for both getters and setters)
	 *  Case : Email that exists in the database
	 */
	@Test
	public void emailTest4() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test4 = {'s','n','o','o','p','@','y','a','h','o','o','.','c','o','m'};
		signUpModel.setEmail(test4);
		result = signUpModel.getEmail();
		expected = "snoop@yahoo.com";
		
		assertEquals(expected,result);
	}
	
	/** Test 5 (for both getters and setters)
	 *  Case : Email that exists in the database
	 */
	@Test
	public void emailTest5() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test5 = {'k','a','n','y','e','@','y','a','h','o','o','.','c','o','m'};
		signUpModel.setEmail(test5);
		result = signUpModel.getEmail();
		expected = "kanye@yahoo.com";
		
		assertEquals(expected,result);
	}
	
	/** Test 6 (for both getters and setters)
	 *  Case : Email that exists in the database
	 */
	@Test
	public void emailTest6() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test6 = {'c','o','o','l','@','y','a','h','o','o','.','c','o','m'};
		signUpModel.setEmail(test6);
		result = signUpModel.getEmail();
		expected = "cool@yahoo.com";
		
		assertEquals(expected,result);
	}
	
	/** Test 1 (for both getters and setters)
	 *  Case : Email that exists in the database
	 */
	@Test
	public void confirmEmailTest1() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test1 = {'e','m','i','n','e','m','@','y','a','h','o','o','.','c','o','m'};
		signUpModel.setConfirmEmail(test1);
		result = signUpModel.getConfirmEmail();
		expected = "eminem@yahoo.com";
		
		assertEquals(expected,result);
	}
	
	/** Test 2 (for both getters and setters)
	 *  Case : Email that exists in the database
	 */
	@Test
	public void confirmEmailTest2() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test2 = {'i','c','e','@','y','a','h','o','o','.','c','o','m'};
		signUpModel.setConfirmEmail(test2);
		result = signUpModel.getConfirmEmail();
		expected = "ice@yahoo.com";
		
		assertEquals(expected,result);
	}
	
	/** Test 3 (for both getters and setters)
	 *  Case : Email that exists in the database
	 */
	@Test
	public void confirmEmailTest3() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test3 = {'d','o','c','t','o','r','@','y','a','h','o','o','.','c','o','m'};
		signUpModel.setConfirmEmail(test3);
		result = signUpModel.getConfirmEmail();
		expected = "doctor@yahoo.com";
		
		assertEquals(expected,result);
	}
	
	/** Test 4 (for both getters and setters)
	 *  Case : Email that exists in the database
	 */
	@Test
	public void confirmEmailTest4() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test4 = {'s','n','o','o','p','@','y','a','h','o','o','.','c','o','m'};
		signUpModel.setConfirmEmail(test4);
		result = signUpModel.getConfirmEmail();
		expected = "snoop@yahoo.com";
		
		assertEquals(expected,result);
	}
	
	/** Test 5 (for both getters and setters)
	 *  Case : Email that exists in the database
	 */
	@Test
	public void confirmEmailTest5() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test5 = {'k','a','n','y','e','@','y','a','h','o','o','.','c','o','m'};
		signUpModel.setConfirmEmail(test5);
		result = signUpModel.getConfirmEmail();
		expected = "kanye@yahoo.com";
		
		assertEquals(expected,result);
	}
	
	/** Test 6 (for both getters and setters)
	 *  Case : Email that exists in the database
	 */
	@Test
	public void confirmEmailTest6() {
		
		signUpModel = new SignUpModel();
		
		String result;
		String expected;
		
		char[] test6 = {'c','o','o','l','@','y','a','h','o','o','.','c','o','m'};
		signUpModel.setConfirmEmail(test6);
		result = signUpModel.getConfirmEmail();
		expected = "cool@yahoo.com";
		
		assertEquals(expected,result);
	}
}