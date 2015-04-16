package edu.neu.cs5200.project;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class comment_author {

	@Id
	private int id;
	private String time;
	private String comments;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user")
	private regusers usr;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="author")
	private author author;
	
	public comment_author() {
		super();
	}
	public comment_author(int id, String time, String comments) {
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
	public regusers getUsr() {
		return usr;
	}
	public void setUsr(regusers usr) {
		this.usr = usr;
	}
	public author getAuthor() {
		return author;
	}
	public void setAuthor(author author) {
		this.author = author;
	}
}
