package socketServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import chatServer.ChatServer;

public class SocketServer {
	
	public SocketServer(int port)
	{
		//this.port = port;
		acceptor = new NioSocketAcceptor();
        
        acceptor.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new TextLineCodecFactory( Charset.forName( "UTF-8" ))));
        acceptor.setHandler(new SocketHandler(new ChatServer()));
        
        acceptor.getSessionConfig().setReadBufferSize( 2048 );
        acceptor.getSessionConfig().setIdleTime( IdleStatus.BOTH_IDLE, 10 );
        try {
			acceptor.bind( new InetSocketAddress(port) );
		} catch (IOException e) {
			System.out.println("Cannot Bind!!! Maybe something running on this port? ->"+port);
		}
	}
	
	//private int port;
	private IoAcceptor acceptor;
    
	public void Kill()
	{
		acceptor.dispose();
	}
	
}
