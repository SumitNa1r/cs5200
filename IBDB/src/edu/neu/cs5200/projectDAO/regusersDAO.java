package edu.neu.cs5200.projectDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs5200.project.regusers;

public class regusersDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("IBDB");
	EntityManager em = factory.createEntityManager();
	
	public regusers createRegUser(regusers r) {
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		return r;
	}
	
	public regusers getUserByUname(String Uname){
		return em.find(regusers.class, Uname);
	}
	
	@SuppressWarnings("unchecked")
	public List<regusers> getUsers(){
		Query query = em.createQuery("select r from regusers r");
		return (List<regusers>) query.getResultList();
	}
	
	public void updateRegUsers(regusers r){
		em.getTransaction().begin();
		em.merge(r);
		em.getTransaction().commit();
	}
	
	public void deleteUser(String uname){
		regusers r = em.find(regusers.class, uname);
		em.getTransaction().begin();
		em.remove(r);
		em.getTransaction().commit();
		
	}
	
	public boolean isValidUser(String uname, String pwd) {
		Query query = em
				.createQuery("select r from regusers r where r.username = :uname and r.password = :pwd");
		query.setParameter("uname", uname);
		query.setParameter("pwd", pwd);
		@SuppressWarnings("unused")
		regusers r = new regusers();
		try {
			r = (regusers) query.getSingleResult();
		} catch (NoResultException nre) {
			return false;
		}

		return true;
	}
	
	public void addToFollowing(regusers v, regusers s)
	{
		s.getFollowers().add(v);			
		v.getFollowing().add(s);
		
		em.getTransaction().begin();
		em.merge(s);
		em.merge(v);
		em.getTransaction().commit();		
	}
}
