package chatServer.commands.Administration;

import java.util.Arrays;
import java.util.Calendar;

import chatServer.ChatSession;
import chatServer.channels.ChannelManager;
import chatServer.commands.Command;
import chatServer.permissions.Permittable;
import chatServer.users.User.TimedPermission;

public class MuteUserCommand extends Command {


	public MuteUserCommand(String username,String channelname,long seconds) throws Exception {
		super(Arrays.asList(Permittable.MUTEUSER),Arrays.asList(Permittable.MUTEUSER));
		
		
		//TODO check!!!
		this.username = username; //null is invalid!!! //if user doesn't exist ERROR
		this.target = ChannelManager.get(channelname); //null is for every channel //if channel doesn't exist ERROR
		this.seconds = seconds; //0 is forever
	}

	private String username;
	private Object target;
	private long seconds;
	
	@Override
	public void execute(ChatSession cs) throws Exception {
		
		//TODO mute for seconds!!!
		if(target != null)
		{
			cs.user.localPermissions.get(target).remove(Permittable.SAYTOCHANNEL);
			//and remove say to channel for all channels!
			
		}else
		{
			cs.user.globalPermissions.remove(Permittable.SAYTOCHANNEL);
		}
		
		if(seconds != 0){
			TimedPermission tp = cs.user.new TimedPermission();
			tp.giveTime.setTime(Calendar.getInstance().getTime().getTime() + seconds);
			if(target != null)
			{
				
			}
		
			cs.user.timedPermissions.add(tp);
		}
		//TODO implement
		cs.out("user silenced:"+username);

	}

}
