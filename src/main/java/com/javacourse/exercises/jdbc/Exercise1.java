package com.javacourse.exercises.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Exercise1 {
	public void printFilms(int storeId, int year) {
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost/sakila?serverTimezone=UTC&useSSL=false", "root", "root");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
				.executeQuery("SELECT DISTINCT f.film_id, f.title, f.release_year, length FROM film f"
								+ " JOIN inventory i ON (i.film_id = f.film_id)"
								+ " JOIN rental r ON (r.inventory_id = i.inventory_id)"
								+ " WHERE YEAR(r.rental_date) = " + year + " AND i.store_id = " + storeId
								+ " ORDER BY f.title;");
				Statement stmt2 = conn.createStatement();) {
			while (rs.next()) {
				int id = rs.getInt("film_id");
				String title = rs.getString("title");
				int releaseYear = rs.getInt("release_year");
				int length = rs.getInt("length");
				try (ResultSet rs2 = stmt2.executeQuery("SELECT a.first_name, a.last_name FROM actor a"
						+ " JOIN film_actor fa ON (fa.actor_id = a.actor_id)" + " WHERE fa.film_id = " + id + ";")) {
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
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Exercise1 app = new Exercise1();
		Scanner scan = new Scanner(System.in);
		boolean exit = false;
		while(!exit) {
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
		scan.close();
	}
}
