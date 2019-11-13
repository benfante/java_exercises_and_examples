package com.javacourse.examples.jpa.examples;

import javax.persistence.EntityManager;

import com.javacourse.examples.jpa.model.Language;
import com.javacourse.examples.jpa.util.JpaUtil;

public class UpdateExample {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();

//		Language klingon = em.getReference(Language.class, (short)9);
		Language klingon = em.find(Language.class, (short)9);
		System.out.println(klingon.getName());
		
		klingon.setName("Klingon");
		
		//em.remove(klingon);
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	}
}
