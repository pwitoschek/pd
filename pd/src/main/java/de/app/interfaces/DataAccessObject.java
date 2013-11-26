/**
 * 
 */
package de.app.interfaces;

import java.util.List;

import org.springframework.webflow.execution.Event;

import de.app.pd.entities.pv.Tagesertrag;
import de.app.pd.entities.pv.Tagesverbrauch;

/**
 * @author Peter
 * 
 */
public interface DataAccessObject {
	public List<Tagesertrag> getTagesertrag(int month);

	public List<Tagesverbrauch> getTagesverbrauch(int month);

	public Event addTagesertrag(Tagesertrag tagesertrag);

	public boolean addTagesverbrauch(Tagesverbrauch tagesverbrauch);

	public boolean deleteTagesverbrauch(Tagesverbrauch tagesverbrauch);

	public boolean deleteTagesertrag(Tagesertrag tagesertrag);

	public boolean updateTagesverbrauch(Tagesverbrauch tagesverbrauch);

	public boolean updateTagesertrag(Tagesertrag tagesertrag);

}
