package chatServer;


import org.apache.mina.core.session.IoSession;
import org.json.simple.JSONObject;

import chatServer.commands.Command;
import chatServer.commands.CommandParser;
import chatServer.permissions.PermissionFilter;
import logging.log;
import settings.Settings;


public class ChatServer {
	
	public ChatServer()
	{
		//fix potential error!
		Settings.Load();
		
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
		
		try {
			cs.out(Settings.getString("welcomeText"));
		} catch (Exception e) {
			log.debug("no welcome text!");
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
		
		//todo delete this
	}
	
	@SuppressWarnings("unchecked")
	public void exceptionCaught(IoSession session, Throwable exeption) throws Exception {
		
		JSONObject json = new JSONObject();
		
		json.put("command", "errormessage");
		json.put("message", exeption.getMessage());
		
		log.warning("Exception cought! message: "+exeption.getMessage());
		session.write(json.toJSONString());
	}
	
	
	
}
