/**
 * 
 */
package de.app.navigation;

import java.io.Serializable;
import java.util.List;

/**
 * @author ap420 Diese Klasse repräsentiert den View-State bzw. Action-State im
 *         Flow
 */
public class NavigationItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7323167415279090166L;
	private String name;

	private String uri;
	private String description;

	private boolean isActive = false;

	private boolean isReachable = false;

	private boolean isAuthenticationRequired = false;

	private List<String> states;

	/**
	 * //TODO Bitte ausreichend kommentieren<br>
	 * Hilfe: - Was macht die Methode (Aufgabe)?<br>
	 * - Was ist der Kontext?<br>
	 * 
	 * @param name
	 * @return
	 */
	public static NavigationItem getInstance(final String name) {
		NavigationItem navigationItem = new NavigationItem();
		navigationItem.setName(name);
		return navigationItem;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		NavigationItem other = (NavigationItem) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public boolean isActive() {
		return isActive;
	}

	public boolean isReachable() {
		return isReachable;
	}

	public void setActive(final boolean isActive) {
		this.isActive = isActive;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setReachable(final boolean isReachable) {
		this.isReachable = isReachable;
	}

	public List<String> getStates() {
		return states;
	}

	public void setStates(List<String> states) {
		this.states = states;
	}

	public boolean isAuthenticationRequired() {
		return isAuthenticationRequired;
	}

	public void setAuthenticationRequired(boolean isAuthenticationRequired) {
		this.isAuthenticationRequired = isAuthenticationRequired;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
}
