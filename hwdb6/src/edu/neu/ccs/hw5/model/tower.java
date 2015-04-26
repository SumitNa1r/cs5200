package edu.neu.ccs.hw5.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class tower {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	private int id;
	
	@XmlAttribute
	private String name;
	
	@XmlAttribute
	private double height;
	
	@XmlAttribute
	private int sides;
	
	@OneToMany(mappedBy="tower")
	@XmlElement(name="equipment")
	private List<equipment> equipments;

	@ManyToOne
	@JoinColumn(name="siteId")
	@XmlTransient
	private site site;
	
	public tower() {
		super();
	}
	public tower(int id, String name, double height, int sides) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.sides = sides;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getSides() {
		return sides;
	}
	public void setSides(int sides) {
		this.sides = sides;
	}
	public List<equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<equipment> equipments) {
		this.equipments = equipments;
	}
	public site getSite() {
		return site;
	}
	public void setSite(site site) {
		this.site = site;
	}


	
}
