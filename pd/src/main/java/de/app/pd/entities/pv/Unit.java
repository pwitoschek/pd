package de.app.pd.entities.pv;

import java.io.Serializable;
import java.util.Date;

import org.joda.time.LocalDate;

/*
 * Serializable muss implementiert sein für Flows
 */
public abstract class Unit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6408427900445775413L;
	private String weekDay;
	// @NotNull
	private Date currentDateAndTime;
	private double durchschnittsTemperatur;

	public Unit setInitValues() {
		LocalDate localDate = new LocalDate();
		localDate.dayOfWeek().getAsString();
		// Calendar calendar = new GregorianCalendar();
		// setWeekDay(DateUtilities.getWeekDay(calendar.get(Calendar.DAY_OF_WEEK)));
		// setCurrentDateAndTime(new Timestamp(new Date().getTime()));
		setWeekDay(localDate.dayOfWeek().getAsText());
		return this;
	}

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	public Date getCurrentDateAndTime() {
		return currentDateAndTime;
	}

	public void setCurrentDateAndTime(Date currentDateAndTime) {
		this.currentDateAndTime = currentDateAndTime;
	}

	public Double getDurchschnittsTemperatur() {
		return durchschnittsTemperatur;
	}

	public void setDurchschnittsTemperatur(Double durchschnittsTemperatur) {
		this.durchschnittsTemperatur = durchschnittsTemperatur;
	}

}
