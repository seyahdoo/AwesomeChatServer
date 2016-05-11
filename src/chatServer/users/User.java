package chatServer.users;


import java.util.HashSet;

import chatServer.ChatSession;
import chatServer.channels.Channel;

public class User {
	
	public User(ChatSession cSession)
	{
		this.chatSession = cSession;
	}
	
	//user properties
	public ChatSession chatSession;
	
	public String username;
	public String email;
	
	//Refresh token Oath!
	public String token;
	
	public String globalPermissions;
	
	//
	//public Map<String> channels = new ArrayList<String>();
	public HashSet<String> channels = new HashSet<String>();
	
	//for every channel????
	//public String localPermissions; //for each channel
	public String getlocalPermissions(Channel c)
	{
		
		return null;
	}
	
}
