package de.app.pd.entities.pv;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.joda.time.LocalDate;

/*
 * Serializable muss implementiert sein f�r Flows
 */
public abstract class Unit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6408427900445775413L;
	private String weekDay;
	@NotNull
	private String currentDateAndTime;
	private Double durchschnittsTemperatur;

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

	public String getCurrentDateAndTime() {
		return currentDateAndTime;
	}

	public void setCurrentDateAndTime(String currentDateAndTime) {
		this.currentDateAndTime = currentDateAndTime;
	}

	public Double getDurchschnittsTemperatur() {
		return durchschnittsTemperatur;
	}

	public void setDurchschnittsTemperatur(Double durchschnittsTemperatur) {
		this.durchschnittsTemperatur = durchschnittsTemperatur;
	}

}
