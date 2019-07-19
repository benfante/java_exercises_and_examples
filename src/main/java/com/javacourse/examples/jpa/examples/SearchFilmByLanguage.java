package com.javacourse.examples.jpa.examples;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.javacourse.examples.jpa.model.Film;
import com.javacourse.examples.jpa.model.Language;
import com.javacourse.examples.jpa.util.JpaUtil;

public class SearchFilmByLanguage {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Film> q =
				em.createQuery("SELECT f FROM Film f WHERE f.language.name = :languageName", Film.class);
		q.setParameter("languageName", "English");
		List<Film> films = q.getResultList();
		for(Film film: films) {
			System.out.println(film);
		}
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	}
	
	public static void main2(String[] args) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Language> q = em.createQuery("from Language l WHERE l.name = 'Italian'", Language.class);
		
		Language italian = q.getSingleResult();
		for(Film film: italian.getFilms()) {
			System.out.println(film.getTitle());
		}
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
		

	}

	public static void main3(String[] args) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Film> q =
				em.createNamedQuery("Film.findByLanguage", Film.class);
		q.setParameter("languageName", "English");
		List<Film> films = q.getResultList();
		for(Film film: films) {
			System.out.println(film.getTitle());
		}
		
		em.getTransaction().commit();
		em.close();
		JpaUtil.closeEntityManagerFactory();
	}
	
}
