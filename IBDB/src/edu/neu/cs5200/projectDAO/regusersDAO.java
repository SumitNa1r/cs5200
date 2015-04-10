package edu.neu.cs5200.projectDAO;

import java.io.IOException;
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
	
	private regusers createRegUser(regusers r) {
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		return r;
	}
	
	private regusers readUserByUname(String Uname){
		return em.find(regusers.class, Uname);
	}
	
	private List<regusers> readAllUsers(){
		Query query = em.createQuery("select r from regusers r");
		return (List<regusers>) query.getResultList();
	}
	
	private regusers updateRegUsers(regusers r){
		em.getTransaction().begin();
		em.merge(r);
		em.getTransaction().commit();
		
		return r;
	}
	
	private void deleteUser(String uname){
		regusers r = em.find(regusers.class, uname);
		em.getTransaction().begin();
		em.remove(r);
		em.getTransaction().commit();
		
	}
	
	private boolean isValidUser(String uname, String pwd){
		Query query = em.createQuery("select r from regusers r where r.username = :uname and r.password = :pwd");
		query.setParameter("uname", uname);
		query.setParameter("pwd", pwd);
		regusers r = new regusers();
		try{
			r = (regusers) query.getSingleResult();
		}
		catch (NoResultException nre){
			return false;
		}
		
		return true;
	}
	
	public static void main (String args[]) throws IOException
	{
		regusersDAO dao = new regusersDAO();
		
		/*CREATE
		regusers r = new regusers("sum", "sum", "sumit", "nair", "sumit.nair@gmail.com", "02-01-1990", "8672609367");
		r = dao.createRegUser(r);
		System.out.println(r.getEmail());
		*/
		
		/*READ BY UNAME
		regusers r = dao.readUserByUname("sum");
		System.out.println(r.getEmail());
		*/
		
		/*READ ALL BY UNAME
		List <regusers> r = dao.readAllUsers();
		for(regusers ru : r){
			System.out.println(ru.getLast_name());
		}
		*/
		
		/* UPDATE Regusers
		regusers r = dao.readUserByUname("sum");
		r.setEmail("changed.email@gmail.com");
		dao.updateRegUsers(r);
		*/
		
		//dao.deleteUser("sum");
		System.out.println(dao.isValidUser("sum", "sum"));
	}

}
