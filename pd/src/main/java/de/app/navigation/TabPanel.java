/**
 * 
 */
package de.app.navigation;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * @author pd
 * 
 */
public class TabPanel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5278172755638410593L;
	private LinkedList<Tab> tabliste;

	public LinkedList<Tab> getTabliste() {
		return tabliste;
	}

	public void setTabliste(LinkedList<Tab> tabliste) {
		this.tabliste = tabliste;
	}
}
