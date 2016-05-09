package chatServer;

import chatServer.commands.Command;

public class AuthorizationFilter  {
	
	//can this user do this command?
	
	public void filter(ChatSession cs, Command command) throws Exception
	{
		
		//throw authorization exception if there is
		
		
		
		throw new Exception("Authorizarion is not implemented yet!");
	}
	
	
}
