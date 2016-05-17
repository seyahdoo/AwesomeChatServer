package chatServer.commands.Administration;

import java.util.Arrays;

import chatServer.ChatSession;
import chatServer.commands.Command;
import chatServer.permissions.Permittable;
import settings.Settings;

public class IamGodCommand extends Command {
	
	public IamGodCommand() throws Exception {
		super(null, null);
		if(Settings.getBool("isIamGodUsed"))
		{
			throw new Exception("Somebody is already a god!!! All hail all mighty -somebody-");
		}
	}

	
	@Override
	public void execute(ChatSession cs) throws Exception {
		//TODO implement i am god!
		//grant all permissions!!!
		
		cs.user.globalPermissions = Arrays.asList(
				Permittable.DOCOMMAND,
				Permittable.JOINCHANNEL,
				Permittable.LEAVECHANNEL,
				Permittable.SAYTOCHANNEL,
				Permittable.LOGIN,
				Permittable.REGISTER,
				
				Permittable.CREATECHANNEL,
				Permittable.MUTEUSER
				);
		
		
		
		cs.out("You are now a god!!! congrats! Now, all hail "+cs.user.username);
		Settings.setBool("isIamGodUsed", true);
	}
	
}
