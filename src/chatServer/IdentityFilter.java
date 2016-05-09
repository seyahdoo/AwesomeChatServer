package chatServer;

import chatServer.commands.Command;

public class IdentityFilter {
	
	//login needed?
	//can user be null
	//anonymous allowed???
	//what happens if user == null
		
	public void filter(ChatSession cs, Command command) throws Exception
	{
		//Use token to determine who is who.
		//users may say TOKEN sth to login.
			

		throw new Exception("Authentication is not implemented yet!");
	}
		
	
	
}
