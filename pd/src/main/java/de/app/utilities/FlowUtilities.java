/**
 * 
 */
package de.app.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.springframework.webflow.definition.FlowDefinition;

import de.app.navigation.Navigation;

/**
 * @author pd
 * 
 */
public class FlowUtilities {

	static Navigation getNavigationObject(String flow) {
		try {
			File testfile = new File(
					"C:/Users/pd/git/pd/pd/src/main/webapp/WEB-INF/flows/fileUpload-flow.xml");
			FileReader reader = new FileReader(testfile);
			BufferedReader br = new BufferedReader(reader);

			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.contains("<view-state")
						|| line.contains("<action-state")
						|| line.contains("<end-state")) {

				}
			}

			// while(testfile.)

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Navigation result = new Navigation();

		return result;
	}

	int getStateCount(FlowDefinition definition) {
		int result = 0;
		definition.getState("");

		return result;
	}
}
