package donuttycoon;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class Db {

	public static Connection Db() {

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://ec2-54-243-203-93.compute-1.amazonaws.com:5432/d6s8ma77ta0qpn?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", "xpngkxwhdhcfvk", "QbT4Z9pO2mvK7Pg9kf25UYcesx");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		
		return connection;
	}
}
