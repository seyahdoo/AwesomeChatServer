package chatServer;

import chatServer.commands.Command;

public class PermissionFilter  {
	
	//can this user do this command?
	
	public void filter(ChatSession cs, Command command) throws Exception
	{
		//TODO check cs.user.permissions => command.requiredPermissions
		//throw authorization exception if there is
		
		
		
		//throw new Exception("Authorizarion is not implemented yet!");
	}
	
	
}
