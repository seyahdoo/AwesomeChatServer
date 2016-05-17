package chatServer.users;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


import chatServer.ChatSession;
import chatServer.permissions.Permittable;

public class User {
	
	
	public User(ChatSession cSession)
	{
		this.chatSession = cSession;
		
		globalPermissions = Arrays.asList(
				Permittable.DOCOMMAND,
				//Permittable.CREATECHANNEL,
				//Permittable.JOINCHANNEL,
				//Permittable.LEAVECHANNEL,
				//Permittable.SAYTOCHANNEL,
				Permittable.LOGIN,
				Permittable.REGISTER
				);
		
		localPermissions = new HashMap<Object,List<Permittable>>();
		
		
	}
	
	//user properties
	public ChatSession chatSession;
	
	public String username;
	public String email;
	
	//Refresh token Oath!,and access token...!?!?!? 
	//actually we don't need access token here! 
	//only for login...
	public String token;
	
	public HashSet<String> channels = new HashSet<String>();
	
	public List<Permittable> globalPermissions;
	public HashMap<Object,List<Permittable>> localPermissions;
	
	//for every channel????
	//public String localPermissions; //for each channel
	public List<Permittable> getlocalPermissions(Object obj)
	{
		
		//TODO give permission to say or join to user as it tries to join???
		//TODO do this for channel
		if(!localPermissions.containsKey(obj))
		{
			List<Permittable> permissions = Arrays.asList(
					Permittable.JOINCHANNEL,
					Permittable.LEAVECHANNEL,
					Permittable.SAYTOCHANNEL
					);
			
			localPermissions.put(obj, permissions);
			
			return permissions;
		}
		
		return localPermissions.get(obj);
	}
	
	public class TimedPermission
	{
		public Date giveTime = new Date();
		public boolean isLocal;
		public Object localObject;
		public Permittable permission;
	}
	
	public List<TimedPermission> timedPermissions = new ArrayList<TimedPermission>();
	
	public void executeTimedPermissions()
	{
		Iterator<TimedPermission> it = timedPermissions.iterator();
		while(it.hasNext()){
			TimedPermission tp = it.next();
			if(tp.giveTime.after(Calendar.getInstance().getTime())){
				if(tp.isLocal){
					if(!localPermissions.containsKey(tp.localObject)){
						localPermissions.put(tp.localObject, Arrays.asList(tp.permission));
					}else{	
						if(!localPermissions.get(tp.localObject).contains(tp.permission))
							localPermissions.get(tp.localObject).add(tp.permission);
					}
				}else{
					if(!globalPermissions.contains(tp.permission))
						globalPermissions.add(tp.permission);
				}
				it.remove();
			}
		}
	
	}
	
}
