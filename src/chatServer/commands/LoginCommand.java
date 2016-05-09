package chatServer.commands;

import chatServer.ChatSession;
import chatServer.users.User;
import settings.Settings;

public class LoginCommand extends Command {

	public LoginCommand (String username, String password) throws Exception
	{
		if(username == null)
		{
			throw new Exception("username field required to login!");
		}
		if(username.length() < 1)
		{
			throw new Exception("username length must be grater then 1");
		}
		this.username = username;
		
		if(Settings.passwordRequiredForLogin()){
			if(password == null){
				throw new Exception("password fild required to login!");
			}
			if(password.length() < 6){
				throw new Exception("password length must be grater than 6");
			}
			this.password = password;
		}
	}
	
	public String username = null;
	public String password = null;
	
	@Override
	public void execute(ChatSession cs) throws Exception{
		//TODO implement login command!
		
		User user = new User();
		user.username = username;
		
		cs.user = user;
		
		cs.out("INFO Login success!!!");
	}
	
	
}
