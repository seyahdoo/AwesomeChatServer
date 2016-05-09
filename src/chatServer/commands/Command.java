package chatServer.commands;

import chatServer.ChatSession;

public abstract class Command {
	
	public abstract void execute(ChatSession cs) throws Exception;
	
}
