/**
 * 
 */
package de.app.pd.entities.pv;

import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @author Peter
 * 
 */
@Component
public class Tagesertrag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String weekDay;
	private Date date;
	private Time time;
	private Double ertrag;
	private Double durchschnittsTemperatur;

	public Tagesertrag setInitValues() {
		Tagesertrag tagesertrag = new Tagesertrag();
		Date currentDate = new Date();
		tagesertrag.setDate(currentDate);
		tagesertrag.setTime(new Time(currentDate.getTime()));
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
		tagesertrag.setWeekDay(dateFormat.format(currentDate));

		return tagesertrag;
	}

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
