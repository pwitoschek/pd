/**
 * 
 */
package de.app.navigation;

import java.io.Serializable;

/**
 * @author pd Diese Klasse repräsentiert ein ViewState im Flow
 */
public class NavigationItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4889986037107556640L;
	private String name;
	private String description;
	private boolean isActive = false;
	private boolean isReachable = false;
	private String executionStep;
	private String executionNumber;
	private String uri;

	public String getExecutionStep() {
		return executionStep;
	}

	public void setExecutionStep(String executionStep) {
		this.executionStep = executionStep;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getExecutionNumber() {
		return executionNumber;
	}

	public void setExecutionNumber(String executionNumber) {
		this.executionNumber = executionNumber;
	}
}
