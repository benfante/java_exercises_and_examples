package com.javacourse.examples.jpa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author <a href="mailto:lucio.benfante@gmail.com">Lucio Benfante</a>
 */
public class JpaUtil {

	private static EntityManagerFactory entityManagerFactory;

	static {
		try {
			entityManagerFactory =
					Persistence.createEntityManagerFactory(
							"com.benfante.javacourse.jpa-examples");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	public static void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}
	
	private JpaUtil() {}
}
