package chatServer.commands;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import chatServer.commands.Administration.IamGodCommand;
import chatServer.commands.Authentication.LoginCommand;
import chatServer.commands.Authentication.RegisterCommand;
import chatServer.commands.channel.CreateChannelCommand;
import chatServer.commands.channel.JoinChannelCommand;
import chatServer.commands.channel.LeaveChannelCommand;
import chatServer.commands.channel.SayChannelCommand;

public class CommandParser {
	
	public CommandParser()
	{
		//TODO get command list from Settings
		
		//Command attirbutes 
		// -> required permission
		// -> -> permission arguments (Channel name like???)
		// -> what does it do, code!
		
		jParser = new JSONParser();
	}
	
	private JSONParser jParser;
	
	public Command parse(String str) throws Exception
	{
		//TODO parse command!
		//if str[0] == '{' json decode
		//else normal decode
		//command=login&username=seyahdoo&password=abuzittin!!!
		//LOGIN seyahdoo abuzittin!!!
		if(str.charAt(0) == '{')
		{
			JSONObject json = (JSONObject) jParser.parse(str);
			
			if(json.containsKey("command"))
			{

				switch ((String)json.get("command")) {
				case "login"		:return new LoginCommand((String)json.get("username"), (String)json.get("password"));
				case "register"		:return new RegisterCommand((String)json.get("username"), (String)json.get("email"), (String)json.get("password"));
				case "resetpassword":break;
				case "confirmemail"	:break;
				
				case "createchannel":return new CreateChannelCommand((String)json.get("channelname"));
				case "joinchannel"	:return new JoinChannelCommand((String)json.get("channelname"));
				case "leavechannel"	:return new LeaveChannelCommand((String)json.get("channelname"));
				case "saychannel"	:return new SayChannelCommand((String)json.get("channelname"),(String)json.get("message"));
					
				case "kick"			:break; //kick from channel for seconds
				case "ban"			:break; //add mac to ban for seconds
				case "permban"		:break; //add mac to bans for 99999999999999
				case "ghostmode"	:break; //dont say when you join,quit channels!
				case "livemode"		:break; //say when you join,quit channels
				case "mute"			:break;//return new MuteUserCommand((String)json.get("username")); //mute on channel so he cant say anything!
				case "unmute"		:break; //unmute!
				//Kill ???
					
				
				case "whoami"		:break; //return user info
				
				case "iamgod"		:return new IamGodCommand(); //works only once per every server
				
				case "iamreporter"	:break; //report to dash board!!!
					
				default:		throw new Exception("Command did not recognized!!!");
				}
			}else
			{
				throw new Exception("There must be a command key on your json string!!!");
			}
			
		}
		
		throw new Exception("command did not recognized!!");
		//return new LoginCommand("TestName","TestPass");
	}
	
}
