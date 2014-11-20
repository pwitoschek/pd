package de.app.pd.entities.pv;

import java.util.Date;

public abstract class Unit {
	private String weekDay;
	private String currentDateAndTime;
	private Double durchschnittsTemperatur;

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
