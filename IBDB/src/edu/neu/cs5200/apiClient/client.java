package edu.neu.cs5200.apiClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom.CharacterData;

import edu.neu.cs5200.project.author;
import edu.neu.cs5200.project.book;

public class client {
	public static String GET_BOOK_BY_ID = "https://www.goodreads.com/book/show/BOOK_ID?format=xml&key=X1Gd1Zw1WpqsH8U5WBBdA";

	public author findBookById(int id)
	{
		String book_url = GET_BOOK_BY_ID.replace("BOOK_ID", Integer.toString(id));
		String xml = getXMLFromURLString(book_url);
		Document xmlDoc = getDocument(xml);
		
		//Fetching book Data
		String name = getData(xmlDoc, "book", "title");
		int book_isbn = Integer.parseInt(getData(xmlDoc, "book", "id"));
		String p_year =getData(xmlDoc, "work", "original_publication_year");
		int publish_year;
		if(!p_year.equals(""))
			publish_year = Integer.parseInt(p_year);
		else
			publish_year = 0;
		String description = getData(xmlDoc, "book","description");
		description = description.replace("<p>", "");
		description = description.replace("</p>", "");
		String poster = getData(xmlDoc, "book","image_url");
		String publisher = getData(xmlDoc, "book","publisher");
		
		//Fetching author data
		int author_id = Integer.parseInt(getData(xmlDoc, "authors", "author", "id"));
		String auth_url = getData(xmlDoc, "authors", "author", "image_url");
		String auth_name = getData(xmlDoc, "authors", "author", "name");
		System.out.println(author_id);
				
		author a = new author(0, auth_name, "", "", 0, 0, auth_url, author_id);
		book b = new book(0, 0 , publish_year, poster, description, publisher, book_isbn, name );
		b.setAuth(a);
		a.setBooks(new ArrayList<book>());
		a.getBooks().add(b);
		
		return a;
	}

	private String getXMLFromURLString(String book_url) {
		try {
			URL url = new URL(book_url);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			InputStream in = connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader r = new BufferedReader(isr);
			String out;
			StringBuffer xml = new StringBuffer();
			while((out = r.readLine()) != null) {
				xml.append(out);
			}
			return xml.toString();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Document getDocument(String xml) {
		DocumentBuilder db = null;

		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(xml));

		Document doc = null;
		try {
			doc = db.parse(is);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return doc;
	}
	
	public String getData(Document doc, String initial, String tag){
		NodeList nodes = doc.getElementsByTagName(initial);
		Element element = (Element) nodes.item(0);
		NodeList name = element.getElementsByTagName(tag);
		Element line = (Element) name.item(0);
		return getCharacterDataFromElement(line);
		
	}
	
	public String getData(Document doc, String initial, String tag, String nested){
		NodeList nodes = doc.getElementsByTagName(initial);
		Element element = (Element) nodes.item(0);
		NodeList name = element.getElementsByTagName(tag);
		Element line = (Element) name.item(0);
		NodeList nest = line.getElementsByTagName(nested);
		Element nestd = (Element) nest.item(0);
		return getCharacterDataFromElement(nestd);		
	}

	public String getData(Document doc, String initial, String tag, String nested, String tag1){
		NodeList nodes = doc.getElementsByTagName(initial);
		Element element = (Element) nodes.item(0);
		NodeList name = element.getElementsByTagName(tag);
		Element line = (Element) name.item(0);
		NodeList nest = line.getElementsByTagName(nested);
		Element nestd = (Element) nest.item(0);
		NodeList nest1 = nestd.getElementsByTagName(tag1);
		Element nestd1 = (Element) nest1.item(0);
		return getCharacterDataFromElement(nestd1);		
	}
	
	public static String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "";
	}
	  
	public static void main(String args[]) throws IOException {
		
		client api = new client();
		api.findBookById(50);
	}
}
