package edu.neu.cs5200.projectDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.neu.cs5200.project.stack;

public class stackDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("IBDB");
	EntityManager em = factory.createEntityManager();
	
	private stack createStack(stack s) {
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		return s;
	}
	
	private List<stack> readStackOfUser(String Username){
		return (List<stack>) em.find(stack.class, Username);
	}
	
}
