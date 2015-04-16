package edu.neu.cs5200.project;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class shelf {
	@Id
	private int id;
	private String category;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="username")
	private regusers usrs;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_id")
	private book boks;

	public shelf() {
		super();
	}

	public shelf(int id, String category) {
		super();
		this.id = id;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public regusers getUsrs() {
		return usrs;
	}

	public void setUsrs(regusers usrs) {
		this.usrs = usrs;
	}

	public book getBoks() {
		return boks;
	}

	public void setBoks(book boks) {
		this.boks = boks;
	}

}
