package chatServer.commands.channel;

import java.util.Arrays;

import org.json.simple.JSONObject;

import chatServer.ChatSession;
import chatServer.channels.Channel;
import chatServer.channels.ChannelManager;
import chatServer.commands.Command;
import chatServer.permissions.Permittable;
import chatServer.users.User;

public class SayChannelCommand extends Command {
	
	public SayChannelCommand(String channelName,String message) throws Exception
	{
		super(	Arrays.asList(Permittable.SAYTOCHANNEL),
				Arrays.asList(Permittable.SAYTOCHANNEL)
				);
		
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
		
		this.target = ChannelManager.get(channelName);
	}
	
	private String channelName;
	private String message;
	

	@SuppressWarnings("unchecked")
	@Override
	public void execute(ChatSession cs) throws Exception {
		
		if(!cs.user.channels.contains(channelName)){
			throw new Exception("You are not in this channel!");
		}

		Channel channel = ChannelManager.get(channelName);
		
		for (User user : channel.users) {
			
			JSONObject json = new JSONObject();
			
			json.put("command", "channelmessage");
			json.put("channelname", ((Channel)target).Name);
			json.put("username", cs.user.username);
			json.put("message", message);
			
			user.chatSession.out(json.toJSONString());
			
			//Respond!!! fromchannel,fromuser,message
			//user.chatSession.out(cs.user.username+":"+message);
		}
		
		//Respond sender OK!
	}

}
