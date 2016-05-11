package logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class log {
	
private static Logger LOGGER = getfirst();
	
	private static Logger getfirst()
	{
		
		System.setProperty("java.util.logging.SimpleFormatter.format", 
				"%1$tF | %1$tT | %4$s %5$s%6$s%n");
		
		Logger logger = Logger.getLogger("default");
	    FileHandler fh;  

	    try {
			fh = new FileHandler("log.log");
		    SimpleFormatter formatter = new SimpleFormatter();
		    fh.setFormatter(formatter);  
		    logger.addHandler(fh);
		    
	    } catch (SecurityException | IOException e) {
			System.out.println("Cannot open log.log");
		}  
	    
	    logger.setLevel(Level.FINER);
	    
	    return logger;
	}
	
	public static void info(String str)
	{
		LOGGER.info(str);
	}
	
	public static void warning(String str)
	{
		LOGGER.warning(str);
	}
	
	public static void severe(String str)
	{
		LOGGER.severe(str);
	}
	
	public static void fine(String str)
	{
		LOGGER.info(str);
	}
	
	public static void debug(String str)
	{
		LOGGER.info(str);
	}
	
	
	
}
