package edu.neu.cs5200.project;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class rating {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int rating;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="username")
	private regusers user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_id")
	private book bks;
	
	public rating() {
		super();
	}
	public rating(int id, int rating) {
		super();
		this.id = id;
		this.rating = rating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public regusers getUser() {
		return user;
	}
	public void setUser(regusers user) {
		this.user = user;
	}
	public book getBks() {
		return bks;
	}
	public void setBks(book bks) {
		this.bks = bks;
	}

}
