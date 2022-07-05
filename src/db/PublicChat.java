package exs406;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PublicChat 
{
	private Calendar date = null;
	private Calendar time = null;
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	private	String currentdate;
	private String path;
	private File publicChatFile;
	Writer fileWriter;
	
	public PublicChat()
	{
		this.date = Calendar.getInstance();
		this.currentdate = date.get(Calendar.DATE) + "/" + (date.get(Calendar.MONTH) + 1) 
							+ "/" + date.get(Calendar.YEAR);
		this.path = "/"+currentdate+".txt";
		this.publicChatFile = new File(path);
		
		try 
		{
			publicChatFile.createNewFile();
		} 
		catch (IOException e) 
		{
			System.out.println("File not created");
			e.printStackTrace();
		}
	}
	
	/**Adds to the history file any changes to the chat
	 * @param currentLine
	 */
	public void setPublicChatHistory(String currentLine) 
	{
		time.getTime();
		try 
		{
			fileWriter = new BufferedWriter(new FileWriter(publicChatFile,true));
			fileWriter.append(sdf.format(time.getTime())+" "+currentLine);	
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Exception while reading and/or appending the history file");
			e.printStackTrace();
		}
		finally
		{
			try {
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
