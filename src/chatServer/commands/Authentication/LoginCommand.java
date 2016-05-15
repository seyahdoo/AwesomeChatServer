package chatServer.commands.Authentication;

import java.util.Arrays;
import chatServer.ChatSession;
import chatServer.commands.Command;
import chatServer.permissions.Permittable;
import settings.Settings;

public class LoginCommand extends Command {

	public LoginCommand (String username, String password) throws Exception
	{
		super(Arrays.asList(Permittable.LOGIN),null);
		
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
		//get from database!!!
		
		//old test code
		//User user = new User(cs);
		//user.username = username;
		//cs.user = user;
		/////
		
		//new plain test code
		cs.user.username = username;
		////
		
		//todo Respond() !!!
		//cs.out("INFO Login success!!!");
		cs.out("OK!");
	}
	
}
