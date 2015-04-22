package edu.neu.cs5200.project;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class author {

	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String hometown;
	private String gender;
	private int work_count;
	private int followers;
	private String url;
	private int api_id;
	
	@OneToMany(mappedBy="auth")
	private List<book> books;
	
	@OneToMany(mappedBy="author")
	private List<comment_author> comnt;
	
	@ManyToMany(mappedBy = "authors")
	private List<regusers> fans;
	
	public author() {
		super();
	}
	public author(int id, String name, String hometown, String gender,
			int work_count, int followers, String url, int api_id) {
		super();
		this.id = id;
		this.name = name;
		this.hometown = hometown;
		this.gender = gender;
		this.work_count = work_count;
		this.followers = followers;
		this.url = url;
		this.api_id = api_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getWork_count() {
		return work_count;
	}
	public void setWork_count(int work_count) {
		this.work_count = work_count;
	}
	public int getFollowers() {
		return followers;
	}
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	public List<book> getBooks() {
		return books;
	}
	public void setBooks(List<book> books) {
		this.books = books;
	}
	public List<comment_author> getComnt() {
		return comnt;
	}
	public void setComnt(List<comment_author> comnt) {
		this.comnt = comnt;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getApi_id() {
		return api_id;
	}
	public void setApi_id(int api_id) {
		this.api_id = api_id;
	}
	public List<regusers> getFans() {
		return fans;
	}
	public void setFans(List<regusers> fans) {
		this.fans = fans;
	}
	
}
