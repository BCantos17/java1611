package com.revature.qc.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

//@XmlRootElement		JAX-B
@Entity
@Table(name="TRAINEE")
public class Trainee {

	// Hibernate  -- when persisting an object //
	@Id
	@Column(name="TRAINEE_ID", nullable=false)
	// Hibernate //
	
	// Spring  -- processes while reading request to "beanify" inputs //
	@Digits(integer=999999, fraction=0)
	// Spring //
	private int id;
	
	@Column(name="TRAINEE_NAME")
	@NotNull
	@Size(max=50, message="Name is too long")
	@Email
	private String name;
	
	@Column(name="MAJOR")
	@NotNull
	@Size(max=50)
	private String major;
	
	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", major=" + major + "]";
	}
	public Trainee(int id, String name, String major) {
		super();
		this.id = id;
		this.name = name;
		this.major = major;
	}
	public int getId() {
		return id;
	}
	public Trainee(String name, String major) {
		super();
		this.name = name;
		this.major = major;
	}
	public Trainee() {
		super();
	}
	//@XmlElement	JAX-B
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	//@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	//@XmlElement
	public void setMajor(String major) {
		this.major = major;
	}
	
	
	
}
