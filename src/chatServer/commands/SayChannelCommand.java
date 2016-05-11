package chatServer.commands;

import chatServer.ChatSession;
import chatServer.channels.Channel;
import chatServer.channels.ChannelManager;
import chatServer.users.User;

public class SayChannelCommand extends Command {
	
	public SayChannelCommand(String channelName,String message) throws Exception
	{
		if(channelName == null)
		{
			throw new Exception("channelname field required to say in channel!");
		}
		if(channelName.length() < 1)
		{
			throw new Exception("channelname length must be grater then 1 to say in channel!");
		}
		this.channelName = channelName;
		
		
		
		if(message == null)
		{
			throw new Exception("message field required to say in channel!");
		}
		if(message.length() < 1)
		{
			throw new Exception("message length must be grater then 1to say in channel!");
		}
		this.message = message;
		
		
	}
	
	private String channelName;
	private String message;
	
	@Override
	public String globalPermissionsRequired() {
		// TODO Auto-generated method stub
		return "s";
	}

	@Override
	public void execute(ChatSession cs) throws Exception {
		
		if(!cs.user.channels.contains(channelName)){
			throw new Exception("You are not in this channel!");
		}

		Channel channel = ChannelManager.get(channelName);
		
		for (User user : channel.users) {
			
			//Respond!!! fromchannel,fromuser,message
			user.chatSession.out(cs.user.username+":"+message);
		}
		
		//Respond sender OK!
	}

}
