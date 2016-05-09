package chatServer;

import org.apache.mina.core.session.IoSession;

import chatServer.users.User;

public class ChatSession {
	
	public ChatSession (IoSession session)
	{
		this.session = session;
	}
	
	private IoSession session;
	public  User user;
	
	public ChatSession out(String message)
	{
		//todo <user>@<channel>:message!
		session.write(message);
		return this;
	}

	public ChatSession close()
	{
		//todo things to do on close
		
		//logout
		//leave channel
		
		return this;
	}
	
}
