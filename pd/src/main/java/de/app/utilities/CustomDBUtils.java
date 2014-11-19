package de.app.utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Component
public class CustomDBUtils {

	@Autowired
	DataSource datasource;

	private final Logger LOGGER = Logger.getLogger(this.getClass());

	public String generateJson(final String sqlStatement) {
		String json = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			connection = datasource.getConnection();
			pstmt = connection.prepareStatement(sqlStatement);
			resultSet = pstmt.executeQuery();
			json = getJsonString(resultSet);
		} catch (SQLException e) {
			LOGGER.error(e, e);
		} finally {
			DbUtils.closeQuietly(connection, pstmt, resultSet);
		}
		return json;
	}

	private String getJsonString(ResultSet resultSet) {
		JsonElement element = getJson(resultSet);
		Gson gson = new Gson();
		return gson.toJson(element);
	}

	private JsonArray getJson(final ResultSet rs) {
		JsonArray json = new JsonArray();
		try {
			ResultSetMetaData rsmd = rs.getMetaData();

			while (rs.next()) {
				int numColumns = rsmd.getColumnCount();
				JsonObject obj = new JsonObject();

				for (int i = 1; i < numColumns + 1; i++) {
					String columnName = rsmd.getColumnName(i);

					if (rsmd.getColumnType(i) == java.sql.Types.BIGINT) {
						obj.addProperty(columnName, rs.getInt(columnName));
					} else if (rsmd.getColumnType(i) == java.sql.Types.BOOLEAN) {
						obj.addProperty(columnName, rs.getBoolean(columnName));
					} else if (rsmd.getColumnType(i) == java.sql.Types.DOUBLE) {
						obj.addProperty(columnName, rs.getDouble(columnName));
					} else if (rsmd.getColumnType(i) == java.sql.Types.FLOAT) {
						obj.addProperty(columnName, rs.getFloat(columnName));
					} else if (rsmd.getColumnType(i) == java.sql.Types.INTEGER) {
						obj.addProperty(columnName, rs.getInt(columnName));
					} else if (rsmd.getColumnType(i) == java.sql.Types.NVARCHAR) {
						obj.addProperty(columnName, rs.getNString(columnName));
					} else if (rsmd.getColumnType(i) == java.sql.Types.VARCHAR) {
						obj.addProperty(columnName, rs.getString(columnName));
					} else if (rsmd.getColumnType(i) == java.sql.Types.TINYINT) {
						obj.addProperty(columnName, rs.getInt(columnName));
					} else if (rsmd.getColumnType(i) == java.sql.Types.SMALLINT) {
						obj.addProperty(columnName, rs.getInt(columnName));
					} else if (rsmd.getColumnType(i) == java.sql.Types.TIMESTAMP) {
						obj.addProperty(columnName, rs.getString(columnName));
					}
				}
				json.add(obj);
			}
		} catch (SQLException e) {
			LOGGER.error(e, e);
		}
		return json;
	}

}
