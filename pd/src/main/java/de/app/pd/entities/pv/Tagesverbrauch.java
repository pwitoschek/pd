/**
 * 
 */
package de.app.pd.entities.pv;

import java.util.Date;

/**
 * @author Peter
 *
 */
public class Tagesverbrauch {
	
	private int gebrauchteKWH;
	private Date currentDateAndTime;
	private Double durchschnittsTemperatur;
	private String wochentag;
	
	public int getGebrauchteKWH() {
		return gebrauchteKWH;
	}
	public void setGebrauchteKWH(int gebrauchteKWH) {
		this.gebrauchteKWH = gebrauchteKWH;
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
	public String getWochentag() {
		return wochentag;
	}
	public void setWochentag(String wochentag) {
		this.wochentag = wochentag;
	}

}
