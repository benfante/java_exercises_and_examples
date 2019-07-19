package com.javacourse.examples.jpa.examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.javacourse.examples.jpa.model.Film;
import com.javacourse.examples.jpa.util.JpaUtil;


public class DynamicQueryExample {
	
	public static Collection<Film> search(String title, int duration) {
		StringBuilder query = new StringBuilder("select f from Film f");
		if (title != null || duration >= 0) {
			boolean alreadyStarted = false;
			query.append(" WHERE");
			if (title != null) {
				query.append(" f.title = :title");
				alreadyStarted = true;
			}
			if (duration >= 0) {
				if (alreadyStarted) {
					query.append(" AND");
				}
				query.append(" f.length > :duration");
				alreadyStarted = true;
			}
		}
		System.out.println(query.toString());
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Film> q = em.createQuery(query.toString(), Film.class);
		if (title != null) {
			q.setParameter("title", title);
		}
		if (duration >= 0) {
			q.setParameter("duration", duration);
		}
		List<Film> result = q.getResultList();
		em.getTransaction().commit();
		em.close();
		return result;
	}
	

	public static Collection<Film> searchCriteria(String title, int duration) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Film> cq = cb.createQuery(Film.class);
		Root<Film> f = cq.from(Film.class);
		List<Predicate> predicates = new ArrayList<>();
		if (title != null) {
			Predicate titleCondition = cb.equal(f.get("title"), title);
			predicates.add(titleCondition);
		}
		if (duration >= 0) {
			Predicate durationCondition = cb.greaterThanOrEqualTo(f.get("length"), duration);
			predicates.add(durationCondition);
		}
		cq.where(predicates.toArray(new Predicate[0]));
		List<Film> result = em.createQuery(cq).getResultList();
		em.getTransaction().commit();
		em.close();
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(searchCriteria("Fantozzi", 0));
		JpaUtil.closeEntityManagerFactory();
	}

}
