package chatServer.channels;

import java.util.HashMap;

public class ChannelManager {
	
	
	private static HashMap<String,Channel> channels = new HashMap<String, Channel>();
	//get channel with name
	public static Channel get(String name) throws Exception
	{
		if(channels.containsKey(name))
		{
			return channels.get(name);
		}else
		{
			throw new Exception("No such channel as "+name+"!");
		}	
	}
	
	public static Channel put(Channel channel) throws Exception
	{
		if (channels.containsKey(channel.Name)) {
			throw new Exception("Channel with "+channel.Name+" name already exists!!!");
		}else
		{
			return channels.put(channel.Name, channel);
		}
		
		
	}
	
	
	
}