package edu.neu.cs5200.project;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class comment {

	@Id
	private int id;
	private String time;
	private String comments;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="username")
	private regusers users;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_id")
	private book bks;
	public comment() {
		super();
	}
	public comment(int id, String time, String comments) {
		super();
		this.id = id;
		this.time = time;
		this.comments = comments;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public regusers getUsers() {
		return users;
	}
	public void setUsers(regusers users) {
		this.users = users;
	}
	public book getBks() {
		return bks;
	}
	public void setBks(book bks) {
		this.bks = bks;
	}
		
}
