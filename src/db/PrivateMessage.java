package exs406;

/**Private Message object for one-to-one chatting within the public chat
 * @author exs406
 *
 */
public class PrivateMessage implements java.io.Serializable
{
	
	private static final long serialVersionUID = 8L;
	private String username;
	private String message;

	/** Private Message constructor with 2 parameters
	 * @param username
	 * @param message
	 */
	public PrivateMessage(String username, String message)
	{
		this.setUsername(username);
		this.setMessage(message);
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getMessage() 
	{
		return message;
	}

	public void setMessage(String message) 
	{
		this.message = message;
	}
	
	
}
