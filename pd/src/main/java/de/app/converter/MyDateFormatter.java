package de.app.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class MyDateFormatter implements Formatter<Date> {

	private static final String EEE_MMM_dd_HH_mm_ss_z_yyy = "EEE MMM dd HH:mm:ss z yyyy";
	// private static final String DD_MM_YYYY = "yyyy-MM-dd";
	private static final String YYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:MM:SS";

	@Override
	public String print(final Date date, final Locale locale) {
		SimpleDateFormat format = new SimpleDateFormat(
				EEE_MMM_dd_HH_mm_ss_z_yyy);
		return format.format(date);
	}

	@Override
	public Date parse(final String source, final Locale locale)
			throws ParseException {
		Date d = null;
		SimpleDateFormat format = new SimpleDateFormat(YYY_MM_DD_HH_MM_SS);
		d = format.parse(source);
		return d;
	}
}
