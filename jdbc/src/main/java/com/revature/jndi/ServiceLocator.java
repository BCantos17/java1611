package com.revature.jndi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Lookup and cache services. Reduces performance
 * overhead of looking up services.
 * @author Owner
 *
 */
public class ServiceLocator {

	private static DataSource chinook;
	private static Properties env; // environment props
	
	static{ // used to initialize static variables.
			// executed when class is loaded into JVM
		// load properties from jndi.properties in classpath
		InputStream stream = ServiceLocator.class.getClassLoader()
				.getResourceAsStream("jndi.properties");
		env = new Properties();
		try {
			env.load(stream); // loads properties from file
		} catch (IOException e) {}
	}
	
	public synchronized static DataSource getChinookDatabase(){
		if(chinook == null)
			chinook = lookupChinook();
		return chinook;
	}

	private static DataSource lookupChinook() {
		try{
			Context ctxt = new InitialContext(env);
			DataSource ds = (DataSource) 
					ctxt.lookup(env.getProperty("chinookdb"));
			return ds;
		}catch(NamingException e){
			e.printStackTrace();
			return null; // datasource could not be found
		}
	}
	
}





