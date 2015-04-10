package edu.neu.cs5200.projectDAO;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs5200.project.comment;

public class commentDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("IBDB");
	EntityManager em = factory.createEntityManager();
	
	private comment createComment(comment c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		return c;
	}
	
	private comment readCommentByID(int id){
		return em.find(comment.class, id);
	}
	
	private List<comment> readAllComments(){
		Query query = em.createQuery("select c from comment c");
		return (List<comment>) query.getResultList();
	}
	
	private comment updateComment(comment c){
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();	
		return c;
	}
	
	private void deleteComment(int id){
		comment c = em.find(comment.class, id);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		
	}

	public static void main (String args[]) throws IOException
	{
		commentDAO dao = new commentDAO();
		
		/*CREATE
		comment c = new comment(123, "sum", "First comment");
		c = dao.createComment(c);
		System.out.println(c.getComment());
		*/
		
		/*READ BY UNAME
		comment c = dao.readCommentByID(1);
		System.out.println(c.getComment());
		*/
		
		/*READ ALL BY UNAME
		List <comment> c = dao.readAllComments();
		for(comment co : c){
			System.out.println(co.getComment());
		}
		*/
		
	    /* UPDATE Regusers
		comment c = dao.readCommentByID(1);
		c.setComment("updated comment");
		dao.updateComment(c);
		*/
		
		dao.deleteComment(1);
		
	}
}
