package com.recommind.tools.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This util class models the allows us to access all the properties defined in
 * the <code>configurations.properties</code> of the test project. <br>
 * e.g. getting browser property
 * 
 * @author asu
 * 
 */
public class ConfigUtil {

	private static Properties config = null;
	private static String configLoc = null;

	static {
		config = new Properties();
		try {
			configLoc = new File(".").getCanonicalPath() + File.separator
					+ "config" + File.separator+ "configurations.properties" ;
			FileInputStream fis = new FileInputStream(configLoc);

			config.load(fis);
			System.out.println("Properties file loaded at '" + configLoc +"'");
		} catch (FileNotFoundException e) {
			System.err.println("Unable to load properties file: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Unable to load properties file: " + e.getMessage());
		}
	}
	
	/**
	 * Gets the value of input property <i>key</i> property defined in the
	 * <code>"config/config.properties"</code> file
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return config.getProperty(key);
	}

	/**
	 * Sets the value of input property <i>key</i> property defined in the
	 * <code>"config/config.properties"</code> file
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static void setProperty(String key, String value) {
		config.setProperty(key, value);
	}
}
