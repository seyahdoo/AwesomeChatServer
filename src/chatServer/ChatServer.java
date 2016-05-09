package chatServer;

import org.apache.mina.core.session.IoSession;

import chatServer.commands.Command;
import chatServer.commands.CommandParser;
import settings.Settings;


public class ChatServer {
	
	public ChatServer()
	{
		this.sessionManager = new SessionManager();
		this.identityFilter = new IdentityFilter();
		this.authorizationFilter = new AuthorizationFilter();
		this.commandParser = new CommandParser();
	}
	
	//Command from user
	//Command class
	
	//Users do disconnect after some time!
	private SessionManager sessionManager;
	private IdentityFilter identityFilter;
	private AuthorizationFilter authorizationFilter;
	private CommandParser commandParser;
	
	public void sessionOpened(IoSession session) throws Exception {
		//open chatsession for session
		ChatSession cs = new ChatSession(session);
		sessionManager.add(session, cs);
		if(Settings.welcomeText().length()>0)
		{
			cs.out(Settings.welcomeText());
		}
		
	}
	
	public void sessionClosed(IoSession session) throws Exception {
		//close chat session for session
		sessionManager.getChatSession(session).close();
	}
	
	public void messageReceived(IoSession session, String str) throws Exception {
		ChatSession cs = sessionManager.getChatSession(session);
		Command command = commandParser.parse(str);
		
		identityFilter.filter(cs, command);
		authorizationFilter.filter(cs, command);
		
		command.execute(cs);
		
	}
	
	public void exceptionCaught(IoSession session, Throwable exeption) throws Exception {
		
		session.write("ERROR "+exeption.getMessage());
	}

	

}
