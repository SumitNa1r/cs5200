package edu.neu.cs5200.project;

public class stack {

	private int id;
	private int book_id;
	private String username;
		
	public stack() {
		super();
	}

	public stack(int id, int book_id, String username) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.username = username;
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
	
}
