/**
 * 
 */
package de.app.pd.entities.pv;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@Size(min = 2)
	private String test;

	private static final long serialVersionUID = -4453985606360922467L;
	@NotNull
	private double ertrag;

	public double getErtrag() {
		return ertrag;
	}

	public void setErtrag(double ertrag) {
		this.ertrag = ertrag;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
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
