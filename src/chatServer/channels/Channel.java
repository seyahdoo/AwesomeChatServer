package chatServer.channels;

import java.util.ArrayList;

import chatServer.users.User;

public class Channel {
	
	public String Name;
	//keep list of users.
	public ArrayList<User> users = new ArrayList<User>();

	@Override
	public String toString() {		
		return this.Name;
	}
	
	
}
