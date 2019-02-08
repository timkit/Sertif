package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private String user, pass, timeZone;

	public Connection getConn() throws SQLException {
		user = "myuser";
		pass = "";
		timeZone="UTC";
		//Asia/Krasnoyarsk
		try {
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://192.168.0.18/mes?useLegacyDatetimeCode=false&amp" + "&serverTimezone="+timeZone, user,
					pass);
			return connection;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
