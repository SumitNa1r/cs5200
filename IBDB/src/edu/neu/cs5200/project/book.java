package edu.neu.cs5200.project;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class book {

	@Id
	private int id;
	private int likes;
	private int number_pages;
	private int publish_year;
	private String poster;
	private String description;
	private String publisher;
	private int isbn;
	private int rating_count;
	private int sum_rating;
	private int avg_rating;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="author_id")
	private author auth;
	
	@OneToMany(mappedBy="bks")
	private List<comment> comnt;
	
	@OneToMany(mappedBy="boks")
	private List<shelf> shlf;
	
	public book() {
		super();
	}
	public book(int id, int likes, int number_pages, int publish_year,
			String poster, String description, String publisher, int isbn) {
		super();
		this.id = id;
		this.likes = likes;
		this.number_pages = number_pages;
		this.publish_year = publish_year;
		this.poster = poster;
		this.description = description;
		this.publisher = publisher;
		this.isbn = isbn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getNumber_pages() {
		return number_pages;
	}
	public void setNumber_pages(int number_pages) {
		this.number_pages = number_pages;
	}
	public int getPublish_year() {
		return publish_year;
	}
	public void setPublish_year(int publish_year) {
		this.publish_year = publish_year;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public author getAuth() {
		return auth;
	}
	public void setAuth(author auth) {
		this.auth = auth;
	}
	public List<comment> getComnt() {
		return comnt;
	}
	public void setComnt(List<comment> comnt) {
		this.comnt = comnt;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getRating_count() {
		return rating_count;
	}
	public void setRating_count(int rating_count) {
		this.rating_count = rating_count;
	}
	public int getSum_rating() {
		return sum_rating;
	}
	public void setSum_rating(int sum_rating) {
		this.sum_rating = sum_rating;
	}
	public int getAvg_rating() {
		return avg_rating;
	}
	public void setAvg_rating(int avg_rating) {
		this.avg_rating = avg_rating;
	}
	public List<shelf> getShlf() {
		return shlf;
	}
	public void setShlf(List<shelf> shlf) {
		this.shlf = shlf;
	}
	
	
}
