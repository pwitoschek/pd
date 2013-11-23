/**
 * 
 */
package de.app.interfaces;

import java.util.List;

import de.app.pd.entities.pv.Tagesertrag;
import de.app.pd.entities.pv.Tagesverbrauch;

/**
 * @author Peter
 * 
 */
public interface DataAccessObject {
	public List<Tagesertrag> getTagesertrag(int month);

	public List<Tagesverbrauch> getTagesverbrauch(int month);

	public void addTagesertrag();

	public void addTagesverbrauch();

	public void deleteTagesverbrauch();

	public void deleteTagesertrag();

	public void updateTagesverbrauch(Tagesverbrauch tagesverbrauch);

	public void updateTagesertrag(Tagesertrag tagesertrag);

}
