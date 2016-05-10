package chatServer.commands;

import chatServer.ChatSession;

public abstract class Command {
	
	public abstract String permissionsRequired();
	
	public abstract void execute(ChatSession cs) throws Exception;
	
}
