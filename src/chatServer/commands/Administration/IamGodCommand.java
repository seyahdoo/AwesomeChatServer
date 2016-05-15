package chatServer.commands.Administration;

import chatServer.ChatSession;
import chatServer.commands.Command;

public class IamGodCommand extends Command {
	
	public IamGodCommand() throws Exception {
		super(null, null);
		if(isUsed)
		{
			throw new Exception("Somebody is already a god!!! All hail all mighty -somebody-");
		}
	}

	public static boolean isUsed = false;
	
	@Override
	public void execute(ChatSession cs) throws Exception {
		//TODO implement i am god!
		
		isUsed = true;
		cs.out("You are now a god!!! congrats! Now, all hail "+cs.user.username);
		
	}
	
}
