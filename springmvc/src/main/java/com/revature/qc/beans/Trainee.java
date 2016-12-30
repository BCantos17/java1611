package com.revature.qc.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@XmlRootElement		JAX-B
@Entity
@Table(name="TRAINEE")
public class Trainee {

	@Id
	@Column(name="TRAINEE_ID")
	private int id;
	@Column(name="TRAINEE_NAME")
	private String name;
	@Column(name="MAJOR")
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
