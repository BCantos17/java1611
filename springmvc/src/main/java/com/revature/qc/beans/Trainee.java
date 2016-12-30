package com.revature.qc.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Trainee {

	private int id;
	private String name;
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
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	@XmlElement
	public void setMajor(String major) {
		this.major = major;
	}
	
	
	
}
