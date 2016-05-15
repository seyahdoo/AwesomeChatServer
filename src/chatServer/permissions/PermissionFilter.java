package chatServer.permissions;

import chatServer.ChatSession;
import chatServer.commands.Command;

public class PermissionFilter  {
	
	//can this user do this command?
	
	public void filter(ChatSession cs, Command command) throws Exception
	{
		//TODO check cs.user.permissions => command.requiredPermissions
		for (Permittable prm : command.globalPermissionsRequired) {
			if(!cs.user.globalPermissions.contains(prm)){
				throw new Exception("Authorization problem! You are not authorized to do "+prm.name());
			}
		}
		
		
		//TODO check local permissions...
		//TODO cache these!!!
		//what if null?
		for (Permittable prm : command.localPermissionsRequired) {
			if(!cs.user.getlocalPermissions(command.target).contains(prm)){
				throw new Exception("Authorization problem! You are not authorized to do "+prm.name());	
			}
		}
		
	}
	
	
}
