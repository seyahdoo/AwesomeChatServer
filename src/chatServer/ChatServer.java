package chatServer;


import org.apache.mina.core.session.IoSession;

import chatServer.commands.Command;
import chatServer.commands.CommandParser;
import chatServer.permissions.PermissionFilter;
import settings.Settings;


public class ChatServer {
	
	public ChatServer()
	{
		this.sessionManager = new SessionManager();
		this.permissionFilter = new PermissionFilter();
		this.commandParser = new CommandParser();
	}
	
	private SessionManager sessionManager;
	private PermissionFilter permissionFilter;
	private CommandParser commandParser;
	
	//TODO auto disconnect PING->if(PONG) cont(); else disconnect()
	
	public void sessionOpened(IoSession session) throws Exception {
		ChatSession cs = new ChatSession(session);
		sessionManager.add(session, cs);
		if(Settings.welcomeText().length()>0)
		{
			cs.out(Settings.welcomeText());
		}
		
	}
	
	public void sessionClosed(IoSession session) throws Exception {
		//todo! Users do disconnect after some time!
		
		//close chat session for session
		sessionManager.getChatSession(session).close();
	}
	
	public void messageReceived(IoSession session, String str) throws Exception {
		ChatSession cs = sessionManager.getChatSession(session);
		Command command = commandParser.parse(str);
		
		permissionFilter.filter(cs, command);
		
		command.execute(cs);
	}
	
	public void exceptionCaught(IoSession session, Throwable exeption) throws Exception {
		
		session.write("ERROR "+exeption.getMessage());
	}
	
	
}
