package edu.neu.cs5200.projectDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs5200.project.author;
import edu.neu.cs5200.project.comment_author;
import edu.neu.cs5200.project.regusers;

public class comment_authorDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("IBDB");
	EntityManager em = factory.createEntityManager();
	
	public void createComment(comment_author c, author a, regusers u){
		c.setAuthor(a);
		c.setUsr(u);
		a.getComnt().add(c);
		u.getAuth_comnt().add(c);
		em.getTransaction().begin();
		em.merge(a);
		em.merge(u);
		em.getTransaction().commit();		
	}
	
	public comment_author getCommentByID(int id){
		return em.find(comment_author.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<comment_author> getComments(){
		Query query = em.createQuery("select c from comment_author c");
		return (List<comment_author>) query.getResultList();
	}

	public void updateComment(comment_author c){
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();	
	}
	
	public void deleteComment(int id){
		comment_author c = em.find(comment_author.class, id);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();		
	}
}
