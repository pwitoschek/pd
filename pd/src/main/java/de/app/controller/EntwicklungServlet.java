package de.app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import de.app.utilities.CustomDBUtils;

@Controller
public class EntwicklungServlet {

	private final Logger LOGGER = Logger.getLogger(EntwicklungServlet.class);
	@Autowired
	private CustomDBUtils customDBUtils;

	@RequestMapping("entwicklung.json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String getEntwicklungsRows(
			@RequestParam("fromDate1") final String date1,
			@RequestParam("toDate2") final String date2) {
		String result = "";
		LOGGER.debug(date1 + "" + date2);
		String query = "SELECT * FROM entwicklung WHERE datum >= '" + date1
				+ " 00:00:00'" + " and datum <= '" + date2 + " 00:00:00'";
		result = customDBUtils.generateJson(query);
		return result;
	}
}
