package edu.usyd.medivise.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Doctor 
{
	@Id
	@Column
	@GeneratedValue
	private int id;
	@Column
	private String category;
	@Column
	private String available_time;
	
	// create model class 
	
	public Doctor(){}
	public Doctor(int id,String category,String available_time) {
		super();
		this.id=id;
		this.category=category;
		this.available_time=available_time;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAvailable_time() {
		return available_time;
	}
	public void setAvailable_time(String available_time) {
		this.available_time = available_time;
	}
	
	
}
