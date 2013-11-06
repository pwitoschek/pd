/**
 * 
 */
package de.app.pd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author pd
 *
 */
@Controller
public class PVStartController {

	@RequestMapping(value="/pv/{function}", method={RequestMethod.GET})
	public ModelAndView getStartpage(@PathVariable String function){
		return new ModelAndView("test");
	}
	
}
