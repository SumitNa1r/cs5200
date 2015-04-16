package edu.neu.cs5200.projectDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs5200.project.author;

public class authorDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("IBDB");
	EntityManager em = factory.createEntityManager();
	
	public author createAuthor(author a) {
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		return a;
	}
	
	public author getauthortByID(int id){
		return em.find(author.class, id);
	}
	
	public List<author> getAuthor() {
		Query query = em.createQuery("select a from author a");
		@SuppressWarnings("unchecked")
		List<author> a = query.getResultList();
		return a;
	}
	
	public author getAuthorByName(String name){
		Query query = em.createQuery("select a from author a where a.name = :id ");
		query.setParameter("id", name);
		author a = (author) query.getSingleResult();
		return a;		
	}
		
	public void removeAuthorById(int id){
		author a = em.find(author.class, id);
		em.getTransaction().begin();
		em.remove(a);
		em.getTransaction().commit();
	}
	
	public void updateAuthor(int id, author a){
		em.getTransaction().begin();
		a.setId(id);
		em.merge(a);
		em.getTransaction().commit();
	}
	
}
