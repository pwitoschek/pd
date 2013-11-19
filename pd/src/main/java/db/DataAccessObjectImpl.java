/**
 * 
 */
package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.app.interfaces.DBConnection;
import de.app.interfaces.DataAccessObject;
import de.app.pd.entities.pv.Tagesertrag;
import de.app.pd.entities.pv.Tagesverbrauch;

/**
 * @author Peter
 * 
 */

public class DataAccessObjectImpl implements DataAccessObject {

	// Da es hier nur eine eine Implementierung dieses Interfaces gibt,
	// wird automatisch die richtige Implementierung des Interfaces eingebunden.
	// Hier mache ich aber einen großen Fehler, indem die Connection in dem
	// Interface geschlossen wird
	@Autowired
	DBConnection connection;

	/*
	 * Diese Methode gibt alle gespeicherten Tageserträge zurück
	 */
	@Override
	public List<Tagesertrag> getTagesertrag() {
		List<Tagesertrag> tagesertraege = new ArrayList<Tagesertrag>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select * from tagesertrag";
		try {
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Tagesertrag tempTagesertrag = new Tagesertrag();
				tempTagesertrag.setCurrentDateAndTime(new SimpleDateFormat()
						.parse(rs.getString(0)));

				tagesertraege.add(tempTagesertrag);
			}
		} catch (Exception e) {

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
		// TODO Auto-generated method stub
		return null;
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
