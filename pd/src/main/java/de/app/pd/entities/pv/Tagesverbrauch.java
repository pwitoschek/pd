/**
 * 
 */
package de.app.pd.entities.pv;

/**
 * @author Peter
 * 
 */
public class Tagesverbrauch extends Unit {

	private double gebrauchteKWH;
	private double sumToday;

	public double getGebrauchteKWH() {
		return gebrauchteKWH;
	}

	public void setGebrauchteKWH(double gebrauchteKWH) {
		this.gebrauchteKWH = gebrauchteKWH;
	}

	public double getSumToday() {
		return sumToday;
	}

	public void setSumToday(double sumToday) {
		this.sumToday = sumToday;
	}
}
