/**
 * 
 */
package de.app.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.app.interfaces.DataAccessObject;
import de.app.pd.entities.pv.Tagesertrag;
import de.app.pd.entities.pv.Tagesverbrauch;

/**
 * @author Peter
 * 
 */
@Component
public class DataAccessObjectImpl implements DataAccessObject {

	// Da es hier nur eine eine Implementierung dieses Interfaces gibt,
	// wird automatisch die richtige Implementierung des Interfaces eingebunden.
	// Hier mache ich aber einen großen Fehler, indem die Connection in dem
	// Interface geschlossen wird
	@Autowired
	DataSource dataSource;

	private static Log4JLogger logger = new Log4JLogger();

	/*
	 * Diese Methode gibt alle gespeicherten Tageserträge zurück
	 */
	@Override
	public List<Tagesertrag> getTagesertrag() {
		List<Tagesertrag> tagesertraege = new ArrayList<Tagesertrag>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select currentDateAndTime, durchschnittsTemperatur, weekDay, ertrag from tagesertrag";
		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Tagesertrag tempTagesertrag = new Tagesertrag();

				tempTagesertrag.setCurrentDateAndTime(rs.getString("currentDateAndTime"));
				tempTagesertrag.setDurchschnittsTemperatur(Double
						.parseDouble(rs.getString("durchSchnittsTemperatur")));
				tempTagesertrag.setWeekDay(rs.getString("weekDay"));
				tempTagesertrag
						.setErtrag(Double.valueOf(rs.getString("ertrag")));

				tagesertraege.add(tempTagesertrag);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			DbUtils.closeQuietly(connection, ps, rs);
		}
		return tagesertraege;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.app.interfaces.DataAccessObject#getTagesverbrauch()
	 */
	@Override
	public List<Tagesverbrauch> getTagesverbrauch() {
		List<Tagesverbrauch> tagesverbrauchs = new ArrayList<Tagesverbrauch>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select currentDateAndTime, durchschnittsTemperatur, weekDay, gebrauchteKWH from tagesverbrauch";
		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Tagesverbrauch tempTagesverbrauch = new Tagesverbrauch();

				tempTagesverbrauch.setCurrentDateAndTime(rs.getString("currentDateAndTime"));
				tempTagesverbrauch.setDurchschnittsTemperatur(Double.parseDouble(rs.getString("durchSchnittsTemperatur")));
				tempTagesverbrauch.setWeekDay(rs.getString("weekDay"));
				tempTagesverbrauch.setGebrauchteKWH(Double.valueOf(rs.getString("gebrauchteKWH")));

				tagesverbrauchs.add(tempTagesverbrauch);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			DbUtils.closeQuietly(connection, ps, rs);
		}
		return tagesverbrauchs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.app.interfaces.DataAccessObject#addTagesertrag()
	 */
	@Override
	public void addTagesertrag() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.app.interfaces.DataAccessObject#addTagesverbrauch()
	 */
	@Override
	public void addTagesverbrauch() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.app.interfaces.DataAccessObject#deleteTagesverbrauch()
	 */
	@Override
	public void deleteTagesverbrauch() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.app.interfaces.DataAccessObject#deleteTagesertrag()
	 */
	@Override
	public void deleteTagesertrag() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.app.interfaces.DataAccessObject#updateTagesverbrauch(de.app.pd.entities
	 * .pv.Tagesverbrauch)
	 */
	@Override
	public void updateTagesverbrauch(Tagesverbrauch tagesverbrauch) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.app.interfaces.DataAccessObject#updateTagesertrag(de.app.pd.entities
	 * .pv.Tagesertrag)
	 */
	@Override
	public void updateTagesertrag(Tagesertrag tagesertrag) {
		// TODO Auto-generated method stub

	}

}
