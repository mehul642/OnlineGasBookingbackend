package com.cg.gasbooking.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Cylinder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cylinderId;
	private String type;
	private float weight;
	private String strapColor;
	private float price;
	
	
	public Cylinder(int cylinderId, String type, float d, String strapColor, float e) {
		super();
		this.cylinderId = cylinderId;
		this.type = type;
		this.weight = d;
		this.strapColor = strapColor;
		this.price = e;
	}
	
	public Cylinder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCylinderId() {
		return cylinderId;
	}
	public void setCylinderId(int cylinderId) {
		this.cylinderId = cylinderId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getStrapColor() {
		return strapColor;
	}
	public void setStrapColor(String strapColor) {
		this.strapColor = strapColor;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Cylinder [cylinderId=" + cylinderId + ", type=" + type + ", weight=" + weight + ", strapColor="
				+ strapColor + ", price=" + price + "]";
	}

}
