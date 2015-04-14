package edu.neu.ccs.hw5.DAO;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import edu.neu.ccs.hw5.model.site;

@Path("/api")
public class siteDAO {

	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("hwdb5");
	EntityManager em = factory.createEntityManager();

	@GET
	@Path("/site/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public site findSite(@PathParam("id") int siteId) {
		site s = null;
		try {
			Query query = em
					.createQuery("select s from site s where s.sid = :id ");
			query.setParameter("id", siteId);
			s = (site) query.getSingleResult();
			System.out.println(s.getSid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	@GET
	@Path("/site")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public List<site> findAllSites() {
		Query query = em.createQuery("select s from site s");
		return (List<site>) query.getResultList();
	}

	@PUT
	@Path("/site/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public List<site> updateSite(@PathParam("id") int siteId, site s) {
		em.getTransaction().begin();
		s.setSid(siteId);
		em.merge(s);
		em.getTransaction().commit();

		Query query = em.createQuery("select s from site s");
		return (List<site>) query.getResultList();
	}

	@DELETE
	@Path("/site")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public List<site> removeSite(@QueryParam("id") int siteId) {

		Query query = em.createQuery("select s from site s where s.sid = :id ");
		query.setParameter("id", siteId);
		site s = (site) query.getSingleResult();
		em.getTransaction().begin();
		em.remove(s);
		em.getTransaction().commit();

		Query query1 = em.createQuery("select s from site s");
		return (List<site>) query1.getResultList();
	}

	@POST
	@Path("/site")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public List<site> createSite(site s) {
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();

		Query query1 = em.createQuery("select s from site s");
		return (List<site>) query1.getResultList();
	}

	public static void main(String args[]) throws IOException {
		siteDAO dao = new siteDAO();

		// get site by id
		site s = dao.findSite(1);
	

		/*
		 * //Find all site List<site> ls = dao.findAllSites();
		 * System.out.println(ls.size());
		 * 
		 * //update site s1 = dao.findSite(1); s1.setName("Site 3"); List<site>
		 * ls1 = dao.updateSite(1, s1); System.out.println(ls1.size());
		 * 
		 * //delete //List<site> ls2 = dao.removeSite(3);
		 * //System.out.println(ls2.size());
		 * 
		 * //create site s2 = new site(0, "Site 4", 1.0, 2.0); List<site> ls3 =
		 * dao.createSite(s2); System.out.println(ls3.size());
		 */
	}
}
