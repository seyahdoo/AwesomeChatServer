package chatServer.commands;

import chatServer.ChatSession;

public abstract class Command {
	
	public abstract String globalPermissionsRequired();
	//public abstract String localPermissionsRequired(); //for channel.
	
	public abstract void execute(ChatSession cs) throws Exception;
	
}
