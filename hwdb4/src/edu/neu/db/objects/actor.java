package edu.neu.db.objects;

public class actor {
	private String Id;
	private String first_name;
	private String last_name;
	private String dob;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public actor() {
		super();
	}
	public actor(String id, String first_name, String last_name, String dob) {
		super();
		Id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
	}

}
