/**
 * 
 */
package de.app.utilities;

/**
 * @author pd Dieses enum wird verwendet, sobald ich weiß, wie ich anhand der id
 *         auf den Namen des enums zugreifen kann
 */
public enum WeekDay {
	Montag(1), Dienstag(2), Mittwoch(3), Donnerstag(4), Freitag(5), Samstag(6), Sonntag(
			0);
	private int id;

	private WeekDay(int i) {
		id = i;
	}
}
