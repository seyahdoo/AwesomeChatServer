package chatServer.commands;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
		if(str.charAt(0) == '{')
		{
			JSONObject json = (JSONObject) jParser.parse(str);
			
			if(json.containsKey("command"))
			{

				switch ((String)json.get("command")) {
				case "login":	return new LoginCommand((String)json.get("username"), (String)json.get("password"));
				case "register":return new RegisterCommand((String)json.get("username"), (String)json.get("email"), (String)json.get("password"));
				default:		throw new Exception("Command did not recognized!!!");
				}
			}else
			{
				throw new Exception("There must be a command key on your json!!!");
			}
			
		}else
		{
			
			
			
			
		}
		
		
		
		
		
		return new LoginCommand("TestName","TestPass");
	}
	
	
}
