package donuttycoon;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class Db {

	public Db() {

		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgres://xpngkxwhdhcfvk:QbT4Z9pO2mvK7Pg9kf25UYcesx@ec2-54-243-203-93.compute-1.amazonaws.com:5432/d6s8ma77ta0qpn", "xpngkxwhdhcfvk",
					"QbT4Z9pO2mvK7Pg9kf25UYcesx");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}

}
