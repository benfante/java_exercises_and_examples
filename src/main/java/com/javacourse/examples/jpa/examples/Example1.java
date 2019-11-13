package com.javacourse.examples.jpa.examples;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.javacourse.examples.jpa.model.Actor;
import com.javacourse.examples.jpa.model.Film;
import com.javacourse.examples.jpa.util.JpaUtil;

public class Example1 {
	public static void main1(String[] args) {
		EntityManager em = null;
		List<Film> result = null;
		try {
			em = JpaUtil.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Film> query = em.createQuery("select f from Film f", Film.class);
			result = query.getResultList();
			for (Film film : result) {
//				System.out.printf("%d %s %.2f %s (", film.getFilmId(), film.getTitle(), film.getReplacementCost(), film.getLanguage().getName());
				System.out.printf("%d %s %.2f (", film.getFilmId(), film.getTitle(), film.getReplacementCost());
				for (Actor actor : film.getActors()) {
					System.out.printf("%s %s,", actor.getFirstName(), actor.getLastName());
				}
				System.out.println(")");
			}
			em.getTransaction().commit();
		} finally {
			if (em != null) em.close();
			JpaUtil.closeEntityManagerFactory();
		}
	}

	public static void main1_1(String[] args) {
		EntityManager em = null;
		List<Film> result = null;
		try {
			em = JpaUtil.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Film> query = em.createQuery("select f from Film f WHERE f.title LIKE :title", Film.class);
			query.setParameter("title", "%LOVE%");
			result = query.getResultList();
			for (Film film : result) {
				System.out.printf("%d %s %.2f %s (", film.getFilmId(), film.getTitle(), film.getReplacementCost(), film.getLanguage().getName());
				for (Actor actor : film.getActors()) {
					System.out.printf("%s %s,", actor.getFirstName(), actor.getLastName());
				}
				System.out.println(")");
			}
			em.getTransaction().commit();
		} finally {
			if (em != null) em.close();
			JpaUtil.closeEntityManagerFactory();
		}
	}
	
	public static void main(String[] args) {
		EntityManager em = null;
		try {
			em = JpaUtil.getEntityManagerFactory().createEntityManager();
			
			EntityGraph<Film> graph = em.createEntityGraph(Film.class);
			graph.addAttributeNodes("actors");
			
			em.getTransaction().begin();
			TypedQuery<Film> query = em.createQuery("select f from Film f", Film.class);
			query.setHint("javax.persistence.loadgraph", graph);
			List<Film> result = query.getResultList();
			for (Film film : result) {
				System.out.printf("%d %s %.2f %s (", film.getFilmId(), film.getTitle(), film.getReplacementCost(), film.getLanguage().getName());
				for (Actor actor : film.getActors()) {
					System.out.printf("%s %s,", actor.getFirstName(), actor.getLastName());
				}
				System.out.println();
			}
			em.getTransaction().commit();
		} finally {
			if (em != null) em.close();
			JpaUtil.closeEntityManagerFactory();
		}
	}

	public static void main3(String[] args) {
		EntityManager em = null;
		try {
			em = JpaUtil.getEntityManagerFactory().createEntityManager();
					
			em.getTransaction().begin();
			TypedQuery<Film> query = em.createNamedQuery("Film.findAll", Film.class);
			query.setHint("javax.persistence.loadgraph",
					em.getEntityGraph("graph.Film.actors"));
			List<Film> result = query.getResultList();
			for (Film film : result) {
				System.out.printf("%d %s %.2f %s (", film.getFilmId(), film.getTitle(), film.getReplacementCost(), film.getLanguage().getName());
				for (Actor actor : film.getActors()) {
					System.out.printf("%s %s,", actor.getFirstName(), actor.getLastName());
				}
				System.out.println();
			}
			em.getTransaction().commit();
		} finally {
			if (em != null) em.close();
			JpaUtil.closeEntityManagerFactory();
		}
	}
	
}
