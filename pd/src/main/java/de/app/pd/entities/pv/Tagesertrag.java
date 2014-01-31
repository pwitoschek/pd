/**
 * 
 */
package de.app.pd.entities.pv;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

/**
 * @author Peter
 */
/*
 * Alle Entities (UND deren Basisklassen) müssen serialisierbar sein, damit
 * diese in Flows verwendet werden können.
 */
@Component
public class Tagesertrag extends Unit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4453985606360922467L;
	@NotNull
	private double ertrag;

	public double getErtrag() {
		return ertrag;
	}

	public void setErtrag(double ertrag) {
		this.ertrag = ertrag;
	}

	// public Event addTagesertrag(Tagesertrag tagesertrag) {
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("testAttribute", "test1");
	// AttributeMap attributeMap = new LocalAttributeMap(map);
	// return new Event(this, "success", attributeMap);
	// }
	//
	// public Event addTagesertrag(RequestContext rc, Tagesertrag tagesertrag) {
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("testAttribute", "test");
	// AttributeMap attributeMap = new LocalAttributeMap(map);
	// return new Event(this, "success", attributeMap);
	// }
}
