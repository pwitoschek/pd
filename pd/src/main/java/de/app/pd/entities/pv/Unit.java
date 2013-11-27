package de.app.pd.entities.pv;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import de.app.utilities.DateUtilities;

/*
 * Serializable muss implementiert sein für Flows
 */
public abstract class Unit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6408427900445775413L;
	private String weekDay;
	private Date currentDateAndTime;
	private Double durchschnittsTemperatur;

	public Unit setInitValues() {
		Calendar calendar = new GregorianCalendar();
		setWeekDay(DateUtilities.getWeekDay(calendar.get(Calendar.DAY_OF_WEEK)));
		setCurrentDateAndTime(new Timestamp(new Date().getTime()));
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
