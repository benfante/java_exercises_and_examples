package com.javacourse.exercises.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise1WithPrepared {
	public void printFilms(int storeId, int year) {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/sakila?serverTimezone=UTC&useSSL=false",
				"root", "root");
				PreparedStatement stmt = conn.prepareStatement("""
					SELECT DISTINCT f.film_id, f.title, f.release_year, length FROM film f
						JOIN inventory i ON (i.film_id = f.film_id)
						JOIN rental r ON (r.inventory_id = i.inventory_id)
						WHERE YEAR(r.rental_date) = ? AND i.store_id = ?
						ORDER BY f.title;
					""");
				PreparedStatement stmt2 = conn.prepareStatement("""
					SELECT a.first_name, a.last_name FROM actor a
						JOIN film_actor fa ON (fa.actor_id = a.actor_id)
						WHERE fa.film_id = ?;
					""");) {
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

	public static void main(String[] args) {
		Exercise1WithPrepared app = new Exercise1WithPrepared();
		try (Scanner scan = new Scanner(System.in)) {
			boolean exit = false;
			while (!exit) {
				System.out.print("Store id: ");
				int storeId = scan.nextInt();
				System.out.print("Year: ");
				int year = scan.nextInt();
				scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				app.printFilms(storeId, year);

				System.out.print("Again (y/n)? ");
				if (!scan.nextLine().toLowerCase().equals("y")) {
					exit = true;
				}
			}
		}
	}
}
