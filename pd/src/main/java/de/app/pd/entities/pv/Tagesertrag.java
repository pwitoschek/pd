/**
 * 
 */
package de.app.pd.entities.pv;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;
import org.springframework.webflow.core.collection.AttributeMap;
import org.springframework.webflow.core.collection.LocalAttributeMap;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import de.app.utilities.DateUtilities;

/**
 * @author Peter
 * 
 */

@Component
public class Tagesertrag extends Unit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4453985606360922467L;
	@NotNull
	private Double ertrag;

	public Double getErtrag() {
		return ertrag;
	}

	public void setErtrag(Double ertrag) {
		this.ertrag = ertrag;
	}

	public Tagesertrag setInitValues() {
		Calendar calendar = new GregorianCalendar();
		setWeekDay(DateUtilities.getWeekDay(calendar.get(Calendar.DAY_OF_WEEK)));
		setCurrentDateAndTime(new Timestamp(new Date().getTime()));
		return this;
	}

	public void validateStartEnterPVData(ValidationContext context) {
		MessageContext messages = context.getMessageContext();
		// So sollte man es NICHT machen!
		String durchschnittsTemperatur = String
				.valueOf(getDurchschnittsTemperatur());
		if (durchschnittsTemperatur == "null") {
			messages.addMessage(new MessageBuilder()
					.error()
					.source("durchschnittsTemperatur")
					.defaultText(
							"Bitte geben Sie die Tagesdurchschnittstemperatur ein")
					.build());
		}
	}

	public Event addTagesertrag(Tagesertrag tagesertrag) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("testAttribute", "test1");
		AttributeMap attributeMap = new LocalAttributeMap(map);
		return new Event(this, "success", attributeMap);
	}

	public Event addTagesertrag(RequestContext rc, Tagesertrag tagesertrag) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("testAttribute", "test");
		AttributeMap attributeMap = new LocalAttributeMap(map);
		return new Event(this, "success", attributeMap);
	}
}
