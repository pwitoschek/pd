package de.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class EntwicklungServlet {

	@RequestMapping("entwicklung.json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<String> getEntwicklungsRows(
			@RequestParam("fromDate1") final String date1,
			@RequestParam("toDate2") final String date2) {
		System.out.println(date1 + "" + date2);
		return null;
	}
}
