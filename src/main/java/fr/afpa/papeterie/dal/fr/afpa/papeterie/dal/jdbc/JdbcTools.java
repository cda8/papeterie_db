package fr.afpa.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import fr.afpa.papeterie.dal.util.MesProprietes;


public class JdbcTools {
	MesProprietes properties = new MesProprietes();
	Properties prop = properties.chargerProp("Settings.properties");
	String urldb = prop.getProperty("URL");
	String userdb = prop.getProperty("USER");
	String passworddb = prop.getProperty("PASSWORD");
	Connection conn = null;
	/**
	 * connect method connects java to postgre using URL, USER, PASSWORD
	 * 
	 * @throws SQLException
	 * @return conn
	 */
	public Connection connect() {

		try {
			conn = DriverManager.getConnection(urldb, userdb, passworddb);
			if (conn != null) {
				System.out.println("Connected to the PostgreSQL server successfully.");
			} else {
				System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return conn;
	}

}
