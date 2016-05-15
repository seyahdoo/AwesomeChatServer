package chatServer.commands.channel;

import java.util.Arrays;
import chatServer.ChatSession;
import chatServer.channels.Channel;
import chatServer.channels.ChannelManager;
import chatServer.commands.Command;
import chatServer.permissions.Permittable;

public class CreateChannelCommand extends Command {
	
	public CreateChannelCommand(String channelName) throws Exception
	{
		super(Arrays.asList(Permittable.CREATECHANNEL),null);
		
		if(channelName == null)
		{
			throw new Exception("channelname field required to create channel!");
		}
		if(channelName.length() < 1)
		{
			throw new Exception("channelname length must be grater then 1 to create channel");
		}
		this.channelName = channelName;
		
		//this.target = ChannelManager.get(channelName);
		
	}
	
	private String channelName;
	

	@Override
	public void execute(ChatSession cs) throws Exception {
		Channel channel = new Channel();
		channel.Name = channelName;
		ChannelManager.put(channel);
		//TODO respond OK
		cs.out("OK!");
	}

}
