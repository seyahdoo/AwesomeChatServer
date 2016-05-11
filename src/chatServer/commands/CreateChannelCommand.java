package chatServer.commands;

import chatServer.ChatSession;
import chatServer.channels.Channel;
import chatServer.channels.ChannelManager;

public class CreateChannelCommand extends Command {
	
	public CreateChannelCommand(String channelName) throws Exception
	{
		if(channelName == null)
		{
			throw new Exception("channelname field required to create channel!");
		}
		if(channelName.length() < 1)
		{
			throw new Exception("channelname length must be grater then 1 to create channel");
		}
		this.channelName = channelName;
	}
	
	private String channelName;
	
	@Override
	public String globalPermissionsRequired() {
		
		return "";
	}

	@Override
	public void execute(ChatSession cs) throws Exception {
		Channel channel = new Channel();
		channel.Name = channelName;
		ChannelManager.put(channel);
		//TODO respond OK
		cs.out("OK!");
	}

}
