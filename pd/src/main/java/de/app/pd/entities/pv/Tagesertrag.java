/**
 * 
 */
package de.app.pd.entities.pv;

import java.sql.Time;
import java.util.Date;

/**
 * @author Peter
 *
 */

public class Tagesertrag {
	private String weekDay;
	private Date date;
	private Time time;
	private Double ertrag;
	private Double durchschnittsTemperatur;
	
	public String getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Double getErtrag() {
		return ertrag;
	}
	public void setErtrag(Double ertrag) {
		this.ertrag = ertrag;
	}
	public Double getDurchschnittsTemperatur() {
		return durchschnittsTemperatur;
	}
	public void setDurchschnittsTemperatur(Double durchschnittsTemperatur) {
		this.durchschnittsTemperatur = durchschnittsTemperatur;
	}
}
