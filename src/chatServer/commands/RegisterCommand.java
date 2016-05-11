package chatServer.commands;

import chatServer.ChatSession;
import chatServer.users.User;
import settings.Settings;

public class RegisterCommand extends Command {
	
	public RegisterCommand (String username,String email, String password) throws Exception
	{
		if(username == null)
		{
			throw new Exception("username field required to login!");
		}
		if(username.length() < 1)
		{
			throw new Exception("username field required to login!");
		}
		this.username = username;
		
		//TODO email required for register?
		
		if(Settings.emailRequiredForRegister()){
			if(email == null){
				throw new Exception("email fild required to register!");
			}
			//TODO email valid check here!!!
			
			this.email = email;
		}
		
		if(Settings.passwordRequiredForRegister()){
			if(password == null){
				throw new Exception("password fild required to register!");
			}
			if(password.length() < 6){
				throw new Exception("password length must be grater than 6");
			}
			this.password = password;
		}
	}
	
	public String username = null;
	public String password = null;
	public String email = null;
	
	@Override
	public void execute(ChatSession cs) throws Exception{
		//TODO implement register command!
		
		User user = new User(cs);
		user.username = username;
		
		cs.user = user;
		
		//todo respond
		//cs.out("INFO Register success!!!");
		cs.out("OK!");
	}

	@Override
	public String globalPermissionsRequired() {
		
		return "r";
	}
}
