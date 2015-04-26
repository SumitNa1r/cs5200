package edu.neu.ccs.hw5.DAO;

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import edu.neu.ccs.hw5.model.site;
import edu.neu.ccs.hw5.model.siteList;

public class siteDAO {

	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("hwdb5");
	EntityManager em = factory.createEntityManager();

	public site findSite(int siteId) {
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

	@SuppressWarnings("unchecked")
	public List<site> findAllSites() {
		Query query = em.createQuery("select s from site s");
		return (List<site>) query.getResultList();
	}
	
	public void exportSitesToXmlFile(siteList sitelist, String xmlFileName) {
		File xmlFile = new File(xmlFileName);
		try {
			JAXBContext jaxb = JAXBContext.newInstance(siteList.class);
			Marshaller marshaller = jaxb.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(sitelist, xmlFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void convertXmlFileToOutputFile(String sitelistXmlFile,
			String outputFile, String xsltFile) {
		File input = new File(sitelistXmlFile);
		File output = new File(outputFile);
		File xsltFile1 = new File(xsltFile);

		StreamSource source = new StreamSource(input);
		StreamSource xslt = new StreamSource(xsltFile1);
		StreamResult output1 = new StreamResult(output);

		TransformerFactory factory = TransformerFactory.newInstance();
		try {
			Transformer transformer = factory.newTransformer(xslt);
			transformer.transform(source, output1);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		siteDAO dao = new siteDAO();
		
		site site = dao.findSite(1);
		
		List<site> sites = dao.findAllSites();
		
		siteList sl = new siteList();
		sl.setSites(sites);
		
		dao.exportSitesToXmlFile(sl, "xml/sites.xml");
		
		dao.convertXmlFileToOutputFile("xml/sites.xml", "xml/sites.html", "xml/sites2html.xslt");
		dao.convertXmlFileToOutputFile("xml/sites.xml", "xml/equipments.html", "xml/sites2equipment.xslt");
	}

}
