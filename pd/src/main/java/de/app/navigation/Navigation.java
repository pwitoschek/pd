/**
 * 
 */
package de.app.navigation;

import java.io.Serializable;
import java.util.List;

/**
 * @author ap420 Container für die Navigation
 */
public class Navigation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2952636913683420794L;
	private List<NavigationItem> itemList;

	public List<NavigationItem> getItemList() {
		return itemList;
	}

	public void setItemList(final List<NavigationItem> itemList) {
		this.itemList = itemList;
	}

}
