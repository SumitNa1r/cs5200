package edu.neu.cs5200.projectDAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs5200.project.book;
import edu.neu.cs5200.project.comment;
import edu.neu.cs5200.project.regusers;

public class commentDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("IBDB");
	EntityManager em = factory.createEntityManager();
	
	public void createComment(comment c, book b, regusers r)
	{
		c.setBks(b);
		c.setUsers(r);
		b.getComnt().add(c);
		r.getComnt().add(c);
		em.getTransaction().begin();
		em.merge(b);
		em.merge(r);
		em.getTransaction().commit();	
	}
	
	public comment getCommentByID(int id){
		return em.find(comment.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<comment> getComments(){
		Query query = em.createQuery("select c from comment c");
		return (List<comment>) query.getResultList();
	}
	
	public void updateComment(comment c){
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();	
	}
	
	public void deleteComment(int id){
		comment c = em.find(comment.class, id);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		
	}

}
