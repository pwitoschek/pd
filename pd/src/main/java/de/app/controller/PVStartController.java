/**
 * 
 */
package de.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import db.DataAccessObjectImpl;
import de.app.interfaces.DataAccessObject;
import de.app.pd.entities.pv.Tagesverbrauch;

/**
 * @author pd
 * 
 */

@Controller
public class PVStartController {

	@RequestMapping(value = "/pv/{function}", method = { RequestMethod.GET })
	public ModelAndView getStartpage(@PathVariable String function) {
		DataAccessObject dao = new DataAccessObjectImpl();
		List<Tagesverbrauch> tagesverbrauchs = dao.getTagesverbrauch();

		String viewname = "";
		if (function.equals("uTagesverbrauch")) {
			viewname = "uTagesverbrauch";
		}
		return new ModelAndView("uTagesverbrauch", "tagesverbrauchs",
				tagesverbrauchs);
	}
}
