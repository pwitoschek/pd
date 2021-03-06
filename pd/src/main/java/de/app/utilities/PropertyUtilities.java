/**
 * 
 */
package de.app.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author pd
 * 
 */
public class PropertyUtilities {

	private final static String flowPropertyPath = "C:/Users/pd/git/pd/pd/src/main/webapp/WEB-INF/properties/flow.properties";

	public String getFlowProperties(String definition, String field) {
		String result = "";
		Properties properties = new Properties();
		InputStream is = null;

		try {
			is = Thread
					.currentThread()
					.getContextClassLoader()
					.getResourceAsStream(
							"/WEB-INF/properties/" + definition + ".properties");
			if (is != null) {
				properties.load(is);
				result = properties.getProperty(field);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
