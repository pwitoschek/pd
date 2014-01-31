package de.app.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class MyDateFormatter implements Formatter<Date> {

	private static final String DD_MM_YYYY = "dd.MM.yyyy";

	@Override
	public String print(final Date date, final Locale locale) {
		SimpleDateFormat format = new SimpleDateFormat(DD_MM_YYYY);
		return format.format(date);
	}

	@Override
	public Date parse(final String source, final Locale locale)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(DD_MM_YYYY);
		return format.parse(source);
	}
}
