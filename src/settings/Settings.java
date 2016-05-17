package settings;

import java.util.HashMap;
import java.util.HashSet;

public class Settings {
	
	public static void Load()
	{
		setString("welcomeText", "Welcome bla blalaala!!!");
		
		setBool("passwordRequiredForLogin", true);
		setBool("passwordRequiredForRegister", true);
		setBool("emailRequiredForRegister", true);
		setBool("isIamGodUsed",false);		
	}
	
	public static void Save()
	{
		
	}
	
	//string to string map!
	private static HashMap<String, String> _strings = new HashMap<String,String>();
	public static String getString(String key) throws Exception
	{
		if(!_strings.containsKey(key))
		{
			throw new Exception("No key for "+key+" in Settings");
		}
		return _strings.get(key);
	}
	public static void setString(String key,String value)
	{
		if(_strings.containsKey(key))
			_strings.remove(key);
		
		_strings.put(key, value);
	}
	
	//if contains true!!!
	private static HashSet<String> _bools = new HashSet<String>();
	public static boolean getBool(String key)
	{
		return _bools.contains(key);
	}
	public static void setBool(String key,boolean value)
	{
		if(value != getBool(key))
		{
			if(value)
			{
				_bools.add(key);
			}else
			{
				_bools.remove(key);
			}
		}
	}
	
}
