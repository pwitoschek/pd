/**
 * 
 */
package de.home.pd.db;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import de.app.pd.entities.pv.Tagesertrag;

/**
 * @author pd
 * 
 */
public class NewDBEntryTest {

	private static Logger logger = Logger.getLogger(NewDBEntryTest.class);

	@Test
	public void test() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("PDPersitenceUnit");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			Tagesertrag tagesertrag = new Tagesertrag();
			tagesertrag.setCurrentDateAndTime(new Date());
			tagesertrag.setDurchschnittsTemperatur(4.0);
			tagesertrag.setErtrag(10.0);
			tagesertrag.setWeekDay("Samstag");
			em.persist(tagesertrag);
			em.getTransaction().commit();
			Assert.assertTrue(true);

		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error(e.toString());
			Assert.fail(e.toString());
		}
	}

}
