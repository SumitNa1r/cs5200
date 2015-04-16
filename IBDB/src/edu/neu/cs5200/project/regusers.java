package edu.neu.cs5200.project;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity
public class regusers {

	@Id
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String email;
	private String dob;
	private String contact;
	
	@OneToMany(mappedBy="users")
	private List<comment> comnt;
	
	@OneToMany(mappedBy="usr")
	private List<comment_author> auth_comnt;
	
	@ManyToMany
	@JoinTable(name = "userlink", joinColumns = { @JoinColumn(name = "following_uname", referencedColumnName = "username") }, inverseJoinColumns = { @JoinColumn(name = "follower_uname", referencedColumnName = "username") })
	private List<regusers> followers;
	
	@ManyToMany(mappedBy = "followers")
	private List<regusers> following;
	
	@OneToMany(mappedBy="usrs")
	private List<shelf> shlf;
	
	
	public regusers(String username, String password, String first_name,
			String last_name, String email, String dob, String contact) {
		super();
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.dob = dob;
		this.contact = contact;
	}

	public regusers() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<comment> getComnt() {
		return comnt;
	}

	public void setComnt(List<comment> comnt) {
		this.comnt = comnt;
	}

	public List<regusers> getFollowers() {
		return followers;
	}

	public void setFollowers(List<regusers> followers) {
		this.followers = followers;
	}

	public List<regusers> getFollowing() {
		return following;
	}

	public void setFollowing(List<regusers> following) {
		this.following = following;
	}

	public List<comment_author> getAuth_comnt() {
		return auth_comnt;
	}

	public void setAuth_comnt(List<comment_author> auth_comnt) {
		this.auth_comnt = auth_comnt;
	}

	public List<shelf> getShlf() {
		return shlf;
	}

	public void setShlf(List<shelf> shlf) {
		this.shlf = shlf;
	}
	
}
