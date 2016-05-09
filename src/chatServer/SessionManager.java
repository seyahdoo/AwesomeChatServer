package chatServer;

import java.util.HashMap;

import org.apache.mina.core.session.IoSession;

public class SessionManager {
	
	private HashMap<IoSession,ChatSession> _sessions = new HashMap<IoSession,ChatSession>();
	
	public ChatSession getChatSession(IoSession session) throws Exception
	{
		if(!_sessions.containsKey(session))
		{
			throw new Exception("No ChatSession defined!!!");
		}
		
		return _sessions.get(session);
	}
	
	public ChatSession add(IoSession session,ChatSession cSession) throws Exception
	{
		if(_sessions.containsKey(session))
		{
			throw new Exception("ChatSession Already hashed!!!");
		}
		
		_sessions.put(session, cSession);
		
		return cSession;
	}
	
	public ChatSession remove(IoSession session,ChatSession cSession) throws Exception
	{
		if(!_sessions.containsKey(session))
		{
			throw new Exception("Cannot remove ChatSession. Not Hashed!!!");
		}
		_sessions.remove(session);
		
		return cSession;
	}
	
}
