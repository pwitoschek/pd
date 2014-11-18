/**
 * 
 */
package de.app.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.webflow.core.collection.AttributeMap;
import org.springframework.webflow.core.collection.LocalAttributeMap;
import org.springframework.webflow.execution.Event;

import de.app.interfaces.DataAccessObject;
import de.app.pd.entities.paul.Entwicklung;
import de.app.pd.entities.pv.Tagesertrag;
import de.app.pd.entities.pv.Tagesverbrauch;
import de.app.utilities.DBException;
import de.app.utilities.DateUtilities;

/**
 * @author Peter
 * 
 */
@Component
public class DataAccessObjectImpl implements DataAccessObject {

	// Da es hier nur eine eine Implementierung dieses Interfaces gibt,
	// wird automatisch die richtige Implementierung des Interfaces eingebunden.
	// Hier mache ich aber einen gro�en Fehler, indem die Connection in dem
	// Interface geschlossen wird
	@Autowired
	DataSource dataSource;

	private static Log4JLogger logger = new Log4JLogger();

	/*
	 * Diese Methode gibt alle gespeicherten Tagesertr�ge zur�ck Es wird
	 * noch ermittelt
	 */
	@Override
	public List<Tagesertrag> getTagesertrag(int month) {
		List<Tagesertrag> tagesertraege = new ArrayList<Tagesertrag>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select currentDateAndTime, durchschnittsTemperatur, weekDay, ertrag from tagesertrag order by currentDateAndTime asc";
		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Tagesertrag tempTagesertrag = new Tagesertrag();

				tempTagesertrag.setCurrentDateAndTime(new SimpleDateFormat()
						.parse(rs.getString("currentDateAndTime")));
				if (StringUtils.isNotEmpty(rs
						.getString("durchSchnittsTemperatur"))) {
					tempTagesertrag.setDurchschnittsTemperatur(0.0);
				} else {
					tempTagesertrag.setDurchschnittsTemperatur(Double
							.parseDouble(rs
									.getString("durchSchnittsTemperatur")));
				}
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
	 * (non-Javadoc) die Differenz von der Menge der gebrauchten KWH zum
	 * vorherigen Eintrag
	 * 
	 * @see de.app.interfaces.DataAccessObject#getTagesverbrauch()
	 */
	@Override
	public List<Tagesverbrauch> getTagesverbrauch(int month) {
		List<Tagesverbrauch> tagesverbrauchs = new ArrayList<Tagesverbrauch>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select currentDateAndTime, durchschnittsTemperatur, weekDay, gebrauchteKWH from tagesverbrauch";
		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			Double tempSumToday = 0.0;
			while (rs.next()) {
				Tagesverbrauch tempTagesverbrauch = new Tagesverbrauch();
				Double gebrauchteKWH = Double.valueOf(rs
						.getString("gebrauchteKWH"));

				tempTagesverbrauch.setCurrentDateAndTime(new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").parse(rs
						.getString("currentDateAndTime")));
				tempTagesverbrauch.setDurchschnittsTemperatur(Double
						.parseDouble(rs.getString("durchSchnittsTemperatur")));
				tempTagesverbrauch.setWeekDay(rs.getString("weekDay"));
				tempTagesverbrauch.setGebrauchteKWH(gebrauchteKWH);

				tempTagesverbrauch.setSumToday(gebrauchteKWH - tempSumToday);

				tagesverbrauchs.add(tempTagesverbrauch);
				tempSumToday = gebrauchteKWH;
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
	public Event addTagesertrag(Tagesertrag tagesertrag) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("testAttribute", "test1");
		AttributeMap<Object> attributeMap = new LocalAttributeMap<Object>(map);

		String result = "failure";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "";
		try {
			query = "INSERT INTO pd_spring.tagesertrag ("
					+ "id,"
					+ "currentDateAndTime,"
					+ "durchschnittsTemperatur,"
					+ "weekDay,"
					+ "ertrag"
					+ ")"
					+ "VALUES ("
					+ "NULL ,'"
					+ DateUtilities.convertDateToMySQLDate(tagesertrag
							.getCurrentDateAndTime()) + "',"
					+ tagesertrag.getDurchschnittsTemperatur() + ",'"
					+ tagesertrag.getWeekDay() + "'," + tagesertrag.getErtrag()
					+ ")";

			connection = dataSource.getConnection();
			ps = connection.prepareStatement(query);
			ps.execute();
			result = "success";
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error(query);
		} finally {
			DbUtils.closeQuietly(connection, ps, rs);
		}
		return new Event(this, result, attributeMap);
	}

	public Event addEntwicklung(Entwicklung entwicklung) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("testAttribute", "test1");
		AttributeMap<Object> attributeMap = new LocalAttributeMap<Object>(map);

		String result = "failure";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "";

		try {
			String query2 = "INSERT INTO pd_spring.entwicklung (" + "datum,"
					+ "gewicht," + "pipi," + "kaka," + "wickeln,"
					+ "bemerkung," + "stillen," + "stillenBemerkung,"
					+ "wochentag" + ")" + "VALUES (?,?,?,?,?,?,?,?,?)";

			connection = dataSource.getConnection();
			ps = connection.prepareStatement(query2);
			ps.setString(1, entwicklung.getCurrentDateAndTime());
			ps.setDouble(2, entwicklung.getGewicht());
			ps.setBoolean(3, entwicklung.isPipi());
			ps.setBoolean(4, entwicklung.isKaka());
			ps.setBoolean(5, entwicklung.isWickeln());
			ps.setString(6, entwicklung.getBemerkung());
			ps.setBoolean(7, entwicklung.isStillen());
			ps.setString(8, entwicklung.getStillenBemerkung());
			ps.setString(9, entwicklung.getWeekDay());
			ps.execute();
			result = "success";
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error(query);
		} finally {
			DbUtils.closeQuietly(connection, ps, rs);
		}
		return new Event(this, result, attributeMap);
	}

	/*
	 * (non-Javadoc) Diese Methode wirft im Fehlerfall eine DBException Diese
	 * Exception wird ben�tigt, da im Flow darauf reagiert wird
	 * 
	 * @see de.app.interfaces.DataAccessObject#addTagesverbrauch()
	 */
	@Override
	public boolean addTagesverbrauch(Tagesverbrauch tagesverbrauch) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "";
		try {
			query = "INSERT INTO pd_spring.tagesverbrauch ("
					+ "id,"
					+ "currentDateAndTime,"
					+ "durchschnittsTemperatur,"
					+ "weekDay,"
					+ "gebrauchteKWH"
					+ ")"
					+ "VALUES ("
					+ "NULL ,'"
					+ DateUtilities.convertDateToMySQLDate(tagesverbrauch
							.getCurrentDateAndTime()) + "',"
					+ tagesverbrauch.getDurchschnittsTemperatur() + ",'"
					+ tagesverbrauch.getWeekDay() + "',"
					+ tagesverbrauch.getGebrauchteKWH() + ")";

			connection = dataSource.getConnection();
			ps = connection.prepareStatement(query);
			ps.execute();
			result = true;
		} catch (SQLException e) {
			logger.error(e.getMessage());
			try {
				throw new DBException();
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DbUtils.closeQuietly(connection, ps, rs);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.app.interfaces.DataAccessObject#updateTagesverbrauch(de.app.pd.entities
	 * .pv.Tagesverbrauch)
	 */
	@Override
	public boolean updateTagesverbrauch(Tagesverbrauch tagesverbrauch) {
		// TODO Auto-generated method stub
		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.app.interfaces.DataAccessObject#updateTagesertrag(de.app.pd.entities
	 * .pv.Tagesertrag)
	 */
	@Override
	public boolean updateTagesertrag(Tagesertrag tagesertrag) {
		// TODO Auto-generated method stub
		return false;

	}

	@Override
	public boolean deleteTagesverbrauch(Tagesverbrauch tagesverbrauch) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTagesertrag(Tagesertrag tagesertrag) {
		// TODO Auto-generated method stub
		return false;

	}

}
