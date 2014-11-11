/**
 * 
 */
package de.app.utilities;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author pd
 * 
 */
public class DateUtilities {

	public static String getWeekDay(int weekDay) {
		String result = "";
		switch (weekDay) {
		case 0:
			result = "Montag";
			break;
		case 1:
			result = "Dienstag";
			break;
		case 2:
			result = "Mittwoch";
			break;
		case 3:
			result = "Donnerstag";
			break;
		case 4:
			result = "Freitag";
			break;
		case 5:
			result = "Samstag";
			break;
		case 6:
			result = "Sonntag";
			break;
		}
		return result;
	}

	public static Timestamp getCurrentSqlTimestamp() {
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		return timestamp;
	}

	// Diese Methode gibt einen String in diesem Format zur�ck:
	// 2013-11-26 18:40:24
	public static String convertDateToMySQLDate(Date currentDateAndTime) {
		String result = "";
		result = (1900 + currentDateAndTime.getYear()) + "-"
				+ currentDateAndTime.getMonth() + "-"
				+ currentDateAndTime.getDay() + " "
				+ currentDateAndTime.getHours() + ":"
				+ currentDateAndTime.getMinutes() + ":"
				+ currentDateAndTime.getSeconds();
		return result;
	}

}
