package edu.neu.ccs.hw5.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class site {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	private int sid;
	
	@XmlAttribute
	private String name;
	
	@XmlAttribute
	private double latitude;
	
	@XmlAttribute
	private double longitude;
	
	@OneToMany(mappedBy="site")
	private List<tower> towers;

	public site() {
		super();
	}

	public site(int id, String name, double latitude, double longitude
			) {
		super();
		this.sid = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
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

	
	public List<tower> getTowers() {
		return towers;
	}
	

	
	public void setTowers(List<tower> towers) {
		this.towers = towers;
	}
	
	
}
