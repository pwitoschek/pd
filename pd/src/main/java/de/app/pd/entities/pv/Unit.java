package de.app.pd.entities.pv;

import java.io.Serializable;
import java.util.Date;

public abstract class Unit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6408427900445775413L;
	private String weekDay;
	private Date currentDateAndTime;
	private Double durchschnittsTemperatur;

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
