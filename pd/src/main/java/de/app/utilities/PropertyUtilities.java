/**
 * 
 */
package de.app.utilities;

import java.io.FileInputStream;
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
			if (definition.equals("ertrag")) {
				// is =
				// this.getClass().getClassLoader().getResourceAsStream("/Users/peterwitoschek/git/pd/pd/src/main/webapp/WEB-INF/properties/flow.properties");
				is = new FileInputStream(
				// "/Users/peterwitoschek/git/pd/pd/src/main/webapp/WEB-INF/properties/ertrag.properties");
						"C:/Users/pd/git/pd/pd/src/main/webapp/WEB-INF/properties/ertrag.properties");
				// is =
				// Thread.currentThread().getContextClassLoader().getResourceAsStream("/WEB-INF/properties/flow.properties");
			} else if (definition.equals("entwicklung")) {
				is = new FileInputStream(
				// "/Users/peterwitoschek/git/pd/pd/src/main/webapp/WEB-INF/properties/entwicklung.properties");
						"C:/Users/pd/git/pd/pd/src/main/webapp/WEB-INF/properties/entwicklung.properties");
			}
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
