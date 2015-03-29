package edu.neu.db.objects;

public class comment {
	private int id;
	private String username;
	private String movie_id;
	private String comment;
	private String date;
	public comment(int id, String username, String movie_id, String comment,
			String date) {
		super();
		this.id = id;
		this.username = username;
		this.movie_id = movie_id;
		this.comment = comment;
		this.date = date;
	}
	public comment() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
}
