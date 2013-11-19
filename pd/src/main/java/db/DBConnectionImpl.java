/**
 * 
 */
package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.app.interfaces.DBConnection;

/**
 * @author Peter
 * 
 */
@Component
public class DBConnectionImpl implements DBConnection {

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.app.interfaces.DBConnection#getConnection()
	 */

	@Autowired
	DataSource dataSource;

	@Override
	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
			}
		}
		return connection;
	}

}
