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
public class Navigation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5278172755638410593L;
	private LinkedList<NavigationItem> itemList;

	public LinkedList<NavigationItem> getItemList() {
		return itemList;
	}

	public void setItemList(LinkedList<NavigationItem> tabliste) {
		itemList = tabliste;
	}
}
