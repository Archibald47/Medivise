package edu.usyd.medivise.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//add JPA annotations (Java Persistence API)
//描述对象－关系表的映射关系，并将运行期的实体对象持久化到数据库中
//JPA的宗旨是为POJO提供持久化标准规范
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
		// TODO Auto-generated constructor stub
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
