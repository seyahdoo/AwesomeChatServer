package chatServer.commands.channel;

import java.util.Arrays;

import chatServer.ChatSession;
import chatServer.channels.Channel;
import chatServer.channels.ChannelManager;
import chatServer.commands.Command;
import chatServer.permissions.Permittable;

public class JoinChannelCommand extends Command {

	public JoinChannelCommand(String channelName) throws Exception
	{
		super(	Arrays.asList(Permittable.JOINANYCHANNEL),
				Arrays.asList(Permittable.JOINTHISCHANNEL)
				);
		
		if(channelName == null)
		{
			throw new Exception("channelname field required to join channel!");
		}
		if(channelName.length() < 1)
		{
			throw new Exception("channelname length must be grater then 1 to join channel");
		}
		this.channelName = channelName;
	
		this.target = ChannelManager.get(channelName);
		
	}
	
	private String channelName;


	@Override
	public void execute(ChatSession cs) throws Exception {
		//TODO
		
		Channel channel = ChannelManager.get(channelName);
		if(channel.users.contains(cs.user))
		{
			throw new Exception("You are already on channel "+channelName+"!");
		}
		
		channel.users.add(cs.user);
		
		cs.user.channels.add(channelName);
		//Respond! joined channel!
		cs.out("OK!");
	}

}
