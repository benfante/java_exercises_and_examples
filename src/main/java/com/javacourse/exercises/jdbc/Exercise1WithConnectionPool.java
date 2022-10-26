package com.javacourse.exercises.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercise1WithConnectionPool {
	private static final Logger log = LoggerFactory.getLogger(Exercise1WithConnectionPool.class);

	private static final Map<String, String> QUERIES;

	static {
		String mysqlMainQuery = """
			SELECT DISTINCT f.film_id, f.title, f.release_year, length FROM film f
					JOIN inventory i ON (i.film_id = f.film_id)
					JOIN rental r ON (r.inventory_id = i.inventory_id)
				WHERE YEAR(r.rental_date) = ? AND i.store_id = ?
				ORDER BY f.title;
			""";

		String postgresqlMainQuery = """
			SELECT DISTINCT f.film_id, f.title, f.release_year, length FROM film f
					JOIN inventory i ON (i.film_id = f.film_id)
					JOIN rental r ON (r.inventory_id = i.inventory_id)
				WHERE EXTRACT(YEAR FROM r.rental_date) = ? AND i.store_id = ?
				ORDER BY f.title;
			""";

		QUERIES = Map.of("MySQL", mysqlMainQuery,
			"PostgreSQL", postgresqlMainQuery);
	}

	private static final String JDBC_DATABASE_PROPERTIES = "com/javacourse/exercises/jdbc/database.properties";
	// private static final String JDBC_DATABASE_PROPERTIES = "com/javacourse/exercises/jdbc/database-postgres.properties";

	private DataSource dataSource;

	public Exercise1WithConnectionPool(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void printFilms(int storeId, int year) {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn
					.prepareStatement(QUERIES.get(conn.getMetaData().getDatabaseProductName()));
				PreparedStatement stmt2 = conn.prepareStatement("""
					SELECT a.first_name, a.last_name FROM actor a
							JOIN film_actor fa ON (fa.actor_id = a.actor_id)
						WHERE fa.film_id = ?;
					""");) {
			log.info("Connected to database {}", conn.getMetaData().getDatabaseProductName());
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
						List<String> actors = new ArrayList<>();
						while (rs2.next()) {
							actors.add("%s %s".formatted(
								rs2.getString(1),
								rs2.getString(2)));
						}
						System.out.printf("%s, %d, %d min., (%s)%n",
							title, releaseYear, length,
							actors.stream().collect(Collectors.joining(", ")));
					}
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException, IOException {
		try (BasicDataSource dataSource = getDataSource();
			Scanner scan = new Scanner(System.in);
		) {
			Exercise1WithConnectionPool app = new Exercise1WithConnectionPool(dataSource);
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
