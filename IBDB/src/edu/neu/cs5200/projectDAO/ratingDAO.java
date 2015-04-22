package edu.neu.cs5200.projectDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs5200.project.book;
import edu.neu.cs5200.project.rating;
import edu.neu.cs5200.project.regusers;

public class ratingDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("IBDB");
	EntityManager em = factory.createEntityManager();
	
	public void createRating(rating r, book b, regusers u)
	{
		r.setBks(b);
		r.setUser(u);
		b.getRatings().add(r);
		b.setSum_rating(b.getSum_rating() + r.getRating());
		b.setRating_count(b.getRating_count()+ 1);
		b.setAvg_rating(b.getSum_rating() / b.getRating_count());
		u.getRatings().add(r);
		
		em.getTransaction().begin();
		em.merge(b);
		em.merge(u);
		em.getTransaction().commit();	
	}
	
	public rating getRatingByID(int id){
		return em.find(rating.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<rating> getRatings(){
		Query query = em.createQuery("select r from rating r");
		return (List<rating>) query.getResultList();
	}
	
	public void updateRatingt(rating r){
		em.getTransaction().begin();
		em.merge(r);
		em.getTransaction().commit();	
	}
	
	public void deleteRating(int id){
		rating r = em.find(rating.class, id);
		em.getTransaction().begin();
		em.remove(r);
		em.getTransaction().commit();
		
	}


}
