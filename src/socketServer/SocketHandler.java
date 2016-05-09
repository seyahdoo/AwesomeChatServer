package socketServer;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import chatServer.ChatServer;

public class SocketHandler implements IoHandler {

	//Get arguments from string!
	//Get string to space and trim to space!
	
	public SocketHandler(ChatServer server)
	{
		this.server = server;
	}
	
	private ChatServer server;
	
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		server.sessionOpened(session);
	}
	
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		server.sessionClosed(session);
	}
	
	@Override
	public void messageReceived(IoSession session, Object obj) throws Exception {
		if(obj instanceof String)
		{
			server.messageReceived(session, (String)obj);
		}else
		{			
			//todo fix this!
			session.write("I demand String type Input!!!");
		}
	}
	
	@Override
	public void exceptionCaught(IoSession session, Throwable exeption) throws Exception {
		server.exceptionCaught(session, exeption);
	}

	
	@Override
	public void inputClosed(IoSession arg0) throws Exception {
		
	}
	@Override
	public void messageSent(IoSession arg0, Object arg1) throws Exception {
		
	}
	@Override
	public void sessionCreated(IoSession arg0) throws Exception {
		
	}
	@Override
	public void sessionIdle(IoSession arg0, IdleStatus arg1) throws Exception {
		
	}

}
