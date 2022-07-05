package gui;

/**
 * public model class for the program's sign up screen,
 * that contains getter and setter methods for the user's
 * first and last name, alias, username, password, confirm
 * password, email and confirm email fields
 * 
 * @author kxk432
 */
public class SignUpModel implements java.io.Serializable {

	/*
	 * initialize private variables
	 */
	private static final long serialVersionUID = 1L;
	private String firstname;
	private String lastname;
	private String alias;
	private String username;
	private String password;
	private String confirmPassword;
	private String email;
	private String confirmEmail;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(char[] firstname) {
		// convert char[] to String
		this.firstname = String.valueOf(firstname);
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(char[] lastname) {
		// convert char[] to String
		this.lastname = String.valueOf(lastname);
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(char[] alias) {
		// convert char[] to String
		this.alias = String.valueOf(alias);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(char[] username) {
		// convert char[] to String
		this.username = String.valueOf(username);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		// convert char[] to String
		this.password = String.valueOf(password);
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(char[] confirmPassword) {
		// convert char[] to String
		this.confirmPassword = String.valueOf(confirmPassword);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(char[] email) {
		// convert char[] to String
		this.email = String.valueOf(email);
	}

	public String getConfirmEmail() {		
		return confirmEmail;
	}

	public void setConfirmEmail(char[] confirmEmail) {
		// convert char[] to String
		this.confirmEmail = String.valueOf(confirmEmail);
	}
}