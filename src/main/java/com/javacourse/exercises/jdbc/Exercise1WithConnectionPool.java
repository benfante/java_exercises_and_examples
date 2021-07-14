package com.javacourse.exercises.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Exercise1WithConnectionPool {

	// Query for MySQL
	// private static final String MAIN_QUERY = "SELECT DISTINCT f.film_id, f.title, f.release_year, length FROM film f"
	// 		+ " JOIN inventory i ON (i.film_id = f.film_id)"
	// 		+ " JOIN rental r ON (r.inventory_id = i.inventory_id)"
	// 		+ " WHERE YEAR(r.rental_date) = ? AND i.store_id = ?"
	//      + " ORDER BY f.title;";

	// Query for PostgreSQL
	private static final String MAIN_QUERY = "SELECT DISTINCT f.film_id, f.title, f.release_year, length FROM film f"
			+ " JOIN inventory i ON (i.film_id = f.film_id)"
			+ " JOIN rental r ON (r.inventory_id = i.inventory_id)"
			+ " WHERE EXTRACT(YEAR FROM r.rental_date) = ? AND i.store_id = ?"
			+ " ORDER BY f.title;";

	//	private static final String JDBC_DATABASE_PROPERTIES = "com/javacourse/exercises/jdbc/database.properties";
	private static final String JDBC_DATABASE_PROPERTIES = "com/javacourse/exercises/jdbc/database-postgres.properties";

	private DataSource dataSource;

	public Exercise1WithConnectionPool(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void printFilms(int storeId, int year) {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement(MAIN_QUERY);
				PreparedStatement stmt2 = conn.prepareStatement("SELECT a.first_name, a.last_name FROM actor a"
						+ " JOIN film_actor fa ON (fa.actor_id = a.actor_id)" + " WHERE fa.film_id = ?;");) {
			stmt.setInt(1, year);
			stmt.setInt(2, storeId);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					int id = rs.getInt("film_id");
					String title = rs.getString("title");
					int releaseYear = rs.getInt("release_year");
					int length = rs.getInt("length");
					stmt2.setInt(1, id);
					try (ResultSet rs2 = stmt2.executeQuery()) {
						System.out.print(title + ", " + releaseYear + ", " + length + " min., (");
						if (rs2.next()) {
							System.out.print(rs2.getString(1) + " " + rs2.getString(2));
							while (rs2.next()) {
								System.out.print(", " + rs2.getString(1) + " " + rs2.getString(2));
							}
						}
						System.out.println(")");
					}
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException, IOException {
		try (BasicDataSource dataSource = getDataSource()) {
			Exercise1WithConnectionPool app = new Exercise1WithConnectionPool(dataSource);
			Scanner scan = new Scanner(System.in);
			boolean exit = false;
			while (!exit) {
				System.out.print("Store id: ");
				int storeId = scan.nextInt();
				System.out.print("Year: ");
				int year = scan.nextInt();
				app.printFilms(storeId, year);
				System.out.print("Again (y/n)? ");
				scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
				if (!scan.nextLine().toLowerCase().equals("y")) {
					exit = true;
				}
			}
		}
	}

	private static BasicDataSource getDataSource() throws IOException {
		Properties properties = null;
		try(InputStream is = Exercise1WithConnectionPool.class.getClassLoader().getResourceAsStream(JDBC_DATABASE_PROPERTIES);) {
			properties = new Properties();
			properties.load(is);
		}
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl(properties.getProperty("jdbc.url"));
		basicDataSource.setUsername(properties.getProperty("jdbc.username"));
		basicDataSource.setPassword(properties.getProperty("jdbc.password"));
		basicDataSource.setMinIdle(5);
		basicDataSource.setTimeBetweenEvictionRunsMillis(1000000);
		basicDataSource.setMaxTotal(10);
		basicDataSource.setMaxConnLifetimeMillis(0);
		basicDataSource.setInitialSize(5);
		return basicDataSource;
	}
}
