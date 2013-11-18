/**
 * 
 */
package de.app.interfaces;

import java.sql.Connection;

/**
 * @author Peter
 * 
 */
public interface DBConnection extends Connection {

	public Connection getConnection();

}
