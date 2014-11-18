/**
 * 
 */
package de.app.pd.entities.pv;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author pd
 * 
 */
@Component
public class CompositeEntitiy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4838832137932561397L;
	@Autowired
	private Tagesertrag tagesertrag;
	@Autowired
	private Tagesverbrauch tagesverbrauch;

	public Tagesertrag getTagesertrag() {
		return tagesertrag;
	}

	public void setTagesertrag(Tagesertrag tagesertrag) {
		this.tagesertrag = tagesertrag;
	}

	public Tagesverbrauch getTagesverbrauch() {
		return tagesverbrauch;
	}

	public void setTagesverbrauch(Tagesverbrauch tagesverbrauch) {
		this.tagesverbrauch = tagesverbrauch;
	}

}
