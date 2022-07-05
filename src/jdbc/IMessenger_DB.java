package BMessenger_JDBC;

public interface IMessenger_DB 
{
	public void getUser(String username, String password);
	
	public void sign_UP(String name, String surname, String username,String password, String on_screen_name);
	
	public void sign_UP(String name, String surname, String username,String password);
}
