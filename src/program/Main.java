package program;

import socketServer.SocketServer;

public class Main {

	public static void main(String[] args) {
		
		SocketServer ss = new SocketServer(4444);
		
		//kill on close
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() 
		{
	        public void run() {
	            ss.Kill();
	        }
	    }));
		
	}

}
