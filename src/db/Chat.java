package exs406;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
//import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;

/**Class to create chat objects in order to manipulate and save the chat history within users. 
 * @author exs406
 * updated 13/03/2015
 */
public class Chat 
{
	
	//name of a chat
	private String chatName;
	private String chatUser;
	private int chatID;
	private String message;
	
//	//history file
//	private File chatFile;
//	//path of the history file
//	private String path;
//	//directory path within the server where the files will be saved
//	private static String directory;
//	Writer infile;

	
	public Chat()
	{
		
	}
	
	/**Construct a new chat
	 * Note: This constructor saves the file in a path directory and name give by the user!!
	 * 
	 * @param chatName
	 * @param path
	 */
	public Chat(String chatName, int chatID, String user, String message)
	{
		this.chatUser = user;
		this.chatID = chatID;
		this.chatName = chatName;
		this.setMessage(message);
//		this.path = directory+"/"+chatName+chatID+".txt";
//		this.chatFile = new File(path);
//		try 
//		{
//			// http://www.studytrails.com/java-io/file-operations.jsp
//			chatFile.createNewFile();
//		} 
//		catch (IOException e) 
//		{
//			System.out.println("File not created");
//			e.printStackTrace();
//		}
	}
	
	public int getChatID() 
	{
		return chatID;
	}

	public void setChatID(int chatID) {
		this.chatID = chatID;
	}
	
	public String getChatName() {
		return chatName;
	}

	public void setChatName(String chatName) {
		this.chatName = chatName;
	}
	
	public String getChatUser()
	{
		return chatUser;
	}
	
	public void setChatUser(String user)
	{
		this.chatUser = user;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

//	public String getPath() {
//		return path;
//	}
//
//	public void setChatFile(File chatHistory) {
//		this.chatFile = chatHistory;
//	}
//
//	public boolean isActiveChat() {
//		return activeChat;
//	}
//
//	public void setActiveChat(boolean activeChat) {
//		this.activeChat = activeChat;
//	}

//	public Set<User> getChatUsers() {
//		return chatUsers;
//	}
//
//	public void setChatUsers(Set<User> chatUsers) {
//		this.chatUsers = chatUsers;
//	}

//	public File getChatFile() {
//		return chatFile;
//	}
//	
//	/**Adds to the history file any changes to the chat
//	 * @param currentLine
//	 */
//	public void setChatHistory(String currentLine) 
//	{
//		try 
//		{
//			infile = new BufferedWriter(new FileWriter(chatFile,true));
//			infile.append(currentLine);	
//		} 
//		catch (IOException e) 
//		{
//			// TODO Auto-generated catch block
//			System.out.println("Exception while reading and/or appending the history file");
//			e.printStackTrace();
//		}
//		finally
//		{
//			try {
//				infile.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//	}


	
	
}
