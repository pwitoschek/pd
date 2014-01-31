/**
 * 
 */
package de.app.utilities;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author pd
 * 
 */
public class PropertyUtilities {

	private final static String flowPropertyPath = "C:/Users/pd/git/pd/pd/src/main/webapp/WEB-INF/properties/flow.properties";

	public static String getFlowProperties(String field) {
		String result = "";
		Properties properties = new Properties();
		BufferedInputStream stream = null;
		try {
			stream = new BufferedInputStream(new FileInputStream(new File(
					flowPropertyPath)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			properties.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		result = properties.getProperty(field);
		return result;
	}
}
