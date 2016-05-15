package chatServer.commands;

import java.util.Arrays;
import java.util.List;

import chatServer.ChatSession;
import chatServer.permissions.Permittable;

public abstract class Command {
	
	public Command(List<Permittable>global,List<Permittable>local)
	{
		if(global == null)
		{
			globalPermissionsRequired = Arrays.asList();
		}else
		{
			globalPermissionsRequired = global;
		}
		
		if(local == null)
		{
			localPermissionsRequired = Arrays.asList();
		}else
		{
			localPermissionsRequired = local;
		}
		
	}
	
	//public abstract ArrayList<Permittable> globalPermissionsRequired();
	//public abstract ArrayList<Permittable> localPermissionsRequired(); //for channel.
	public List<Permittable> globalPermissionsRequired;
	public List<Permittable> localPermissionsRequired;
	
	public Object target;
	
	public abstract void execute(ChatSession cs) throws Exception;
	
}
