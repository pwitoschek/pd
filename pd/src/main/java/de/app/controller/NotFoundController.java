/**
 * 
 */
package de.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author pd
 * 
 */
@ControllerAdvice
public class NotFoundController {

	/**
	 * 
	 */

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleException(Exception e) {
		return "error";
	}

}
