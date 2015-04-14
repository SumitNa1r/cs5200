package edu.neu.ccs.hw5.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class equipment {
	
	@Id
	private int eid;
	private String name;
	private String brand;
	private String description;
	private double price;
	private int tower_id;
	public equipment() {
		super();
	}
	public equipment(int eid, String name, String brand, String description,
			double price, int tower_id) {
		super();
		this.eid = eid;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.tower_id = tower_id;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getTower_id() {
		return tower_id;
	}
	public void setTower_id(int tower_id) {
		this.tower_id = tower_id;
	}

	
	
}
