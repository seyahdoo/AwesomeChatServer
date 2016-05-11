package chatServer.commands;

import chatServer.ChatSession;
import chatServer.channels.Channel;
import chatServer.channels.ChannelManager;

public class LeaveChannelCommand extends Command {
	
	public LeaveChannelCommand(String channelName) throws Exception
	{
		if(channelName == null)
		{
			throw new Exception("channelname field required to leave channel!");
		}
		if(channelName.length() < 1)
		{
			throw new Exception("channelname length must be grater then 1 to leave channel!");
		}
		this.channelName = channelName;
		
	}
	
	private String channelName;
	
	@Override
	public String globalPermissionsRequired() {
		
		return "l";
	}

	@Override
	public void execute(ChatSession cs) throws Exception {
		
		Channel channel = ChannelManager.get(channelName);
		if(!channel.users.contains(cs.user))
		{
			throw new Exception("You are not on channel "+channelName+"!");
		}
		
		channel.users.remove(cs.user);
		
		cs.user.channels.remove(channelName);
		
		//if left notify open for that channel!
		//notify users in room, user left
		
		//Respond! left channel!
		cs.out("OK!");
		
		
	}

}
