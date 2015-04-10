package edu.neu.cs5200.project;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class comment {

	@Id
	private int id;
	
	private int book_id;
	private String username;
	private String time;
	private String comments;
	
	public comment() {
		super();
	}

	public comment(int book_id, String username, String comments) {
		super();
		this.id = 0;
		//this.time = "";
		this.book_id = book_id;
		this.username = username;
		this.comments = comments;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getComment() {
		return comments;
	}

	public void setComment(String comments) {
		this.comments = comments;
	}
	
	
	
}
