/**
 * 
 */
package de.app.navigation;

import java.io.Serializable;

/**
 * @author pd Diese Klasse repräsentiert ein ViewState im Flow
 */
public class Tab implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4889986037107556640L;
	private String name;
	private String description;
	private boolean isActive;
	private boolean isReachable;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isReachable() {
		return isReachable;
	}

	public void setReachable(boolean isReachable) {
		this.isReachable = isReachable;
	}
}
