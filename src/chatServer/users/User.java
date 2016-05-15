package chatServer.users;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import chatServer.ChatSession;
import chatServer.permissions.Permittable;

public class User {
	
	
	public User(ChatSession cSession)
	{
		this.chatSession = cSession;
		
		globalPermissions = Arrays.asList(
				Permittable.DOCOMMAND,
				//Permittable.CREATECHANNEL,
				Permittable.JOINANYCHANNEL,
				Permittable.LEAVEANYCHANNEL,
				Permittable.SAYTOANYCHANNEL,
				Permittable.LOGIN,
				Permittable.REGISTER
				);
		
		localPermissions = new HashMap<Object,List<Permittable>>();
		
		
	}
	
	//user properties
	public ChatSession chatSession;
	
	public String username;
	public String email;
	
	//Refresh token Oath!,and access token...!?!?!? 
	//actually we don't need access token here! 
	//only for login...
	public String token;
	
	public HashSet<String> channels = new HashSet<String>();
	
	public List<Permittable> globalPermissions;
	public HashMap<Object,List<Permittable>> localPermissions;
	
	//for every channel????
	//public String localPermissions; //for each channel
	public List<Permittable> getlocalPermissions(Object obj)
	{
		
		//TODO give permission to say or join to user as it tries to join???
		if(!localPermissions.containsKey(obj))
		{
			List<Permittable> permissions = Arrays.asList(
					Permittable.JOINTHISCHANNEL,
					Permittable.LEAVETHISCHANNEL,
					Permittable.SAYTOTHISCHANNEL
					);;
			
			localPermissions.put(obj, permissions);
			
			return permissions;
		}
		
		return localPermissions.get(obj);
	}
	
}
