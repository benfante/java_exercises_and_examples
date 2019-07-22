package com.javacourse.examples.jpa.examples;

import java.util.Date;

import javax.persistence.EntityManager;

import com.javacourse.examples.jpa.model.Language;
import com.javacourse.examples.jpa.util.JpaUtil;

public class InsertExample {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();

		Language newLanguage = new Language();
		newLanguage.setName("Spanish");
//		newLanguage.setLastUpdate(new Date());
		
		em.persist(newLanguage);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	}
}
