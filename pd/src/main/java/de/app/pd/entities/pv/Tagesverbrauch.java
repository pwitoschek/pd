/**
 * 
 */
package de.app.pd.entities.pv;

import java.io.Serializable;

/**
 * @author Peter
 * 
 */
public class Tagesverbrauch extends Unit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7196263870929574803L;
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
