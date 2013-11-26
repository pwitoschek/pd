/**
 * 
 */
package de.app.utilities;

/**
 * @author pd
 * 
 */
public enum WeekDay {
	Montag(1), Dienstag(2), Mittwoch(3), Donnerstag(4), Freitag(5), Samstag(6), Sonntag(
			0);
	private int id;

	private WeekDay(int i) {
		id = i;
	}
}
