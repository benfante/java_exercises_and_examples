package com.javacourse.examples.jpa.examples;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.javacourse.examples.jpa.model.Film;
import com.javacourse.examples.jpa.util.JpaUtil;

public class SearchFilmByActor {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Film> q = em.createQuery("SELECT f FROM Film f JOIN f.actors a WHERE a.firstName = :firstName", Film.class);
		q.setParameter("firstName", "JOHNNY");
		List<Film> films = q.getResultList();
		for (Film film : films) {
			System.out.println(film);
		}
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	}

}
