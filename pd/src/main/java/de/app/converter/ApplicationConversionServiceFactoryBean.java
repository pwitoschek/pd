/**
 * 
 */
package de.app.converter;

import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author pd Diese Klasse registriert diverse Formatter, die Strings (Request
 *         Parameter) im Webflow zu Objekten (im Model) umwandeln
 */
@Component(value = "applicationConversionService")
public class ApplicationConversionServiceFactoryBean extends
		FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		// Register the default date formatter provided by Spring
		registry.addFormatter(new DateFormatter("dd/MM/yyyy HH:mm"));
		registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
		// registry.addFormatter(new
		// DateFormatter("EEE MMM dd HH:mm:ss z yyyy"));
	}
}