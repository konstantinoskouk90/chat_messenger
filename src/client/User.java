package pxv425;

import java.util.Observable;

public class User implements java.io.Serializable{

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String onScreenName;
	private String email;
	
	/** empty constructor
	 * 
	 */
	public User()
	{
		
	}
	/**
	 * Constructor for registered users
	 * 
	 * @param String username
	 * @param String password
	 * 
	 * @author pxv425
	 * @version 2015-03-03
	 */
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Constructor for new users
	 * 
	 * @param String firstName
	 * @param String lastName
	 * @param String username
	 * @param String password
	 * @param String onScreenName
	 * @param String email
	 * 
	 * @author pxv425
	 * @version 2015-03-03
	 */
	public User(String firstName, String lastName, String username, String password, String onScreenName, String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.onScreenName = onScreenName;
		this.email = email;
	}

	/**
	 * @return email
	 * 
	 * @author pxv425
	 * @version 2015-03-03
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param String email
	 * 
	 * @author pxv425
	 * @version 2015-03-03
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return first name
	 * 
	 * @author pxv425
	 * @version 2015-03-03
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param String first Name
	 * 
	 * @author pxv425
	 * @version 2015-03-03
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return last name
	 * 
	 * @author pxv425
	 * @version 2015-03-03
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param String last Name
	 * 
	 * @author pxv425
	 * @version 2015-03-03
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return username
	 * 
	 * @author pxv425
	 * @version 2015-03-03
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param String username
	 * 
	 * @author pxv425
	 * @version 2015-03-03
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * @return password
	 * 
	 * @author pxv425
	 * @version 2015-03-03
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param String password
	 * 
	 * @author pxv425
	 * @version 2015-03-03
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return on screen name
	 * 
	 * @author pxv425
	 * @version 2015-03-03
	 */
	public String getOnScreenName() {
		return onScreenName;
	}

	/**
	 * 
	 * @param String onScreenName
	 * 
	 * @author pxv425
	 * @version 2015-03-03
	 */
	public void setOnScreenName(String onScreenName) {
		this.onScreenName = onScreenName;
	}



	
	@Override
	public String toString(){
		return "First name: " + getFirstName() + ", Last name: " + getLastName() + ", usernane: " + getUsername() + ", password: " + getPassword() + ", onscreen name: " + getOnScreenName() + ", email: " + getEmail();
	}
}