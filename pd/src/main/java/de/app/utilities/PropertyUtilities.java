/**
 * 
 */
package de.app.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author pd
 * 
 */
public class PropertyUtilities {

	private final static String flowPropertyPath = "C:/Users/pd/git/pd/pd/src/main/webapp/WEB-INF/properties/flow.properties";
	@Autowired
	HttpServletRequest request;
	
	public String getFlowProperties(String field) {
		String result = "";
		Properties properties = new Properties();
		InputStream is = null;
		try {
			is = this.getClass().getClassLoader().getResourceAsStream("/Users/peterwitoschek/git/pd/pd/src/main/webapp/WEB-INF/properties/flow.properties");
			if (is != null){
				properties.load(is);
				result = properties.getProperty(field);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
