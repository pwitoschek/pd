package de.app.pd.entities.paul;

import java.io.Serializable;
import java.util.Date;

import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class Entwicklung implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5769133221729712228L;
	private Date currentDateAndTime;
	private Double gewicht;
	private boolean pipi;
	private boolean kaka;
	private boolean stillen;
	private boolean wickeln;
	private String bemerkung;
	private String stillenBemerkung;
	private String weekDay;

	public Entwicklung setInitValues() {
		LocalDate localDate = new LocalDate();
		localDate.dayOfWeek().getAsString();
		// Calendar calendar = new GregorianCalendar();
		// setWeekDay(DateUtilities.getWeekDay(calendar.get(Calendar.DAY_OF_WEEK)));
		// setCurrentDateAndTime(new Timestamp(new Date().getTime()));
		setWeekDay(localDate.dayOfWeek().getAsText());
		return this;
	}

	public Date getCurrentDateAndTime() {
		return currentDateAndTime;
	}

	public void setCurrentDateAndTime(Date currentDateAndTime) {
		this.currentDateAndTime = currentDateAndTime;
	}

	public Double getGewicht() {
		return gewicht;
	}

	public void setGewicht(Double gewicht) {
		this.gewicht = gewicht;
	}

	public boolean isPipi() {
		return pipi;
	}

	public void setPipi(boolean pipi) {
		this.pipi = pipi;
	}

	public boolean isKaka() {
		return kaka;
	}

	public void setKaka(boolean kaka) {
		this.kaka = kaka;
	}

	public boolean isStillen() {
		return stillen;
	}

	public void setStillen(boolean stillen) {
		this.stillen = stillen;
	}

	public boolean isWickeln() {
		return wickeln;
	}

	public void setWickeln(boolean wickeln) {
		this.wickeln = wickeln;
	}

	public String getBemerkung() {
		return bemerkung;
	}

	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
	}

	public String getStillenBemerkung() {
		return stillenBemerkung;
	}

	public void setStillenBemerkung(String stillenBemerkung) {
		this.stillenBemerkung = stillenBemerkung;
	}

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

}
