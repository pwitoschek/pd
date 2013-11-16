package de.app.pd;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.app.pd.entity.pv.Tagesertrag;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("PDPersitenceUnit");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			Tagesertrag tagesertrag = new Tagesertrag();
			tagesertrag.setDatum(new Date());
			tagesertrag.setDurchschnittsTemperatur(4.0);
			tagesertrag.setErzeugerStrom(10.0);
			tagesertrag.setWochentag("Samstag");
			em.persist(tagesertrag);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error(e.toString());
		}

		return "home";
	}

}
