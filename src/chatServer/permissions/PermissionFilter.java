package chatServer.permissions;

import chatServer.ChatSession;
import chatServer.commands.Command;

public class PermissionFilter  {
	
	//can this user do this command?
	public void filter(ChatSession cs, Command command) throws Exception
	{
		//maybe i should do this if user dont have permissions???
		cs.user.executeTimedPermissions();
		
		//if permission doesnt contain in global permissions check local permissions.
		
		//check cs.user.permissions => command.requiredPermissions
		for (Permittable prm : command.globalPermissionsRequired) {
			if(!cs.user.globalPermissions.contains(prm)){
				if(!cs.user.getlocalPermissions(command.target).contains(prm)){	
					throw new Exception("Authorization problem! You are not authorized to do "+prm.name());	
				}
			}
		}
		
		
		//i check with global now, no need to do this!
		//check local permissions...
		//cache these!!!
		//what if null?
		//for (Permittable prm : command.localPermissionsRequired) {
		//	if(!cs.user.getlocalPermissions(command.target).contains(prm)){
		//		throw new Exception("Authorization problem! You are not authorized to do "+prm.name());	
		//	}
		//}
		
	}
	
	
}
