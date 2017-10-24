package edu.usyd.medivise.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Appointment 
{
	@Id
	@Column
	@GeneratedValue
	private long id;
	
	@Column
	private String category;

	@Column
	private String availability;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
    
	public Appointment(){}
	
	public Appointment(User user, String category,String availability) {
		this.user = user;
		this.category=category;
		this.availability=availability;
	}
	
	public long getId() {
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
	public String getAvailability() {
		return availability;
	}
	public void setAvailable_time(String availability) {
		this.availability = availability;
	}
	
	public User getUser() {
		return user;
	}
	
}
