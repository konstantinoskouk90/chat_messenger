package gui;

/**
 * public model class for the program's login
 * screen, that contains getter and setter methods
 * for the user's username and password fields
 * 
 * @author kxk432
 */
public class LoginModel implements java.io.Serializable {

	/*
	 * initialize private variables
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

//	public void setUsername(char[] username) {
//		// convert char[] to String
//		this.username = String.valueOf(username);
//	}
	
	public void setUsername (String username)
	{
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		// convert char[] to String
		this.password = String.valueOf(password);
	}
}