package edu.neu.ccs.hw5.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class site {
	
	@Id
	@Column(name="id")
	private int sid;
	private String name;
	private double latitude;
	private double longitude;
	
	//@OneToMany(mappedBy="si")
	//private List<tower> towers;

	public site() {
		super();
	}

	public site(int id, String name, double latitude, double longitude/*,
			List<tower> towers*/) {
		super();
		this.sid = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		//this.towers = towers;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int id) {
		this.sid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/*
	public List<tower> getTowers() {
		return towers;
	}
	*/

	/*
	public void setTowers(List<tower> towers) {
		this.towers = towers;
	}
	
	*/
}
