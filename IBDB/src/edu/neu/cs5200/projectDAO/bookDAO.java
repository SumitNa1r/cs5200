package edu.neu.cs5200.projectDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs5200.project.author;
import edu.neu.cs5200.project.book;


public class bookDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("IBDB");
	EntityManager em = factory.createEntityManager();
	
	public void createBook(author a, book b){		
		b.setAuth(a);
		a.getBooks().add(b);
		
		em.getTransaction().begin();		
		em.merge(a);
		em.getTransaction().commit();		
	}
	
	public List<book> getBooks(){
		Query query = em.createQuery("select b from book b");
		@SuppressWarnings("unchecked")
		List<book> b = query.getResultList();
		return b;
	}
	
	public book getBookById(int id){
		return em.find(book.class, id);
	}
	
	public book getBookByISBN(int isbn){
		Query query = em.createQuery("select b from book b where b.isbn = :id ");
		query.setParameter("id", isbn);
		book b = (book) query.getSingleResult();
		return b;		
	}
	
	public book getBookByName(String name){
		Query query = em.createQuery("select b from book b where b.name = :id ");
		query.setParameter("id", name);
		book b = (book) query.getSingleResult();
		return b;		
	}
	
	public void removeBookById(int id){
		book b = em.find(book.class, id);
		em.getTransaction().begin();
		em.remove(b);
		em.getTransaction().commit();
	}
	
	public void removeBookByName(String name){
		Query query = em.createQuery("select b from book b where b.name = :id ");
		query.setParameter("id", name);
		book b = (book) query.getSingleResult();
		em.getTransaction().begin();
		em.remove(b);
		em.getTransaction().commit();		
	}
	
	public void removeBookByISBN(int isbn){
		Query query = em.createQuery("select b from book b where b.isbn = :id ");
		query.setParameter("id", isbn);
		book b = (book) query.getSingleResult();
		em.getTransaction().begin();
		em.remove(b);
		em.getTransaction().commit();	
	}
	
	public void updateBook(int id, book b){
		em.getTransaction().begin();
		b.setId(id);
		em.merge(b);
		em.getTransaction().commit();
	}
}
